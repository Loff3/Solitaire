package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

public class StrålarGrundhög extends AbstractPile {


        public StrålarGrundhög(int x, int y) {
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
                if (isEmpty()) {

                        return aCard.getRank() == 7;
                } else {
                        Card topCard = top();
                        if (topCard.getRank() < 13) {
                                return aCard.getRank() == topCard.getRank() + 1;
                        }
                }
                return false;
        }



}
