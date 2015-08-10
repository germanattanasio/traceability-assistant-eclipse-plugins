/**
 * Copyright 2015 UNICEN. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.isistan.carcha.plugin.editors;

import isistan.edu.carcha.model.carcha.CarchaProject;
import isistan.edu.carcha.model.carcha.DesignDecision;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.util.Rotation;

import edu.isistan.carcha.util.PluginUtil;

/**
 * An example showing how to create a multi-page editor. This example has 3
 * pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class TraceabilityEditor extends MultiPageEditorPart implements
		IResourceChangeListener {

	/** The Constant logger. */
	private static final Log logger = LogFactory.getLog(TraceabilityEditor.class);

	/** The cp. */
	CarchaProject cp;
	
	/** The impact dataset. */
	DefaultPieDataset ddDataset,impactDataset;
	
	/** The dirty. */
	private boolean dirty = false;
	
	/** The text editor used in page 0. */
	private TextEditor editor;
	
	/** The markers. */
	List<IMarker> markers;
	
	/** The bottom new link. */
	TableViewer topViewLink, bottomViewLink, topNewLink, bottomNewLink;
		
	/**
	 * Creates a multi-page editor example.
	 */
	public TraceabilityEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	/**
	 * Loads the current file into a CarchaProject.
	 */
	void createCarchaProject(){
		IFile file = (IFile) editor.getEditorInput().getAdapter(IFile.class);
		cp = PluginUtil.loadTraceabilityModel(file);
	}
	
	/**
	 * Creates the columns.
	 *
	 * @param parent the parent
	 * @param viewer the viewer
	 */
	void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "Type", "Label" };
		int[] bounds = { 100, 700 };

		// first column is for the kind
		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0, viewer);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				String[] temp = (String[]) element;
				return temp[0];
			}
		});

		// second column is for the  name
		col = createTableViewerColumn(titles[1], bounds[1], 1, viewer);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				String[] temp = (String[]) element;
				return temp[1];
			}
		});
	}
	/**
	 * Creates the pages of the multi-page editor.
	 */
	protected void createPages() {
		markers = new ArrayList<IMarker>();
		impactListPage();
		impactPieChartPage();
		createTraceabilityLinkPage();
		sourcePage();
		
		createCarchaProject();
		generateWarnings();
		generateLinkViewData();
	}	
	
	/**
	 * Creates the table viewer column.
	 *
	 * @param title the title
	 * @param bound the bound
	 * @param colNumber the col number
	 * @param viewer the viewer
	 * @return the table viewer column
	 */
	TableViewerColumn createTableViewerColumn(String title, int bound,
			final int colNumber, TableViewer viewer) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}
	/**
	 * Creates a page to allow users to create a traceability link.
	 */
	void createTraceabilityLinkPage() {
		final Composite composite = new Composite(getContainer(), SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 5));
		composite.setLayout(new GridLayout());
				
		Label concernLabel = new Label(composite, SWT.BORDER);
		concernLabel.setText("Crosscuttings Concerns(CCC)");
		concernLabel.setToolTipText("This are the Crosscuttings Concerns detected on the requierement document");
		GridData gridData = new GridData(SWT.LEFT, SWT.TOP, false, false);
		concernLabel.setLayoutData(gridData);
		
		topNewLink = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL| SWT.V_SCROLL);
		createColumns(composite, topNewLink);

		final Table table = topNewLink.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		topNewLink.setContentProvider(new ArrayContentProvider());
		getSite().setSelectionProvider(topNewLink);
		// define layout for the viewer
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		topNewLink.getControl().setLayoutData(gridData);

		Button button = new Button(composite, SWT.PUSH);
		button.setText("Link");
		button.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent event) {}

			public void widgetSelected(SelectionEvent event) {
				IStructuredSelection topSelection = (IStructuredSelection) topNewLink.getSelection();
				IStructuredSelection bottomSelection = (IStructuredSelection) bottomNewLink.getSelection();

				String[] crosscuttingConcern = (String[]) topSelection.getFirstElement();
				String[] designDecision = (String[]) bottomSelection.getFirstElement();
				
				if ( (crosscuttingConcern != null) && (designDecision != null) ){
					// create dialog with ok and cancel button and info icon
					MessageBox dialog = 
					  new MessageBox(composite.getShell(), SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					dialog.setText("Link confirmation");
					dialog.setMessage("Do you want to link the selected items?");

					// open dialog and await user selection
					int response = dialog.open(); 
					if (response == SWT.OK){
						PluginUtil.createNewLink(crosscuttingConcern, designDecision, cp);
						dirty = true;
						firePropertyChange(IEditorPart.PROP_DIRTY); 
					}
				}else{
					MessageDialog.openError(composite.getShell(), "Error", "Please select item(s) to link");
				}
			}
		});
		
		gridData = new GridData(SWT.CENTER, SWT.TOP, false, false, 2, 1);
		button.setLayoutData(gridData);

		Label ddsLabel = new Label(composite, SWT.BORDER);
		ddsLabel.setText("Architectural design decisions");
		ddsLabel.setToolTipText("This are the design decisions detected in the architectural document");
		gridData = new GridData(SWT.LEFT, SWT.TOP, false, false);
		ddsLabel.setLayoutData(gridData);
		bottomNewLink = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		createColumns(composite, bottomNewLink);

		Table table2 = bottomNewLink.getTable();
		table2.setHeaderVisible(true);
		table2.setLinesVisible(true);

		bottomNewLink.setContentProvider(new ArrayContentProvider());

		getSite().setSelectionProvider(bottomNewLink);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		bottomNewLink.getControl().setLayoutData(gridData);

		int index = addPage(composite);
		setPageText(index, "New Link");
	}
	
	/**
	 * The <code>MultiPageEditorPart</code> implementation of this
	 * <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		for(IMarker marker : markers){
			try {
				marker.delete();
			} catch (CoreException e) {
				logger.error("Error disposing the editors",e);
			}
		}
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	
	/**
	 * Saves the multi-page editor's document.
	 *
	 * @param monitor the monitor
	 */
	public void doSave(IProgressMonitor monitor) {
		getEditor(3).doSave(monitor);
		IFile file = (IFile) editor.getEditorInput().getAdapter(IFile.class);
		try {
			PluginUtil.saveTraceabilityModel(file, cp);
		} catch (IOException e) {
			logger.error("Error saving the traceability model", e);

		}
		dirty = false;
		firePropertyChange(IEditorPart.PROP_DIRTY); 

	}
	
	/**
	 * Saves the multi-page editor's document as another file. Also updates the
	 * text for page 0's tab, and updates this multi-page editor's input to
	 * correspond to the nested editor's.
	 */
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());
		dirty = false;
		firePropertyChange(IEditorPart.PROP_DIRTY); 

	}
	
	/**
	 * Generate link view data.
	 */
	void generateLinkViewData(){
		List<String[]> ccs = new ArrayList<String[]>();
		for (isistan.edu.carcha.model.carcha.CrosscuttingConcern cccs : PluginUtil.getLinkedCrossCuttingConcerns(cp)){
			String[] cc = { cccs.getKind(), cccs.getName() };
			ccs.add(cc);
		}

		topViewLink.setInput(ccs);
	}
	/**
	 * Get the info for the pie chart.
	 */
	void generatePieData() {
		HashMap<String,Integer> values = PluginUtil.getCrossCuttingConcernsDistribution(cp);
		for(String key : values.keySet()){
			ddDataset.setValue(key, values.get(key));
		}
	}

	/**
	 * Generate table data.
	 */
	void generateTableData() {
		List<String[]> ccs = new ArrayList<String[]>();
		for (isistan.edu.carcha.model.carcha.CrosscuttingConcern cccs : cp.getConcerns()){
			String[] cc = { cccs.getKind(), cccs.getName() };
			ccs.add(cc);
		}
		topNewLink.setInput(ccs);

		List<String[]> dds = new ArrayList<String[]>();
		for (DesignDecision ddds : cp.getDesignDecisions()){
			String[] dd = { ddds.getKind(), ddds.getName() };
			dds.add(dd);
		}
		bottomNewLink.setInput(dds);

	}

	/**
	 * Generates the warning for unlinked crosscutting concerns.
	 */
	void generateWarnings(){
		try {
			IFile file = (IFile) editor.getEditorInput().getAdapter(IFile.class);
			for (isistan.edu.carcha.model.carcha.CrosscuttingConcern cccs : PluginUtil.getUnusedConcerns(cp)){
				IMarker marker = file.createMarker(IMarker.PROBLEM);
			      marker.setAttribute(IMarker.MESSAGE, "Link not found on: "+ cccs.getName());
			      marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			      marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
			      marker.setAttribute(IMarker.LINE_NUMBER, getLineFor(cccs.getName(), cccs.getKind()));
			      markers.add(marker);
			}
//			for (DesignDecision dds : PluginUtil.getUnusedDesignDecisions(cp)){
//				IMarker marker = file.createMarker(IMarker.PROBLEM);
//			      marker.setAttribute(IMarker.MESSAGE, "Link not found on: "+ dds.getName());
//			      marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
//			      marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
//			      marker.setAttribute(IMarker.LINE_NUMBER, getLineFor(dds.getName(), dds.getKind()));
//			      markers.add(marker);
//			}
		} catch (Exception e) {
			logger.error("Attribute value was rejected",e);
		}
	}

	/**
	 * Gets the line number for a given cross cutting concern or design decision.
	 *
	 * @param name the name
	 * @param kind the kind
	 * @return line number
	 */
	int getLineFor(String name, String kind){
		int i = 0;
		String editorText = editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
		String[] lines = editorText.split(System.getProperty("line.separator"));

		int temp = 1;
		String lineEscaped;
		boolean find = false;
		for	(int j = 0; j < lines.length && !find; j++){
			lineEscaped = StringEscapeUtils.unescapeXml(lines[j]);
			if (lineEscaped.contains(name) && lineEscaped.contains(kind)){
				i = temp;
				find = true;
			}
			temp++;
		}
		return i;
	}

	/**
	 * Goto marker.
	 *
	 * @param marker the marker
	 */
	/*
	 * (non-Javadoc) Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		setActivePage(0);
		IDE.gotoMarker(getEditor(0), marker);
	}

	/**
	 * Creates the impact list page.
	 */
	void impactListPage() {
		final Composite composite = new Composite(getContainer(), SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 6));
		composite.setLayout(new GridLayout());
		
		Label concernLabel = new Label(composite, SWT.BORDER);
		concernLabel.setText("Crosccuting Concerns(CCC)");
		concernLabel.setToolTipText("This are the concern detected on the requierement document.");
		GridData gridData = new GridData(SWT.LEFT, SWT.TOP, false, false);
		concernLabel.setLayoutData(gridData);

		topViewLink = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		createColumns(composite, topViewLink);

		final Table table = topViewLink.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		topViewLink.setContentProvider(new ArrayContentProvider());

		getSite().setSelectionProvider(topViewLink);
		// define layout for the viewer
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		topViewLink.getControl().setLayoutData(gridData);

		Button button = new Button(composite, SWT.PUSH);
		button.setText("Remove");
		button.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent event) { }

			public void widgetSelected(SelectionEvent event) {
				IStructuredSelection topSelection = (IStructuredSelection) topViewLink.getSelection();
				IStructuredSelection bottomSelection = (IStructuredSelection) bottomViewLink.getSelection();

				String[] crosscuttingConcern = (String[]) topSelection.getFirstElement();
				String[] designDecision = (String[]) bottomSelection.getFirstElement();
				if (topSelection.size() > 1){
					MessageDialog.openError(composite.getShell(), "Error", "Please select one crosscutting concern");
				}else{
					if ((crosscuttingConcern != null) && (designDecision != null)) {
						// create dialog with ok and cancel button and info icon
						MessageBox dialog = new MessageBox(
								composite.getShell(), SWT.ICON_QUESTION
										| SWT.OK | SWT.CANCEL);
						dialog.setText("Link confirmation");
						dialog.setMessage("Do you want to remove the link between the selected items?");

						// open dialog and await user selection
						int response = dialog.open();
						if (response == SWT.OK) {
							PluginUtil.removeLink(crosscuttingConcern, designDecision, cp);
							dirty = true;
							firePropertyChange(IEditorPart.PROP_DIRTY); 
							// update the list after the remove
							generateLinkViewData();
							bottomViewLink.getTable().clearAll();
						}
					} else {
						MessageDialog.openError(composite.getShell(), "Error",
								"Please select a crosscutting concern and a design decision to remove a traceability link");
					}
				}
			}
		});
		gridData = new GridData(SWT.CENTER, SWT.TOP, false, false, 2, 1);
		button.setLayoutData(gridData);
		
		
		Label ddsLabel = new Label(composite, SWT.BORDER);
		ddsLabel.setText("Architectural design decisions");
		ddsLabel.setToolTipText("This are the design decisions detected on the architectural document");
		
		gridData = new GridData(SWT.LEFT, SWT.TOP, false, false);
		ddsLabel.setLayoutData(gridData);

		bottomViewLink = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		createColumns(composite, bottomViewLink);
		Table table2 = bottomViewLink.getTable();
		table2.setHeaderVisible(true);
		table2.setLinesVisible(true);
		bottomViewLink.setContentProvider(new ArrayContentProvider());
		topViewLink.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
		        IStructuredSelection selection = (IStructuredSelection)event.getSelection();
				if (!selection.isEmpty()){
							String[] cccs = (String[]) selection.getFirstElement();
							List<DesignDecision> dds = PluginUtil.getDesignDecisionsForCrossCuttingConcern(cp, cccs[1], cccs[0]);
							logger.info("Impact List for CCC ("+dds.size()+" DDD): "+ cccs[0]+ " - "+ cccs[1]);
							List<String[]> designDecisions = new ArrayList<String[]>();

							for (DesignDecision dd : dds) {
								String[] designDecision = { dd.getKind(),dd.getName() };
								designDecisions.add(designDecision);
							}
							bottomViewLink.setInput(designDecisions);
				}
			}
		} );
		getSite().setSelectionProvider(bottomViewLink);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		bottomViewLink.getControl().setLayoutData(gridData);
		
		int index = addPage(composite);
		setPageText(index, "Links");
	}

	/**
	 * Creates the impact Pie Chart page. It allows users to select a Crosscutting Concern and see Design Decision type distribution
	 */
	void impactPieChartPage() {

		ddDataset = new DefaultPieDataset();
		impactDataset = new DefaultPieDataset();
		JFreeChart ddChart = ChartFactory.createPieChart("Crosscutting Concerns", ddDataset, true, true, false);
		JFreeChart impactChart = ChartFactory.createPieChart("Design Decisions",impactDataset, true, true, false);

		PiePlot ddPlot = (PiePlot) ddChart.getPlot();
		ddPlot.setStartAngle(290);
		ddPlot.setDirection(Rotation.CLOCKWISE);
		ddPlot.setForegroundAlpha(0.5f);

		PiePlot impactPlot = (PiePlot) impactChart.getPlot();
		impactPlot.setStartAngle(290);
		impactPlot.setDirection(Rotation.CLOCKWISE);
		impactPlot.setForegroundAlpha(0.5f);

		 PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}  ({2})");
		 ddPlot.setLabelGenerator(gen);
		 impactPlot.setLabelGenerator(gen);
		
		 Composite composite = new Composite(getContainer(), SWT.NONE);
		FillLayout layout = new FillLayout();
		composite.setLayout(layout);
		final ChartComposite cComposite = new ChartComposite(composite,
				SWT.NONE, ddChart, true);
		cComposite.addChartMouseListener(new ChartMouseListener() {

			@Override
			public void chartMouseClicked(ChartMouseEvent event) {
				String[] parts = event.getEntity().getToolTipText().split(":");
				HashMap<String, Integer> values = PluginUtil.getDDDistributionForCrossCuttingConcern(cp, parts[0]);
				logger.info("Impact Pie Chart for: "+parts[0]);
				impactDataset.clear();
				for(String key : values.keySet()){
					impactDataset.setValue(key, values.get(key));
				}
			}

			@Override
			public void chartMouseMoved(ChartMouseEvent event) {
			}
		});
		new ChartComposite(composite, SWT.NONE, impactChart, true);
		int index = addPage(composite);
		setPageText(index, "Graph");
	}

	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method
	 * checks that the input is an instance of <code>IFileEditorInput</code>.
	 *
	 * @param site the site
	 * @param editorInput the editor input
	 * @throws PartInitException the part init exception
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
			throws PartInitException {
		if (!(editorInput instanceof IFileEditorInput))
			throw new PartInitException(
					"Invalid Input: Must be IFileEditorInput");
		super.init(site, editorInput);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.MultiPageEditorPart#isDirty()
	 */
	@Override
	  public boolean isDirty() {
	    return dirty;
	}
	
	/*
	 * (non-Javadoc) Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() {
		return false;
	}
	
	/**
	 * Calculates the contents of page 2 when the it is activated.
	 *
	 * @param newPageIndex the new page index
	 */
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
		if (newPageIndex == 0) {
			generateLinkViewData();
		}
		if (newPageIndex == 1) {
			generatePieData();
		}
		if (newPageIndex == 2) {
			generateTableData();
		}
		
	}

	/**
	 * Closes all project files on project close.
	 *
	 * @param event the event
	 */
	public void resourceChanged(final IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow()
							.getPages();
					for (int i = 0; i < pages.length; i++) {
						if (((FileEditorInput) editor.getEditorInput())
								.getFile().getProject()
								.equals(event.getResource())) {
							IEditorPart editorPart = pages[i].findEditor(editor
									.getEditorInput());
							pages[i].closeEditor(editorPart, true);
						}
					}
				}
			});
		}
	}

	/**
	 * Creates a View Source page
	 */
	void sourcePage() {
		try {
			editor = new TextEditor();
			int index = addPage(editor, getEditorInput());
			setPageText(index, "Source");
		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(),"Error creating nested text editor", null, e.getStatus());
		}
	}
	
}
