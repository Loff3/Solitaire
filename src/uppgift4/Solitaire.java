package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Solitaire {

        static public KastHög kastHög;
        static public KastHög discardPile;
        static public MittenGrundhög mitten;
        static public Vägg[] vägg = new Vägg[4];
        static public Kortlek korthög;
        static public StrålarGrundhög[] strålar = new StrålarGrundhög[4];
        static public Parkering parkering;
        static public AbstractPile[] allAbstractPiles;
        private boolean secondChanceUsed = false;


        private List<Card> deck;

        public Solitaire() {
                start();
                loadKorthög();
                korthög.shuffle();
                fillVägg();

        }

        private void start() {
                //skapa kortlek
                skapaKortlek();
                //mitten
                mitten = new MittenGrundhög(300, 150);
                // Strålar
                strålar[0] = new StrålarGrundhög(200, 50);
                strålar[1] = new StrålarGrundhög(400, 50);
                strålar[2] = new StrålarGrundhög(200, 250);
                strålar[3] = new StrålarGrundhög(400, 250);
                // väggar
                vägg[0] = new Vägg(300, 250);
                vägg[1] = new Vägg(300, 50);
                vägg[2] = new Vägg(380, 150);
                vägg[3] = new Vägg(220, 150);
                // Korthög
                korthög = new Kortlek(500, 50);
                //kasthög
                kastHög = new KastHög(580, 50);
                //parkering
                parkering = new Parkering(500, 250);
                //array med alla högar
                allAbstractPiles = new AbstractPile[]{
                        parkering, mitten,
                        vägg[0], vägg[1], vägg[2], vägg[3],
                        korthög,
                        kastHög,
                        strålar[0], strålar[1], strålar[2], strålar[3]
                };
        }
        public boolean isSecondChanceUsed() {
                return secondChanceUsed;
        }

        public void setSecondChanceUsed(boolean used) {
                secondChanceUsed = used;
        }

        public void fillVägg() {
                for (Vägg v : vägg) {
                        Card card = korthög.dealCard();
                        v.addCard(card);
                }
        }
        public void resetGame(){
                for (AbstractPile abstractPile : allAbstractPiles) {
                        abstractPile.stack.clear();
                }
                skapaKortlek();
                loadKorthög();
                korthög.shuffle();
                fillVägg();
        }
        public void transferKasthög() {
                while (!kastHög.isEmpty()) {
                        Card card = kastHög.pop();
                        korthög.addCard(card);
                }
                korthög.shuffle();
        }
        public void skapaKortlek(){
                deck = new ArrayList<Card>();
                String[] suits = {"c", "d", "h", "s"}; // c = Klöver (Clubs), d = Ruter (Diamonds), h = Hjärter (Hearts), s = Spader (Spades)
                String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};

                for (String suit : suits) {
                        for (String rank : ranks) {
                                int rankInt;
                                if (rank.matches("\\d+")) {
                                        rankInt = Integer.parseInt(rank);
                                } else {
                                        rankInt = switch (rank) {
                                                case "j" -> 11;
                                                case "q" -> 12;
                                                case "k" -> 13;
                                                default -> throw new IllegalArgumentException("Invalid card rank: " + rank);
                                        };
                                }
                                String cardName = suit + rank;
                                deck.add(new Card(rankInt, cardName));
                        }
                }
        }
        private void loadKorthög() {
                for(Card c : deck) {
                        korthög.addCard(c);
                }
        }

        public AbstractPile findPile(int x, int y) {
                for (AbstractPile abstractPile : allAbstractPiles) {
                        if (abstractPile.includes(x, y)) {
                                return abstractPile; //om en hög hittas på koordinaterna
                        }
                }
                return null; //ingen hög där man klickar
        }

        public void draw(Graphics g) {
                for (AbstractPile abstractPile : allAbstractPiles) {
                        abstractPile.draw(g);
                }

        }
}

