import java.util.ArrayList;
import java.util.List;

public class ShopingTest {
    public static void main(String[] args) {
        Bags smallRedBag = new Bags("红色小袋子");
        Goods goods = new Goods("婺源特产",2,7.9f);
        smallRedBag.add(goods);
        goods = new Goods("婺源地图", 1, 9.9f);
        smallRedBag.add(goods);

        Bags smallWhiteBag = new Bags("白色小袋子");
        goods = new Goods("韶关香鸡", 2, 68f);
        smallWhiteBag.add(goods);
        goods = new Goods("韶关红茶", 3, 180f);
        smallWhiteBag.add(goods);

        Bags mediumBag = new Bags("中袋子");
        mediumBag.add(smallRedBag);
        goods = new Goods("景德镇瓷器",1, 380);
        mediumBag.add(goods);

        Bags bigBag = new Bags("大袋子");
        bigBag.add(mediumBag);
        bigBag.add(smallWhiteBag);
        goods = new Goods("李宁牌运动鞋", 1, 198);
        bigBag.add(goods);

        System.out.println("大袋子中的商品包括：");
        bigBag.show();
        System.out.println("支付总价为：" + bigBag.calculation());

    }
}
interface Articles {
    float calculation();
    void show();
}

class Goods implements Articles {

    private String name;
    private int count;
    private float unitPrice;

    public Goods(String name, int count, float unitPrice) {
        this.name = name;
        this.count = count;
        this.unitPrice = unitPrice;
    }

    @Override
    public float calculation() {
        return count * unitPrice;
    }

    @Override
    public void show() {
        System.out.println(name + "(数量：" + count + ", 单价：" + unitPrice + "元)");
    }
}

class Bags implements Articles {

    private String name;
    private List<Articles> bags = new ArrayList<>();

    public Bags(String name) {
        this.name = name;
    }

    public void add(Articles item) {
        bags.add(item);
    }

    public void remove(Articles item) {
        bags.remove(item);
    }

    public Articles getChild(int i) {
        return bags.get(i);
    }

    @Override
    public float calculation() {
        float c = 0f;
        for (Articles bag : bags) {
            c += bag.calculation();
        }
        return c;
    }

    @Override
    public void show() {
        for (Articles bag : bags) {
            bag.show();
        }
    }
}















