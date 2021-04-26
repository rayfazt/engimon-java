import javafx.application.Application;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.control.Button;

import java.awt.*;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game extends Application {

    private String mapFile = "src/main/resources/test.txt";
    private Map map = new Map(mapFile, "");

    private final int ROWS = map.getRow();
    private final int COLUMNS = map.getCol();
    private final int SQUARE_SIZE = 40;
    private final int WIDTH = SQUARE_SIZE*COLUMNS + SQUARE_SIZE*13;
    private final int HEIGHT = SQUARE_SIZE*ROWS;

    private String text;
    private Player player = new Player();
    private ArrayList<WildEngimon> enemies = new ArrayList<WildEngimon>();

    private static final String playerIcon = "player.png";
    private Image playerImage;

    private ArrayList<PlayerEngimon> listOfPlayerEngimon = new ArrayList<PlayerEngimon>();
    private ArrayList<Button> playerEngimonButton = new ArrayList<Button>();
    private Integer turn = 0;
    private static final int MAXEXP = 10000;


    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Engimon");
        Group root = new Group();
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        ArrayList<Skill> skill__ = new ArrayList<Skill>();
        Skill defSkill = new Skill();
        skill__.add(defSkill);
        PlayerEngimon B = new PlayerEngimon("Haihai", Species.Mudtle, "New Daddy", "New Mommy",
                skill__,1, 1);
        PlayerEngimon A = new PlayerEngimon();
        listOfPlayerEngimon.add(A);
        listOfPlayerEngimon.add(B);
        player.addEngimon(A);
        player.addEngimon(B);

        gc = canvas.getGraphicsContext2D();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode code = event.getCode();
                if (code == KeyCode.RIGHT || code == KeyCode.D) {
                    try {
                        moveRight();
                        turn++;
                        randomMoveEnemies();
                        addEnemiesEXP();
                        killEnemies();
                    } catch (Exception e){
                        System.out.println("Right border");
                    }
                } else if (code == KeyCode.LEFT || code == KeyCode.A) {
                    try {
                        moveLeft();
                        turn++;
                        randomMoveEnemies();
                        addEnemiesEXP();
                        killEnemies();
                    } catch (Exception e){
                        System.out.println("Left border");
                    }
                } else if (code == KeyCode.UP || code == KeyCode.W) {
                    try {
                        moveUp();
                        turn++;
                        randomMoveEnemies();
                        addEnemiesEXP();
                        killEnemies();
                    } catch (Exception e){
                        System.out.println("Top border");
                    }
                } else if (code == KeyCode.DOWN || code == KeyCode.S) {
                    try {
                        moveDown();
                        turn++;
                        randomMoveEnemies();
                        addEnemiesEXP();
                        killEnemies();
                    } catch (Exception e){
                        System.out.println("Bottom border");
                    }
                } else if (code == KeyCode.H) {
                    setTextCommands();
                } else if (code == KeyCode.DIGIT1) {
                    setTextListEngimon();
                }
                else if (code == KeyCode.DIGIT2) {
                    // TODO Menampilkan data lengkap suatu engimon
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Nama engimon yang ingin dilihat: ");
                    String name = scanner.nextLine();
                    PlayerEngimon engi = player.getEngimonFromName(name);
                    // engi.printInfo();
                    setText(engi.toString());
                }
                else if (code == KeyCode.DIGIT3) {
                    for (int k = 0; k < listOfPlayerEngimon.size(); k++){
                        if (listOfPlayerEngimon.get(k).getActive() == true){
                            System.out.println(listOfPlayerEngimon.get(k).getName() + " aktif");
                            text = listOfPlayerEngimon.get(k).getName() + " aktif";
                        }
                    }

                }

                else if (code == KeyCode.DIGIT4) {
                    for (int i = 0; i < listOfPlayerEngimon.size(); i++){
                        System.out.println((i+1) + ". " + listOfPlayerEngimon.get(i).getName());
                    }
                    System.out.println("Masukkan nama engimon yang ingin diaktifkan: ");
                    Scanner scanner = new Scanner(System.in);
                    Integer nomorEngimon = scanner.nextInt();
                    System.out.println(nomorEngimon);
                    listOfPlayerEngimon.get(nomorEngimon-1).setActiveTrue();
                    for (int k = 0; k < listOfPlayerEngimon.size(); k++){
                        if (k != nomorEngimon-1){
                            listOfPlayerEngimon.get(k).setActiveFalse();
                        }
                    }
                    if (listOfPlayerEngimon.get(nomorEngimon-1).getActive() == true){
                        System.out.println(listOfPlayerEngimon.get(nomorEngimon-1).getName() + " sudah aktif");
                        text = listOfPlayerEngimon.get(nomorEngimon-1).getName() + " sudah aktif";
                    }


                }
                else if (code == KeyCode.DIGIT5) {
                    // TODO Menggunakan skill item pada suatu engimon
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Nama engimon: ");
                    String newEngimonName = scanner.nextLine();
                    System.out.println("Nama skill item yang ingin digunakan: ");
                    String newSkillName = scanner.nextLine();
                    System.out.println("Mastery levelnya: ");
                    int newMastery = scanner.nextInt();
                    // harus sesuai ya
                    PlayerEngimon newEngimon = player.getEngimonFromName(newEngimonName);
                    SkillItem newSkill = player.getSkillItemFromName(newSkillName,newMastery);
                    player.setActiveEngimon(newEngimon);
                    player.useSkillItem(newEngimon,newSkill);
                    // Ini asumsi namanya bener ajalah
                    setText("Skill item "+newSkillName+ " berhasil digunakan pada engimon"+newEngimonName);
                }
                else if (code == KeyCode.DIGIT6) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Nama parent pertama: ");
                    String parent1Name = scanner.nextLine();
                    System.out.println("Nama parent kedua: ");
                    String parent2Name = scanner.nextLine();
                    PlayerEngimon parent1 = player.searchEngimonInList(parent1Name);
                    PlayerEngimon parent2 = player.searchEngimonInList(parent2Name);
                    if (parent1 != null && parent2 != null) {
                        try {
                            player.breed(parent1, parent2);
                        } catch (BreedException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Tidak ada engimon dengan nama yang dimasukkan");
                    }
                }
                else if (code == KeyCode.DIGIT7) {
                    // TODO Membuang X amount dari suatu skill item
                    // TODO Melepaskan engimon inventory
                    // SEMUA ASUMSIIN BERHASIL GA ADA ERROR
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Commands:\n1. Membuang X amount dari suatu skill item\n2. Melepaskan engimon inventory");
                    System.out.println("Masukkan input (1/2): ");
                    int input = scanner.nextInt();
                    if (input == 1) {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Nama skill item yang ingin dihapus: ");
                        String newSkillName = scanner1.nextLine();
                        System.out.println("Mastery levelnya: ");
                        int masteryLevel = scanner1.nextInt();
                        SkillItem newSkill = player.getSkillItemFromName(newSkillName,masteryLevel);
                        System.out.println("Jumlah amount skill item: ");
                        int amountNewSkill = scanner1.nextInt();
                        player.delXSkillItem(newSkill.getSkill(),amountNewSkill);
                        // System.out.println("Berhasil dihapus");
                        setText("Skill" + newSkillName + " sebanyak "+amountNewSkill+" berhasil dihapus");
                    }
                    else if (input == 2) {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Nama engimon yang ingin dilepaskan: ");
                        String newName = scanner2.nextLine();
                        PlayerEngimon newEngimon = player.getEngimonFromName(newName);
                        player.delEngimon(newEngimon);
                        // System.out.println("Engimon berhasil dihapus");
                        setText("Engimon "+newName+ " berhasil dihapus.");
                    }
                    else {
                        // System.out.println("Invalid command!");
                        setText("Invalid command!");
                    }
                }
                else if (code == KeyCode.DIGIT8) {
                    // TODO Mengganti nama dari suatu engimon yang ada di inventory
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Nama engimon lama: ");
                    String oldName = scanner.nextLine();
                    System.out.println("Nama engimon baru: ");
                    String newName = scanner.nextLine();
                    PlayerEngimon oldEngimon = player.getEngimonFromName(oldName);
                    player.changeEngimonName(oldEngimon, newName);
                    // Ini asumsi namanya bener ajalah
                    // System.out.println("Berhasil diganti");
                    setText("Nama engimon berhasil diganti dari" + oldName+" menjadi "+newName+"\nTekan tombol E untuk melihat inventory.\n");
                }
                else if (code == KeyCode.DIGIT9) {
                    FileSaverAndLoader.savePlayer(player);
                    FileSaverAndLoader.saveWildEngimons(enemies);
                    setTextSaveSuccess();
                }
                else if (code == KeyCode.B) {
                    int x = player.getPlayerLocation().getX();
                    int y = player.getPlayerLocation().getY();
                    if (isEnemyPresent(x+1,y)!=null || isEnemyPresent(x-1,y)!=null || isEnemyPresent(x,y+1)!=null || isEnemyPresent(x,y-1)!=null) {
                        ArrayList<WildEngimon> enemies = isBattleFeasible();
                        for (WildEngimon enemy : enemies) {
                            Battle war = new Battle(player, enemy);
                            boolean win = war.commenceBattle();
                            if (win)  {
                                player.setPlayerLocation(enemy.getX(), enemy.getY());
                            }
                        }
                    }
                    else {
                        text = "No enemy nearby";
                    }
                }
                /* SHOW INVENTORY */
                else if (code == KeyCode.I) {
                    InventorySkillItemGUI inv = new InventorySkillItemGUI();
                    inv.showInventorySkillItem(player);
                }
                else if (code == KeyCode.E) {
                    InventoryEngimonGUI inv2 = new InventoryEngimonGUI();
                    inv2.showInventoryEngimon(player);
                }
            }
        });

        generateEnemies();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(130), e -> run(gc, root)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void run(GraphicsContext gc, Group root) {
        writeText(gc);
        drawBackground(gc);
        drawPlayer(gc);
        drawWildEngimon(gc);
        EngimonButton(player.getEngimonInventory(), root, playerEngimonButton);
    }

    private void EngimonButton(ArrayList<PlayerEngimon> listOfPlayerEngimon, Group root, ArrayList<Button> playerEngimonButton){
        int currButtonSize = playerEngimonButton.size();
        int size = listOfPlayerEngimon.size();
        for (int i = currButtonSize; i < listOfPlayerEngimon.size(); i++){
            Button btn = new Button(listOfPlayerEngimon.get(i).getSpeciesName().toString());
            btn.setLayoutX(900);
            btn.setLayoutY(300 + 50*i);
            btn.setTooltip(new Tooltip(listOfPlayerEngimon.get(i).printInfoTooltip()));
            int finalI = i;
            btn.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent eventEngimon){
                    listOfPlayerEngimon.get(finalI).setActiveTrue();
                    for (int j = 0; j < listOfPlayerEngimon.size(); j++){
                        if (j != finalI){
                            listOfPlayerEngimon.get(j).setActiveFalse();
                        }
                    }
                    System.out.println(listOfPlayerEngimon.get(finalI).getSpeciesName().toString() + " is active");
                }
            });
            root.getChildren().add(btn);
            playerEngimonButton.add(btn);
        }
    }


    private void moveRight() throws Exception{
        int x = player.getPlayerLocation().getX();
        int y = player.getPlayerLocation().getY();
        if (x + 1 >= map.getCol() || isEnemyPresent(x+1,y)!= null) {
            throw new Exception();
        } else {
            player.setPlayerLocation(x+1, y);
        }
    }

    private void moveLeft() throws Exception{
        int x = player.getPlayerLocation().getX();
        int y = player.getPlayerLocation().getY();
        if (x - 1 < 0 || isEnemyPresent(x-1,y)!= null) {
            throw new Exception();
        } else {
            player.setPlayerLocation(x-1, y);
        }
    }

    private void moveUp() throws Exception{
        int x = player.getPlayerLocation().getX();
        int y = player.getPlayerLocation().getY();
        if (y - 1 < 0 || isEnemyPresent(x,y-1)!= null) {
            throw new Exception();
        } else {
            player.setPlayerLocation(x, y-1);
        }
    }

    private void moveDown() throws Exception{
        int x = player.getPlayerLocation().getX();
        int y = player.getPlayerLocation().getY();
        if (y + 1 >= map.getRow() || isEnemyPresent(x,y+1)!= null) {
            throw new Exception();
        } else {
            player.setPlayerLocation(x, y+1);
        }
    }

    private void generateEnemies() {
        Skill skillDefault = new Skill();
        ArrayList<Skill> listOfSkill = new ArrayList<Skill>();

        Random randomGenerator = new Random();
        int index, x, y;
        Point location;

        // Random location in mountains
        index = randomGenerator.nextInt(map.getMountains().size()-1);
        location = map.getMountains().get(index);
        location.printPoint();
        x = location.getX();
        y = location.getY();
        WildEngimon w1 = new WildEngimon("charizard", Species.Charizard, "dad", "mom", listOfSkill, x, y);
        enemies.add(w1);

        // Random location in sea
        index = randomGenerator.nextInt(map.getSea().size()-1);
        location = map.getSea().get(index);
        location.printPoint();
        x = location.getX();
        y = location.getY();
        WildEngimon w2 = new WildEngimon("squirtle", Species.Squirtle, "dad", "mom", listOfSkill, x, y);
        enemies.add(w2);

        // Random location in grassland
        index = randomGenerator.nextInt(map.getGrassland().size()-1);
        location = map.getGrassland().get(index);
        location.printPoint();
        x = location.getX();
        y = location.getY();
        WildEngimon w3 = new WildEngimon("pikachu", Species.Pikachu, "dad", "mom", listOfSkill, x, y);
        enemies.add(w3);

        // Random location in grassland
        index = randomGenerator.nextInt(map.getGrassland().size()-1);
        location = map.getGrassland().get(index);
        location.printPoint();
        x = location.getX();
        y = location.getY();
        WildEngimon w4 = new WildEngimon("mudkip", Species.Mudkip, "dad", "mom", listOfSkill, x, y);
        enemies.add(w4);

        // Random location in tundra
        index = randomGenerator.nextInt(map.getTundra().size()-1);
        location = map.getTundra().get(index);
        location.printPoint();
        x = location.getX();
        y = location.getY();
        WildEngimon w5 = new WildEngimon("gabumon", Species.Gabumon, "dad", "mom", listOfSkill, x, y);
        enemies.add(w5);

    }

    // Check if a particular point contains Wild Engimon
    private WildEngimon isEnemyPresent(int x, int y) {
        boolean found = false;
        int i = 0;
        while (!found && i < enemies.size()) {
            if (x == enemies.get(i).getX() && y == enemies.get(i).getY()) {
                found = true;
                return enemies.get(i);
            }
            i++;
        }
        return null;
    }

    // Check if player's surrounding cells contain Wild Engimon
    private ArrayList<WildEngimon> isBattleFeasible() {
        ArrayList<WildEngimon> surroundingEnemies = new ArrayList<WildEngimon>();

        int x = player.getPlayerLocation().getX();
        int y = player.getPlayerLocation().getY();

        WildEngimon top = isEnemyPresent(x,y-1);
        if (top != null) {
            surroundingEnemies.add(top);
        }

        WildEngimon bottom = isEnemyPresent(x,y+1);
        if (bottom != null) {
            surroundingEnemies.add(bottom);
        }

        WildEngimon right = isEnemyPresent(x+1,y);
        if (right != null) {
            surroundingEnemies.add(right);
        }

        WildEngimon left = isEnemyPresent(x-1,y);
        if (left != null) {
            surroundingEnemies.add(left);
        }

        return surroundingEnemies;
    }

    private void addEnemiesEXP() {
        if (turn % 5 == 0) {
            for (WildEngimon enemy: enemies) {
                enemy.setCurrExp(enemy.getCurrExp() + 100);
                enemy.updateEngimonLevel();
            }
        }
    }

    private void killEnemies() {
        if (turn % 5 == 0) {
            for (WildEngimon enemy: enemies) {
                if (enemy.getCurrExp() >= MAXEXP) {
                    enemies.remove(enemy);
                }
            }
        }
    }

    private void randomMoveEnemies() {
        if (turn % 5 == 0) {
            Random randomGenerator = new Random();
            Point location;
            int index;
            for (WildEngimon enemy : enemies) {
                if (enemy.getSpeciesName() == Species.Charizard) {
                    index = randomGenerator.nextInt(map.getMountains().size() - 1);
                    location = map.getMountains().get(index);
                    enemy.setX(location.getX());
                    enemy.setY(location.getY());
                } else if (enemy.getSpeciesName() == Species.Squirtle) {
                    index = randomGenerator.nextInt(map.getSea().size() - 1);
                    location = map.getSea().get(index);
                    enemy.setX(location.getX());
                    enemy.setY(location.getY());
                } else if (enemy.getSpeciesName() == Species.Pikachu || enemy.getSpeciesName() == Species.Mudkip) {
                    index = randomGenerator.nextInt(map.getGrassland().size() - 1);
                    location = map.getGrassland().get(index);
                    enemy.setX(location.getX());
                    enemy.setY(location.getY());
                } else if (enemy.getSpeciesName() == Species.Gabumon) {
                    index = randomGenerator.nextInt(map.getTundra().size() - 1);
                    location = map.getTundra().get(index);
                    enemy.setX(location.getX());
                    enemy.setY(location.getY());
                } else if (enemy.getSpeciesName() == Species.Charkachu) {
                    ArrayList<Point> mountainsGrassland = new ArrayList<Point>();
                    mountainsGrassland.addAll(map.getMountains());
                    mountainsGrassland.addAll(map.getGrassland());
                    index = randomGenerator.nextInt(mountainsGrassland.size() - 1);
                    location = mountainsGrassland.get(index);
                    enemy.setX(location.getX());
                    enemy.setY(location.getY());
                } else if (enemy.getSpeciesName() == Species.Squirmon) {
                    ArrayList<Point> seaTundra = new ArrayList<Point>();
                    seaTundra.addAll(map.getSea());
                    seaTundra.addAll(map.getTundra());
                    index = randomGenerator.nextInt(seaTundra.size() - 1);
                    location = seaTundra.get(index);
                    enemy.setX(location.getX());
                    enemy.setY(location.getY());
                } else if (enemy.getSpeciesName() == Species.Mudtle) {
                    ArrayList<Point> seaGrassland = new ArrayList<Point>();
                    seaGrassland.addAll(map.getSea());
                    seaGrassland.addAll(map.getGrassland());
                    index = randomGenerator.nextInt(seaGrassland.size() - 1);
                    location = seaGrassland.get(index);
                    enemy.setX(location.getX());
                    enemy.setY(location.getY());
                }
            }
        }
    }

    private void drawBackground(GraphicsContext gc) {
        ArrayList<Point> points = map.getMap();
        int index = 0;
        for (int i = 0; i < map.getRow(); i++) {
            for (int j = 0; j < map.getCol(); j++) {
                if (points.get(index).getType() == MapType.MOUNTAINS) {
                    if ((i + j) % 2 == 0) {
                        gc.setFill(Color.web("C3C388"));
                    } else {
                        gc.setFill(Color.web("BBBB77"));
                    }
                    gc.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
                else if (points.get(index).getType() == MapType.SEA) {
                    if ((i + j) % 2 == 0) {
                        gc.setFill(Color.web("B3ECFF"));
                    } else {
                        gc.setFill(Color.web("99E6FF"));
                    }
                    gc.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
                else if (points.get(index).getType() == MapType.GRASSLAND) {
                    if ((i + j) % 2 == 0) {
                        gc.setFill(Color.web("AAD751"));
                    } else {
                        gc.setFill(Color.web("A2D149"));
                    }
                    gc.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
                else {
                    // TUNDRA
                    if ((i + j) % 2 == 0) {
                        gc.setFill(Color.web("B3B3B3"));
                    } else {
                        gc.setFill(Color.web("A6A6A6"));
                    }
                    gc.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
                index++;
            }
        }
    }

    private void drawPlayer(GraphicsContext gc) {
        playerImage = new Image(playerIcon);
        gc.drawImage(playerImage, player.getPlayerLocation().getX() * SQUARE_SIZE, player.getPlayerLocation().getY() * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
        //Image activeEngimonImage = new Image(player.getActiveEngimon().getImagePath());
        //gc.drawImage(activeEngimonImage, (player.getPlayerLocation().getX()-1)*SQUARE_SIZE, (player.getPlayerLocation().getY()-1)*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }

    private void drawWildEngimon(GraphicsContext gc) {
        for (WildEngimon enemy: enemies) {
            Image enemyImage = new Image(enemy.getImagePath());
            gc.drawImage(enemyImage, enemy.getX() * SQUARE_SIZE, enemy.getY()*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
        }
    }

    /*
    private void drawEngimon(GraphicsContext gc) {
        engimonImage = new Image(pikachu);
        gc.drawImage(engimonImage, engimonX * SQUARE_SIZE, engimonY * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }
     */
    private void setText(String teks) {
        text = teks;
    }
    private void setTextCommands() {
        text = player.stringCommands();
    }

    private void setTextListEngimon() {
        text = player.stringSortedEngimon();
    }

    private void setTextActiveEngimon() {
        text = player.stringActiveEngimon();
    }

    private void setTextSaveSuccess() {
        text = "Game saved successfully";
    }

    private void writeText(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.web("000000"));
        gc.fillText(text, map.getCol()*SQUARE_SIZE+20, SQUARE_SIZE/2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}