package com.algorithms.data_structures;

/**
 * In computer science, a circular buffer, circular queue, cyclic buffer or ring
 * buffer is a data structure that uses a single, fixed-size buffer as if it
 * were connected end-to-end. This structure lends itself easily to buffering
 * data streams.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 * @see <a
 *      href="https://en.wikipedia.org/wiki/Circular_buffer">https://en.wikipedia.org/wiki/Circular_buffer</a>
 *
 */
public class CircularBuffer {

	protected int first;// the latest inserted String
	protected int next;// next cell to insert into
	protected String nodes[];// container for elements
	protected int size; // size of circular buffer
	protected int capacity; // current capacity of buffer

	public CircularBuffer(int size) {
		super();
		this.size = size;
		nodes = new String[size];
	}

	public static void main(String[] args) {
		CircularBuffer buffer = new CircularBuffer(3);
		buffer.write("ff");
		System.out.println(buffer.capacity);
	}

	public void write(String item) {

		if (!isFull()) {
			nodes[next] = item;
			next = (next + 1) % size;
			++capacity;
		} else {
			throw new IllegalArgumentException("The buffer is full");
		}
	}

	public String read() {
		String item = null;
		if (!isEmpty()) {
			item = nodes[first];
			nodes[first] = null;
			first = (first + 1) % size;
			--capacity;
		} else {
			throw new IllegalArgumentException("The buffer is empty");
		}
		return item;

	}

	public boolean isFull() {
		return (size - 1) == capacity;
	}

	public boolean isEmpty() {
		return first == next;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(final int first) {
		this.first = first;
	}

	public int getNext() {
		return next;
	}

	public void setNext(final int next) {
		this.next = next;
	}

	public String[] getNodes() {
		return nodes;
	}

	public void setNodes(String[] nodes) {
		this.nodes = nodes;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}