How to compile the program.
We will be compiling the project and running it in the Eclipse IDE
This all assumes latest version of Java is installed and the class path is set. (1.8 at the time of writing this README).

Required items:
-Eclipse IDE (Eclipse EE preferred, but Eclipse Luna+ is okay.)
-Source code (in Alex_Ariaz_PR_1.zip)
-jar files: Json jar file included in the project folder.
-
-Rest Client plugin for Firefox or Chrome.

Import the Zipped file provided by opening Eclipse then following File>Import…> General> Existing Projects into Workspace.
Select ‘Select archive file’ and browse for the zip folder mentioned above.
Click ‘OK’ and ‘Finish’

From there right click on the project and select ‘Run As’>Maven Clean
This should include all the maven dependencies in the project.

Download the required jar file ‘org.json-20120521.jar’
this can be found at:
https://code.google.com/p/org-json-java/downloads/detail?name=org.json-20120521.jar&can=2&q=

Next, add the Json .jar file to external libraries by right clicking the project>Build Path>Configure Build Path…>Libraries>Add External JARs.
Navigate to where you saved the jar file and select it.
Click 'Add' and 'OK'

Right click the project and Select Maven>Update Project
Make sure vin is selected. Click ‘OK’.

The project should now be fully equipped to run.

To run the project navigate to the run button at the top of  the eclipse toolbar and select run Main.
This will start the server at http://localhost:8080/vin
Enter the above address into whatever REST client you choose.
From there you should have REST functionality.

To run the test files run AllTests.java through eclipse the same way you ran Main.java 

Alex Ariaz 1/1 Final Project

CS445-01:Spring 2015 Illinois Institute of Technology: Computer Science

