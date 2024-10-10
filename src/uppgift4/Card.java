package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

import java.awt.*;



public class Card extends AbstractCard{
        private boolean isSelected = false;
        public Card(int rank, String name){
                super(rank, name);
        }
        public boolean isSelected() {
                return isSelected;
        }
        public void setSelected(boolean selected) {
                isSelected = selected;
        }


        @Override
        public void draw(Graphics g, int x, int y){
                if (!getFace()) {
                        g.drawImage(faceDownImage, x, y, null);
                } else {
                        g.drawImage(image, x, y, null);
                }

        }



}

