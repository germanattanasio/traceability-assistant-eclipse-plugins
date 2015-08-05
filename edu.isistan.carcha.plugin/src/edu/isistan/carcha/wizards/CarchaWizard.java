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
package edu.isistan.carcha.wizards;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import edu.isistan.carcha.commands.OpenFileWithEditorCommand;
import edu.isistan.carcha.commands.TraceabilityRecoverCommand;
import edu.isistan.carcha.commands.UIMAAnnotatorCommand;


/**
 * The  CarchaWizard Its a Wizard to create a traceability link.
 */
public class CarchaWizard extends Wizard implements INewWizard {
	
	/** The extensions dxmi plane. */
	public static String EXTENSIONS_DXMI_PLANE = "dxmi";
	
	/** The extensions ado plane. */
	public static String EXTENSIONS_ADO_PLANE = "ado";
	
	/** The extensions rea plane. */
	public static String EXTENSIONS_REA_PLANE = "rea";
		
	/** The extensions rea. */
	public static String[] EXTENSIONS_REA = {EXTENSIONS_REA_PLANE};
	
	/** The extensions ado. */
	public static String[] EXTENSIONS_ADO = {EXTENSIONS_ADO_PLANE};
	
	/** The extensions dxmi. */
	public static String[] EXTENSIONS_DXMI = {EXTENSIONS_DXMI_PLANE};

	/** The logger. */
	private Log logger = LogFactory.getLog(CarchaWizard.class);

	
	/** The base output. */
	public static String BASE_OUTPUT = "untitled";
	
	/** The extension tra. */
	public static String EXTENSION_TRA = "tra";
	
	/** The dxmi page. */
	private DXMIPage dxmiPage;
	
	/** The dxmi creation page. */
	private DXMICreationPage dxmiCreationPage;
	
	/** The dxmi selection page. */
	private DXMISelectionPage dxmiSelectionPage;
	
	/** The rea selection page. */
	private REASelectionPage reaSelectionPage;
	
	/** The ado selection page. */
	private ADOSelectionPage adoSelectionPage;
	
	/** The trace creation page. */
	private TraceCreationPage traceCreationPage;

	/** The selection. */
	protected IStructuredSelection selection;
	
	/** The workbench. */
	protected IWorkbench workbench;
	
