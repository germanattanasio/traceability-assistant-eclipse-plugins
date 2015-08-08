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

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import edu.isistan.carcha.CarchaPipeline;

/**
 * The Class UIMAAnnotatorCommand its a command that execute the UIMAAnnotator
 * It connects the Carcha plug-in with the algorithms that annotate 
 * the architecture document.
 */
public class UIMAAnnotatorCommand extends WorkspaceModifyOperation {

	/** The logger. */
	private Log logger = LogFactory.getLog(UIMAAnnotatorCommand.class);

	/** The input file. */
	private IFile inputFile;
	
	/** The output file. */
	private IFile outputFile;
	
	
	/**
	 * Instantiates a new UIMA Annotator.
	 *
	 * @param inputFile the .ADO file
	 * @param outputFile the .DXMI file
	 */
	public UIMAAnnotatorCommand(IFile inputFile, IFile outputFile) {
		super();
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void execute(IProgressMonitor progressMonitor) throws CoreException,InvocationTargetException, InterruptedException {
			progressMonitor.beginTask("Annotating Design Decisions in the ADO file", 100);
		
			String inputFilename = inputFile.getRawLocation().toOSString();
			String dxmiURI = outputFile.getRawLocation().toOSString();
			try {
				CarchaPipeline uimaAnnotator = new CarchaPipeline();
				logger.info("Running the UIMAAnnotator with: "+inputFilename + " and: "+dxmiURI);
				uimaAnnotator.executeUIMAAnnotator(inputFilename, dxmiURI);
				outputFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e) {
				logger.error("Error executing the UIMAAnnotator",e);
			} finally {
				progressMonitor.worked(100);
				progressMonitor.done();
			}
	}

}
