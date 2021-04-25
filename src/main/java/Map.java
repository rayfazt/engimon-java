import java.lang.reflect.Array;
import java.util.*;

public class Map {
    private ArrayList<Point> map; // All points
    private ArrayList<Point> mountains;
    private ArrayList<Point> sea;
    private ArrayList<Point> grassland;
    private ArrayList<Point> tundra;

    private int row;
    private int col;

    public Map(String filename, String separator){
        try {
            this.map = new ArrayList<Point>();
            this.mountains = new ArrayList<Point>();
            this.sea = new ArrayList<Point>();
            this.grassland = new ArrayList<Point>();
            this.tundra = new ArrayList<Point>();
            int i,j;
            MapReader mapRead = new MapReader(filename, separator);
            List<String[]> lines = mapRead.read();
            i = 0;
            j = 0; // supaya ga compile error
            for (String[] line : lines) {
                j = 0;
                for (String point : line) {
                    int x = j;
                    int y = i;
                    System.out.println(point);
                    if (point.equals("m")) {
                        Point coord = new Point(x,y,MapType.MOUNTAINS);
                        this.map.add(coord);
                        this.mountains.add(coord);
                    }
                    else if (point.equals("s")) {
                        Point coord = new Point(x,y,MapType.SEA);
                        this.map.add(coord);
                        this.sea.add(coord);
                    }
                    else if (point.equals("g")) {
                        Point coord = new Point(x,y,MapType.GRASSLAND);
                        this.map.add(coord);
                        this.grassland.add(coord);
                    }
                    else {
                        // TUNDRA
                        Point coord = new Point(x,y,MapType.TUNDRA);
                        this.map.add(coord);
                        this.tundra.add(coord);
                    }
                    j++;
                }
                i++;
            }

            this.row = i;
            this.col = j;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Point> getMap() {
        return map;
    }

    public ArrayList<Point> getMountains() {
        return mountains;
    }

    public ArrayList<Point> getSea() {
        return sea;
    }

    public ArrayList<Point> getGrassland() {
        return grassland;
    }

    public ArrayList<Point> getTundra() {
        return tundra;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void printMapPoints() {
        for (Point point : map) {
            point.printPoint();
        }
        System.out.println("\n");
        for (Point point : mountains) {
            point.printPoint();
        }
        for (Point point : sea) {
            point.printPoint();
        }
        for (Point point : grassland) {
            point.printPoint();
        }
        for (Point point : tundra) {
            point.printPoint();
        }
    }


    public static void main(String[] args) {
        Map map = new Map("src/main/resources/test.txt", "");
        map.printMapPoints();
    }

}