package 设计模式.工厂.简单工厂;

// 工厂类
public class SimpleFactory {
    public static Product createProduct(String type) {
        if ("A".equalsIgnoreCase(type)) {
            return new ConcreteProductA();
        } else if ("B".equalsIgnoreCase(type)) {
            return new ConcreteProductB();
        } else {
            throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}