	/**
	 * Instantiates a new carcha wizard.
	 */
	public CarchaWizard() {
		setWindowTitle("Recovering Documentation-to-Requirement Traceability Links Wizard");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {		

		// REA Selection Page
		reaSelectionPage = new REASelectionPage(selection);
		reaSelectionPage.setTitle("REA Selection");
		reaSelectionPage.setDescription("Select a requirement engineering assistant(REA) as input.");
		addPage(reaSelectionPage);
		
		// DXMI Page
		dxmiPage = new DXMIPage();
		dxmiPage.setTitle("UIMA Options");
		dxmiPage.setDescription("Select how to obtain a Design Decision Document(DXMI) model.");
		addPage(dxmiPage);
		
		// DXMI Selection Page
		dxmiSelectionPage = new DXMISelectionPage(selection);
		dxmiSelectionPage.setTitle("DXMI Selection");
		dxmiSelectionPage.setDescription("Select an existing DXMI model.");
		addPage(dxmiSelectionPage);
		
		// ADO Selection Page
		adoSelectionPage = new ADOSelectionPage(selection);
		adoSelectionPage.setTitle("Architecture DOcument Selection");
		adoSelectionPage.setDescription("Select an architecture document(ADO) as input.");
		addPage(adoSelectionPage);
		
		// DXMI Creation Page
		dxmiCreationPage = new DXMICreationPage(selection);
		dxmiCreationPage.setTitle("Design Decision Document Creation");
		dxmiCreationPage.setDescription("Create a new DXMI model.");
		addPage(dxmiCreationPage);
		
		// TRACE Creation Page
		traceCreationPage = new TraceCreationPage(selection);
		traceCreationPage.setTitle("Documentation-to-Requirement Traceability Links Creation");
		traceCreationPage.setDescription("Create a new TRACE file.");
		addPage(traceCreationPage);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = null;
		if(page instanceof DXMIPage) {
			if(dxmiPage.isCreate()) {
				nextPage = adoSelectionPage;
			}
			else {
				nextPage = dxmiSelectionPage;
			}
		} else if(page instanceof ADOSelectionPage) {
			nextPage = dxmiCreationPage;
		} else if(page instanceof DXMISelectionPage) {
			nextPage = traceCreationPage;
		}
		else {
			nextPage = super.getNextPage(page);
		}
		if(nextPage instanceof TraceCreationPage) {
			IFile input = reaSelectionPage.getFile();
			IResource parent = input.getParent();
			// Set this for the container
			traceCreationPage.setContainerFullPath(input.getFullPath());
			// Make up a unique new name here
			String name = input.getName();
			String extension = input.getFileExtension();
			String defaultModelBaseFilename = name.substring(0, name.length() - extension.length() - 1);
			String modelFilename = defaultModelBaseFilename + "." + EXTENSION_TRA;
			for (int i = 1; ((IContainer)parent).findMember(modelFilename) != null; ++i) {
				modelFilename = defaultModelBaseFilename + i + "." + EXTENSION_TRA;
			}
			traceCreationPage.setFileName(modelFilename);
		} else 	if (nextPage instanceof DXMICreationPage) {
			IFile input = adoSelectionPage.getFile();
			IResource parent = input.getParent();
			// Set this for the container
			dxmiCreationPage.setContainerFullPath(input.getFullPath());
			// Make up a unique new name here
			String name = input.getName();
			String extension = input.getFileExtension();
			String defaultModelBaseFilename = name.substring(0, name.length() - extension.length() - 1);
			String modelFilename = defaultModelBaseFilename + "." + EXTENSIONS_DXMI_PLANE;
			for (int i = 1; ((IContainer)parent).findMember(modelFilename) != null; ++i) {
				modelFilename = defaultModelBaseFilename + i + "." + EXTENSIONS_DXMI_PLANE;
			}
			//Save the DXMI File
			dxmiCreationPage.setFileName(modelFilename);
		}
		return nextPage;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#getPreviousPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		IWizardPage previousPage = null;
		if(page instanceof TraceCreationPage) {
			if(dxmiPage.isCreate()) {
				previousPage = dxmiCreationPage;
			}
			else
				previousPage = dxmiSelectionPage;
		}
		else if(page instanceof ADOSelectionPage || page instanceof DXMISelectionPage) {
			previousPage = dxmiPage;
		} else if(page instanceof DXMICreationPage) {
			previousPage = adoSelectionPage;
		} else {
			previousPage = super.getPreviousPage(page);
		}
		return previousPage;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return
			reaSelectionPage.isPageComplete() &&
			dxmiPage.isPageComplete() &&
			((dxmiCreationPage.isPageComplete() && adoSelectionPage.isPageComplete() ) || dxmiSelectionPage.isPageComplete()) &&
			traceCreationPage.isPageComplete();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		try {
			
			final IFile reaFile = reaSelectionPage.getFile();// REA
			final boolean createUIMA = dxmiPage.isCreate();
			final IFile uimaFile = createUIMA ? dxmiCreationPage.getFile() : dxmiSelectionPage.getFile();// UIMA
			final IFile traceFile = traceCreationPage.getFile();// TRACE
			
			// run the UIMA annotator within an operation
			if(createUIMA) {
				final IFile adoFile = adoSelectionPage.getFile();// ADO
				getContainer().run(false, false, new UIMAAnnotatorCommand(adoFile, uimaFile));
			}
			
			// run the Traceability recover within an operation
			getContainer().run(false, false, new TraceabilityRecoverCommand(traceCreationPage.getName(),reaFile, uimaFile,traceFile,traceCreationPage.getDimensions(),traceCreationPage.getThreshold()));
			
			if (traceFile.exists()) {
				//run a command to open the result file. The traceability file :)
				OpenFileWithEditorCommand command = new OpenFileWithEditorCommand(traceFile);
				command.run(workbench,getShell());
			}
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("Error creating the traceability file",e);
			return false;
		}
	}
}
