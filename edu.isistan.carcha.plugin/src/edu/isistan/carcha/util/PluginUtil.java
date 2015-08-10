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
package edu.isistan.carcha.util;

import isistan.edu.carcha.model.carcha.CarchaFactory;
import isistan.edu.carcha.model.carcha.CarchaPackage;
import isistan.edu.carcha.model.carcha.CarchaProject;
import isistan.edu.carcha.model.carcha.CrosscuttingConcern;
import isistan.edu.carcha.model.carcha.DesignDecision;
import isistan.edu.carcha.model.carcha.TraceabilityLink;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import edu.isistan.carcha.lsa.model.Entity;
import edu.isistan.carcha.lsa.model.Entity.NodeType;

/**
 * The PluginUtil class contains utility methods to operate with REA and DXMI files.
 */
public class PluginUtil {
 
	private static final Log logger = LogFactory.getLog(PluginUtil.class);

	/**
	 * Extracts Crosscutting Concerns from a REA file.
	 *
	 * @param iFile the i file
	 * @return the Crosscutting Concern list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static List<Entity> concernsFromListFileAsList(IFile iFile) throws IOException {
		List<Entity> ret = new ArrayList<Entity>();
		List<String> documents = FileUtils.readLines(iFile.getRawLocation().makeAbsolute().toFile(),"utf-8");
		for (String cStr : documents) {
			String [] concernStr = cStr.split("\\t",2);
			ret.add(new Entity(concernStr[1],concernStr[0],NodeType.CC));
		}
		
		removeDuplicates(ret);
		
		return ret;
	}

	/**
	 * Check if svd is installed
	 * Install it from: https://github.com/lucasmaystre/svdlibc
	 * @return true, if svd is installed
	 */
	public static boolean isSVDInstalled() {
		try {
			Runtime.getRuntime().exec("svd");
		} catch (Exception e) {
			logger.error("svd is not installed. It needs to be visible from the PATH variable in eclipse");
			return false;
		}
		return true;
	}
	
	/**
	 * Removes the duplicates.
	 *
	 * @param concerns the concerns
	 */
	public static void removeDuplicates(List<Entity> concerns) {
		ArrayList<Entity> ret = new ArrayList<Entity>();
		HashSet<Entity>  hash = new HashSet<Entity> ();
		hash.addAll(concerns);
		ret.clear();
		ret.addAll(hash);
	}
	
	/**
	 * Extracts design decisions from a DXMI file.
	 *
	 * @param dxmiFile the DXMI file from where the design decisions will be extracted
	 * @return the design decision list extracted from the DXMIFile
	 */
	public static List<Entity> designDecisionsAsList(IFile dxmiFile) {
		
		return Utils.extractDesignDecisionsAsList(dxmiFile.getRawLocation().toOSString());
	}

	/**
	 * Save traceability model to xmi file.
	 *
	 * @param traceabilityFile the traceability file
	 * @param rootModel the root model
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static  void saveTraceabilityModel(IFile traceabilityFile, CarchaProject rootModel) throws IOException {
		String traceURI = traceabilityFile.getFullPath().toString();
		URI fileURI = URI.createPlatformResourceURI(traceURI, true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(rootModel);
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		resource.save(options);
	}
	
	
	
	/**
	 * Load traceability model from an xmi file and parse it to a CarchaProject.
	 *
	 * @param traceabiliyFile the traceabiliy file
	 * @return the carcha project
	 */
	public static CarchaProject loadTraceabilityModel(IFile traceabiliyFile) {
		URI resourceURI = URI.createURI(traceabiliyFile.getLocationURI().toString());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(resourceURI, true);
		CarchaProject project = (CarchaProject) resource.getContents().get(0);
		return project;
	}
	
