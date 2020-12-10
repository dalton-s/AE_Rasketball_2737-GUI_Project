package guilab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>The Class Characters is responsible for loading available_players.txt and saving each line/player
 * within the currentRoster ArrayList.</p>
 */
public class Characters {

    // Creates an ArrayList to store our data/input of names from out available_players.txt file
    final private ArrayList<String> availableToons = new ArrayList<String>();
    // Creates an ArrayList to later utilize for storing/updating our current selected team's roster
    private ArrayList<String> currentRoster = new ArrayList<String>();

    /**
     * <p>This is the default constructor for the Characters Class.
     *  It will try to open up our available_players.txt (Throwing an exception if the file is not found),
     *  and then proceed to read through the .txt line by line adding each name to availableToons ArrayList</p>
     */
    public Characters() {
        try { // Try to perform the following
            // Creates a new Scanner (inTextFile) for reading through our available_players.txt file
            final Scanner inTextFile = new Scanner(new File("src/guilab/available_players.txt"));
            while (inTextFile.hasNext()) { // While inTextFile has a next line..
                availableToons.add(inTextFile.nextLine()); // Adds next Toon to our availableToons ArrayList
            }
            inTextFile.close(); // Closes our inTextFile/input.txt to prevent any future memory leaks
        } catch (FileNotFoundException e) { // Our catch statement for FileNotFoundException
            e.printStackTrace(); // Print out the Stack Trace of the error
        }
    }

    /**
     * <p>This method returns the desired toon/characters name.</p>
     * @param toon The number identifying which toon/character we wish to add to our team's currentRoster.
     * @return The desired toon/characters name.
     */
    public String getName(int toon) { return availableToons.get(toon); }

    /**
     * <p>This method returns the player's current team size by assuming their are 10 total players.</p>
     * @return The player's current team size.
     */
    public int getSelectedPlayersCount() { return currentRoster.size(); }

    /**
     * <p>This method returns the number of unselected characters, by assuming their are 10 total players.</p>
     * @return The number of unselected toons/characters
     */
    public int getUnselectedPlayersCount() { return 10-currentRoster.size(); }

    /**
     * <p>This is a Setter-like method for adding a toon to our currentRoster Array.
     * Afterwards, it utilizes a enhanced for loop for for "re-building" our new roster to return.</p>
     * @param toon The toon/character we wish to add to our team's currentRoster.
     * @return The new currentRoster in a String format.
     */
    public String addToCurrentRoster(int toon) {
        /* Adds the desired toon (indicated by the toon int parameter) to currentRoster by calling
           availableToons.get() for the name */
        currentRoster.add(availableToons.get(toon));
        String newTeam = ""; // Creates a String responsible for holding our new updated team roster
        for(String player: currentRoster) { newTeam += player + "\n"; } // For each player, add their name and a newline
        return newTeam; // Returns our updated team roster in a String format
    }

    /**
     * <p>This is a Setter-like method for removing a toon from our currentRoster Array.
     * Afterwards, it utilizes a enhanced for loop for for "re-building" our new roster to return.</p>
     * @param toon The toon/character we wish to remove from our team's currentRoster
     * @return The new currentRoster in a String format.
     */
    public String removeFromCurrentRoster(int toon) {
        currentRoster.remove(availableToons.get(toon)); // removes the desired toon from the currentRoster
        String newTeam = ""; // Creates a String responsible for holding our new updated team roster
        for(String player: currentRoster) { newTeam += player + "\n"; } // For each player, add their name and a newline
        return newTeam; // Returns our updated team roster in a String format
    }
}
