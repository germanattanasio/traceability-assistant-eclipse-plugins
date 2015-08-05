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

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import edu.isistan.carcha.nature.ProjectNature;

/**
 * The Class ProjectSupport.
 */
public class ProjectSupport {

	/** The Constant TYPE_SYSTEM_FILENAME. */
	private static final String TYPE_SYSTEM_FILENAME = "TypeSystem.xml";
	
	/** The Constant TYPE_SYSTEM. */
	private static final String TYPE_SYSTEM = ""+
	"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
	"<typeSystemDescription xmlns=\"http://uima.apache.org/resourceSpecifier\">\n"+
	"    <name>edu.isistan.carcha.concern.cdetectorTypeSystem</name>\n"+
	"    <types>\n"+
	"        <typeDescription>\n"+
	"            <name>edu.isistan.carcha.concern.cdetector.Concern</name>\n"+
	"            <description>Type defined in edu.isistan.carcha.concern.cdetector</description>\n"+
	"            <supertypeName>uima.tcas.Annotation</supertypeName>\n"+
	"            <features>\n"+
	"                <featureDescription>\n"+
	"                    <name>kind</name>\n"+
	"                    <description>kind</description>\n"+
	"                    <rangeTypeName>uima.cas.String</rangeTypeName>\n"+
	"                </featureDescription>\n"+
	"            </features>\n"+
	"        </typeDescription>\n"+
	"    </types>\n"+
	"</typeSystemDescription> ";

	/**
	 * For this marvelous project we need to:
	 * - create the default Eclipse project
	 * - add the custom project nature
	 * - create the folder structure.
	 *
	 * @param projectName the project name
	 * @param location the location
	 * @return the i project
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public static IProject createProject(String projectName, URI location) throws UnsupportedEncodingException {
		Assert.isNotNull(projectName);
		Assert.isTrue(projectName.trim().length() > 0);

		IProject project = createBaseProject(projectName, location);
		try {
			addNature(project);

			String[] paths = { "requirements","documentation","traceability" };
			
			addToProjectStructure(project, paths);
			addTypeSystemProjectStructure(project);

		} catch (CoreException e) {
			e.printStackTrace();
			project = null;
		}

		return project;
	}

	/**
	 * Adds the type system project structure.
	 *
	 * @param newProject the new project
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws CoreException the core exception
	 */
	private static void addTypeSystemProjectStructure(IProject newProject) throws UnsupportedEncodingException, CoreException {
		IFile typeSystemFile = newProject.getFile(TYPE_SYSTEM_FILENAME);
		typeSystemFile.create(new ByteArrayInputStream(TYPE_SYSTEM.getBytes("UTF-8")), true, null);
	}

	/**
	 * Just do the basics: create a basic project.
	 *
	 * @param projectName the project name
	 * @param location the location
	 * @return the i project
	 */
	private static IProject createBaseProject(String projectName, URI location) {
		// it is acceptable to use the ResourcesPlugin class
		IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

		if (!newProject.exists()) {
			URI projectLocation = location;
			IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName());
			if (location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
				projectLocation = null;
			}

			desc.setLocationURI(projectLocation);
			try {
				newProject.create(desc, null);
				if (!newProject.isOpen()) {
					newProject.open(null);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		return newProject;
	}

	/**
	 * Creates the folder.
	 *
	 * @param folder the folder
	 * @throws CoreException the core exception
	 */
	private static void createFolder(IFolder folder) throws CoreException {
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			createFolder((IFolder) parent);
		}
		if (!folder.exists()) {
			folder.create(false, true, null);
		}
	}

	/**
	 * Create a folder structure with a parent root, overlay, and a few child
	 * folders.
	 *
	 * @param newProject the new project
	 * @param paths the paths
	 * @throws CoreException the core exception
	 */
	private static void addToProjectStructure(IProject newProject,String[] paths) throws CoreException {
		for (String path : paths) {
			IFolder etcFolders = newProject.getFolder(path);
			createFolder(etcFolders);
		}
	}

	/**
	 * Adds the nature.
	 *
	 * @param project the project
	 * @throws CoreException the core exception
	 */
	private static void addNature(IProject project) throws CoreException {
		if (!project.hasNature(ProjectNature.NATURE_ID)) {
			IProjectDescription description = project.getDescription();
			String[] prevNatures = description.getNatureIds();
			String[] newNatures = new String[prevNatures.length + 1];
			System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
			newNatures[prevNatures.length] = ProjectNature.NATURE_ID;
			description.setNatureIds(newNatures);

			IProgressMonitor monitor = null;
			project.setDescription(description, monitor);
		}
	}

}