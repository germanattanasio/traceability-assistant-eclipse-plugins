# Traceability Assistant - plugins

TRAS(Traceability Assistant) is a semi-automated tool that help analysts uncover traceability links between requirements documents described as use cases and architectural documents.

This project presents TRAS in a set of eclipse plugins. We use [Tycho](http://www.eclipse.org/tycho) to build and release the plugins.

This project depends on [traceability-assistant](https://github.com/germanattanasio/traceability-assistant)

## Installation instructions

1. Open eclipse kelper or newer
2. Help -> Install new software
3. Add Site -> `url to our plugin`
4. Select TRAS
5. Next, Accept, Next...

## Using TRAS

Steps to use the plugin here....

## Release process
You need to run the `tycho-version-plugin` to update the version in all your projects.
1. Create a maven run configuration in the parent project
2. Set `tycho-versions:set-version`
3. Add `newVersion` as parameter and `x.x.x` as version. 
4. Run the maven goal.

## How do I get set up?

### Assumptions

 * You have eclipse installed. See https://eclipse.org/downloads/
 * You have maven installed. See https://maven.apache.org/
 * You have UIMA RUTA installed. Update site: http://www.apache.org/dist/uima/eclipse-update-site
### Steps

1. Download the code:

        git clone git@github.com:germanattanasio/traceability-assistant-eclipse.git

1. Install the [SVD](https://github.com/lucasmaystre/svdlibc) library. 
2. Open a terminal and type `svd`. 
3. If you get `command not found`, export the library folder to your PATH.

        export PATH=$PATH:/path/to/svdlibc/directory

    e.g: `/Users/foo/svdlibc` that way the runtime can find the svd command.

    If you are using eclipse you need to look at the environment. You may need to add the path variable in  your run configuration and include the path to `svd`as showed above.
    You can also follow the instructions in this [blog](http://architectryan.com/2012/10/02/add-to-the-path-on-mac-os-x-mountain-lion/#.UtSw2vbVVyo)

4. Open eclipse, import the project as Maven projects and refresh the workspace.

5. Copy the traceability-assistant jar file to `edu.isistan.carcha.unified` and add it as a dependency. Make sure that the jar name is the same as in the `edu.isistan.carcha.unified/META-INF/MANIFEST.MF` file.

6. Create a Run Configuration and run your workspace as an eclipse plugin.


## What is REAssistant?

REAssistant is an Eclipse toolset that supports the identification of software concerns in textual requirements specifications, mainly use cases.

To achieve its work, REAssistant is based on three pillars:

 * an annotation-based representation of textual use cases,
 * a pipeline of Natural Language Processing (NLP) techniques and domain knowledge (about use cases),
 * concern-specific rules that, when executed on the use case representation, can extract concern-related information.

In this way, REAssistant aims at exposing both candidate concerns and contextual information (typically, crosscutting relations) that might be overlooked by the analyst.

### How to install REAssistant

In order to install REAssistant you will have to contact alejandro.rago[at]gmail[dot]com.

## Troubleshooting

The plugins are using maven + [Tycho](https://wiki.eclipse.org/Tycho/Dependency_Resolution_Troubleshooting)

1. Unable to satisfy dependency during maven build
```
java.lang.RuntimeException: No solution found because the problem is unsatisfiable.: [Unable to satisfy dependency from edu.isistan.carcha.plugin 1.0.0.qualifier...
```

Make sure that you have all the bundle. Check each `plugin.xml` file and match the bundle you have installed with the one needed.

## License

This sample code is licensed under Apache 2.0. Full license text is available in LICENSE.