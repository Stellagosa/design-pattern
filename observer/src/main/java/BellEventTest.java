import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

public class BellEventTest {
    public static void main(String[] args) {
        BellEventSource source = new BellEventSource();
        source.addListener(new TeacherListener());
        source.addListener(new StudentListener());
        source.ring("上课");
        source.ring("下课");
    }
}

class RingEvent extends EventObject {
    private String sound;

    public RingEvent(Object source, String sound) {
        super(source);
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}

class BellEventSource {
    private final List<BellEventListener> listeners = new ArrayList<>();

    public void addListener(BellEventListener listener) {
        listeners.add(listener);
    }
    public void removeListener(BellEventListener listener) {
        listeners.remove(listener);
    }

    public void ring(String ring) {
        RingEvent event = new RingEvent(this, ring);
        notifies(event);
    }

    private void notifies(RingEvent ringEvent) {
        for (BellEventListener listener : listeners) {
            listener.headBell(ringEvent);
        }
    }
}

interface BellEventListener extends EventListener {
    void headBell(RingEvent ringEvent);
}

class TeacherListener implements BellEventListener {
    @Override
    public void headBell(RingEvent ringEvent) {
        if (ringEvent.getSound().equals("上课")) {
            System.out.println("老师开始上课了");
        } else {
            System.out.println("老师下课了");
        }
    }
}

class StudentListener implements BellEventListener {
    @Override
    public void headBell(RingEvent ringEvent) {
        if (ringEvent.getSound().equals("上课")) {
            System.out.println("学生开始上课了");
        } else {
            System.out.println("学生下课了");
        }
    }
}










