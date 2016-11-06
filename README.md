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
```
## Installation
```
java -jar DrawingTool.jar
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
|-- dist     # maven configuration dependencies
|   |--DrawingTool.jar                     # Jar program              
...
	
```

## Some useful info

```
 - debe existir un canvas para poder dibujar
 - Se puede dibujar si los puntos parametros permiten dibujar la forma deseada
 - Solo se puede dibujar en los limites del canvas
 - si hay varrios canvas se dibujar en el ultimo que se lea.
 - tamñao limite del canvas 1024X768
```
