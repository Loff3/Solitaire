package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

import java.awt.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class AbstractPile {
        protected int x;
        protected int y;
        protected Stack<Card> stack;

        AbstractPile(int x, int y){
                this.x = x;
                this.y = y;
                stack = new Stack<Card>();
        }

        public int getX() {
                return x;
        }

        public int getY() {
                return y;
        }

        public Card top(){
                if (!stack.isEmpty()) {
                        return stack.peek();
                }
                return null;
        }


        public boolean isEmpty(){
                return stack.isEmpty();
        }

        public boolean includes (int tx, int ty) {
                return x <= tx && tx <= x + Card.WIDTH &&
                        y <= ty && ty <= y + Card.HEIGHT;
        }

        public Card pop() {
                try {
                        return stack.pop();
                } catch( EmptyStackException e ){
                        return null;
                }
        }
        public void removeCard(Card card) {
                if (!stack.isEmpty() && stack.peek().equals(card)) {
                        stack.pop();
                }
        }
        public void select (int tx, int ty) {
                // do nothing
        }
        public void addCard (Card card) {
                if (canTake(card)) {
                        stack.push(card);
                }
        }

        public void draw(Graphics g) {
                g.setColor(Color.green);
                g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
                if (!isEmpty()) {
                        top().draw(g, x, y);
                }

        }
        public boolean canTake (Card aCard) {
                return false;
        }

}
