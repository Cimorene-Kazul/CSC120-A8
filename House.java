import java.util.ArrayList;

/**
 * This is the House class. House is a subclass of Building and impliments HouseRequirements.
 * A House has the same locational information as any Building but also keeps track of a list of students that dwell in it and whether it has a dining room.
 */
public class House extends Building implements HouseRequirements{
  // additional attributes
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;


    /* Default constructor */
    public House() {
        this("<Name Unknown>", "<Address Unknown>", 1,false, false);
    }

    /* Overloaded constructor with address only */
    public House(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /* Overloaded constructor with name, address */
    public House(String name, String address) {
        this(name, address, 1, false, false); // Call full constructor with hard-coded # floors and no elevator or dining room
    }

        /* Overloaded constructor with no elevator or dining room indicated*/
    public House(String name, String address, int nFloors) {
        this(name, address, nFloors, false, false); // Call full constructor with hard-coded no elevator and no dining room
    }

    /* Overloaded constructor with no elevator indicated*/
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        this(name, address, nFloors, hasDiningRoom, false); // Call full constructor with hard-coded no elevator
    }

  /**
   * Constructor for a House.
   * @param name is a String name for the house.
   * @param address is a String address for the house.
   * @param nFloors is the positive integer number of floors the house has.
   * @param hasDiningRoom is a boolean that indicates whether the house has a dining room.
   * @param hasElevator is a boolean that indicates whether the house has an elevator.
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    // use the superclass constructor
    super(name, address, nFloors);
    // make an empty array to store the students that live in the house
    this.residents = new ArrayList<Student>();
    // store whether the house has a dining room and elevator
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    // notify the user of success
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for hasDiningRoom.
   * @return true if the house has a dining room and false if it does not.
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Accessor for hasElevator
   * @return true if the house has an elevator and false if it does not.
   */
  public boolean hasElevator(){
    return this.hasElevator;
  }

  /**
   * Accessor for the number of residents that the house has.
   * @return the number of residents of the house.
   */
  public int nResidents(){
    return this.residents.size(); // uses arraylist builtins to fetch the number of residents
  }

  /**
   * Adds a student to the house, and throws a RuntimeException message if they already live there.
   * @param s is the Student object representing the student to add.
   */
  public void moveIn(Student s){
    if (this.isResident(s)){ // throw an error if s already lives in the house
      throw new RuntimeException(s+" already lives in "+this.name+" and so cannot move into "+this.name+".");
    } else{ // otherwise add s to the house residents
     this.residents.add(s);
     System.out.println(s+" has moved in to "+this.name+".");
    }
  }

  /**
   * Removes a student from the house, and throws a RuntimeException message if they do not live there.
   * @param s is the Student object representing the student that needs to move out.
   * @return the Student s if s moved out
   */
  public Student moveOut(Student s){
    if (!this.isResident(s)){ // throw an error if s does not live in the house
      throw new RuntimeException(s+" does not live in "+this.name+" thus cannot move out of "+this.name+".");
    } else{ 
      // otherwise remove s from the house residents
     this.residents.remove(s);
     // notify the user
     System.out.println(s+" has moved out of "+this.name+".");
     // and return s
     return s;
    }
  }

  /**
   * An accessor that returns if a student is currently a resident of the house.
   * @return true if s is a resident of the house and false if s is not a resident of the house.
   */
  public boolean isResident(Student s){
    return residents.contains(s);
  }

  /**
   * Overwrite the parent class's showOptions method to show the House-specifc methods as well
   */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + moveIn() \n + moveOut()");
  }

      // overwriting goUp and goDown as I think the comment on goToFloor indicates

    /**
     * goUp for just one floor, not using the elevator
     */
    public void goUp(){
        super.goUp();
    }

    /**
     * goUp for a given number of floors, using the elevator if there is one, and throwing an error if trying to go up multiple floors and there is no elevator.
     * @param nFloors int number of floors to go up by
     */
    public void goUp(int nFloors){
        if (nFloors < 1){
            throw new RuntimeException("You can only go up a positive number of floors and "+nFloors+" is not positive.");
        }if (this.hasElevator){
            this.goToFloor(this.activeFloor + nFloors);
        }if (nFloors == 1){
            this.goUp();
        }else{
            throw new RuntimeException("There is no elevator in "+this.name+" to permit you to go up multiple floors at once.");
        }
    }

    /**
     * goDown for just one floor, not using the elevator
     */
    public void goDown(){
        super.goDown();
    }

    /**
     * goDown for a given number of floors, using the elevator if there is one, and throwing an error if trying to go down multiple floors and there is no elevator.
     * @param nFloors int number of floors to go down by
     */
   public void goDown(int nFloors){
        if (nFloors < 1){
            throw new RuntimeException("You can only go down a positive number of floors and "+nFloors+" is not positive.");
        }if (this.hasElevator){
            this.goToFloor(this.activeFloor - nFloors);
        }if (nFloors == 1){
            this.goDown();
        }else{
            throw new RuntimeException("There is no elevator in "+this.name+" to permit you to go up multiple floors at once.");
        }
    }

    // main method to test the class
    public static void main(String[] args) {
    }

}