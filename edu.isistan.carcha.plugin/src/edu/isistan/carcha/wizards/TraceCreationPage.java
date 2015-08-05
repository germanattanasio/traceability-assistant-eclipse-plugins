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
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * The Class TraceCreationPage.
 */
public class TraceCreationPage extends WizardNewFileCreationPage {
	
	/** The id. */
	public static String ID = "edu.isistan.carcha.wizards.TraceCreationPage";
	
	/** The selection. */
	@SuppressWarnings("unused")
	private IStructuredSelection selection;
	
	/** The dimensions. */
	private Spinner dimensions;
	
	/** The threshold. */
	private Spinner threshold;
	
	/** The dimensions. */
	private static int DIMENSIONS = 100;
	
	/** The threshold. */
	private static int THRESHOLD = 750; //0.75
	
	/**
	 * Create the wizard.
	 *
	 * @param selection the selection
	 */
	public TraceCreationPage(IStructuredSelection selection) {
		super(ID, selection);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validatePage()
	 */
	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !extension.equalsIgnoreCase(CarchaWizard.EXTENSION_TRA)) {
				String message = "The file name must end in '%s'";
				setErrorMessage(String.format(message, CarchaWizard.EXTENSION_TRA));
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
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
	      // inherit default container and name specification widgets
	      super.createControl(parent);
	      final Composite composite = (Composite)getControl();

	      // sample section generation group
	      final Group group = new Group(composite,SWT.NONE);
	      group.setLayout(new GridLayout(2,false));
	      group.setText("Traceability algorithm parameter(LSA)");
	      group.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));

	      
			Label nameLabel = new Label(group, SWT.NONE);
			nameLabel.setText("Dimensions:");
			
			dimensions = new Spinner(group, SWT.BORDER);  // use desired style  
			dimensions.setMinimum(50);
			dimensions.setMaximum(300);
			dimensions.setSelection(DIMENSIONS);
			dimensions.setIncrement(1);
			dimensions.setPageIncrement(10);
			GridData gridData = new GridData();
			gridData.horizontalAlignment = SWT.FILL;
			gridData.grabExcessHorizontalSpace = true;
			dimensions.setLayoutData(gridData);
		      
			Label thresholdLabel = new Label(group, SWT.NONE);
			thresholdLabel.setText("Threshold:");
			gridData = new GridData();
			gridData.verticalAlignment = SWT.TOP;
			thresholdLabel.setLayoutData(gridData);
			
			
			threshold = new Spinner(group, SWT.NONE);
			// allow 3 decimal places
			threshold.setDigits(3);
			// set the minimum value to 0.001
			threshold.setMinimum(1);
			// set the maximum value to 20
			threshold.setMaximum(1000);
			// set the increment value to 0.010
			threshold.setIncrement(10);
			// set the seletion to 3.456
			threshold.setSelection(THRESHOLD);
			gridData = new GridData();
			gridData.horizontalAlignment = SWT.FILL;
			gridData.grabExcessHorizontalSpace = true;
			threshold.setLayoutData(gridData);
			
}

	/**
	 * Gets the dimensions.
	 *
	 * @return the dimensions
	 */
	public Integer getDimensions() {
		return Integer.parseInt(dimensions.getText());
	}

	/**
	 * Gets the threshold.
	 *
	 * @return the threshold
	 */
	public Double getThreshold() {
		return Double.parseDouble(threshold.getText());
	}
}
