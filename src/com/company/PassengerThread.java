package com.company;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private int passengerNumber;

    public PassengerThread(Semaphore semaphore, CountDownLatch countDownLatch, int passengerNumber) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.passengerNumber = passengerNumber;
    }

    public synchronized void run() {
        try {
            int cashier = new Random().nextInt(4) + 1;

            semaphore.acquire();

            System.out.println("Пассажир " + passengerNumber + " купил билет в кассе №" + cashier);
            sleep(500);

            semaphore.release();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
        }
    }
}



