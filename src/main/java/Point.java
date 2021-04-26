public class Point implements java.io.Serializable{
    private int x;
    private int y;
    private MapType type;

    public Point(){
        this.x = 0;
        this.y = 0;
        this.type = MapType.GRASSLAND;
    }

    public Point(int x, int y, MapType type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MapType getType() {
        return type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(MapType type) {
        this.type = type;
    }

    public void printPoint(){
        System.out.println("Coordinate: " + "(" + this.x + "," + this.y + ")");
        System.out.println("Type: " + this.type);
    }

    @Override
    public String toString() {
        return "Coordinate: (" + x + "," + y + ")\nType: " + type;
    }

    public static void main(String[] args) {
        Point a = new Point();
        System.out.println(a.toString());
    }
}