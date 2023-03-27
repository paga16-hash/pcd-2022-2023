package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {
		Semaphore mutexPing = new Semaphore(0);
		Semaphore mutexPong = new Semaphore(0);

		new Pinger(mutexPing, mutexPong).start();
		new Ponger(mutexPing, mutexPong).start();
		mutexPong.release();
	}

}