	/**
	 * Creates the new link.
	 *
	 * @param crosscuttingConcern - [0] kind - [1] name
	 * @param designDecision - [0] kind - [1] name
	 * @param rootModel the root model
	 */
	public static void createNewLink(String[] crosscuttingConcern, String[] designDecision, CarchaProject rootModel){
		CarchaPackage carchaPackage = CarchaPackage.eINSTANCE;
		CarchaFactory carchaFactory = carchaPackage.getCarchaFactory();
		
		TraceabilityLink modelLink = carchaFactory.createTraceabilityLink();
		
		isistan.edu.carcha.model.carcha.CrosscuttingConcern ccc = carchaFactory.createCrosscuttingConcern();
		ccc.setKind(crosscuttingConcern[0]);
		ccc.setName(crosscuttingConcern[1]);
		modelLink.setConcern(ccc);

		DesignDecision dd = carchaFactory.createDesignDecision();
		dd.setKind(designDecision[0]);
		dd.setName(designDecision[1]);
		modelLink.setDesignDecision(dd);
		
		modelLink.setWeight(1);
		rootModel.getLinks().add(modelLink);
	}
	
	/**
	 * Removes the link.
	 *
	 * @param crosscuttingConcern - [0] kind - [1] name
	 * @param designDecision - [0] kind - [1] name
	 * @param rootModel the root model
	 */
	public static void removeLink(String[] crosscuttingConcern, String[] designDecision, CarchaProject rootModel){
		CarchaPackage carchaPackage = CarchaPackage.eINSTANCE;
		CarchaFactory carchaFactory = carchaPackage.getCarchaFactory();
		
		TraceabilityLink modelLink = carchaFactory.createTraceabilityLink();
		
		isistan.edu.carcha.model.carcha.CrosscuttingConcern ccc = carchaFactory.createCrosscuttingConcern();
		ccc.setKind(crosscuttingConcern[0]);
		ccc.setName(crosscuttingConcern[1]);
		modelLink.setConcern(ccc);

		DesignDecision dd = carchaFactory.createDesignDecision();
		dd.setKind(designDecision[0]);
		dd.setName(designDecision[1]);
		modelLink.setDesignDecision(dd);
		
		modelLink.setWeight(1);
		isistan.edu.carcha.model.carcha.TraceabilityLink linkToRemove = null;
		boolean existLink = false;
		for (isistan.edu.carcha.model.carcha.TraceabilityLink link : rootModel.getLinks()){
			if(link.getConcern().getKind().equals(ccc.getKind()) && link.getConcern().getName().equals(ccc.getName())
					&& link.getDesignDecision().getKind().equals(dd.getKind()) && link.getDesignDecision().getName().equals(dd.getName())){
				linkToRemove = link;
				existLink = true;
			}
		}
		if (existLink){
			rootModel.getLinks().remove(linkToRemove);
		}
	}
	
	/**
	 * Gets the unused concerns.
	 *
	 * @param cp the cp
	 * @return the unused concerns
	 */
	public static List<isistan.edu.carcha.model.carcha.CrosscuttingConcern> getUnusedConcerns(CarchaProject cp){
		List<isistan.edu.carcha.model.carcha.CrosscuttingConcern> concerns = new ArrayList<isistan.edu.carcha.model.carcha.CrosscuttingConcern>();
		boolean hasLink;
		for (isistan.edu.carcha.model.carcha.CrosscuttingConcern concern : cp.getConcerns()){
			hasLink = false;
			for (isistan.edu.carcha.model.carcha.TraceabilityLink link : cp.getLinks()){
				if ( (concern.getName().equalsIgnoreCase(link.getConcern().getName()))  && (concern.getKind().equalsIgnoreCase(link.getConcern().getKind())) ){
					hasLink = true;
				}
			}
			if(!hasLink){
				concerns.add(concern);
			}
		
		}
		return concerns;
	}
	
	/**
	 * Gets the unused design decisions.
	 *
	 * @param cp the cp
	 * @return the unused design decisions
	 */
	public static List<DesignDecision> getUnusedDesignDecisions(CarchaProject cp){
		List<DesignDecision> dds = new ArrayList<DesignDecision>();
		boolean hasLink;
		for (DesignDecision dd : cp.getDesignDecisions()){
			hasLink = false;
			for (isistan.edu.carcha.model.carcha.TraceabilityLink link : cp.getLinks()){
				if ( (dd.getName().equalsIgnoreCase(link.getDesignDecision().getName()))  && (dd.getKind().equalsIgnoreCase(link.getDesignDecision().getKind())) ){
					hasLink = true;
				}
			}
			if(!hasLink){
				dds.add(dd);
			}
		
		}
		return dds;
	}
	
