// Dalton Shanholtz
// GUI Lab

package guilab;

import javafx.application.Application;
import javafx.geometry.Pos; // Used for centering various GUI text
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent; // Used for handling mouse input/events
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 <p>This program allows the player to select a basket-ball team of 5 players from an assortment of 10.
 It primarily works by building a GUI to utilize for inputs (checkboxes) and a output (a TextView).
 There are also two buttons, which when clicked will display either your current team-size or
 the number of currently unselected players.</p>

 <p>After five players are chosen, the player's current team roster will become Immutable.</p>

 <p>This Main Class also interacts with the Characters class and style.css.</p>

 <p>Input is located within the local <u>available_players.txt</u> text-file.</p>
 <hr>
 <p><b>Known Bugs:</b><br> If a CheckBox is MOUSE_PRESSED, but then the user's mouse is dragged away from the CheckBox before
 releasing, the program will  run into errors. Unknown remedy due to what seems to be the
 nature of JavaFX CheckBoxes. If a CheckBox is MOUSE_PRESSED, but then the user's mouse is dragged away from the
 CheckBox before<br><br><i>Solutions already tried to no avail: MOUSE_CLICKED, MOUSE_RELEASED.</i></p>
 <p>This program was released open-source via Github on December 9, 2020.<br><br></p>
 @author Dalton Shanholtz
 @version 1.01 2020-12-09
 @since 2020-12-04
 */
public class Main extends Application {

    /**
     * <p>This method starts our program, displaying all the required GUI JavaFX
     * elements. Event handling for all inputs is also implemented, utilizing calls to
     * AvailableCharacters; an Object of the Characters class</p>
     * @param stage Creates a new object of the Stage class
     */
    public void start(Stage stage) { // Our start method. Within our parameters a object of Stage (stage) is created
        VBox parentLayout = new VBox(42); // Creates VBox for our parent/head/top-level JavaFX Gui Element
        parentLayout.setAlignment(Pos.CENTER); // Centers the alignment property of parentLayout

        parentLayout.setId("parentLayout"); // Sets an ID to our parentLayout to be referenced in our style.css

        FlowPane toonSelectPane = new FlowPane(); // Creates a new Object of FlowPane named toonSelectPane
        toonSelectPane.setHgap(42); // Sets the toonSelectPane horizontal gap property
        toonSelectPane.setVgap(20); // Sets the toonSelectPane vertical gap property
        toonSelectPane.setAlignment(Pos.CENTER); // Centers the alignment property of toonSelectPane

        parentLayout.getChildren().add(toonSelectPane); // Add on our new toonSelectPane FlowPane to our parentLayout

        Characters AvailableCharacters = new Characters(); //Creates an object of our Characters class

        // Creates our 10 Checkbox Objects for use in GUI Character Selection

        /* Creates a new Object of the class CheckBox called cb01, which is given it's text as it's argument via
           us calling the getName getter method from our created Characters Class object; AvailableCharacters.txt */
        CheckBox cb01 = new CheckBox(AvailableCharacters.getName(1));
        toonSelectPane.getChildren().add(cb01); // Adds our new Checkbox Object, cb01, to our toonSelectPane
        CheckBox cb02 = new CheckBox(AvailableCharacters.getName(2));
        toonSelectPane.getChildren().add(cb02);
        CheckBox cb03 = new CheckBox(AvailableCharacters.getName(3));
        toonSelectPane.getChildren().add(cb03);
        CheckBox cb04 = new CheckBox(AvailableCharacters.getName(4));
        toonSelectPane.getChildren().add(cb04);
        CheckBox cb05 = new CheckBox(AvailableCharacters.getName(5));
        toonSelectPane.getChildren().add(cb05);
        CheckBox cb06 = new CheckBox(AvailableCharacters.getName(6));
        toonSelectPane.getChildren().add(cb06);
        CheckBox cb07 = new CheckBox(AvailableCharacters.getName(7));
        toonSelectPane.getChildren().add(cb07);
        CheckBox cb08 = new CheckBox(AvailableCharacters.getName(8));
        toonSelectPane.getChildren().add(cb08);
        CheckBox cb09 = new CheckBox(AvailableCharacters.getName(9));
        toonSelectPane.getChildren().add(cb09);
        CheckBox cb00 = new CheckBox(AvailableCharacters.getName(0)); // Left last intentionally, for aesthetics
        toonSelectPane.getChildren().add(cb00);

        // Creates a VBox to use for our bottom vertical-based layout
        VBox bottomLayout = new VBox(42); // Sets the bottomLayout vertical gap property
        parentLayout.getChildren().add(bottomLayout); // Adds our bottomLayout to parentLayout

        // Creates a Label to use within our GUI hinting at what is required next by the user
        Label helpLabel = new Label("Choose 5 Players For Your Team"); // Creates a new object of the Label Class
        parentLayout.getChildren().add(helpLabel); // Adds our helpLabel to parentLayout
        helpLabel.setAlignment(Pos.CENTER); // Centers the alignment property of helpLabel

        TextArea currentTeam = new TextArea(); // Creates a TextArea to use for displaying our selected team
        currentTeam.setMaxHeight(192); // Sets currentTeams Max Height for aesthetics

        bottomLayout.getChildren().add(currentTeam); // Add on our new currentTeam TextArea to our bottomLayout

        // Creates a HBox to use for insuring both of our Buttons are aligned horizontally
        HBox buttonHBox = new HBox(42); // Creates a HBox for aligning our next two buttons horizontally
        buttonHBox.setAlignment(Pos.CENTER); // Centers the alignment property of buttonHBox
        bottomLayout.getChildren().add(buttonHBox); // Adds our buttonHBox Button to bottomLayout

        Button currentTeamCount = new Button("Current Team: 0"); // Creates a new object of the Button class
        buttonHBox.getChildren().add(currentTeamCount); // Adds our currentTeamCount to buttonHBox

        Button unselectedCount = new Button("Unselected Toons: 10"); // Creates a new object of the Button class
        buttonHBox.getChildren().add(unselectedCount); // Adds our unselectedCount Button to buttonHBox

        /* Our Event Logic for when a MOUSE_PRESSED from the MouseEvent class event occurs.
         *  If this event happens we call currentTeamCount.setText() while using the method getSelectedPlayersCount();
         *  from our AvailableCharacters, which is a Object of the Characters.java Class to assist in what the text
         *  should change to. */
        currentTeamCount.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent ->
                currentTeamCount.setText("Current Team: " + AvailableCharacters.getSelectedPlayersCount()));

