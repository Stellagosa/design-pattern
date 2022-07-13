package abstractFactory;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FarmTest {
    public static void main(String[] args) {
        Farm farm = (Farm) ReadXML.getObject();
        assert farm != null;
        Animal animal = farm.newAnimal();
        Plant plant = farm.newPlant();
        animal.show();
        plant.show();
    }
}

interface Animal {
    void show();
}

interface Plant {
    void show();
}

class A_Horse implements Animal {

    private JFrame jFrame;

    public A_Horse() {
        jFrame = new JFrame("抽象工厂模拟测试");
        Container contentPane = jFrame.getContentPane();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createTitledBorder("动物：马"));
        JScrollPane scrollPane = new JScrollPane(jPanel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        String url = Objects.requireNonNull(A_Horse.class.getClassLoader().getResource("A_Horse.jpg")).getPath();
        JLabel jLabel = new JLabel(new ImageIcon(url));
        jPanel.add(jLabel);

        jFrame.pack();
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void show() {
        jFrame.setVisible(true);
    }
}

class A_Cattle implements Animal {

    private JFrame jFrame;

    public A_Cattle() {
        jFrame = new JFrame("抽象工厂模拟测试");
        Container contentPane = jFrame.getContentPane();

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createTitledBorder("动物：牛"));

        JScrollPane scrollPane = new JScrollPane(jPanel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        String url = Objects.requireNonNull(A_Cattle.class.getClassLoader().getResource("A_Cattle.jpg")).getPath();
        JLabel label = new JLabel(new ImageIcon(url));
        jPanel.add(label);

        jFrame.pack();
        ;
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void show() {
        jFrame.setVisible(true);
    }
}

class P_Fruitage implements Plant {

    private JFrame jFrame;

    public P_Fruitage() {
        jFrame = new JFrame("抽象工厂模拟测试");
        Container contentPane = jFrame.getContentPane();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(BorderFactory.createTitledBorder("植物：水果"));
        JScrollPane scrollPane = new JScrollPane(panel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        String url = P_Fruitage.class.getClassLoader().getResource("P_Vegetables.jpg").getPath();
        JLabel label = new JLabel(new ImageIcon(url));
        panel.add(label);

        jFrame.pack();
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void show() {
        jFrame.setVisible(true);
    }
}

class P_Vegetables implements Plant {

    private JFrame jFrame;

    public P_Vegetables() {
        jFrame = new JFrame("抽象工厂模拟测试");
        Container contentPane = jFrame.getContentPane();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(BorderFactory.createTitledBorder("植物：蔬菜"));
        JScrollPane scrollPane = new JScrollPane(panel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        String url = P_Fruitage.class.getClassLoader().getResource("P_Vegetables.jpg").getPath();
        JLabel label = new JLabel(new ImageIcon(url));
        panel.add(label);

        jFrame.pack();
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void show() {
        jFrame.setVisible(true);
    }
}

interface Farm {
    Animal newAnimal();

    Plant newPlant();
}

class SRFarm implements Farm {

    @Override
    public Animal newAnimal() {
        return new A_Horse();
    }

    @Override
    public Plant newPlant() {
        return new P_Fruitage();
    }
}

class SGFarm implements Farm {

    @Override
    public Animal newAnimal() {
        return new A_Cattle();
    }

    @Override
    public Plant newPlant() {
        return new P_Vegetables();
    }
}














