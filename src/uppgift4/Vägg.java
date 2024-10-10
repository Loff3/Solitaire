package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

class Vägg extends AbstractPile {
        protected boolean isSelected;
        Vägg(int x, int y) {
                super(x, y);
                isSelected = false;
        }

        @Override
        public void addCard(Card card) {
                if (isEmpty()) {
                        if (!card.getFace()) {
                                card.flip();
                        }
                        super.stack.push(card);
                }
        }

        @Override
        public boolean canTake(Card aCard) {
                //Villkor för att kunna ta ett kort
                return isEmpty();
        }





}
