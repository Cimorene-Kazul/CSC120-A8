import java.util.ArrayList;

/**
 * This is the House class. House is a subclass of Building and impliments HouseRequirements.
 * A House has the same locational information as any Building but also keeps track of a list of students that dwell in it and whether it has a dining room.
 */
public class House extends Building implements HouseRequirements{
  // additional attributes
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  /**
   * Constructor for a House.
   * @param name is a String name for the house.
   * @param address is a String address for the house.
   * @param nFloors is the positive integer number of floors the house has.
   * @param hasDiningRoom is a boolean that indicates whether the house has a dining room.
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    // use the superclass constructor
    super(name, address, nFloors);
    // make an empty array to store the students that live in the house
    this.residents = new ArrayList<Student>();
    // store whether the house has a dining room
    this.hasDiningRoom = hasDiningRoom;
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
   * Accessor for the number of residents that the house has.
   * @return the number of residents of the house.
   */
  public int nResidents(){
    return this.residents.size(); // uses arraylist builtins to fetch the number of residents
  }

  /**
   * Adds a student to the house, and prints an error message if they already live there.
   * @param s is the Student object representing the student to add.
   */
  public void moveIn(Student s){
    if (this.isResident(s)){ // print an error if s already lives in the house
      System.out.println(s+" already lives in "+this.name+" and so cannot move into "+this.name+".");
    } else{ // otherwise add s to the house residents
     this.residents.add(s);
     System.out.println(s+" has moved in to "+this.name+".");
    }
  }

  /**
   * Removes a student from the house, and prints an error message if they do not live there.
   * @param s is the Student object representing the student that needs to move out.
   * @return the Student s if s moved out and null if s failed to move out due to not living in the house.
   */
  public Student moveOut(Student s){
    if (!this.isResident(s)){ // print an error if s does not live in the house
      System.out.println(s+" does not live in "+this.name+" thus cannot move out of "+this.name+".");
      // and return null
      return null;
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

  // main method to test the class
  public static void main(String[] args) {
    new House("Tyler", "102 Tyler Avenue", 5, true); // test House!
  }

}