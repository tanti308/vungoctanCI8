import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public BufferedImage image; // public: quyen truy xuat, ben ngoai class co the truy cap dc >< private: chi truy cap trong file
    // de het private => Alt + Insert => Getter and setter => chon bien private

    // thuoc tinh
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;   // toc do
    // ve
//    public Star(BufferedImage image, int x, int y, int width, int height, int velocityX) {
//        this.x =x;
//        this.y =y;// this la 1 object dac biet, goi chinh no
//    }
    // phim tat tao constructor Alt+Insert => chon pramater


    public Star() {

    }

    public void run() {
        this.x -= this.velocityX;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height,null);
    }


}
