import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {
    private GameCanvas gameCanvas;
    private long lastTime = 0;

    private int vXEnemy = 10;
    private int vYEnemy = 10;

    public Random random = new Random();

    public GameWindow() {
        this.setSize(1024,600);

        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            // chỉ quan tâm key pressed và key released
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_A)) {
                    gameCanvas.positionXPlayer -= 5;
                    if (gameCanvas.positionXPlayer <=0) {
                        gameCanvas.positionYPlayer = random.nextInt(595);
                        gameCanvas.positionXPlayer = 1024;
                    }
                }
                if ((e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_D)) {
                    gameCanvas.positionXPlayer += 5;
                    if (gameCanvas.positionXPlayer >= 1024) {
                        gameCanvas.positionYPlayer = random.nextInt(595);
                        gameCanvas.positionXPlayer = 0;
                    }
                }
                if ((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_W)) {
                    gameCanvas.positionYPlayer -= 5;
                    if (gameCanvas.positionYPlayer <=0) {
                        gameCanvas.positionYPlayer =600;
                        gameCanvas.positionXPlayer =  random.nextInt(1019);

                    }
                }
                if ((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_S)) {
                    gameCanvas.positionYPlayer +=5;
                    if (gameCanvas.positionYPlayer >=600) {
                        gameCanvas.positionYPlayer =0;
                        gameCanvas.positionXPlayer = random.nextInt(1019);
                    }
                }
            }



            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_SPACE){
                    System.out.println("Space released");
                }
            }
        });

        // Tắt chương trình khi thoát
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

        this.setVisible(true);

    }
    public void gameLoop(){
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.positionXStar -=3;



                if (this.gameCanvas.positionXEnemy == 0){
                    vXEnemy = 10;
                }
                if (this.gameCanvas.positionXEnemy ==1024){
                    vXEnemy = -10;
                }
                if (this.gameCanvas.positionYEnemy ==600) {
                    vYEnemy = -10;
                }
                if (this.gameCanvas.positionYEnemy ==0) {
                    vYEnemy = 10;
                }

                this.gameCanvas.positionXEnemy += vXEnemy;
                this.gameCanvas.positionYEnemy += vYEnemy;

                this.gameCanvas.renderAll();
                this.gameCanvas.repaint();
                this.lastTime = currentTime;
            }

        }
    }


}
