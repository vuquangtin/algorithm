package com.algorithms.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.algorithms.common.threads.ReadingThread;
import com.algorithms.common.threads.WritingThread;


/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class BlockingBuffer extends CircularBuffer {

	private final Lock bufferLock = new ReentrantLock();;

	// private int first;// the latest inserted String
	// private int next;// next cell to insert into
	// private String nodes[];// container for elements
	// private int size; // size of circular buffer
	// private int capacity; // current capacity of buffer
	private final Condition writeNow = bufferLock.newCondition();
	private final Condition readNow = bufferLock.newCondition();

	public BlockingBuffer(int size) {
		super(size);
	}

	public static void main(String[] args) {
		print100Messages();
	}

	public static void print100Messages() {
		final BlockingBuffer firstBuff = new BlockingBuffer(15);
		final BlockingBuffer secondBuff = new BlockingBuffer(10);
		List<Thread> writing = BlockingBuffer
				.createWritingThreads(5, firstBuff);
		List<Thread> reading = BlockingBuffer.createReadingThreads(2,
				firstBuff, secondBuff);
		BlockingBuffer.setDaemons(reading);
		BlockingBuffer.setDaemons(writing);
		BlockingBuffer.startThreads(writing);
		BlockingBuffer.startThreads(reading);
		int i = 0;
		while (i < 100) {
			System.out.println(secondBuff.read());
			++i;
		}
	}

	private static List<Thread> createWritingThreads(int amount,
			BlockingBuffer buff) {
		List<Thread> writingOnes = new ArrayList<Thread>();
		for (int i = 0; i < amount; i++) {
			writingOnes.add(new Thread(new WritingThread(buff, " Thread № " + i
					+ " generated this message ")));
		}
		return writingOnes;
	}

	private static List<Thread> createReadingThreads(int amount,
			BlockingBuffer buff1, BlockingBuffer buff2) {
		List<Thread> writingOnes = new ArrayList<Thread>();
		for (int i = 0; i < amount; i++) {
			writingOnes.add(new Thread(new ReadingThread(buff1, buff2,
					" Thread № " + i + " shifted message ")));
		}
		return writingOnes;
	}

	private static void setDaemons(List<Thread> threads) {
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).setDaemon(true);
		}
	}

	private static void startThreads(List<Thread> threads) {
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
		}
	}

	public void write(String item) {
		bufferLock.lock();
		try {
			while (isFull()) {
				writeNow.await();
			}
			nodes[next] = item;
			next = (next + 1) % size;
			++capacity;
			readNow.signalAll();
		} catch (InterruptedException ex) {
		} finally {
			bufferLock.unlock();
		}
	}

	public String read() {
		bufferLock.lock();
		String item = null;
		try {
			while (isEmpty()) {
				readNow.await();
			}
			item = nodes[first];
			nodes[first] = null;
			first = (first + 1) % size;
			--capacity;
			writeNow.signalAll();
		} catch (InterruptedException ex) {

		}

		finally {
			bufferLock.unlock();
		}
		return item;
	}

}