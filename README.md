# Welcome to Readme!

This document will guid you to successfully run the Application but also were to find all of the Reports and exploratory Test file.

This git repository has diferente folders, for instance:

1. **Exploratory Test - Reporting** - this folder contains the document with all the report issues and suggestions that were found in the "Test Drive Booking - Screenshot_v3.4" file.
2. **QA Documents** - this folder contains all of the information that was given in order to create this QA Automation Challenge.
3. **Java project folders (src,target,webservices)** - this file contains all the necessary "project" files in order to run the java application with Intelli J or other IDE.

# How the java project/mini framework works.

This project was build using maven project in order for us to use dependencies more more easily. In this mini framework there are different repositories, like:

1. **Selenium** - used in order for us to interact with browser objects with the help with the proper browser driver.
2. **Cucumber** - used in order to create a more readable testing file and use always the same "structure"
3. **POI** - used in order to manipulate files like word, excel etc.

All of the above repositories are used in order for us to easily scaling the framework if there is any reason for that.

# How to use this mini framework

1. Download this repository and open with your favorite IDE( personally i use Intelli J).
2. If there is any errors with the imports. Try to re-install the maven repositories. To do that, follow the bellow steps:
   - Open the Pom.xml file and run "maven clean" and the "maven install".
3. Under the folder src->test->java open the class name "WebTestingTC01" and run this file.
4. After the test is complete if there is no folder named "report" it will automatically generate one. 5. Inside the generate folder you will find 2 files: - One file is a .xslx file with the information about the test. It's like a report file. The other file will be an screenshot as required for the given Test Case.

StackEdit stores your files in your browser, which means all your files are automatically saved locally and are accessible **offline!**
