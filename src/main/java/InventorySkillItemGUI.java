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

public class InventorySkillItemGUI extends Application {

    Stage window;
    TableView<SkillItem> tableSkillItem;

    public ObservableList<SkillItem> getSkillItems() {
        Player pemain = new Player();

        Skill fireSkill = new Skill("FireSkill", 100, 1, ElementType.FIRE);
        Skill waterSkill = new Skill("WaterSkill", 50, 1, ElementType.WATER);
        Skill electricSkill = new Skill("electric",250,1, ElementType.ELECTRIC);
        Skill electricSkill2 = new Skill("electric",250,2, ElementType.ELECTRIC);

        SkillItem sk1 = new SkillItem(fireSkill,3);
        SkillItem sk2 = new SkillItem(waterSkill,5);
        SkillItem sk3 = new SkillItem(electricSkill,2);
        SkillItem sk4 = new SkillItem(electricSkill2,1);
//        Inventory<SkillItem> invSkill = new Inventory<>();
//        invSkill.addItem(sk1);
//        invSkill.addItem(sk2);
//        invSkill.addItem(sk3);
        pemain.addSkillItem(sk1.getSkill(), sk1.getSkillAmount());
        pemain.addSkillItem(sk2.getSkill(),sk2.getSkillAmount());
        pemain.addSkillItem(sk3.getSkill(),sk3.getSkillAmount());
        pemain.addSkillItem(sk4.getSkill(),sk4.getSkillAmount());


        ObservableList<SkillItem> skillItems = FXCollections.observableArrayList();
        for (SkillItem skill : pemain.getSkillItemInventory()) {
            skillItems.add(skill);
        }
        return skillItems;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Inventory SkillItem");



        // Skill column
        TableColumn<SkillItem, String> skillColumn = new TableColumn<>("Skill");
        skillColumn.setCellValueFactory(new PropertyValueFactory<>("skill"));
        // Amount column
        TableColumn<SkillItem, Integer> amountColumn = new TableColumn<>("Amount");
        amountColumn.setMinWidth(200);
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("skillAmount"));

        tableSkillItem = new TableView<>();
        tableSkillItem.setItems(getSkillItems());
        tableSkillItem.getColumns().addAll(skillColumn,amountColumn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableSkillItem);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
}
