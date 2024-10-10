package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

import java.awt.*;
import java.util.Collections;

class Kortlek extends AbstractPile {
        protected boolean isSelected;
        Kortlek(int x, int y) {
                super(x, y);
                isSelected = false;
        }


        @Override
        public void addCard(Card card) {
                if (!card.getFace()) {
                        card.flip();
                }
                super.stack.push(card);
        }

        @Override
        public boolean canTake(Card aCard) {
                return false;
        }

        @Override
        public void select(int tx, int ty) {
                if (!isEmpty() && includes(tx, ty)) {
                        if(isSelected == false) {
                                isSelected = true;
                        }else{
                                isSelected = false;
                        }


                }
        }

        public void shuffle() {
                Collections.shuffle(stack);
        }

        public Card dealCard() {
                if (!isEmpty()) {
                        return pop();
                }
                return null;
        }

        @Override
        public void draw(Graphics g) {
                super.draw(g);
                if (!isEmpty()) {
                        top().draw(g, x, y);
                } else {
                        g.setColor(Color.black);
                        g.fillRect(x, y, Card.WIDTH, Card.HEIGHT);
                }
        }
}
