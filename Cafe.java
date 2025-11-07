/**
 * This is the Cafe class. Cafe is a subclass of Building and impliments CafeRequirements.
 * A Cafe has the same locational information as any Building but also keeps track of inventory and models (not terribly realistically) the purchasing of drinks.
 */
public class Cafe extends Building implements CafeRequirements{
    // initialize attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private int maxCoffeeOunces; // The number of ounces of coffee the cafe storage can hold.
    private int maxSugarPackets; // The number of sugar packets the cafe storage can hold.
    private int maxCreams; // The number of "splashes" of cream the cafe storage can hold.
    private int maxCups; // The number of cups the cafe storage can hold.

    /* Default constructor */
    public Cafe(int maxCoffeeOunces, int maxSugarPackets, int maxCreams, int maxCups) {
        this("<Name Unknown>", "<Address Unknown>", 1, maxCoffeeOunces, maxSugarPackets, maxCreams, maxCups);
    }

    /* Overloaded constructor with address only */
    public Cafe(String address, int maxCoffeeOunces, int maxSugarPackets, int maxCreams, int maxCups) {
        this(maxCoffeeOunces, maxSugarPackets, maxCreams, maxCups); // Call default constructor
        this.address = address; // Override address
    }

    /* Overloaded constructor with name, address */
    public Cafe(String name, String address, int maxCoffeeOunces, int maxSugarPackets, int maxCreams, int maxCups) {
        this(name, address, 1, maxCoffeeOunces, maxSugarPackets, maxCreams, maxCups); // Call full constructor with hard-coded # floors and no elevator or dining room
    }

    /**
     * Constructor for a cafe with all attributes given.
     * @param name is a String that indicates the name of the cafe.
     * @param address is a String that indicates the cafe's address.
     * @param nFloors is a positive integer indicating the number of floors the cafe has.
     * @param maxCoffeeOunces is a nonnegative integer indicating the number of ounces of coffee the cafe storage can hold.
     * @param maxSugarPackets is a nonnegative integer indicating the number of sugar packets the cafe storage can hold.
     * @param maxCreams is a nonnegative integer indicating the number of splashes of cream  the cafe storage can hold.
     * @param maxCups is a nonnegative integer indicating the number of cups the cafe storage can hold.
     */
    public Cafe(String name, String address, int nFloors, int maxCoffeeOunces, int maxSugarPackets, int maxCreams, int maxCups) {
        // use the superclass constructor
        super(name, address, nFloors);
        // throw an exception if the inputs are bad
        if (maxCoffeeOunces<0||maxSugarPackets<0||maxCreams<0||maxCups<0){
            throw new IllegalArgumentException("Quantities for supplies must be positive integers.");
        }
        // set the amounts of the ingredients
        this.nCoffeeOunces = maxCoffeeOunces;
        this.maxCoffeeOunces = maxCoffeeOunces;
        this.nSugarPackets = maxSugarPackets;
        this.maxSugarPackets = maxSugarPackets;
        this.nCreams = maxCreams;
        this.maxCreams = maxCreams;
        this.nCups = maxCups;
        this.maxCups = maxCups;
        // notify the user of success
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells a drink with given requirements from the Cafe, restocking if need be.
     * @param size is the integer number of ounces of coffee in the drink.
     * @param nSugarPackets is the integer number of packets of sugar in the drink.
     * @param nCreams is the integer number of splashes of cream in the drink,
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        // if the coffee is too big for the cafe to ever sell, throw an exception
        if (this.maxCups < 1||this.maxCoffeeOunces<size||this.maxSugarPackets<nSugarPackets||this.maxCreams<nCreams){
            throw new RuntimeException("Drink ingredient amounts must be below the cafe stock maximum.");
        } else if (this.nCups < 1||this.nCoffeeOunces<size||this.nSugarPackets<nSugarPackets||this.nCreams<nCreams){
            this.restock();
        }
        // remove from inventory the used supplies 
        this.nCups -= 1; // any drink uses 1 cup
        this.nCoffeeOunces -= size; 
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        
        // record the sale
        System.out.println("One "+size+"oz coffee with "+nCreams+" splashes of cream and "+nSugarPackets+" packets of sugar sold.");
    }

    /**
     * Restock the cafe by adding more materials to the supply stock, returning the supplies to max.
     */
    private void restock(){
        // return the supplies to the saved maximum values
        this.nCoffeeOunces = this.maxCoffeeOunces;
        this.nSugarPackets = this.maxSugarPackets;
        this.nCups = this.maxCups;
        this.nCreams = this.maxCreams;
        // notify the user
        System.out.println("The Cafe has been restocked!");
    }

    /**
     * Overwrite the parent class's showOptions method to show the Cafe-specifc methods as well
     */
    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffee(size, sugars, creams)");
    }

    // main method to test the class in 
    public static void main(String[] args) {
    }
    
}