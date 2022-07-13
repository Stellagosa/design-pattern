public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategy = new ConcreteStrategyA();
        context.setStrategy(strategy);
        context.strategyMethod();
        System.out.println("-------------------------");
        strategy = new ConcreteStrategyB();
        context.setStrategy(strategy);
        context.strategyMethod();
    }
}

interface Strategy {
    void strategyMethod();
}

class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问");
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问");
    }
}

class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }

}


