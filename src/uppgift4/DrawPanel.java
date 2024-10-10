package uppgift4;


/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawPanel extends JPanel {
        private Card selectedCard;
        private AbstractPile selectedAbstractPile;
        private Solitaire game;
        private JButton resetButton, secondChance;
        private JLabel labelKastHog, labelKortlek, labelParkering;
        public DrawPanel() {
                setBackground(Color.blue);
                game = new Solitaire();
                setupUI();


                addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                                handleMouseClick(e);
                                repaint();
                        }
                });
        }
        private void setupUI() {
                setLayout(null);
                resetButton = new JButton("Reset Game");
                resetButton.setBounds(35, 20, 125, 30);
                resetButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                game.resetGame();
                                repaint();
                        }
                });

                secondChance = new JButton("Second Chance");
                secondChance.setBounds(300, 150, 200, 50);
                secondChance.addActionListener(e -> {
                        if (!game.isSecondChanceUsed()) {
                                game.transferKasthög();
                                game.setSecondChanceUsed(true);
                                secondChance.setVisible(false);
                        }
                });

                add(resetButton);
                secondChance.setVisible(false);
                add(secondChance);

                labelKastHog = new JLabel("Kast Hög");
                labelKastHog.setForeground(Color.WHITE);
                labelKastHog.setBounds(589, 25, 100, 30);
                add(labelKastHog);

                labelKortlek = new JLabel("Kortlek");
                labelKortlek.setForeground(Color.WHITE);
                labelKortlek.setBounds(511, 25, 100, 30);
                add(labelKortlek);

                labelParkering = new JLabel("Parkering");
                labelParkering.setForeground(Color.WHITE);
                labelParkering.setBounds(507, 225, 100, 30);
                add(labelParkering);
        }

        private void deckStatus() {
                if (game.korthög.isEmpty() && !game.isSecondChanceUsed()) {
                        secondChance.setVisible(true);
                }
        }

        private void handleMouseClick(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                AbstractPile clickedAbstractPile = game.findPile(x, y);

                if (clickedAbstractPile != null) {
                        if (selectedAbstractPile != null && selectedCard != null && clickedAbstractPile != selectedAbstractPile) {
                                if (clickedAbstractPile.canTake(selectedCard)) {

                                        selectedAbstractPile.removeCard(selectedCard);
                                        clickedAbstractPile.addCard(selectedCard);
                                        selectedCard.setSelected(false);
                                        selectedCard = null;
                                        selectedAbstractPile = null;
                                } else {

                                        selectedCard.setSelected(false);
                                        selectedCard = null;
                                        selectedAbstractPile = null;
                                }
                        } else {

                                if (!clickedAbstractPile.isEmpty()) {
                                        Card topCard = clickedAbstractPile.top();
                                        if (topCard != null && topCard != selectedCard) {
                                                if (selectedCard != null) {
                                                        selectedCard.setSelected(false);
                                                }
                                                topCard.setSelected(true);
                                                selectedCard = topCard;
                                                selectedAbstractPile = clickedAbstractPile;
                                        }
                                }
                        }
                        repaint();
                }
                deckStatus();
        }




        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                game.draw(g);
                if (selectedCard != null) {
                        highligt(g, selectedCard);
                }
        }

        private void highligt(Graphics g, Card card) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.RED);
                g2.setStroke(new BasicStroke(3));
                g2.drawRect(selectedAbstractPile.getX(), selectedAbstractPile.getY(), Card.WIDTH, Card.HEIGHT);
        }


}



