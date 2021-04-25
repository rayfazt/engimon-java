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
import javafx.util.Pair;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryEngimonGUI extends Application {


    Stage window;
    TableView<Engimon> tableEngimon;

    public ObservableList<Engimon> getEngimons() {
        Player pemain = new Player();

        Skill fireSkill = new Skill("FireSkill", 100, 1, ElementType.FIRE);
        Skill waterSkill = new Skill("WaterSkill", 50, 1, ElementType.WATER);
        Skill electricSkill = new Skill("electric",250,1, ElementType.ELECTRIC);
//        SkillItem sk1 = new SkillItem(fireSkill,3);
//        SkillItem sk2 = new SkillItem(waterSkill,5);
//        SkillItem sk3 = new SkillItem(electricSkill,2);
//        Inventory<SkillItem> invSkill = new Inventory<>();
//        invSkill.addItem(sk1);
//        invSkill.addItem(sk2);
//        invSkill.addItem(sk3);
//        pemain.listSkill.addItem(sk1);
//        pemain.listSkill.addItem(sk2);
//        pemain.listSkill.addItem(sk3);
//        pemain.sortSkillItem();
//        pemain.printListSkillItem();
//        System.out.println("Capacity full? "+pemain.isCapacityFull());
//        pemain.delXSkillItem("FireSkill",2);
//        System.out.println("Setelah di delete satu FireSkill: ");
//        pemain.printListSkillItem();
//        // pemain.printCommands();
        ArrayList<Skill> arrSkillWater = new ArrayList<>();
        arrSkillWater.add(waterSkill);
        ArrayList<Skill> arrSkillFire = new ArrayList<>();
        arrSkillWater.add(fireSkill);
        Engimon e1 = new Engimon("Haihai", Species.Mudtle, "New Daddy", "New Mommy", arrSkillWater,1, 1);
        Engimon e2 = new Engimon();
        Engimon e3 = new Engimon("e3",Species.Charizard,"daddy e3","mommy e3",arrSkillFire,5,1);
        Engimon e4 = new Engimon("e4",Species.Mudkip,"dad4","mom4",arrSkillWater,30,1);
        // e1.getSkills().add(waterSkill);
        e1.setLevel(10);
        e2.setLevel(3);
        e3.setLevel(20);
        e4.setLevel(100);
        pemain.changeEngimonName(e4,"eheheh");
        pemain.addEngimon(e1);
        pemain.addEngimon(e2);
        pemain.addEngimon(e3);
        pemain.addEngimon(e4);
        // pemain.sortEngimon();
        // pemain.delEngimon(e2);


        ObservableList<Engimon> engimons = FXCollections.observableArrayList();
        for (Engimon engi : pemain.getEngimonInventory()) {
            engimons.add(engi);
        }
        return engimons;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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
        // Species name column
        TableColumn<Engimon, ArrayList<ElementType>> elementsColumn = new TableColumn<>("Elements");
        speciesNameColumn.setMinWidth(200);
        speciesNameColumn.setCellValueFactory(new PropertyValueFactory<>("elements"));
        // ini nanti pengennya pake gambar gitu sih
//        TableColumn<Engimon, ImageView> photoEngimonColumn = new TableColumn<Engimon, ImageView>("Photo");
//        photoEngimonColumn.setMinWidth(200);
//        photoEngimonColumn.setCellValueFactory(new PropertyValueFactory<Engimon,ImageView>("photo"));
//        photoEngimonColumn.setPrefWidth(100);
//        /* initialize two CustomImage objects and add them to the observable list */
//        ObservableList<CustomImage> imgList = FXCollections.observableArrayList();
//        CustomImage item_1 = new CustomImage(new ImageView(new Image("Icon_AddNewPatient.png")));
//        CustomImage item_2 = new CustomImage(new ImageView(new Image("Icon_EditPatient.png")));
//        imgList.addAll(item_1, item_2);
//
//        /* initialize and specify table column */
//        TableColumn<CustomImage, ImageView> firstColumn = new TableColumn<CustomImage, ImageView>("Images");
//        firstColumn.setCellValueFactory(new PropertyValueFactory<CustomImage, ImageView>("image"));
//        firstColumn.setPrefWidth(60);

//        /* add column to the tableview and set its items */
//        tableview.getColumns().add(firstColumn);
//        tableview.setItems(imgList);

//        // Teksunik (?) gausah sih
//        TableColumn<Engimon, String> teksUnikColumn = new TableColumn<>("Teks Unik");
//        teksUnikColumn.setMinWidth(200);
//        teksUnikColumn.setCellValueFactory(new PropertyValueFactory<>("teksUnik"));

        // Parent -> string, species Papa, string species Mama
        TableColumn<Engimon, Species> speciesPapaColumn = new TableColumn<>("Species papa");
        speciesPapaColumn.setMinWidth(200);
        speciesPapaColumn.setCellValueFactory(new PropertyValueFactory<>("speciesPapa"));
        TableColumn<Engimon, Species> speciesMamaColumn = new TableColumn<>("Species mama");
        speciesMamaColumn.setMinWidth(200);
        speciesMamaColumn.setCellValueFactory(new PropertyValueFactory<>("speciesMama"));
        // Elements column
        // pake gambar sih hrsnya
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

//        /* COBA */
//        Map< ArrayList<ElementType>, List<Engimon>> sortedEngimon = pemain.sortEngimon();
//        ObservableList engimonsMap = FXCollections.observableArrayList();
//        TableColumn<Map< ArrayList<ElementType>,List<Engimon>>> engimonColumn = new TableColumn<Map,Engimon>("Engimon");
//        engimonColumn.setCellValueFactory(new MapValueFactory<Engimon>("engimon"));

//        TableColumn<Map, List> firstNameColumn = new TableColumn<Map, String>("First Name");
//        firstNameColumn.setCellValueFactory(new MapValueFactory<String>("firstName"));

//        TableView table = new TableView(personMapList);
//        tableView.getColumns().setAll(firstNameColumn);

        tableEngimon = new TableView<>();
        tableEngimon.setItems(getEngimons());
        tableEngimon.getColumns().addAll(nameEngimonColumn, speciesNameColumn, elementsColumn, speciesPapaColumn, speciesMamaColumn, levelColumn, currExpColumn, maxExpColumn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableEngimon);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
}