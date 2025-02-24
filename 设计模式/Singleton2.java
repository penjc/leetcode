package 设计模式;

/**
 * author peng
 * description
 * date 2025/2/22
 */
public class Singleton2 {
    private static volatile Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
