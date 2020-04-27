import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {
    private int x;
    private int y;
    private int dx;
    private int dy;

    public static int getSIZE() {
        return SIZE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public static final int SIZE = 10;

    public Ball(int x, int y, int dx, int dy){
        // Keep track of ball's position
        this.x = x;
        this.y = y;
        // Keep track of ball's velocity
        this.dx = dx;
        this.dy = dy;
    }

    public void updateLocation(int xBound, int yBound){
        this.x += this.dx;
        this.y += this.dy;
        if((this.x < 0 || this.x > xBound)){
            this.dx *= -1;
            this.x += this.dx * 2;
        }
        if((this.y < 0 || this.y > yBound)){
            this.dy *= -1;
            this.y += this.dy * 2;
        }
    }

    public void drawBall(Graphics2D g2){
        g2.setColor(Color.blue);
        Ellipse2D.Double tempBall = new Ellipse2D.Double(x, y, SIZE, SIZE);
        g2.fill(tempBall);
    }
}
