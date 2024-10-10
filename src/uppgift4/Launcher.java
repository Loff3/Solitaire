package uppgift4;
import javax.swing.SwingUtilities;

/**
 * @author Olof Zetterstrand olof.z1337@gmail.com
 */

public class Launcher {
        public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> new MainWindow());
        }
}

