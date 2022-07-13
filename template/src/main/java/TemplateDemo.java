public class TemplateDemo {

    public static void main(String[] args) {
        Game game = new Football();
        game.template();
    }
}

abstract class Game {
    final void template() {
        initialize();
        start();
        end();
    }

    abstract void initialize();
    abstract void start();
    abstract void end();
}

class Football extends Game {

    @Override
    void initialize() {
        System.out.println("Football 初始化");
    }

    @Override
    void start() {
        System.out.println("开始踢足球");
    }

    @Override
    void end() {
        System.out.println("时间到，游戏结束");
    }
}
