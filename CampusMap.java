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
        myMap.addBuilding(new Cafe("Julia Child Campus Center", "100 Elm St Northampton, MA 01063", 3, 2000, 200, 200, 300));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Elm St Northampton, MA 01063", 3, 1500, 100, 100, 200));
        myMap.addBuilding(new Library("Nielson Library", "7 Elm St Northampton, MA 01063", 3, true));
        myMap.addBuilding(new House("Tyler", "164 Green St Northampton, MA 01060", 3, true));
        myMap.addBuilding(new House("Capen", "26 Prospect St, Northampton, MA 01060", 3));
        myMap.addBuilding(new House("Hubbard", "3 Green St, Northampton, MA 01060",4));
        myMap.addBuilding(new Building("Capen Anex", "25a Henshaw Ave Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Dr #1 Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Burton Hall", "46 College Ln Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Sabin-Reed Hall", "44 College Ln Northampton, MA 01063", 5));
        System.out.println(myMap);
    }
    
}
