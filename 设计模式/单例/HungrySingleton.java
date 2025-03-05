package 设计模式.单例;

public class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    public void doSomething() {
        System.out.println("Hungry Singleton doing something!");
    }
}
