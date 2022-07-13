package flyweight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class WuZiQIGame {
    public static void main(String[] args) {
        new Chessboard();
    }
}

class Chessboard extends MouseAdapter {

    WZQFactory factory;
    JFrame jFrame;
    Graphics g;
    JRadioButton bz;
    JRadioButton hz;

    private final int x = 50;
    private final int y = 50;
    private final int w = 40;
    private final int rw = 400;

    public Chessboard() {
        factory = new WZQFactory();
        jFrame = new JFrame("享元模式在五子棋中的应用");
        jFrame.setBounds(100, 100, 520, 540);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel southPanel = new JPanel();
        jFrame.add("South", southPanel);

        bz = new JRadioButton("白子");
        hz = new JRadioButton("黑子", true);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(bz);
        buttonGroup.add(hz);
        southPanel.add(bz);
        southPanel.add(hz);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setSize(500, 500);
        centerPanel.addMouseListener(this);
        jFrame.add("Center", centerPanel);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        g = centerPanel.getGraphics();
        g.setColor(Color.BLUE);
        g.drawRect(x, y, rw, rw);
        for (int i = 1; i < 10; i++) {
            g.drawLine(x + (i * w), y, x + (i * w), y + rw);
            g.drawLine(x, y + (i * w), x + rw, y + (i * w));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = new Point(e.getX() - 15, e.getY() - 15);
        if (bz.isSelected()) {
            ChessPieces w = factory.getChessPieces("w");
            w.downPieces(g, point);
        } else if (hz.isSelected()) {
            ChessPieces b = factory.getChessPieces("b");
            b.downPieces(g, point);

        }
    }
}

interface ChessPieces {
    public void downPieces(Graphics g, Point point);
}

class WhitePieces implements ChessPieces {
    @Override
    public void downPieces(Graphics g, Point point) {
        g.setColor(Color.WHITE);
        g.fillOval(point.x, point.y, 30, 30);
    }
}

class BlackPieces implements ChessPieces {
    @Override
    public void downPieces(Graphics g, Point point) {
        g.setColor(Color.BLACK);
        g.fillOval(point.x, point.y, 30, 30);
    }
}

class WZQFactory {
    private List<ChessPieces> qz;

    public WZQFactory() {
        qz = new ArrayList<>();
        ChessPieces w = new WhitePieces();
        qz.add(w);
        ChessPieces b = new BlackPieces();
        qz.add(b);
    }

    public ChessPieces getChessPieces(String key) {
        if (key.equalsIgnoreCase("w")) {
            return qz.get(0);
        } else if (key.equalsIgnoreCase("b")) {
            return qz.get(1);
        } else {
            return null;
        }
    }
}







