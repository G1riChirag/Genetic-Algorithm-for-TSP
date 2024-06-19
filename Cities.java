/*
Cities class holds a collection of city objects and the cost-matrix for travel between them.
*/
public class Cities{
  private final int numCities;
  private final City[] cityList;
  private final int[][] costMatrix;

  //CONSTRUCTOR: takes int, list of City and 2D array of int from file
  public Cities(int numCities, City[] cityList, int[][] costMatrix){
    this.numCities = numCities;
    this.cityList = cityList;
    this.costMatrix = costMatrix;
  }

  //GETTER: returns path cost between two cities, given their indexes
  public int pathCost(int start, int goal){
    return costMatrix[start][goal];
  }

  //GETTER: returns the city object, given its index
  public int getCityByIndex(int index){
    return cityList[index].getIndex();
  }

  //GETTER: returns the city name, given its index
  public String returnCityName(int index){
    return cityList[index].getName();
  }

  //GETTER: returns the total number of cities
  public int getNumCities(){
    return numCities;
  }

  //PRINT TEXT-FILE INFORMATION
  public void print(){
    System.out.println(numCities);
    printCityList();
    printCostMatrix();
  }
  
  //HELPER FUNCTION FOR PRINTER
  private void printCostMatrix(){
    for(int i = 0; i < numCities; i++){
      for(int j = 0; j < numCities; j++){
        System.out.print(costMatrix[i][j] + " ");
      }
      System.out.println("");
    } 
  }

  //HELPER FUNCTION FOR PRINTER
  private void printCityList(){
    for(int i = 0; i < numCities; i++){
      System.out.println(cityList[i].getName());
    }
  }
}