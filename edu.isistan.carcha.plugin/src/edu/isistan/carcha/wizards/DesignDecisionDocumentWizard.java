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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import edu.isistan.carcha.commands.UIMAAnnotatorCommand;


/**
 * The Class DesignDecisionDocumentWizard.
 */
public class DesignDecisionDocumentWizard extends Wizard implements INewWizard {	
	
	/** The dxmi creation page. */
	private DXMICreationPage dxmiCreationPage;
	
	/** The ado selection page. */
	private ADOSelectionPage adoSelectionPage;
	
	/** The selection. */
	protected IStructuredSelection selection;
	
	/** The workbench. */
	protected IWorkbench workbench;
	
	/** The logger. */
	private Log logger = LogFactory.getLog(DesignDecisionDocumentWizard.class);

	/**
	 * Instantiates a new design decision document wizard.
	 */
	public DesignDecisionDocumentWizard() {
		setWindowTitle("Design Decision Document Wizard");
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
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if (nextPage instanceof DXMICreationPage) {
			IFile input = adoSelectionPage.getFile();
			IResource parent = input.getParent();
			// Set this for the container
			dxmiCreationPage.setContainerFullPath(input.getFullPath());
			// Make up a unique new name here
			String name = input.getName();
			String extension = input.getFileExtension();
			String defaultModelBaseFilename = name.substring(0, name.length() - extension.length() - 1);
			String modelFilename = defaultModelBaseFilename + "." + CarchaWizard.EXTENSIONS_DXMI_PLANE;
			for (int i = 1; ((IContainer)parent).findMember(modelFilename) != null; ++i) {
				modelFilename = defaultModelBaseFilename + i + "." + CarchaWizard.EXTENSIONS_DXMI_PLANE;
			}
			//Save the DXMI File
			dxmiCreationPage.setFileName(modelFilename);
		}
		return nextPage;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return dxmiCreationPage.isPageComplete() && adoSelectionPage.isPageComplete();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		try {			
			// ADO
			final IFile adoFile = adoSelectionPage.getFile();

			// Do the work within an workspace operation
			getContainer().run(false, false, new UIMAAnnotatorCommand(adoFile,dxmiCreationPage.getFile()));
			
			
			
			// Open an editor on the new file
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			try {
				// Select the new file resource in the current view
				if (activePart instanceof ISetSelectionTarget) {
					final ISelection targetSelection = new StructuredSelection(dxmiCreationPage.getFile());
					getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							((ISetSelectionTarget)activePart).selectReveal(targetSelection);
						}
					});
				}
				page.openEditor(new FileEditorInput(dxmiCreationPage.getFile()), workbench.getEditorRegistry().getDefaultEditor(dxmiCreationPage.getFile().getFullPath().toString()).getId());					 	 
			}
			catch (PartInitException exception) {
				logger.error("Error ", exception);
				MessageDialog.openError(workbenchWindow.getShell(), "Error opening the editor.", exception.getMessage());
				return false;
			}
			
			return true;
		}
		catch (Exception exception) {
			logger.error("Error ", exception);
			exception.printStackTrace();
			return false;
		}
	}
}
