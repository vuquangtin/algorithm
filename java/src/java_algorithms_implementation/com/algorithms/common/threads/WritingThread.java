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
public class WritingThread implements Runnable {

	private BlockingBuffer buffer;
	private String message;

	public WritingThread(final BlockingBuffer buffer, final String message) {
		super();
		this.buffer = buffer;
		this.message = message;
	}

	public BlockingBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(final BlockingBuffer buffer) {
		this.buffer = buffer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void run() {

		for (;;) {
			buffer.write(message);
		}

	}

}