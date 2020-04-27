import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Enemy extends Ball {

    public Enemy(int x, int y, int dx, int dy) {
        super(x, y, dx, dy);
    }

    public void drawBall(Graphics2D g2){
        g2.setColor(Color.red);
        Ellipse2D.Double tempBall = new Ellipse2D.Double(this.getX(), this.getY(), SIZE, SIZE);
        g2.fill(tempBall);
    }

    public boolean destroyBall(Ball aBall){
        int centerEnemyX = this.getX() + Ball.SIZE/2;
        int centerEnemyY = this.getY() + Ball.SIZE/2;
        int centerBallX = aBall.getX() + Ball.SIZE/2;
        int centerBallY = aBall.getY() + Ball.SIZE/2;

        double distanceBetween = Math.sqrt(Math.pow(centerEnemyX - centerBallX, 2) + Math.pow(centerEnemyY - centerBallY, 2));

        if(distanceBetween <= Ball.SIZE){
            return true;
        }else{
            return false;
        }
    }
}
