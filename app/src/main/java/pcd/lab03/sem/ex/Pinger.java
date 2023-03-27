package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Pinger extends Thread {

	private Semaphore mutexPing;
	private Semaphore mutexPong;


	public Pinger(Semaphore mutexPing, Semaphore mutexPong) {
		this.mutexPing = mutexPing;
		this.mutexPong = mutexPong;
	}

	public void run() {
		while (true) {
			try {
				mutexPong.acquire();
				System.out.println("ping!");
				mutexPing.release();
			} catch (InterruptedException ex) {
				System.out.println("interrupted..");
			} finally {
				//mutexPong.release();
			}
		}
	}
}