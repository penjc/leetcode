package 设计模式.单例;

/**
 * author peng
 * description
 * date 2025/2/28
 */
public class Application {
    public static void main(String[] args) {
        // 饿汉式单例
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        hungrySingleton.doSomething();

        // 懒汉式单例
        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.doSomething();
    }
}
