package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

class MittenGrundhög extends AbstractPile {

        MittenGrundhög(int x, int y) {
                super(x, y);

        }

        @Override
        public boolean canTake(Card aCard) {
                if (isEmpty()) {

                        return aCard.getRank() == 6;
                } else {
                        Card topCard = top();

                        if (topCard.getRank() > 1) {
                                return aCard.getRank() == topCard.getRank() - 1;
                        } else {

                                return aCard.getRank() == 6;
                        }
                }
        }
        @Override
        public void addCard(Card aCard){
                if (canTake(aCard)){
                        stack.push(aCard);
                }
        }

}
