# Genetic-Algorithm-for-TSP-Optimization
This project implements a genetic algorithm to solve the Traveling Salesman Problem (TSP) using Java. The program reads the cost matrix for travel between cities from a file and estimates the shortest path between them over multiple generations.

# Project Description
The Traveling Salesman Problem (TSP) is a well-known problem in computer science and operations research. The goal is to find the shortest possible route that visits each city exactly once and returns to the origin city. This project uses a genetic algorithm to find an approximate solution to TSP.

# Genetic Algorithm Overview
A genetic algorithm is an optimization technique inspired by natural selection. It uses a population of candidate solutions, and through selection, crossover, and mutation operations, it evolves the population towards better solutions over several generations.

# Features
* Reads TSP data from a file, including city names and a cost matrix.
* Implements a genetic algorithm with selection, crossover, and mutation operations.
* Iteratively prints the cost of the best tour found during each generation.
* Caps the number of generations at 100 to ensure timely completion.

# Requirements
* Java Development Kit (JDK) 8 or higher
* A file containing TSP data formatted as described below

# TSP Data File Format
The input file should have the following format:
* The first line contains an integer N, the number of cities.
* The next N lines contain the names of the cities.
* The next N lines contain N integers each, representing the cost matrix, where the element at row i and column j represents the travel cost from city i to city j.

# Example
4<br>
CityA <br>
CityB <br>
CityC <br>
CityD <br>
0 10 15 20 <br>
10 0 35 25 <br>
15 35 0 30 <br>
20 25 30 0 <br>

# Classes
* Main: The main class reads input, initializes the cities object, and runs the genetic algorithm.
* Cities: Stores the list of cities and the cost matrix.
* City: Represents a single city.
* Individual: Represents an individual solution to the TSP.
* Population: Repesents a generation of solutions.
* Crossover: Defines how individuals "reproduce" to produce a new generation.
* TSP: Implements the genetic algorithm for solving the TSP.

# Author
Chirag Giri


