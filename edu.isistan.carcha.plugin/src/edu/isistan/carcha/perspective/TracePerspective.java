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
package edu.isistan.carcha.perspective;


import org.apache.uima.caseditor.editor.editview.EditView;
import org.apache.uima.caseditor.editor.fsview.FeatureStructureBrowserView;
import org.apache.uima.caseditor.editor.styleview.AnnotationStyleView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * The Class TracePerspective.
 */
public class TracePerspective implements IPerspectiveFactory {
  
  /** The id. */
  public static String ID = "edu.isistan.carcha.perspective";

  /**
   * Define the initial layout of the Carcha Editor Perspective.
   *
   * @param layout the layout
   */
  public void createInitialLayout(IPageLayout layout) {
    defineActions(layout);
    defineLayout(layout);
  }

  /**
   * Define actions.
   *
   * @param layout the layout
   */
  private void defineActions(IPageLayout layout) {

    // add "show views"
    layout.addShowViewShortcut("org.eclipse.ui.navigator.ProjectExplorer");
    layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
    layout.addShowViewShortcut(AnnotationStyleView.ID);

    
    // add "open perspective"
    layout.addPerspectiveShortcut(TracePerspective.ID);
  }

  /**
   * Define layout.
   *
   * @param layout the layout
   */
  private void defineLayout(IPageLayout layout) {
    String editorArea = layout.getEditorArea();

    // left views
    IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT,0.20f, editorArea);
    left.addView("org.eclipse.ui.views.ResourceNavigator");
    
    // right views
    IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT,0.70f, editorArea);

    right.addView(IPageLayout.ID_OUTLINE);
    right.addView(FeatureStructureBrowserView.ID);
    
    IFolderLayout rightBottomCorner  = layout.createFolder("rightBottomCorner", IPageLayout.BOTTOM,0.75f, "right");
    rightBottomCorner.addView(AnnotationStyleView.ID);

    // bottom views
    IFolderLayout rightBottom = layout.createFolder("rightBottom",IPageLayout.BOTTOM, 0.75f, editorArea);

    rightBottom.addView(EditView.ID);

    IFolderLayout leftBottom = layout.createFolder("leftBottom",IPageLayout.RIGHT, 0.5f, EditView.ID);

    //errors
    leftBottom.addView("org.eclipse.ui.views.markers.MarkerSupportView");
  }
}

