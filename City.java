/*
Class city defines a simple city object that knows its name and index within the cost matrix.
*/

public class City{
  private final int index;
  private final String name;

  //CONSTRUCTOR: takes index and name
  public City(int index, String name){
    this.index = index;
    this.name = name;
  }

  //GETTER: returns index of the city
  public int getIndex(){
    return index;
  }

  //GETTER: returns the name of the city
  public String getName(){
    return name;
  }
}