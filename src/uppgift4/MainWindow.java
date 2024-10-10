package uppgift4;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

import javax.swing.*;


public class MainWindow extends JFrame{
        public MainWindow(){
                setTitle("Napoleon's Grav");
                setSize(850, 450);


                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                getContentPane().add(new DrawPanel());
                setVisible(true);

        }


}