/*
This program simulates the Travelling Salesman Problem by reading the cost matrix for travel between cities from a file and runs a genetic algorithm to estimate the shortest path between them.
*/

import java.util.Scanner;
import java.io.FileReader;

public class Main {
  private static final int NUM_GEN = 100;
  private static final int NUM_POP = 10000;
  
  public static void main(String[] args) {
    greeting();

    //Make a cities object that stores file information
    Cities cities = null;
    try{
      cities = readCitiesFromFile();
    }
    catch(Exception e){
      System.out.println("Error: " + e.getMessage());
    }

    //continue if the file reader worked
    if(cities != null){
      cities.print();

      TSP tsp = new TSP(cities, NUM_GEN, NUM_POP);
      tsp.simulate();
    }
    
  }
  
  //Print greeting
  public static void greeting(){
    System.out.println("Welcome to TSP solver!");
    System.out.print("Please enter the name of the file you want to use: ");
  }

  //Return a city object with information from the file
  public static Cities readCitiesFromFile() throws Exception{
    Scanner scanner = new Scanner(System.in);
    String fileName = scanner.nextLine();

    scanner = new Scanner(new FileReader(fileName));
    int numCities = Integer.parseInt(scanner.nextLine());

    City[] cityList = new City[numCities];
    for(int i = 0; i < numCities; i++){
      cityList[i] = new City(i, scanner.nextLine());
    }

    int[][] costMatrix = new int[numCities][numCities];
    String[] line = new String[numCities];
      
    for(int i = 0; i < numCities; i++){
      line = scanner.nextLine().split(" ");
      for(int j = 0; j < numCities; j++){
        costMatrix[i][j] = Integer.parseInt(line[j]);
      }
    }
    scanner.close();
      
    return new Cities(numCities, cityList, costMatrix);
  }
}