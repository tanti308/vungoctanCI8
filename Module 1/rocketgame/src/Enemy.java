import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {

    public BufferedImage image;

    public int x;
    public int y;

    public int width;
    public int height;

    public int velocityX;

    public Enemy() {

    }

    public void run() {
        this.x -= this.velocityX;
    }

    public void render(Graphics graphics) {
        if (this.image != null)
            graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);

    }


}

