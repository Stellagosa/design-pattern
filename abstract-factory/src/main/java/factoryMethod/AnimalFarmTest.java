package factoryMethod;

import javax.swing.*;
import java.awt.*;

public class AnimalFarmTest {
    public static void main(String[] args) {
        AnimalFarm animalFactory = (AnimalFarm) ReadXML2.getObject();
        assert animalFactory != null;
        Animal animal = animalFactory.newAnimal();
        animal.show();
    }
}

interface Animal {
    void show();
}

class Horse implements Animal {

    private JFrame jFrame;

    public Horse() {
        jFrame = new JFrame("动物养殖场");
        Container contentPane = jFrame.getContentPane();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createTitledBorder("动物：马"));
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        contentPane.add(jScrollPane, BorderLayout.CENTER);
        String url = Horse.class.getClassLoader().getResource("A_Horse.jpg").getPath();
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

class Cattle implements Animal {

    private JFrame jFrame;

    public Cattle() {
        jFrame = new JFrame("动物养殖场");
        Container contentPane = jFrame.getContentPane();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createTitledBorder("动物：牛"));
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        contentPane.add(jScrollPane, BorderLayout.CENTER);
        String url = Horse.class.getClassLoader().getResource("A_Cattle.jpg").getPath();
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

//抽象工厂：畜牧场
interface AnimalFarm {
    Animal newAnimal();
}

//具体工厂：养马场
class HorseFarm implements AnimalFarm {
    @Override
    public Animal newAnimal() {
        return new Horse();
    }
}

//具体工厂：养牛场
class CattleFarm implements AnimalFarm {
    @Override
    public Animal newAnimal() {
        return new Cattle();
    }
}










