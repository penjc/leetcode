package 手撕.多线程打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumbersLock {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int number = 1;
    private static final int MAX = 100;

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Thread thread1 = new Thread(() -> {
                try {
                    lock.lock();
                    while (number <= MAX) {
                        System.out.println(number++);
                        condition.signalAll();
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } finally {
                    condition.signalAll();
                    lock.unlock();
                }
            });
            thread1.start();
        }

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (number > MAX) {
                        condition.signalAll(); // 确保所有等待的线程都能退出
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + number++);
                    condition.signalAll(); // 唤醒所有等待的线程
                    condition.await(); // 当前线程进入等待状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
    }


}
