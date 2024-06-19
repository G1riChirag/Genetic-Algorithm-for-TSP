/*
Population class defines a collection of individual solutions.
It uses a comparator to sort the individuals according to their fitness.
*/

import java.util.*;

public class Population{
  private Cities cities;
  private List<Individual> pop = new ArrayList<Individual>();
  private final int NUM_POP;
  Comparator<Individual> individualComparator = new Comparator<Individual>() {
    @Override
    public int compare(Individual i1, Individual i2){
      return Integer.compare(i1.getFitness(), i2.getFitness());
    }
  };
  
  //Constructor initializes fields
  public Population(Cities cities, int NUM_POP){
    this.cities = cities;
    this.NUM_POP = NUM_POP;
    pop = new ArrayList<Individual>();
  }

  //Sort by fitness
  public void sortPop(){
    Collections.sort(pop, individualComparator);
  }

  //Get the size of the population
  public int getNum(){
    return pop.size();
  }

  //Add an individual into the population
  public void add(Individual i){
    pop.add(i);
  }

  //Print the best individual, assuming the method is called on a sorted population
  public void printBest(){
    pop.get(0).print2();
  }

  //Returns the best population, assuming the method is called on a sorted population
  public Individual getBest(){
    return pop.get(0);
  }

  //Returns individual at a particular index
  //I could swap the above methods with this...
  public Individual getIndividual(int i){
    return pop.get(i);
  }
  
  //Copy the list of indivudals from a given population into this population
  public void copy(Population pop2){
    for(int i = 0; i < pop2.getNum(); i++){
      pop.add(pop2.getIndividual(i));
    }
  }

  //Create a population of randomly ordered indivduals
  public void createPopulation(){
    for(int i = 0; i < NUM_POP; i++){
      pop.add(new Individual(cities));
    }
  }

  //Mutate the whole population
  public void mutatePop(){
    for(int i = 0; i < NUM_POP; i++){
      pop.get(i).mutate();
    }
  }
  
}