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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import edu.isistan.carcha.components.WorkbenchTreeViewer;

/**
 * The Class DXMISelectionPage.
 */
public class DXMISelectionPage extends WizardPage {
	
	/** The id. */
	public static String ID = "edu.isistan.carcha.wizards.DXMISelectionPage";
	
	/** The tree viewer. */
	private WorkbenchTreeViewer treeViewer;
	
	/** The selection. */
	private IStructuredSelection selection;
	
	/**
	 * Create the wizard.
	 *
	 * @param selection the selection
	 */
	public DXMISelectionPage(IStructuredSelection selection) {
		super(ID);
		this.selection = selection;
	}

	/**
	 * Create contents of the wizard.
	 *
	 * @param parent the parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(1, false));
		
		treeViewer = new WorkbenchTreeViewer(container, SWT.SINGLE, CarchaWizard.EXTENSIONS_DXMI);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				setPageComplete(validatePage());
			}
		});
		StructuredSelection selection = getSelection();
		if(selection != null)
			treeViewer.setSelection(selection);
		
		setControl(container);
		
		setPageComplete(validatePage());
	}
	
	/**
	 * Gets the selection.
	 *
	 * @return the selection
	 */
	private StructuredSelection getSelection() {
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					IFile selectedFile = (IFile) selectedResource;
					if(selectedFile.getFileExtension().equalsIgnoreCase(CarchaWizard.EXTENSIONS_DXMI_PLANE))
						return new StructuredSelection(selectedResource);
					selectedResource = selectedResource.getParent();
				}
				// This gives us a directory...
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container
					return new StructuredSelection(selectedResource);
				}
			}
		}
		return null;
	}
	
	/**
	 * Gets the resource.
	 *
	 * @return the resource
	 */
	private IResource getResource() {
		return treeViewer.getSingleResult();
	}
	
	/**
	 * Validate resource.
	 *
	 * @param resource the resource
	 * @return true, if successful
	 */
	private boolean validateResource(IResource resource) {
		if (resource != null && !resource.isDerived()) {
			if (resource.getType() == IResource.FILE) {
				String extension = resource.getFileExtension();
				if (extension != null) {
					if (extension.equalsIgnoreCase(CarchaWizard.EXTENSIONS_DXMI_PLANE))
						return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Validate page.
	 *
	 * @return true, if successful
	 */
	protected boolean validatePage() {
		if(!validateResource(getResource())) {
			String message = "Invalid DXMI input file. The file name must end in '%s'";
			setErrorMessage(String.format(message, CarchaWizard.EXTENSIONS_DXMI_PLANE));
			return false;
		}
		setErrorMessage(null);
		return true;
	}
	
	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public IFile getFile() {
		return (IFile) getResource();
	}
}
