package org.jdk.feature;

import java.util.concurrent.locks.StampedLock;

public class JDK8新增StampedLock {

    private double x, y;
    private final StampedLock sl = new StampedLock();
    void move(double deltaX, double deltaY) { // an exclusively locked method
        // 1、写入全局变量：获取到排他锁，将字段的值更新到全局变量

        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }
    //下面看看乐观读锁案例
    double distanceFromOrigin() { // A read-only method

        // 2、读取全局变量，本地变量可能不是最新。获取到乐观锁，首先将将字段读到本地局部变量。
        // 如果检测到，获取读锁失败（意味着其他线程获取到写锁，对数据可能做修改），此时获取悲观锁，读锁。获取到写锁线程更新后的值

        long stamp = sl.tryOptimisticRead(); //获得一个乐观读锁
        double currentX = x, currentY = y; //将两个字段读入本地局部变量
        if (!sl.validate(stamp)) { //检查发出乐观读锁后同时是否有其他写锁发生?
            stamp = sl.readLock(); //如果没有，我们再次获得一个读悲观锁
            try {
                currentX = x; // 将两个字段读入本地局部变量
                currentY = y; // 将两个字段读入本地局部变量
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
    //下面是悲观读锁案例
    void moveIfAtOrigin(double newX, double newY) { // upgrade
        // Could instead start with optimistic, not read mode
        // 3、写入全局变量，本地变量可能不是最新

        // 3.1、获取到悲观锁，写锁。写锁保证和写锁互斥，可能获取到修改后，最新的全局变量，更新到本地
        // 3.2、值对比，确保数据符合，没有别其他线程修改
        // 3.3、将新值更新到全局

        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) { //循环，检查当前状态是否符合
                long ws = sl.tryConvertToWriteLock(stamp); //将读锁转为写锁
                if (ws != 0L) { //这是确认转为写锁是否成功
                    stamp = ws; //如果成功 替换票据
                    x = newX; //进行状态改变
                    y = newY; //进行状态改变
                    break;
                }
                else { //如果不能成功转换为写锁
                    sl.unlockRead(stamp); //我们显式释放读锁
                    stamp = sl.writeLock(); //显式直接进行写锁 然后再通过循环再试
                }
            }
        } finally {
            sl.unlock(stamp); //释放读锁或写锁
        }
    }
}
