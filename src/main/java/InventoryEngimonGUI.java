import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;i
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryEngimonGUI {

    Stage window;
    TableView<Engimon> tableEngimon;

    public void showInventoryEngimon(Player p) {
        Stage primaryStage = new Stage();
        window = primaryStage;
        window.setTitle("Inventory Engimon");
        // Name column
        TableColumn<Engimon, String> nameEngimonColumn = new TableColumn<>("Name");
        nameEngimonColumn.setMinWidth(200);
        nameEngimonColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        // Species name column
        TableColumn<Engimon, Species> speciesNameColumn = new TableColumn<>("Species Name");
        speciesNameColumn.setMinWidth(200);
        speciesNameColumn.setCellValueFactory(new PropertyValueFactory<>("speciesName"));
        // Elements  column
        TableColumn<Engimon, ArrayList<ElementType>> elementsColumn = new TableColumn<>("Elements");
        speciesNameColumn.setMinWidth(200);
        speciesNameColumn.setCellValueFactory(new PropertyValueFactory<>("elements"));
        // Parent -> string, species Papa, string species Mama
        TableColumn<Engimon, Species> speciesPapaColumn = new TableColumn<>("Species papa");
        speciesPapaColumn.setMinWidth(200);
        speciesPapaColumn.setCellValueFactory(new PropertyValueFactory<>("speciesPapa"));
        TableColumn<Engimon, Species> speciesMamaColumn = new TableColumn<>("Species mama");
        speciesMamaColumn.setMinWidth(200);
        speciesMamaColumn.setCellValueFactory(new PropertyValueFactory<>("speciesMama"));
        // Level column
        TableColumn<Engimon, Integer> levelColumn = new TableColumn<>("Level");
        levelColumn.setMinWidth(200);
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));
        // currExp column
        TableColumn<Engimon, Integer> currExpColumn = new TableColumn<>("Current Exp");
        currExpColumn.setMinWidth(200);
        currExpColumn.setCellValueFactory(new PropertyValueFactory<>("currExp"));
        // maxExp column
        TableColumn<Engimon, Integer> maxExpColumn = new TableColumn<>("Max Exp");
        maxExpColumn.setMinWidth(200);
        maxExpColumn.setCellValueFactory(new PropertyValueFactory<>("maxExp"));

        tableEngimon = new TableView<>();
        tableEngimon.setItems(getEngimons(p));
        tableEngimon.getColumns().addAll(nameEngimonColumn,speciesNameColumn,speciesPapaColumn,speciesMamaColumn,currExpColumn,maxExpColumn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableEngimon);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public ObservableList<Engimon> getEngimons(Player p) {
        ObservableList<Engimon> engimons = FXCollections.observableArrayList();
        for (Engimon engi : p.getEngimonInventory()) {
            engimons.add(engi);
        }
        return engimons;
    }

}