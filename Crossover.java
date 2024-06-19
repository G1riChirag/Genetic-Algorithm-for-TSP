/*
Crossover class defines a static method to crossover two individual solutions and return the resulting solution to be added to the next generation of population.
*/

import java.util.List;
import java.util.ArrayList;

public class Crossover{
  
  public static Individual crossover(Individual solution1, Individual solution2){
    List<Integer> newSolution = crossoverHelper(solution1.getIndividual(), solution2.getIndividual());
    return new Individual(solution1.getCities(), newSolution);
  }
  
  public static List<Integer> crossoverHelper(List<Integer> individual1, List<Integer> individual2){
    List<Integer> i1 = new ArrayList<Integer>(individual1);
    List<Integer> i2 = new ArrayList<Integer>(individual2);
    List<Integer> newIndividual = new ArrayList<Integer>();
    
    int value = i1.get(0);
    i1.remove(i1.size()-1);
    i2.remove(i2.size()-1);
    for(int i = 0; i < i2.size(); i++){
      if(i2.get(i) == value){
        i2.remove(i);
      }
    }

    newIndividual.add(value);
    newIndividual.addAll(i2);
    newIndividual.add(value);

    return newIndividual;
  }

  public static void printList(List<Integer> x){
    for(int i = 0; i < x.size(); i++){
      System.out.print(x.get(i)+ " ");
    }
    System.out.println("");
  }
}