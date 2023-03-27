package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Ponger extends Thread {

	private Semaphore mutexPing;
	private Semaphore mutexPong;


	public Ponger(Semaphore mutexPing, Semaphore mutexPong) {
		this.mutexPing = mutexPing;
		this.mutexPong = mutexPong;
	}	
	
	public void run() {
		while (true) {
			try {
				mutexPing.acquire();
				System.out.println("pong!");
				mutexPong.release();
			} catch (InterruptedException ex) {
				System.out.println("interrupted..");
			} finally {
				//mutexPing.release();
			}
		}
	}
}