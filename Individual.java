/*
Individual class defines an individual solution as a list of integer objects, with the same first and last element to signify a circular path.
An individual object is aware of its length, fitness, and how likely it is to mutate.
There are methods to randomly create a new individual, mutate the individual, and calculate the fitness of the individual.
*/

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individual{
  private final double MUTATION_PERCENTAGE = 0.25;
  private Cities cities;
  private int length;
  private List<Integer> individual;
  private int fitness;

  //Constructor to randomly initialize an individual
  public Individual(Cities cities){
    this.cities = cities;
    length = cities.getNumCities() + 1;
    individual = new ArrayList<>();
    createIndividual();
    setFitness();
  }

  //Constructor for initializing the best case in TSP simulation
  public Individual(Cities cities, int i){
    this.cities = cities;
    length = cities.getNumCities()+1;
    individual = new ArrayList<Integer>();
    fitness= i;
  }

  //Constructor to initialize an individual with a specific order of solution cities
  public Individual(Cities cities, List<Integer> individual){
    this.cities = cities;
    length = cities.getNumCities() + 1;
    setIndividual(individual);
    setFitness();
  }

  //GETTERS
  
  public Cities getCities(){
    return cities;
  }

  public List<Integer> getIndividual(){
    return individual;
  }

  public int getLength(){
    return length;
  }

  public int getFitness(){
    return fitness;
  }

  //SETTERS
  
  public void setIndividual(List<Integer> individual){
    this.individual = individual;
  }

  private void setFitness(){
    fitness = 0;
    for(int i = 0; i < length-1; i++){
      fitness += cities.pathCost(individual.get(i), individual.get(i+1));
    }
  }

  //Create a randomly shuffled individual
  private void createIndividual(){
    for(int i = 0; i < length-1; i++){
      individual.add(i);
    }
    Collections.shuffle(individual, new Random());
    individual.add(individual.get(0));
  }

  //Mutate randomly swaps two adjacent cities for legth < 3
  //Swaps the first two cities for length 3
  //Does nothing for length 2
  public void mutate(){
    //numCities < 2
    if(length < 3){
      return;
    }
    
    if(Math.random() < MUTATION_PERCENTAGE){
      //numCities = 2
      if(length == 3){
        swap(0,1);
        setFitness();
        return;
      }
      //numCities > 2
      Random random = new Random();
      int rand = (random.nextInt(cities.getNumCities()));
      //2nd to last element
      if(rand == length - 2){
        swap(0, rand);
      }
      else{
        swap(rand, rand+1);
      }
      setFitness();
      return;
    }
  }
  
  //HELPER METHOD FOR MUTATE
  private void swap(int i, int j){
    individual.remove(length-1);
    int value = individual.get(i);
    individual.set(i, individual.get(j));
    individual.set(j, value);
    individual.add(individual.get(0));
  }

  //Print the individual in the form of city names
  public void print(){
    for(Integer i : individual){
      System.out.print(cities.returnCityName(i) + " ");
    }
    System.out.println("");
    System.out.println("Path cost = " + fitness);
  }

  //Print the individual in the form of ints
  public void print2(){
    for(Integer i : individual){
      System.out.print(i);
    }
    System.out.println("");
    System.out.println("Path cost = " + fitness);
    System.out.println("");
  }
  
}