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

public class Game extends Application {

    private String mapFile = "src/main/resources/test.txt";
    private Map map = new Map(mapFile, "");

    private final int ROWS = map.getRow();
    private final int COLUMNS = map.getCol();
    private final int SQUARE_SIZE = 40;
    private final int WIDTH = SQUARE_SIZE*COLUMNS + SQUARE_SIZE*5;
    private final int HEIGHT = SQUARE_SIZE*ROWS;

    private static final String pikachu = "main/resources/pikachu.png";
    private Image engimonImage;
    private int engimonX = 5;
    private int engimonY = 7;

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
            }
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(130), e -> run(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void run(GraphicsContext gc) {
        drawBackground(gc);
        drawEngimon(gc);
    }

    private void moveRight() throws Exception{
        if (engimonX + 1 >= map.getCol()) {
            throw new Exception();
        }
        else {
            engimonX++;
        }
    }

    private void moveLeft() throws Exception{
        if (engimonX - 1 < 0) {
            throw new Exception();
        }
        else {
            engimonX--;
        }
    }

    private void moveUp() throws Exception{
        if (engimonY - 1 < 0) {
            throw new Exception();
        }
        else {
            engimonY--;
        }
    }

    private void moveDown() throws Exception{
        if (engimonY + 1 >= map.getRow()) {
            throw new Exception();
        }
        else {
            engimonY++;
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

    private void drawEngimon(GraphicsContext gc) {
        engimonImage = new Image(pikachu);
        gc.drawImage(engimonImage, engimonX * SQUARE_SIZE, engimonY * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}