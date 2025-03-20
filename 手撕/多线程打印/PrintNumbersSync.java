package 手撕.多线程打印;

/**
 * author peng
 * description
 * date 2025/3/20
 */
public class PrintNumbersSync {
    private int n;
    private int count = 0;
    private Object lock = new Object();

    public PrintNumbersSync(int n) {
        this.n = n;
    }

    public void print() {
        synchronized (lock) {
            while (count < n) {
                System.out.println(++count);
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintNumbersSync printNumbers = new PrintNumbersSync(100);
        new Thread(() -> {
            printNumbers.print();
        }).start();
        new Thread(() -> {
            printNumbers.print();
        }).start();
        new Thread(() -> {
            printNumbers.print();
        }).start();
    }
}
