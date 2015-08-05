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
package edu.isistan.carcha.project;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * The Class ProjectNewWizard.
 */
public class ProjectNewWizard extends Wizard implements INewWizard,IExecutableExtension {

	/** The _page one. */
	private WizardNewProjectCreationPage _pageOne;
	
	/** The _configuration element. */
	private IConfigurationElement _configurationElement;
	
	/**
	 * Instantiates a new project new wizard.
	 */
	public ProjectNewWizard() {
		setWindowTitle("Traceability Project");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		String name = _pageOne.getProjectName();
		URI location = null;
		
		if (!_pageOne.useDefaults()) {
			location = _pageOne.getLocationURI();
		}
		
		try {
			ProjectSupport.createProject(name, location);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		BasicNewProjectResourceWizard.updatePerspective(_configurationElement);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		_pageOne =  new WizardNewProjectCreationPage("Requirement Traceability Project Wizard");
		_pageOne.setTitle("New Project Wizard");
		_pageOne.setDescription("Create a new traceability project.");
		
		addPage(_pageOne);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
	 */
	@Override
	public void setInitializationData(IConfigurationElement config,String propertyName, Object data) throws CoreException {
		_configurationElement = config;
	}
}
