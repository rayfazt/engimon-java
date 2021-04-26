import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class InventorySkillItemGUI {

    Stage window;
    TableView<SkillItem> tableSkillItem;

    public void showInventorySkillItem(Player p) {
        Stage primaryStage = new Stage();
        window = primaryStage;
        window.setTitle("Inventory SkillItem");
        // Skill column
        TableColumn<SkillItem, String> skillColumn = new TableColumn<>("Skill Name");
        skillColumn.setCellValueFactory(new PropertyValueFactory<>("skill"));
        // Amount column
        TableColumn<SkillItem, Integer> amountColumn = new TableColumn<>("Amount");
        amountColumn.setMinWidth(200);
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("skillAmount"));
        // SkillIcon Column
        TableColumn<SkillItem, String> skillIconColumn = new TableColumn<>("Icon");
        skillIconColumn.setMinWidth(200);
        skillIconColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));

        tableSkillItem = new TableView<>();
        tableSkillItem.setItems(getSkillItems(p));
        tableSkillItem.getColumns().addAll(skillColumn,amountColumn,skillIconColumn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableSkillItem);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
    public ObservableList<SkillItem> getSkillItems(Player p) {
        ObservableList<SkillItem> skillItems = FXCollections.observableArrayList();
        for (SkillItem skill : p.getSkillItemInventory()) {
            skillItems.add(skill);
        }
        return skillItems;
    }

}
