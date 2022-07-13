import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MediatorPatternDemo {
    public static void main(String[] args) {
        Medium medium = new EstateMedium();
        Customer buyer = new Buyer(medium);
        Customer seller = new Seller(medium);

        medium.register("buyer", buyer);
        medium.register("seller", seller);

        medium.run();
    }
}

interface Medium {
    void register(String key, Customer customer);
    void relay(String from, String to, String message);

    void run();
}

abstract class Customer {
    protected Medium medium;

    public abstract void send(String ad);
    public abstract void receive(String from, String message);

    public abstract void listener();
}

class EstateMedium implements Medium {

    private Map<String, Customer> customers = new HashMap<>();

    @Override
    public void register(String key, Customer customer) {
        customers.put(key, customer);
    }

    @Override
    public void relay(String from, String to, String message) {
        Customer customer = customers.get(to);
        if (customer != null) {
            customer.receive(from, message);
            customer.listener();
        } else {
            System.out.println("该用户不存在");
        }
    }

    @Override
    public void run() {
        Customer buyer = customers.get("buyer");
        System.out.println("系统已通知买方可以发送信息了：");
        buyer.listener();
    }
}

class Buyer extends Customer {

    public Buyer(Medium m) {
        medium = m;
    }

    @Override
    public void send(String msg) {
        System.out.println("买方：");
        System.out.println("我：" + msg);
        medium.relay("buyer", "seller", msg);
    }

    @Override
    public void receive(String from, String msg) {
        System.out.println("买方：");
        from = from.equals("buyer") ? "买方" : "卖方";
        System.out.println("接收到来自" + from + "的信息：" + msg);
    }

    @Override
    public void listener() {
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.next();
        this.send(msg);
    }
}

class Seller extends Customer {
    public Seller(Medium m) {
        medium = m;
    }
    @Override
    public void send(String msg) {
        System.out.println("卖方：");
        System.out.println("我：" + msg);
        medium.relay("seller", "buyer", msg);
    }

    @Override
    public void receive(String from, String msg) {
        System.out.println("卖方：");
        from = from.equals("buyer") ? "买方" : "卖方";
        System.out.println("接收到来自" + from + "的信息：" + msg);
    }

    @Override
    public void listener() {
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.next();
        this.send(msg);
    }
}






