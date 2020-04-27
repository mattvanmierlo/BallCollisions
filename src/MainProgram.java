import javax.swing.*;
import java.awt.*;

public class MainProgram extends JPanel {

    private LevelOne levelOne;
    private Thread drawThread;

    public MainProgram(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.white);
        this.setVisible(true);
        this.levelOne = new LevelOne();
        this.drawThread = new Worker();
        this.drawThread.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Paint our balls here
        this.levelOne.drawLevel(g2);
        this.levelOne.updateLevelSim();
        // Test code to draw a ball
        //      Ball tempBall = new Ball(250,250,0,0);
        //      tempBall.drawBall(g2);
        // Test code to draw an enemy
        //      Enemy tempEnemy = new Enemy(250,300,0,0);
        //      tempEnemy.drawBall(g2);


    }

    private class Worker extends Thread{
        public void run(){
            while(true){
                repaint();
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        // Making the JFrame here instead of a separate class
        JFrame mainFrameWindow = new JFrame("Ball Collisions");
        mainFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrameWindow.setPreferredSize(new Dimension(500,500));
        mainFrameWindow.add(new MainProgram());
        mainFrameWindow.pack();
        mainFrameWindow.setVisible(true);
    }
}
