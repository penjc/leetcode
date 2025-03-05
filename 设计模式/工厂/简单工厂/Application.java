package 设计模式.工厂.简单工厂;

public class Application {
    public static void main(String[] args) {
        // 使用工厂创建产品A
        Product productA = SimpleFactory.createProduct("A");
        productA.doSomething();

        // 使用工厂创建产品B
        Product productB = SimpleFactory.createProduct("B");
        productB.doSomething();
    }
}
