import java.util.*;

public class Map {
    private ArrayList<Point> map; //Masih bingung ke game.java nya gmn
    private int row;
    private int col;

    public Map(String filename, String separator){
        this.map = new ArrayList<Point>();
        int i,j;
        MapReader mapRead = new MapReader(filename, separator);
        try {
            List<String[]> lines = mapRead.read();
            i = 0;
            j = 0; // supaya ga compile error
            for (String[] line : lines) {
                j = 0;
                for (String point : line) {
                    int x = i;
                    int y = j;
                    System.out.println(point);
                    if (point.equals("m")) {
                        Point coord = new Point(x,y,MapType.MOUNTAINS);
                        this.map.add(coord);
                    }
                    else if (point.equals("s")) {
                        Point coord = new Point(x,y,MapType.SEA);
                        this.map.add(coord);
                    }
                    else if (point.equals("g")) {
                        Point coord = new Point(x,y,MapType.GRASSLAND);
                        this.map.add(coord);
                    }
                    else {
                        // TUNDRA
                        Point coord = new Point(x,y,MapType.TUNDRA);
                        this.map.add(coord); 
                    }
                    j++;
                }
                i++;
            }

            this.row = i;
            this.col = j;

        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public void printMapPoints() {
        for (Point point : map) {
            point.printPoint();
        }
    }

    /*
    public static void main(String[] args) {
        Map map = new Map("test.txt", "");
        map.printMapPoints();
    }
    */
}