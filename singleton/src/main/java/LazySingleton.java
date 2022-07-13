/**
 * 懒汉式单例
 * 类加载时没有生成单例，只有第一次调用 getInstance() 方法时才会创建这个单例
 * 如果是多线程程序，注意 volatile 和 synchronized 两个关键字，可以保证线程安全，
 * 但是访问时需要同步，影响性能，消耗更多资源
 */
public class LazySingleton {
    private static volatile LazySingleton instance = null;

    //避免外部实例化
    private LazySingleton() {}

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
                instance = new LazySingleton();
        }
        return instance;
    }
}
