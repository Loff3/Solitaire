package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */



class KastHög extends AbstractPile {
        KastHög(int x, int y) {
                super(x, y);
        }

        @Override
        public boolean canTake(Card aCard) {
                return aCard.getRank() != 6;
        }

        @Override
        public void addCard(Card card) {
                if (canTake(card)) {
                        stack.push(card);
                }
        }
}
