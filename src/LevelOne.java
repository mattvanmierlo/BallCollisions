import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class LevelOne {

    ArrayList<Ball> ballArrayList;
    ArrayList<Enemy> enemyArrayList;

    public LevelOne(){
        ballArrayList = new ArrayList<>();
        enemyArrayList = new ArrayList<>();
        createBalls();
        createEnemies();
    }

    public void createBalls(){
        for(int i = 0; i < 20; i++){
            // Number between 0 and 500 (width of the screen)
            int randX = (int) Math.floor(Math.random() * 501);
            int randY = (int) Math.floor(Math.random() * 501);
            int randDx = ((int) Math.floor(Math.random() * 5)) - 2;
            int randDy = ((int) Math.floor(Math.random() * 5)) - 2;
            ballArrayList.add(new Ball(randX, randY, randDx, randDy));
        }
    }

    public void createEnemies(){
        for(int j = 0; j < 20; j++){
            // Number between 0 and 500 (width of the screen)
            int randX = (int) Math.floor(Math.random() * 501);
            int randY = (int) Math.floor(Math.random() * 501);
            int randDx = ((int) Math.floor(Math.random() * 5)) - 2;
            int randDy = ((int) Math.floor(Math.random() * 5)) - 2;
            enemyArrayList.add(new Enemy(randX, randY, randDx, randDy));
        }
    }

    public void updateLevelSim(){
        // Remember, the screen is 500 x 500 pixels
        // Balls will bounce around the screen
        // Check to see if balls collide
        // If so, remove the corresponding ball from the list
        //      the enemy lives on
        for(int i = 0; i < ballArrayList.size(); i++){

            ballArrayList.get(i).updateLocation(500,500);
        }

        for(int i = 0; i < enemyArrayList.size(); i++){
            enemyArrayList.get(i).updateLocation(500,500);
        }

        ArrayList<Integer> indicesToRemove = new ArrayList<>();

        for(int j = 0; j < enemyArrayList.size(); j++){
            Enemy tempEnemy = enemyArrayList.get(j);
            for(int k = 0; k < ballArrayList.size(); k++){
                Ball tempBall = ballArrayList.get(k);
                if(tempEnemy.destroyBall(tempBall)){
                    indicesToRemove.add(k);
                }
            }

            for(int index : indicesToRemove){
                ballArrayList.remove(index);
            }

            indicesToRemove = new ArrayList<>();
        }

    }

    public void drawLevel(Graphics2D g2){
        for(Ball ball : ballArrayList){
//            g2.setColor(Color.blue);
//            Ellipse2D.Double tempBall = new Ellipse2D.Double(ball.getX(), ball.getY(), ball.getSIZE(), ball.getSIZE());
//            g2.fill(tempBall);
            ball.drawBall(g2);
        }

        for(Enemy enemy : enemyArrayList){
//            g2.setColor(Color.red);
//            Ellipse2D.Double tempBall = new Ellipse2D.Double(enemy.getX(), enemy.getY(), enemy.getSIZE(), enemy.getSIZE());
//            g2.fill(tempBall);
            enemy.drawBall(g2);
        }
    }
}
