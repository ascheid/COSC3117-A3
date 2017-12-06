# COSC3117-A3
COSC3117-Artificial Intelligence @ Algoma Univeristy | Assignment 3 - Genetic Algorithm

COSC3117 Artificial Intelligence
Project #3
Project description: 

Use any programming language you prefer to write a program using a genetic algorithm to solve the following problem:  Help a robot find a path from the entrance to the exit in the following map: 

     


The map is represented as a simple 2D array of integers. A 0 represents open space, a 1 represents a wall or an obstacle, an 8 represents the starting point of the path and a 5 represents the exit point.

Here is the C++ declaration of a map.
     const int map[MAP_HEIGHT][MAP_WIDTH] = 
           {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
  1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1,
 8, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1,
 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1,
 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1,
 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1,
 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1,
 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 5,
 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1,
 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

If a direction makes the robot bump into a wall or obstacle, it is simply ignored. If a path is longer than needed (i.e., there are still directions left when the exit is reached), the rest of the directions may be discarded. The output of your program should be a set of directions such as east → east → south…. 
P.S. Your program can not use any Genetic Algorithm library. Optional: Create a graphical output to show the different generations of the paths. 

Write a report that 
    1. Explains the design of your genetic algorithm:
a. Describe the candidate representation that was used.
b. State how the fitness function was defined.
c. Explain how you chose the parameters. e.g., the population size and mutation rate.
d. Give examples of how you defined the two genetic operators: crossover and mutate. 
   2. Includes screen dumps to prove your program works.

Submit the report and all source code before December 5, 2017, 11:55 pm.  
