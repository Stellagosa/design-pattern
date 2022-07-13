import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PrototypeWuKong {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("孙悟空拔猴毛");
        Container contentPane = jFrame.getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));

        Wukong w1 = new Wukong();
        jFrame.add(w1);
        Wukong w2 = (Wukong) w1.clone();
        jFrame.add(w2);

        System.out.println("w1 == w2???：" + (w1 == w2));

        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Wukong extends Panel implements Cloneable {

    public Wukong() {
        System.out.println("孙悟空创建成功");
        String url = Objects.requireNonNull(Wukong.class.getClassLoader().getResource("Wukong.jpg")).getPath();
        JLabel jLabel = new JLabel(new ImageIcon(url));
        this.add(jLabel);
    }

    public Object clone() {
        Wukong w = null;
        try {
            System.out.println("孙悟空拔猴毛了");
            w = ((Wukong) super.clone());
        }catch (CloneNotSupportedException e) {
            System.out.println("猴毛没拔下来");
        }
        return w;
    }
}

