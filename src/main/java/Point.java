import java.lang.Math;

public class Point {
    private int x;
    private int y;
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }
    void setX(int x) {
        this.x = x;
    }
    void setY(int y) {
        this.y = y;
    }
    void printPoint() {
        System.out.printf("%d,%d",this.x,this.y);
    }
    double getDistance(Point other) {
        return Math.sqrt(Math.pow(other.getX()-this.getX(), 2) + Math.pow(other.getY()-this.getY(), 2) *1.0);
    }

}