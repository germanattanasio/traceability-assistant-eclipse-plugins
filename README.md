# Traceability Assistant - plugins

TRAS(Traceability Assistant) is a semi-automated tool that help analysts uncover traceability links between requirements documents described as use cases and architectural documents.

This project presents TRAS in a set of eclipse plugins. It uses [Tycho](http://www.eclipse.org/tycho) to build and release the plugins.

More information: http://traceability-assistant.mybluemix.net/

## Installation instructions

This plugin has primarily been tested with Eclipse 4.3 and 4.4\. The plugin is not compatible with versions of Eclipse preceding 4.3\. The plugin runs under Java 1.6/6.0, or newer.

To install the TRAS plugin:

1.  In Eclipse, click on **Help** -> **Software Update** -> Find and Install...
2.  Choose the **Search for new features to install** option, and click **Next**.
3.  Click **New Remote Site**.
4.  Enter the following:
    *   **Name:** TRAS update site
    *   **URL:** https://traceability-assistant.mybluemix.net/eclipse and click **OK**.
5.  "TRAS update site" should appear under **Sites to include in search**.   
    Click the checkbox next to it to select it, and click **Finish**.
6.  You should see **TRAS** under **Select features to install**.   
    Select the checkbox next to it and click next.
7.  Select the **I accept** option to accept the license and click **Next**.
8.  The plugin is not digitally signed. Go ahead and install it anyway.
9.  Click **Yes** to make Eclipse restart itself.

### svdlib
In order to use the traceability discovery feature you need to install a library called [SVD](https://github.com/lucasmaystre/svdlibc).  
Once the library is installed, open a terminal and type `svd`.
If you get `command not found`, export the library folder to your PATH.

    export PATH=$PATH:/path/to/svdlibc/directory  

e.g: `/Users/foo/svdlibc` that way the runtime can find the svd command.

Sometimes even if `svd` is installed, eclipse doesn't find it. That's because eclipse is not using the same PATH as your terminal. While running in eclipse you can manually add `svd` to your PATH variable in the run configuration.

**svd as part of the Run Configuration**
![svd](http://s3.postimg.org/zcwajmqg3/Screen_Shot_2015_08_09_at_8_23_54_PM.png)

## Setting up the local environment
Steps to run the plugins in your development environment.

### Assumptions

 * You have eclipse installed. See https://eclipse.org/downloads/
 * You have maven installed. See https://maven.apache.org/
 * You have UIMA RUTA installed. Update site: http://www.apache.org/dist/uima/eclipse-update-site

1. Download the [traceability-assistant](https://github.com/germanattanasio/traceability-assistant) code:

        git clone git@github.com:germanattanasio/traceability-assistant.git

1. Download the plugins code:

        git clone git@github.com:germanattanasio/traceability-assistant-eclipse-plugins.git

1. Generate the [traceability-assistant](https://github.com/germanattanasio/traceability-assistant) jar file.
2. In the `traceability-assistant` folder run:

        mvn clean install

3. Copy `traceability-assistant/target/traceability-assistant-1.1.2-jar-with-dependencies.jar` into `tras-plugins/edu.isistan.carcha.plugin`

4. Create a Eclipse Application Run configuration. See image below.
![run-configuration](http://s11.postimg.org/50q573q6r/Screen_Shot_2015_08_10_at_1_23_25_AM.png)

5. Run it!

**Note:** You can find all the Run configurations in: `tras-plugins/edu.isistan.carcha.master/runners`
![runners](http://s12.postimg.org/z2aoxl1rh/Screen_Shot_2015_08_10_at_1_22_31_AM.png)

## Using TRAS

### Recovering traceability links
![recovering-traceability](/instructions/traceability.gif)

Full [video](http://recordit.co/9T0D0fC7sM).

## Uninstalling TRAS

Run Help > About Eclipse > Installation Details, select **Traceability Assistant** and click Uninstall. (On Macintosh it is Eclipse > About Eclipse > Installation Details.)


## Release process

1. Create a maven run configuration in the parent project
2. Set `tycho-versions:set-version` as goal
3. Add `newVersion` as parameter and `x.x.x` as version.
4. Click Run.
5. Create another maven run configuration in the parent project
6. Set `clean instal` as goal
7. Click Run.
8. The update-site will be available at:  
   `edu.isistan.carcha.p2updatesite/target/edu.isistan.carcha.p2updatesite-x.x.x.zip`  
   The zip file contains all the information you need to install the plugin in your eclipse.

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

1. Open a terminal and type `svd`.
2. If you get `command not found`, export the library folder to your PATH.

        export PATH=$PATH:/path/to/svdlibc/directory

    e.g: `/Users/foo/svdlibc` that way the runtime can find the svd command.

    If you are using eclipse you need to look at the environment. You may need to add the path variable in  your run configuration and include the path to `svd`as showed above.
    You can also follow the instructions in this [blog](http://architectryan.com/2012/10/02/add-to-the-path-on-mac-os-x-mountain-lion/#.UtSw2vbVVyo)


## License

This sample code is licensed under Apache 2.0. Full license text is available in LICENSE.
