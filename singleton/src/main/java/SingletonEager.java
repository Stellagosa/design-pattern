import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SingletonEager {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("饿汉单例模式");
        jFrame.setLayout(new GridLayout(1, 2));
        Container pane = jFrame.getContentPane();
        Bajie bajie1 = Bajie.getInstance();
        pane.add(bajie1);
        Bajie bajie2 = Bajie.getInstance();
        pane.add(bajie2);
        if (bajie1 == bajie2) {
            System.out.println("是同一只八戒");
        } else {
            System.out.println("他们不相同");
        }

        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class Bajie extends JPanel {
    private static Bajie instance = new Bajie();

    private Bajie() {
        String url = Objects.requireNonNull(Bajie.class.getClassLoader().getResource("Bajie.jpg")).getPath();
        JLabel jLabel = new JLabel(new ImageIcon(url));
        this.add(jLabel);
    }

    public static Bajie getInstance() {
        return instance;
    }
}
