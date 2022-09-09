# ATM

## Build and Generate the JAR file (compile the source code)
```
# Git clone (download the soruce code)
$ git clone https://github.com/mallikaravi/ATM.git
$ cd ATM

# Build and Generate the JAR file (compile the source code)
$ mvn clean package install 
$ java -jar ATM-0.0.1.jar  

# How to generate a jar file from Eclipse IDE
# launch Eclipse IDE >
   > Import project from local drive
   > Select pom.xml > Right Click > Run As > Run configuraions Dialog, Enter "clean package install" in Goals text box 
   > Select Run button

# Run the ATM application, assets folder and jar file should be in same path.
.
├── ...
    ├──assets
    ├──ATM-0.0.1.jar
```
# Table of Contents
<!--ts-->
   * [Prerequisites](#prerequisites)
   * [About](#about)
   * [Project SetUp](#project-setup)
   * [Implementation And Design](#implementation-and-design)
      * [Define a simple Maven Build](#define-a-simple-maven-build)
        * [Dependencies](#dependencies)
        * [UseCase Diagram](#usecase-diagram)
        * [Class Diagram](#class-diagram) 
        * [Class Diagram](#class-diagram) 

	* [Sequence Diagram](#sequence-diagram)
   *  [Tool Used For Project Management](#tool-used-for-project-management)

        
<!--te-->


Prerequisites
============
### - JDK 17.0.2
### - Maven [[Download](https://maven.apache.org/download.cgi) / [Install](https://maven.apache.org/install.html)]



About
============
ATM is a terminal based application.The user should first login in to the application and the use the bank services.If the user is not a registered member,he can create an account by signingup.The user has also option to change his profile.They are


1. Edit Profile
2. Change password
3. Delete profile

This application is used for performing banking operations.

They are:

1. View Balance
2. Deposit
3. Withdraw
4. Transfer

Project setUp
============
First you’ll need to setup a Java project for Maven to build. 

Implementation and Design
============
Explained here 

https://github.com/mallikaravi/ATM/blob/main/design/Bank-ATM-Design.pdf

### Usecase Diagram: 

https://github.com/mallikaravi/ATM/blob/main/design/Bank-ATM-Design.pdf

### Class Diagram 

https://github.com/mallikaravi/ATM/blob/main/design/Bank-ATM-Design.pdf

### Sequence Diagram 

https://github.com/mallikaravi/ATM/blob/main/design/Bank-ATM-Design.pdf

Technology
============
The following technologies are used in designing and developing the recipe manager application.

1. Java – Coding language for implementing the ATM application
2. Eclipse - IDE Purpose 
3. Microsoft Visio - UML Diagram tool
4. Maven - Bulding tool
5. Jackson API-Parsing and saving the models

Define a simple Maven Build
============
1.You need to create a Maven project definition.
2.Maven projects are defined with an XML file named pom.xml.
3.Among other things, this file gives the project’s name, version, and dependencies that it has on external libraries.
4.Create a file named pom.xml at the root of the project.

 Dependencies
============

```
	<dependencies>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>${jackson.version}</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

This is the simplest possible pom.xml file necessary to build a Java project. It includes the following details of the project configuration:

*  modelVersion- POM model version (always 4.0.0).
*  groupId -  Group or organization that the project belongs to. Often expressed as an inverted domain name.
*  artifactId - Name to be given to the project’s library artifact (for example, the name of its JAR or WAR file).
*  version  -  Version of the project that is being built.

Tool used for project management
============
JIRA tool is used for this project, mainly maintaining the recipe-manager application backlogs. In sort following activities are done
- EPIC
- User stories
- Sprint handling
- etc.

### Link to jira
https://github.com/mallikaravi/ATM/tree/main/design






