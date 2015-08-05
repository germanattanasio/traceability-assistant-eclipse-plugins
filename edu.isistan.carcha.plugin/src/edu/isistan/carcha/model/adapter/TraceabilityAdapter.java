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
package edu.isistan.carcha.model.adapter;

import isistan.edu.carcha.model.carcha.CarchaFactory;
import isistan.edu.carcha.model.carcha.CarchaPackage;
import isistan.edu.carcha.model.carcha.CarchaProject;
import isistan.edu.carcha.model.carcha.CrosscuttingConcern;
import isistan.edu.carcha.model.carcha.DesignDecision;
import isistan.edu.carcha.model.carcha.TraceabilityLink;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.isistan.carcha.lsa.model.Entity;
import edu.isistan.carcha.lsa.model.TraceabilityDocument;

/**
 * TraceabilityAdapter its an adapter to adapt a traceability document to the EMF models that represent it.
 */
public class TraceabilityAdapter {

	/** The carcha package. */
	protected CarchaPackage carchaPackage = CarchaPackage.eINSTANCE;
	
	/** The carcha factory. */
	protected CarchaFactory carchaFactory = carchaPackage.getCarchaFactory();
	
	
	/**
	 * Traceability document 2 carcha project.
	 *
	 * @param trace the traceability document coming from the LSA Algorithm
	 * @param rootModel the Carcha project where the traceability data will be stored
	 * @param reaConcerns the Crosscutting Concerns
	 * @param designDecisions the Design Decisions
	 */
	public void traceabilityDocument2CarchaProject(
			TraceabilityDocument trace, CarchaProject rootModel,
			List<Entity> reaConcerns, List<Entity> designDecisions) {

		Map<Integer, Entity> cccMap = new HashMap<Integer, Entity>();
		Map<Integer, Entity> dddMap = new HashMap<Integer, Entity>();
		
		// copy the crosscuttingConcern
		for (Entity reaConcern : reaConcerns) {
			CrosscuttingConcern ccc = carchaFactory.createCrosscuttingConcern();
			ccc.setKind(reaConcern.getClassification());
			ccc.setName(reaConcern.getLabel());
			rootModel.getConcerns().add(ccc);
			
			cccMap.put(reaConcern.hashCode(), reaConcern);
		}
		
		// copy the designDecisions 
		for (Entity designDecision : designDecisions) {
			DesignDecision ddd = carchaFactory.createDesignDecision();
			ddd.setKind(designDecision.getClassification());
			ddd.setName(designDecision.getLabel());
			rootModel.getDesignDecisions().add(ddd);
			
			dddMap.put(designDecision.hashCode(), designDecision);
		}
	
		// copy the links
		for (edu.isistan.carcha.lsa.model.TraceabilityLink tracelink : trace.getLinks()) {
			Entity cccModel = cccMap.get(tracelink.getConcern());
			Entity dddModel = cccMap.get(tracelink.getDesignDecision());
			
			TraceabilityLink modelLink = carchaFactory.createTraceabilityLink();
			
			//CroscuttingConcern
			CrosscuttingConcern ccc = carchaFactory.createCrosscuttingConcern();
			ccc.setKind(cccModel.getClassification());
			ccc.setName(cccModel.getLabel());
			modelLink.setConcern(ccc);
			
			//DesignDecision
			DesignDecision dd = carchaFactory.createDesignDecision();
			dd.setKind(dddModel.getClassification());
			dd.setName(dddModel.getLabel());
			modelLink.setDesignDecision(dd);
			
			modelLink.setWeight(tracelink.getWeight());
			rootModel.getLinks().add(modelLink);
		}
	}

}
