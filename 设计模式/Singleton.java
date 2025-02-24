package 设计模式;

/**
 * author peng
 * description
 * date 2025/2/22
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
