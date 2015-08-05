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

import isistan.edu.carcha.model.carcha.CarchaFactory;
import isistan.edu.carcha.model.carcha.CarchaPackage;
import isistan.edu.carcha.model.carcha.CarchaProject;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import edu.isistan.carcha.lsa.LSARunner;
import edu.isistan.carcha.lsa.model.Entity;
import edu.isistan.carcha.lsa.model.TraceabilityDocument;
import edu.isistan.carcha.model.adapter.TraceabilityAdapter;
import edu.isistan.carcha.util.PluginUtil;

/**
 * The Class TraceabilityRecoverCommand.
 */
public class TraceabilityRecoverCommand  extends WorkspaceModifyOperation {

	/** The project name. */
	private String projectName;
	
	/** The rea file. */
	private IFile reaFile;
	
	/** The dxmi file. */
	private IFile dxmiFile;
	
	/** The tra file. */
	private IFile traFile;
	
	/** The dimension. */
	private int dimension;
	
	/** The threshold. */
	private double threshold;
	
	/** The carcha package. */
	protected CarchaPackage carchaPackage = CarchaPackage.eINSTANCE;
	
	/** The carcha factory. */
	protected CarchaFactory carchaFactory = carchaPackage.getCarchaFactory();
	
	/** The logger. */
	private Log logger = LogFactory.getLog(TraceabilityRecoverCommand.class);

	
	/**
	 * Creates the initial model.
	 *
	 * @return the carcha project
	 */
	private CarchaProject createInitialModel() {
		return carchaFactory.createCarchaProject();
	}
	
	/**
	 * Instantiates a new traceability recover command.
	 *
	 * @param projectName the project name
	 * @param reaFile the rea file
	 * @param dxmiFile the dxmi file
	 * @param traFile the tra file
	 * @param dimension the dimension
	 * @param threshold the threshold
	 */
	public TraceabilityRecoverCommand(String projectName, IFile reaFile, IFile dxmiFile,
			IFile traFile, int dimension, double threshold) {
		super();
		this.projectName = projectName;
		this.reaFile = reaFile;
		this.dxmiFile = dxmiFile;
		this.traFile = traFile;
		this.dimension = dimension;
		this.threshold = threshold;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void execute(IProgressMonitor progressMonitor) throws CoreException,InvocationTargetException, InterruptedException {
		progressMonitor.beginTask("Recovering Traceability links",100);
		try {
			logger.info("Reading the requirements Concerns from REA file: "+ reaFile.getName());
			List<Entity> reaConcerns = PluginUtil.concernsFromListFileAsList(reaFile);
			logger.info("Reading the design decision from DXMI file: "+ dxmiFile.getName());
			List<Entity> designDecisions = PluginUtil.designDecisionsAsList(dxmiFile);
			
			logger.info("Running the traceability Recovering Tool with dim: "+dimension+" thresold: "+threshold);
			LSARunner lsaRunner = new LSARunner(reaConcerns,designDecisions,dimension,threshold);	
			
			TraceabilityDocument trace = lsaRunner.getTraceability();
			
			//Create and fill the traceability model
			CarchaProject rootModel = createInitialModel();
			rootModel.setName(projectName);
			TraceabilityAdapter adapter = new TraceabilityAdapter();
			adapter.traceabilityDocument2CarchaProject(trace,rootModel,reaConcerns,designDecisions);
			
			PluginUtil.saveTraceabilityModel(traFile, rootModel);
			
			traFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
		} catch (Exception e) {
			logger.error("Error generating the trace file at: "+traFile.getRawLocation(),e);
		}
		progressMonitor.worked(100);
		progressMonitor.done();
	}
}
