package com.algorithms.common.threads;

import com.algorithms.data_structures.BlockingBuffer;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class ReadingThread implements Runnable {
	private BlockingBuffer buffer;
	private BlockingBuffer second;
	private String message;

	public ReadingThread(BlockingBuffer buffer, BlockingBuffer second,
			String message) {
		super();
		this.buffer = buffer;
		this.message = message;
		this.second = second;
	}

	@Override
	public void run() {
		String readed = null;
		for (;;) {
			readed = buffer.read();
			second.write(message + readed);
		}

	}

	public BlockingBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(BlockingBuffer buffer) {
		this.buffer = buffer;
	}

	public BlockingBuffer getSecond() {
		return second;
	}

	public void setSecond(BlockingBuffer second) {
		this.second = second;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}