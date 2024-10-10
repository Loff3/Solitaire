package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class AbstractCard {
        protected final  Image image;
        protected final Image faceDownImage;


        final public static int WIDTH = 71;
        final public static int HEIGHT = 96;
        private boolean face;
        private int rank;


        public AbstractCard(int rank, String name){
                this.rank = rank;
                this.face = false;
                image = readImage("src/uppgift4/cards/" + name + ".gif");
                faceDownImage = readImage("src/uppgift4/cards/b1fv.gif");


        }
        private Image readImage(String file) {
                Image image;
                try{
                        image = ImageIO.read(new File(file));
                } catch (IOException e) {
                        throw new RuntimeException(file);
                }
                return image;
        }

        public int getRank() {
                return rank;
        }


        public boolean getFace() {
                return face;
        }

        public void flip() {
                face = !face;
        }

        public abstract void draw(Graphics g, int x, int y);
}
