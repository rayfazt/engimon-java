import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends Application {

    private String mapFile = "src/main/resources/test.txt";
    private Map map = new Map(mapFile, "");

    private final int ROWS = map.getRow();
    private final int COLUMNS = map.getCol();
    private final int SQUARE_SIZE = 40;
    private final int WIDTH = SQUARE_SIZE*COLUMNS + SQUARE_SIZE*12;
    private final int HEIGHT = SQUARE_SIZE*ROWS;

    private String text;
    private Player player = new Player();
    private ArrayList<WildEngimon> enemies = new ArrayList<WildEngimon>();

    private static final String playerIcon = "main/resources/player.png";
    private Image playerImage;


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

        gc = canvas.getGraphicsContext2D();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode code = event.getCode();
                if (code == KeyCode.RIGHT || code == KeyCode.D) {
                    try {
                        moveRight();
                    } catch (Exception e){
                        System.out.println("Right border");
                    }
                } else if (code == KeyCode.LEFT || code == KeyCode.A) {
                    try {
                        moveLeft();
                    } catch (Exception e){
                        System.out.println("Left border");
                    }
                } else if (code == KeyCode.UP || code == KeyCode.W) {
                    try {
                        moveUp();
                    } catch (Exception e){
                        System.out.println("Top border");
                    }
                } else if (code == KeyCode.DOWN || code == KeyCode.S) {
                    try {
                        moveDown();
                    } catch (Exception e){
                        System.out.println("Bottom border");
                    }
                }
                else if (code == KeyCode.H) {
                    setTextCommands();
                }
            }
        });

        generateEnemies();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(130), e -> run(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void run(GraphicsContext gc) {
        writeText(gc);
        drawBackground(gc);
        drawPlayer(gc);
        drawWildEngimon(gc);
    }

    private void moveRight() throws Exception{
        if (player.getPlayerLocation().getX() + 1 >= map.getCol()) {
            throw new Exception();
        }
        else {
            int x = player.getPlayerLocation().getX();
            int y = player.getPlayerLocation().getY();
            player.setPlayerLocation(x+1, y);
        }
    }

    private void moveLeft() throws Exception{
        if (player.getPlayerLocation().getX() - 1 < 0) {
            throw new Exception();
        }
        else {
            int x = player.getPlayerLocation().getX();
            int y = player.getPlayerLocation().getY();
            player.setPlayerLocation(x-1, y);
        }
    }

    private void moveUp() throws Exception{
        if (player.getPlayerLocation().getY() - 1 < 0) {
            throw new Exception();
        }
        else {
            int x = player.getPlayerLocation().getX();
            int y = player.getPlayerLocation().getY();
            player.setPlayerLocation(x, y-1);
        }
    }

    private void moveDown() throws Exception{
        if (player.getPlayerLocation().getY() + 1 >= map.getRow()) {
            throw new Exception();
        }
        else {
            int x = player.getPlayerLocation().getX();
            int y = player.getPlayerLocation().getY();
            player.setPlayerLocation(x, y+1);
        }
    }

    private void generateEnemies() {
        Skill skillDefault = new Skill();
        ArrayList<Skill> listOfSkill = new ArrayList<Skill>();

        int index, x, y;
        Point location = new Point();

        // Random location in mountains
        Random randomGenerator1 = new Random();
        index = randomGenerator1.nextInt(map.getMountains().size()-1);
        location = map.getMountains().get(index);
        location.printPoint();
        x = location.getX();
        y = location.getY();
        WildEngimon w1 = new WildEngimon("charizard1", Species.Charizard, "dad", "mom", listOfSkill, x, y);
        System.out.println(w1.getX());
        System.out.println(w1.getY());
        enemies.add(w1);

        // Random location in sea
        Random randomGenerator2 = new Random();
        index = randomGenerator2.nextInt(map.getSea().size()-1);
        location = map.getSea().get(index);
        location.printPoint();
        x = location.getX();
        y = location.getY();
        WildEngimon w2 = new WildEngimon("squirtle", Species.Squirtle, "dad", "mom", listOfSkill, x, y);
        System.out.println(w2.getX());
        System.out.println(w2.getY());
        enemies.add(w2);

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

    private void setTextCommands() {
        text = player.stringCommands();
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