	/**
	 * Gets the design decisions for cross cutting concern.
	 *
	 * @param cp the cp
	 * @param cccs the cccs
	 * @return the design decisions for cross cutting concern
	 */
	public static List<DesignDecision> getDesignDecisionsForCrossCuttingConcern(CarchaProject cp, CrosscuttingConcern ccc ){
		List<DesignDecision> dds = new ArrayList<DesignDecision>();
		for (isistan.edu.carcha.model.carcha.TraceabilityLink link : cp.getLinks()){
			if  (link.getConcern().getName().equalsIgnoreCase(ccc.getName())){
				dds.add(link.getDesignDecision());
			}
		}
		return dds;
	}
	
	/**
	 * Gets the linked cross cutting concerns.
	 *
	 * @param cp the cp
	 * @return the linked cross cutting concerns
	 */
	public static List<isistan.edu.carcha.model.carcha.CrosscuttingConcern> getLinkedCrossCuttingConcerns(CarchaProject cp){
		List<isistan.edu.carcha.model.carcha.CrosscuttingConcern> cccs = new ArrayList<isistan.edu.carcha.model.carcha.CrosscuttingConcern>();
		
		for (isistan.edu.carcha.model.carcha.TraceabilityLink link : cp.getLinks()){
			boolean equals = false;
			for (isistan.edu.carcha.model.carcha.CrosscuttingConcern concern : cccs){
				if ( (link.getConcern().getName().equals(concern.getName())) && 
						(link.getConcern().getKind().equals(concern.getKind())) ){
					equals = true;
					break;
				}	
			}
			if (!equals){
				cccs.add(link.getConcern());
			}
		}
		return cccs;
	}
	
	/**
	 * Gets the design decisions for cross cutting concern.
	 *
	 * @param cp the carcha projecy
	 * @param name the crosscutting concern covered text
	 * @param kind the crosscutting concern classification
	 * @return the design decisions for cross cutting concern
	 */
	public static List<DesignDecision> getDesignDecisionsForCrossCuttingConcern(CarchaProject cp, String name, String kind ){
		List<DesignDecision> dds = new ArrayList<DesignDecision>();
		
		for (isistan.edu.carcha.model.carcha.TraceabilityLink link : cp.getLinks()){
				if ( (link.getConcern().getName().equalsIgnoreCase(name))) {
					dds.add(link.getDesignDecision());
				}	
		}
		return dds;
	}
	
	/**
	 * Gets the cross cutting concerns distribution.
	 *
	 * @param cp the cp
	 * @return the cross cutting concerns distribution
	 */
	public static HashMap<String,Integer> getCrossCuttingConcernsDistribution(CarchaProject cp){
		HashMap<String,Integer> values = new HashMap<String, Integer>();
		Integer temp = 0;

		for (isistan.edu.carcha.model.carcha.TraceabilityLink link : cp.getLinks()){
			temp = values.get(link.getConcern().getKind());
			if(temp != null){
				temp ++;
			}else{
				temp = 1;
			}
			values.put(link.getConcern().getKind(), temp);
		}
		return values;
	}
	
	/**
	 * Gets the DD distribution for cross cutting concern.
	 *
	 * @param cp the cp
	 * @param kind the kind
	 * @return the DD distribution for cross cutting concern
	 */
	public static HashMap<String,Integer> getDDDistributionForCrossCuttingConcern(CarchaProject cp, String kind){
		HashMap<String,Integer> values = new HashMap<String, Integer>();
		Integer temp = 0;

		for (TraceabilityLink link : cp.getLinks()){
			if (link.getConcern().getKind().equalsIgnoreCase(kind)){
				temp = values.get(link.getDesignDecision().getKind());
				if(temp != null){
					temp ++;
				}else{
					temp = 1;
				}
				values.put(link.getDesignDecision().getKind(), temp);
			}
		}
		return values;
	}
}
