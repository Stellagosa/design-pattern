/**
 * 饿汉式单例
 * 类一旦加载就会创建一个单例，保证调用 getInstance() 方法之前单例就已经存在
 * 类创建的时候就创建了一个静态的对象供系统使用，以后都不在改变，所以是线程安全的，
 * 可以直接用于多线程中，不会出现问题
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
