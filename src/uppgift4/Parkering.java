package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

class Parkering extends AbstractPile {

        Parkering(int x, int y) {
                super(x, y);
        }
        @Override
        public void addCard(Card aCard) {
                if (canTake(aCard)) {
                        stack.push(aCard);
                }
        }

        @Override
        public boolean canTake(Card aCard) {
                return aCard.getRank() == 6;

        }




}
