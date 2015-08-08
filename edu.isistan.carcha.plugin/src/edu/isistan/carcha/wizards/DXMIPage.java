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

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * The Class DXMIPage.
 */
public class DXMIPage extends WizardPage {
	
	/** The id. */
	public static String ID = "edu.isistan.carcha.wizards.DXMIPage";
	
	/** The form toolkit. */
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	/** The btn create. */
	private Button btnCreate;
	
	/** The btn select. */
	private Button btnSelect;
	
	/**
	 * Create the wizard.
	 */
	public DXMIPage() {
		super(ID);
	}

	/**
	 * Create contents of the wizard.
	 *
	 * @param parent the parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.horizontalSpacing = 10;
		gl_container.verticalSpacing = 10;
		gl_container.marginBottom = 5;
		gl_container.marginTop = 10;
		gl_container.marginRight = 10;
		gl_container.marginLeft = 10;
		container.setLayout(gl_container);
		
		Composite compositeBtn = formToolkit.createComposite(container, SWT.NONE);
		compositeBtn.setLayout(new FillLayout(SWT.VERTICAL));
		compositeBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeBtn.setBounds(0, 0, 64, 64);
		formToolkit.paintBordersFor(compositeBtn);
		
		btnCreate = new Button(compositeBtn, SWT.RADIO);
		btnCreate.setSize(544, 16);
		btnCreate.setText("Recover Design Decisions(DXMI file) from an architectural document.");
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(validatePage());
			}
		});
		
		btnSelect = new Button(compositeBtn, SWT.RADIO);
		btnSelect.setSize(544, 16);
		btnSelect.setText("Select an existent DXMI file.");
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(validatePage());
			}
		});
		
		setPageComplete(validatePage());
	}
	
	/**
	 * Validate page.
	 *
	 * @return true, if successful
	 */
	protected boolean validatePage() {
		return 
			(btnCreate.getSelection() == true && btnSelect.getSelection() == false) ||
			(btnCreate.getSelection() == false && btnSelect.getSelection() == true);
	}
	
	/**
	 * Checks if is creates the.
	 *
	 * @return true, if is creates the
	 */
	public boolean isCreate() {
		return btnCreate.getSelection();
	}
	
	/**
	 * Checks if is select.
	 *
	 * @return true, if is select
	 */
	public boolean isSelect() {
		return btnSelect.getSelection();
	}
}
