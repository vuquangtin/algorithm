package com.algorithms.scheduling.page;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * scheduling
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class SJFPreemptive implements Scheduling {
	private PriorityQueue<Process> sortArrival;
	private PriorityQueue<Process> sortBurst;
	private double[] waitTime;
	private List<Process> res;

	public SJFPreemptive(double[] arrivalTime, double[] burstTime) {
		sortBurst = new PriorityQueue<Process>(new ComparatorBurstTime());
		sortArrival = new PriorityQueue<Process>(new ProcessComparator());
		res = new ArrayList<>();
		waitTime = new double[arrivalTime.length + 1];

		for (int i = 0; i < arrivalTime.length; i++) {
			sortArrival.add(new Process(arrivalTime[i], burstTime[i], i + 1));
			sortBurst.add(new Process(arrivalTime[i], burstTime[i], i + 1));
		}

		double time = 0;
		double tiny = 1;

		for (Process i : sortArrival) {
			tiny = gcd(tiny, i.getArrivalTime());
		}

		Process odd = new Process(-1, -1, -1);
		while (sortBurst.size() > 0) {
			for (Process i : sortBurst) {
				if (i.getBurstTime() == 0) {
					sortBurst.remove(i);
				}

				if (i.getArrivalTime() <= time) {

					time += tiny;
					Process curr = new Process(i);
					i.setBurstTime(i.getBurstTime() - tiny);
					curr.setAroundTime(time);

					if (i.getBurstTime() == 0) {
						sortBurst.remove(i);
					}

					// Merge
					if (odd.getProcess() == curr.getProcess()) {
						res.remove(odd);
					}

					res.add(curr);
					odd = curr;
					break;
				}
			}
		}

	}

	private double gcd(double a, double b) {
		if (a < b) {
			return gcd(b, a);
		}

		if (Math.abs(b) < 0.001) {
			return a;
		} else {
			return gcd(b, a - Math.floor(a / b) * b);
		}
	}

	@Override
	public void showGain() {
		System.out.println("Gaintt: ");
		String line1 = "   ";
		String line2 = "0.0";
		for (Process i : res) {
			String line = "";
			for (int j = 0; j < i.getAroundTime(); j++) {
				line += "-";
			}

			String left = line.substring(0, line.length() / 2);
			String right = line.substring(line.length() / 2 + 1);
			String tmp = left + "P" + i.getProcess() + right;

			String space = "";
			for (int j = 0; j < Double.toString(i.getAroundTime()).length(); j++) {
				space += " ";
			}

			line2 += "-" + line + Double.toString(i.getAroundTime());

			line1 += tmp + space;
		}
		System.out.println(line1);
		System.out.println(line2);
	}

	@Override
	public void showWaitingTime() {
		Process curr = new Process(-1, -1, 0);
		for (Process i : res) {
			i.setWaitTime(curr.getAroundTime());
			curr = i;
		}
		// waitTime ~ startTime

		for (int i = 1; i < waitTime.length; i++) {
			for (Process iter : res) {
				if (iter.getProcess() == i) {
					curr = iter;
					waitTime[i] = iter.getWaitTime() - iter.getArrivalTime();
					for (Process iter2 : res) {
						if (iter2.getProcess() == i) {
							curr = iter2;
						}
					}
					if (curr != iter) {
						waitTime[i] += curr.getWaitTime()
								- iter.getAroundTime();
					}
					break;
				}
			}
		}

		System.out.println("Wait time:");
		double sum = 0;
		for (int i = 1; i < waitTime.length; i++) {
			System.out.print("P" + i + ":" + waitTime[i] + ". ");
			sum += waitTime[i];
		}

		System.out.print("AVG:" + (double) sum / (waitTime.length - 1));
		System.out.println();

	}

	@Override
	public void showAroundTime() {
		System.out.println("Save time:");
		double sum = 0;
		for (Process i : sortArrival) {
			i.setAroundTime(waitTime[i.getProcess()] + i.getBurstTime());
			System.out.print("P" + i.getProcess() + ":" + i.getAroundTime()
					+ ". ");
			sum += i.getAroundTime();
		}
		System.out.print("AVG:" + (double) sum / (waitTime.length - 1));
		System.out.println();
	}

}