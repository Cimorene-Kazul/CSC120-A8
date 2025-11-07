import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        // given defaults
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        // additional 10 Buildings (I might get info wrong - I have not been in all of them)
        myMap.addBuilding(new Cafe("Julia Child Campus Center", "<address>", 3, 2000, 200, 200, 300));
        myMap.addBuilding(new Cafe("Library Anex", "<address>", 3, 1500, 100, 100, 200));
        myMap.addBuilding(new Library("Library", "<address>", 3, true));
        myMap.addBuilding(new Library("Sage Music Library", "<address>"));
        myMap.addBuilding(new House("Tyler", "<address>", 3, true));
        myMap.addBuilding(new House("Capen", "<address>", 2));
        myMap.addBuilding(new Building("Capen Anex", "<address>", 2));
        myMap.addBuilding(new Building("Seelye Hall", "<address>", 4));
        myMap.addBuilding(new Building("Burton Hall", "<address>", 4));
        myMap.addBuilding(new Building("Sabin-Reed Hall", "<address>", 5));
        System.out.println(myMap);
    }
    
}
