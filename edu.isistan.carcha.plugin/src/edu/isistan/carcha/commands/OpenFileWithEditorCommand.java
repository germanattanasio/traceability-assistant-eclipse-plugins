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
package edu.isistan.carcha.commands;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * The Class OpenFileWithEditorCommand.
 */
public class OpenFileWithEditorCommand {

	/** The trace file. */
	private IFile traceFile;
	
	/** The logger. */
	private Log logger = LogFactory.getLog(OpenFileWithEditorCommand.class);

	/**
	 * Instantiates a new open file with editor command.
	 *
	 * @param traceFile the trace file
	 */
	public OpenFileWithEditorCommand(IFile traceFile) {
		super();
		this.traceFile = traceFile;
	}

	/**
	 * Run.
	 *
	 * @param workbench the workbench
	 * @param shell the shell
	 */
	public void run(IWorkbench workbench, Shell shell) {
		// Select the new file resource in the current view
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = workbenchWindow.getActivePage();
		final IWorkbenchPart activePart = page.getActivePart();
		
		// Open an editor on the new file
		try {
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(traceFile);
				shell.getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}
			page.openEditor(new FileEditorInput(traceFile), workbench.getEditorRegistry().getDefaultEditor(traceFile.getFullPath().toString()).getId());					 	 
		}
		catch (PartInitException exception) {
			MessageDialog.openError(workbenchWindow.getShell(), "Error opening the editor.", exception.getMessage());
			logger.error("Error opening the editor.",exception);
		}
		
	}

}
