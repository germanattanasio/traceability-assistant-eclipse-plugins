# Traceability Assistant - plugins

TRAS(Traceability Assistant) is a semi-automated tool that help analysts uncover traceability links between requirements documents described as use cases and architectural documents.

This project presents TRAS in a set of eclipse plugins. We use [Tycho](http://www.eclipse.org/tycho) to build and release the plugins.

This project depends on [traceability-assistant](https://github.com/germanattanasio/traceability-assistant)

## Installation instructions

This plugin has primarily been tested with Eclipse 4.3 and 4.4\. The plugin is not compatible with versions of Eclipse preceding 4.3\. The plugin runs under Java 1.6/6.0, or newer.

To install the TRAS plugin:

1.  In Eclipse, click on **Help** -> **Software Update** -> Find and Install...
2.  Choose the **Search for new features to install** option, and click **Next**.
3.  Click **New Remote Site**.
4.  Enter the following:
    *   **Name:** TRAS update site
    *   **URL:** https://traceability-assistant.mybluemix.net/eclipseand click **OK**.
5.  "TRAS update site" should appear under **Sites to include in search**.   
    Click the checkbox next to it to select it, and click **Finish**.
6.  You should see **TRAS Feature** under **Select features to install**.   
    Select the checkbox next to it and click next.
7.  Select the **I accept** option to accept the license and click **Next**.
8.  The plugin is not digitally signed. Go ahead and install it anyway.
9.  Click **Yes** to make Eclipse restart itself.

## Using TRAS

Steps to use the plugin here....

## Release process
You need to run the `tycho-version-plugin` to update the version in all your projects.
1. Create a maven run configuration in the parent project
2. Set `tycho-versions:set-version`
3. Add `newVersion` as parameter and `x.x.x` as version. 
4. Click Run.


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
