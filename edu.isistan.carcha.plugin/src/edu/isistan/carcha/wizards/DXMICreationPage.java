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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * The Class DXMICreationPage.
 */
public class DXMICreationPage extends WizardNewFileCreationPage {
	
	/** The id. */
	public static String ID = "edu.isistan.carcha.wizards.DXMICreationPage";
	
	/** The selection. */
	@SuppressWarnings("unused")
	private IStructuredSelection selection;
	
	/**
	 * Create the wizard.
	 *
	 * @param selection the selection
	 */
	public DXMICreationPage(IStructuredSelection selection) {
		super(ID, selection);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validatePage()
	 */
	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !extension.equalsIgnoreCase(CarchaWizard.EXTENSIONS_DXMI_PLANE)) {
				String message = "The file name must end in '%s'";
				setErrorMessage(String.format(message, CarchaWizard.EXTENSIONS_DXMI_PLANE));
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public IFile getFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}
}
