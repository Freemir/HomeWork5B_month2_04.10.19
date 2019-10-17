package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Начинается посадка на атобус а город Ош, просьба всех пассажиров купить билеты в кассах");
            Thread.sleep(2000);
            Semaphore semaphore = new Semaphore(4);
            CountDownLatch countDownLatch = new CountDownLatch(100);
            for (int i = 1; i <= 100; i++) {
                new PassengerThread(semaphore, countDownLatch, i).start();
            }

            countDownLatch.await();

            Thread.sleep(2000);
            System.out.println("Все пасажиры сели на автобуз, автобус отправляется");
        } catch (Exception e) {
        }
    }
}
