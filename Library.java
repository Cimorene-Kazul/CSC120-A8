import java.util.Hashtable;

/**
 * This is the Library class. Library is a subclass of Building and impliments LibraryRequirements.
 * A Library has the same locational information as any Building but also keeps track of a collection of books.
 */
public class Library extends Building implements LibraryRequirements{
    // additional attributes
    private Hashtable<String, Boolean> collection;

    /**
     * Constructor for the Library class.
     * @param name a String containing the name of the building.
     * @param address a Strign containing the street address of the building,
     * @param nFloors the integer number of floors that the building has.
     */
    public Library(String name, String address, int nFloors) {
      // use the superclass constructor to start
      super(name, address, nFloors);
      // make an empty Hashtable to store the collection in
      this.collection = new Hashtable<String, Boolean>();
      // notify the user of success
      System.out.println("You have built a library: 📖");
    }

    /**
     * Checks if a title is in the collection
     * @param title is a String indicating the title (with author)
     * @return true if the title is in the collection, false otherwise
     */
    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }

    /**
     * Checks if a title is in the collection and availiable
     * @param title is a String indicating the title (with author)
     * @return true if the title is in the collection and availiable, false otherwise
     */
    public boolean isAvailable(String title){
      return this.collection.getOrDefault(title, false);
    }

    /**
     * Prints a list of books in the library's collection and whether they are availiable or checked out.
     */
    public void printCollection(){
      // header
      System.out.println("============================================");
      System.out.println("PRINTED LIST OF "+this.name+" COLLECTION");
      // print each book and its status 
      for (String title : collection.keySet()){ // for each book with title in the collection
        if (this.isAvailable(title)){ // if the title is availiable 
          System.out.println(title+" - AVALIABLE"); // print the title and that it is availiable
        } else{ // otherwise
          System.out.println(title+" - CHECKED OUT"); // print the title and that it is checked out
        }
      }
      // make the end of the print look nice
      System.out.println("============================================");
    }

    /**
     * Adds a new book to the collection, and sets it to availiable, or prints an error if the book is already in the collection.
     * @param title is a String title (with author) of the book to add.
     */
    public void addTitle(String title){
      if (!this.containsTitle(title)){
        this.collection.put(title, true); // add the book to the collection as availiable if the book is not already in the collection.
        System.out.println(title+" has been added to the collection."); // tell the user
      } else {
        throw new RuntimeException("The book "+title+" is already in the collection and thus cannot be added."); // otherwise, throw an error
      }
    }

    /**
     * Removes a book from the collection and returns it, or prints an error if the book is not actually in the collection.
     * @param title is a String title (with author) of the book to remove.
     * @return the book title that is removed
     */
    public String removeTitle(String title){
      if (this.containsTitle(title)){
        this.collection.remove(title); // if the book is in the collection, remove it from the collection.
        System.out.println(title+" has been removed from the collection."); // tell the user
        return title; // and return the title
      } else {
        throw new RuntimeException("The book "+title+" is not in the collection and thus cannot be removed."); // otherwise, throw an error
      }
    }

    /**
     * Marks a book in the collection as unavailiable.
     * @param title is a String title (with author) of thhe book to check out.
     */
    public void checkOut(String title){
      if (this.collection.get(title)){
        this.collection.put(title, false); // if the book is availiable, mark it as unavailiable.
        System.out.println(title+" has been checked out of the collection."); // tell the user
      } else {
        throw new RuntimeException("The book "+title+" is unavailiable and thus cannot be checked out."); // otherwise, throw an error
      }
    }

    /**
     * Marks a book in the collection as availiable.
     * @param title is a String title (with author) of thhe book to return.
     */
    public void returnBook(String title){
      if (!this.collection.get(title)){
        this.collection.put(title, true); // if the book is not currently availiable, and is in the collection, mark it as availiable
        System.out.println(title+" has been returned to the collection."); // tell the user
      } else {
        throw new RuntimeException("The book title "+title+" is still in the collection and thus cannot be returned.");// otherwise, throw an error
      }
    }

    /**
     * Overwrite the parent class's showOptions method to show the Library-specifc methods as well
     */
    public void showOptions(){
        super.showOptions();
        System.out.println(" + printCollection() \n + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title)");
    }

    // main method to test the class in
    public static void main(String[] args) {
    }
  
  }