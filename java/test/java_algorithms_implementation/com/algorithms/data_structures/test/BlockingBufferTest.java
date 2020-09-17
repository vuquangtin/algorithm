package com.algorithms.data_structures.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.algorithms.data_structures.CircularBuffer;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class BlockingBufferTest {
	@Test
	public final void write_1elemIn_Calculated() {
		final CircularBuffer buff = new CircularBuffer(3);
		buff.write("aaa");
		int expected = 0;
		int actual = buff.getFirst();
		assertEquals(expected, actual);
	}

	@Test
	public final void write_2elemIn_Calculated() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("aaa");
		buff.read();
		buff.write("aaa");
		int expected = 1;
		int actual = buff.getFirst();
		assertEquals(expected, actual);
	}

	@Test
	public final void write_2elemIn2Out_Calculated() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("aaa");
		buff.read();
		buff.write("aaa");
		buff.read();
		int expected = 2;
		int actual = buff.getFirst();
		assertEquals(expected, actual);
	}

	@Test
	public final void write_3elemIn2Out_Calculated() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("aaa");
		buff.read();
		buff.write("aaa");
		buff.read();
		buff.write("aaa");
		int expected = 0;
		int actual = buff.getNext();
		assertEquals(expected, actual);
	}

	@Test
	public final void write_1elemInn_Calculated() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("aaa");
		// buff.read();
		int expected = 1;
		int actual = buff.getNext();
		assertEquals(expected, actual);
	}

	@Test
	public final void write_2elemIn10utt_Calculated() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("aaa");
		buff.read();
		buff.write("aaa");
		int expected = 2;
		int actual = buff.getNext();
		assertEquals(expected, actual);
	}

	@Test
	public final void write_2elemOut_Calculated() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("aaa");
		buff.read();
		buff.write("aaa");
		buff.read();
		buff.write("aaa");
		int expected = 0;
		int actual = buff.getNext();
		assertEquals(expected, actual);
	}

	@Test
	public final void IsFull_full_true() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("aaa");
		buff.write("aaa");
		boolean expected = true;
		boolean actual = buff.isFull();
		assertEquals(expected, actual);

	}

	@Test
	public final void IsFull_full_false() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("aaa");
		boolean expected = false;
		boolean actual = buff.isFull();
		assertEquals(expected, actual);

	}

	@Test
	public final void IsEmpty_emptiness_true() {
		CircularBuffer buff = new CircularBuffer(3);
		boolean expected = true;
		boolean actual = buff.isEmpty();
		assertEquals(expected, actual);
	}

	@Test
	public final void IsEmpty_emptiness_false() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("dd");
		boolean expected = false;
		boolean actual = buff.isEmpty();
		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void write_full_Exception() {
		CircularBuffer buff = new CircularBuffer(3);
		buff.write("dd");
		buff.write("dd");
		buff.write("dd");
	}

}