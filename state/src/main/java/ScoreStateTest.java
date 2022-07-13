public class ScoreStateTest {
    public static void main(String[] args) {
        ScoreContext context = new ScoreContext();
        context.add(60);
        context.add(10);
        context.add(20);
        context.add(-50);
    }
}

abstract class AbstractState {
    protected int score;
    protected String stateName;
    protected ScoreContext context;
    abstract void checkState();

    public void addScore(int x) {
        score += x;
        System.out.print("加上" + x + "分，当前分数：" + score);
        checkState();
        System.out.println("分，当前状态：" + this.context.getState().stateName);
    }

}

class ScoreContext {
    private AbstractState state;

    public ScoreContext() {
        state = new LowState(this);
    }

    public void setState(AbstractState state) {
        this.state = state;
    }

    public AbstractState getState() {
        return state;
    }

    public void add(int score) {
        this.state.addScore(score);
    }

}

class LowState extends AbstractState {

    public LowState(ScoreContext scoreContext) {
        context = scoreContext;
        stateName = "不及格";
        score = 0;
    }

    public LowState(AbstractState state) {
        context = state.context;
        stateName = "不及格";
        score = state.score;
    }

    @Override
    void checkState() {
        if (score >= 90) {
            context.setState(new HighState(this));
        } else if (score >= 60) {
            context.setState(new MiddleState(this));
        }
    }
}

class MiddleState extends AbstractState {

    public MiddleState(AbstractState state) {
        context = state.context;
        stateName = "中等";
        score = state.score;
    }

    @Override
    void checkState() {
        if (score < 60) {
            context.setState(new LowState(this));
        } else if (score >= 90) {
            context.setState(new HighState(this));
        }
    }
}

class HighState extends AbstractState {

    public HighState(AbstractState state) {
        context = state.context;
        stateName = "优秀";
        score = state.score;
    }

    @Override
    void checkState() {
        if (score < 60) {
            context.setState(new LowState(this));
        } else if (score < 90) {
            context.setState(new MiddleState(this));
        }
    }
}











