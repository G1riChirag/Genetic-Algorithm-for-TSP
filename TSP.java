/*
TSP class defines a static method to run the whole simulation.
It creates a population, an empty new population, performs crossover in random individuals from the initial population, and adds the new individual into the new population. 
The new population is mutated, sorted, and the best individual from it is printed each generation. 
Then the contents of intial population is replaced with new population, and the loop repeats NUM_GEN number of times.
At the end, it prints the best path that it found and its fitness/pathcost.
*/
import java.util.*;

public class TSP{
  private static Cities cities;
  private static int NUM_GEN;
  private static int NUM_POP;
  private static Individual currentBest;
  private static int currentBestGen;

  public TSP(Cities cities, int NUM_GEN, int NUM_POP){
    this.NUM_GEN = NUM_GEN;
    this.cities = cities;
    this.NUM_POP = NUM_POP;
    //passing on an arbitrarily large fitness
    currentBest = new Individual(cities, 100000000);
    currentBestGen = 0;
  }

  public void simulate(){
    Population pop = new Population(cities, NUM_POP);
    pop.createPopulation();
    Population newPop;

    Random random = new Random();
    int random1;
    int random2;
    for(int i = 1; i <= NUM_GEN; i++){
      System.out.println("Generation " + i);
      newPop = new Population(cities, NUM_POP);
      random1 = select(pop);
      random2 = select(pop);
      while(newPop.getNum() <= pop.getNum()){
        newPop.add(Crossover.crossover(pop.getIndividual(random1), pop.getIndividual(random2)));
      }
      newPop.mutatePop();
      newPop.sortPop();
      newPop.printBest();
      if(newPop.getBest().getFitness() < currentBest.getFitness()){
        currentBest = new Individual(cities, newPop.getBest().getIndividual());
        currentBestGen = i;
      }
      pop = new Population(cities, NUM_POP);
      pop.copy(newPop);
    }
    System.out.println("Best solution found: ");
    currentBest.print();
    System.out.println("Found in generation: "+ currentBestGen );
  }

  //SELECTS BASED ON FITNESS. ONLY WORKS ON POP SIZES THAT ARE A MULTIPLE OF 100 I THINK
  public static int select(Population pop){
    Random random = new Random();
    int chanceToPick = random.nextInt(9)+1; //1 to 10
    int pick;

    //Top 25% of the fittest individuals have 4/10 chance of getting picked
    if(chanceToPick > 0 && chanceToPick<5){ //1 to 4
      pick = random.nextInt(pop.getNum()/4); //0 to 24 for pop of 100
    }

    
    //Top 25-50% individuals have 3/10 chance
    else if(chanceToPick > 4 && chanceToPick<8){ //5 to 7
      pick = random.nextInt(pop.getNum()/4)+25;//25 to 49
    }

    //Top 50-75% individuals have 2/10 chance
    else if(chanceToPick > 7 && chanceToPick < 10){ //8 to 9
      pick = random.nextInt(pop.getNum()/4)+50;//50 to 74
    }

    //Bottom 25% have 1/10 chance of getting picked
    else{ //10
      pick = random.nextInt(pop.getNum()/4)+75;//75 to 99
    }

    return pick;
  }
}