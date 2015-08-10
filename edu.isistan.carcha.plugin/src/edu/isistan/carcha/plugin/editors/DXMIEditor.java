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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.util.Rotation;

import edu.isistan.carcha.lsa.model.Entity;
import edu.isistan.carcha.util.Utils;


/**
 * An example showing how to create a multi-page editor.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 shows the words in page 0 in sorted order
 * <li>page 2 shows a pie chart
 * </ul>
 */
public class DXMIEditor extends MultiPageEditorPart implements IResourceChangeListener{

	/** The Constant logger. */
	private static final Log logger = LogFactory.getLog(DXMIEditor.class);

	/**
	 * Creates a multi-page editor example.
	 */
	CarchaProject cp;

	/** The dds viewer. */
	TableViewer ddsViewer;
	
	/** The text editor used in page 0. */
	private TextEditor editor;
	/**  The dataset for the pie chart. */
	DefaultPieDataset result;

	/**
	 * Instantiates a new DXMI editor.
	 */
	public DXMIEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	/**
	 * Creates the columns.
	 *
	 * @param parent the parent
	 * @param viewer the viewer
	 */
	void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "Type", "Label" };
		int[] bounds = { 100, 500 };

		// first column is for the kind
		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0],
				0, viewer);
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
	 * Creates the DDD list page.
	 */
	void createListPage() {
		final Composite composite = new Composite(getContainer(), SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
				1, 4));
		composite.setLayout(new GridLayout());
		Label concernLabel = new Label(composite, SWT.BORDER);
		concernLabel.setText("Design Decisions");
		concernLabel.setToolTipText("This are the Design Decisions detected in the architectural document");
		GridData gridData = new GridData(SWT.LEFT, SWT.LEFT, false, false);
		concernLabel.setLayoutData(gridData);

		ddsViewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		createColumns(composite, ddsViewer);

		final Table table = ddsViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		ddsViewer.setContentProvider(new ArrayContentProvider());

		getSite().setSelectionProvider(ddsViewer);
		// define layout for the viewer
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		ddsViewer.getControl().setLayoutData(gridData);

		
		int index = addPage(composite);
		setPageText(index, "List");
	}
	
	/**
	 * Creates the pages of the multi-page editor.
	 */
	protected void createPages() {
		createSourcePage();
		createListPage();
		createPieChartPage();
	}
	/**
	 * Creates the PieChart page.
	 */
	void createPieChartPage() {
		result = new DefaultPieDataset();  

		 JFreeChart chart = ChartFactory.createPieChart("Design Decisions", result, true, true, false);  
		 PiePlot plot = (PiePlot) chart.getPlot();  
		  plot.setStartAngle(290);  
		  plot.setDirection(Rotation.CLOCKWISE);  
		  plot.setForegroundAlpha(0.5f);
		 
		Composite composite = new Composite(getContainer(), SWT.NONE);
		FillLayout layout = new FillLayout();
		composite.setLayout(layout);
		new ChartComposite(composite, SWT.NONE, chart, true);
		int index = addPage(composite);
		setPageText(index, "Graph");

		
	}
	
	/**
	 * Creates the source page.
	 */
	void createSourcePage() {
		try {
			editor = new TextEditor();
			int index = addPage(editor, getEditorInput());
			setPageText(index, "Source");
		} catch (PartInitException e) {
			ErrorDialog.openError(
				getSite().getShell(),
				"Error creating nested text editor",
				null,
				e.getStatus());
		}
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
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}
	/**
	 * The <code>MultiPageEditorPart</code> implementation of this 
	 * <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	
	/**
	 * Saves the multi-page editor's document.
	 *
	 * @param monitor the monitor
	 */
	public void doSave(IProgressMonitor monitor) {
		getEditor(0).doSave(monitor);
	}
	
	/**
	 * Saves the multi-page editor's document as another file.
	 * Also updates the text for page 0's tab, and updates this multi-page editor's input
	 * to correspond to the nested editor's.
	 */
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());
	}
	/**
	 * Generate d ds view data.
	 */
	void generateDDsViewData(){
		List<String[]> dds = new ArrayList<String[]>();
		List<Entity> designDecisions = Utils.extractDesignDecisionsAsList(getPath());
		
		for (Entity designDecision : designDecisions){
			dds.add(new String[]{ designDecision.getClassification(), designDecision.getLabel() });
		}
		ddsViewer.setInput(dds);
	}
	
	/**
	 * Get the info for the pie chart.
	 */
	void generatePieData(){
		try {
			List<Entity> designDecisions = Utils.extractDesignDecisionsAsList(getPath());
			HashMap<String,Integer> values = new HashMap<String, Integer>();
			Integer temp = 0;

			for (Entity dd : designDecisions){
				temp = values.get(dd.getClassification());
				if(temp != null){
					temp ++;
				}else{
					temp = 1;
				}
				values.put(dd.getClassification(), temp);
			}
			for(String key : values.keySet()){
				result.setValue(key, values.get(key));
			}
		} catch (Exception e) {
			logger.error("Error generating the pie chart",e);
		}
		
	}
	
	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	private String getPath(){
		String sPath= "";
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = 
		        workbench == null ? null : workbench.getActiveWorkbenchWindow();
		IWorkbenchPage activePage = 
		        window == null ? null : window.getActivePage();

		IEditorPart editor = 
		        activePage == null ? null : activePage.getActiveEditor();
		IEditorInput input = 
		        editor == null ? null : editor.getEditorInput();
		IPath path = input instanceof FileEditorInput 
		        ? ((FileEditorInput)input).getPath()
		        : null;
		if (path != null)
		{
			sPath = path.toOSString();
		}
		return sPath;
	}


	/**
	 * Goto marker.
	 *
	 * @param marker the marker
	 */
	/* (non-Javadoc)
	 * Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		setActivePage(0);
		IDE.gotoMarker(getEditor(0), marker);
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
			throw new PartInitException("Invalid Input: Must be IFileEditorInput");
		super.init(site, editorInput);
	}
	
	/* (non-Javadoc)
	 * Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}
	
	/**
	 * Calculates the contents of page 2 when the it is activated.
	 *
	 * @param newPageIndex the new page index
	 */
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
		if (newPageIndex == 1) {
			generateDDsViewData();
		}
		if (newPageIndex == 2) {
			generatePieData();
		}
		
	}

	/**
	 * Closes all project files on project close.
	 *
	 * @param event the event
	 */
	public void resourceChanged(final IResourceChangeEvent event){
		if(event.getType() == IResourceChangeEvent.PRE_CLOSE){
			Display.getDefault().asyncExec(new Runnable(){
				public void run(){
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (int i = 0; i<pages.length; i++){
						if(((FileEditorInput)editor.getEditorInput()).getFile().getProject().equals(event.getResource())){
							IEditorPart editorPart = pages[i].findEditor(editor.getEditorInput());
							pages[i].closeEditor(editorPart,true);
						}
					}
				}            
			});
		}
	}
}
