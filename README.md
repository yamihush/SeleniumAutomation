# AutomationFramework

Table of Contents
There are a few things we need before running the tests. These are:

Java Installation / Update
--------------------------
Check your system to see if you have the latest Java version installed.

Command:

$ java -version
If you do not have the latest Java installed, find out how to install Java here.

Ensure your JAVA_HOME environment to the location of the installed JDK

Installing TestNG
-----------------
Download Maven & Install and Set up Maven

Unzip the distribution archive to the directory you wish to install Maven. I extracted maven to my Documents folder
Add Maven to the PATH. More information can be found in the README.txt in the zip folder.

Verify Maven was correctly installed
Command:
$ mvn –version

Running the Project
-------------------
Download the project and go to Terminal / cmd 

From Terminal / cmd -  

Navigate to the location of project then execute "mvn test" to run only test or "mvn clean install"
