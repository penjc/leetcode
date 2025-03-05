package 设计模式.工厂.简单工厂;

public class ConcreteProductA implements Product {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProductA is doing something!");
    }
}
