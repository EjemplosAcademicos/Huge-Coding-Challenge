# Huge-Coding-Challenge

## Prerequisites

## Installation

## App structure

```
.
|-- src
|   |-- main/java/com/huge/drawingtool
|   |   |-- boxtool        			 # by convension async modules are prefixed with + sign            
|   |       |-- feature-module-1.component.html
|   |       |-- feature-module-1.component.ts
|   |       |-- feature-module-1.module.ts
|   |       |-- feature-module-1.routing.ts
|   |       ...
|   |   |-- file
|   | 		|-- feature-module-1.component.html
|   |   |-- util                    # folder with common directives, co
|   |       |-- exceptions                   
|   |   ...    
|   |   |-- App.java
|   |   |-- DrawingTool.java       # app root module
|   |   |-- Graphic.java	       # app root routing  
|   |       
...
|-- pom.xml     # maven configuration dependencies
...

```

## Some useful info

```
 - debe existir un canvas para poder dibujar
 - Se puede dibujar si los puntos parametros permiten dibujar la forma deseada
 - Solo se puede dibujar en los limites del canvas
```
