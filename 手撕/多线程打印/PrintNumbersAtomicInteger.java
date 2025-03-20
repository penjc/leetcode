package 手撕.多线程打印;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author peng
 * description
 * date 2025/3/20
 */
public class PrintNumbersAtomicInteger {
    private static final AtomicInteger number = new AtomicInteger(1);
    private static final int MAX = 100;

    public static void main(String[] args) {
        Runnable printTask = () -> {
            while (true) {
                int current = number.getAndIncrement();
                if (current > MAX) break;
                System.out.println(Thread.currentThread().getName() + ": " + current);
            }
        };

        Thread t1 = new Thread(printTask, "线程1");
        Thread t2 = new Thread(printTask, "线程2");

        t1.start();
        t2.start();
    }
}
