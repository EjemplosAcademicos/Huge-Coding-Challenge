# Huge-Coding-Challenge

```
This program is a simple drawing tool. The program reads the input.txt , executes a set of commands from the file, 
step by step, and produces output.txt with the shapes.

At moment the program let to create the following shapes:
 - C w h Create Canvas: create a new canvas of width w and height h.
 - P x1 y1 Create Point: create a new point at (x1,y1)
 - L x1 y1 x2 y2 Create Line: create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported.
 - R x1 y1 x2 y2 Create Rectangle: create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). 
 - B x y c Bucket Fill: fill the entire area connected to (x,y) with "colour" c.

```
## Prerequisites
```
java version "1.8"

Be sure that your JAVA_HOME environment variable points to the jdk1.8.0 folder extracted from the JDK download.
```
## Installation
```
java -jar [DrawingTool.jar] (https://github.com/EjemplosAcademicos/Huge-Coding-Challenge/blob/master/drawingtool/dist/DrawingTool.jar) 
```
## App structure

```
|-- src
|   |-- main/java/com/huge/drawingtool
|   |   |-- boxtool        			       # by convension async modules are prefixed with + sign            
|   |       |-- paint
|   |       	|--
|   |       	|-- 
|   |       |-- shapes
|   |       	|-- 
|   |       	|-- 
|   |       ...
|   |   |-- file
|   | 		|-- feature-module-1.component.html
|   |   |-- util                           # utilities commons to the program
|   |       |-- exceptions                 # mangement exceptions of the program        
|   |   ...    
|   |   |-- App.java                       # main 
|   |   |-- DrawingTool.java       
|   |   |-- Graphic.java	         
|   | 	...
|	|-- test/java/com/huge/drawingtool     # Junit test module 
|	|-- test/java/resouces/test_files      # files to test
...
|-- pom.xml     # maven configuration dependencies
|-- dist     	
|   |--DrawingTool.jar                     # Jar program              
|-- doc     							   # Java Doc	
|   |--index.html		                   	      
...
	
```

## Some useful info

```
 - There should always be a canvas in order to draw
 - The maximum size for a canvas should be 1024 x 768
 - You can only draw within the canvas 
 - If there is multiple canvas then only the last one will be valid
```