        unselectedCount.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent ->
                unselectedCount.setText("Unselected Toons: " + AvailableCharacters.getUnselectedPlayersCount()));

        // Creates 10 Event Listeners per each Checkbox for use in GUI Character Selection

        // Event Listener (Mouse Press) for Checkbox cb00
        cb00.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> { //adds event listener than does the following..
            // If the check box is already selected and a full team of 5 has not been chosen..
            if(cb00.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5) {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(0)); } // Set the new Team # Text
            /* Else then cb00 must be not selected; Next we
               verify that a full team of 5 has not been chosen.. */
            else if (AvailableCharacters.getSelectedPlayersCount() < 5) {
                /* We now add cb00/toon 0 to the currentTeam by calling AvailableCharacters.addToCurrentRoster().
                   We call this as an argument within currentTeam.setText to also update the currentTeam TextArea
                   with AvailableCharacters.addToCurrentRoster's return value/. */
                currentTeam.setText(AvailableCharacters.addToCurrentRoster(0)); }
        });

        cb01.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if(cb01.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5) {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(1)); }
            else if (AvailableCharacters.getSelectedPlayersCount() < 5) {
                currentTeam.setText(AvailableCharacters.addToCurrentRoster(1)); }
        });

        cb02.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if(cb02.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5) {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(2)); }
            else if (AvailableCharacters.getSelectedPlayersCount() < 5)
            { currentTeam.setText(AvailableCharacters.addToCurrentRoster(2)); }
        });

        cb03.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if(cb03.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5) {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(3)); }
            else if (AvailableCharacters.getSelectedPlayersCount() < 5)
            { currentTeam.setText(AvailableCharacters.addToCurrentRoster(3)); }
        });

        cb04.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if(cb04.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5) {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(4)); }
            else if (AvailableCharacters.getSelectedPlayersCount() < 5)
            { currentTeam.setText(AvailableCharacters.addToCurrentRoster(4)); }
        });

        cb05.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if(cb05.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5)  {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(5)); }
            else if (AvailableCharacters.getSelectedPlayersCount() < 5)
            { currentTeam.setText(AvailableCharacters.addToCurrentRoster(5)); }
        });

        cb06.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if(cb06.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5)  {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(6)); }
            else if (AvailableCharacters.getSelectedPlayersCount() < 5)
            { currentTeam.setText(AvailableCharacters.addToCurrentRoster(6)); }
        });

        cb07.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if(cb07.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5)  {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(7)); }
            else if (AvailableCharacters.getSelectedPlayersCount() < 5)
            { currentTeam.setText(AvailableCharacters.addToCurrentRoster(7)); }
        });

        cb08.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if(cb08.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5)  {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(8)); }
            else if (AvailableCharacters.getSelectedPlayersCount() < 5)
            { currentTeam.setText(AvailableCharacters.addToCurrentRoster(8)); }
        });

        cb09.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            if(cb09.isSelected() && AvailableCharacters.getSelectedPlayersCount() < 5)  {
                currentTeam.setText(AvailableCharacters.removeFromCurrentRoster(9)); }
            else if (AvailableCharacters.getSelectedPlayersCount() < 5)
            { currentTeam.setText(AvailableCharacters.addToCurrentRoster(9)); }
        });

        Scene scene = new Scene(parentLayout, 800, 600); // Creates a new object of Scene

        /* Loads our style.css to add a little spice to our GUI, if no style.css is found the program
           will simply continue without CSS Styling. */
        try {
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        } catch (NullPointerException e) { // If we get a Null Pointer Exception from missing file inform the User
            e.printStackTrace(); // Print out the Stack Trace of the error
            System.out.println("src/sample/style.css cannot be located!\nProgram is running without CSS Styling.");
        }

        stage.setTitle("Æ Rasketball 2737"); //Sets our window's title
        stage.setScene(scene); // Sets our stage's scene to our scene object we created
        stage.show(); // Displays are scene/stage

    }
}

