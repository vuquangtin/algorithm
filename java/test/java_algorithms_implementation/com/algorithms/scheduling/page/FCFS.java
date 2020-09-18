package com.algorithms.scheduling.page;

import java.util.TreeMap;

/**
 * scheduling
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class FCFS implements Scheduling {
	// TreeMap<Process,BurstTime>
	private TreeMap<Integer,Integer> map = new TreeMap<>();
	private int[] waitTime;
	private int[] aroundTime;
	private int[] endTime;
	
	public FCFS(int[] processes, int[] burstTime) {
		map.put(0, 0);
		
		for (int i=0; i<processes.length; i++) {
			map.put(processes[i], burstTime[i]);
		}
		waitTime = new int[map.size()];
		aroundTime = new int[map.size()];
		endTime = new int[map.size()];
	}
	
	@Override
	public void showGain() {
		String line1 = "";
		String line2 = "";
		int sum=0;
		for (int i=1; i<=map.size()-1; i++) {
			String line = "";
			for (int j=0; j<map.get(i); j++) {
				line+="-";
			}
			
			
			String left = line.substring(0,line.length()/2);
			String right = line.substring(line.length()/2+1);
			String tmp = left + "P" + i + right;
			
			sum+=map.get(i-1);
			line2+=Integer.toString(sum)+line+"-";
			
			String space ="";
			for (int j=0; j<Integer.toString(sum).length(); j++) {
				space+=" ";
			}
			
			line1+=space+tmp;
		}
		
		sum+=map.get(map.size()-1);
		line2+=Integer.toString(sum);
		System.out.println("Gantt:");
		System.out.println(line1);
		System.out.println(line2);
	}

	@Override
	public void showWaitingTime() {
		System.out.println("Wait time: ");
		int res = 0;
		for (int i=1; i<waitTime.length; i++) {
			waitTime[i]=map.get(i-1)+waitTime[i-1];
			System.out.print("P"+i+":"+waitTime[i]+". ");
			res+=waitTime[i];
		}
		System.out.print("AVG: ");
		System.out.println(((double)res/(waitTime.length-1)));
	}
	
	@Override
	public void showAroundTime() {
		System.out.println("Save time: ");
		int res = 0;
		for (int i=1; i<endTime.length; i++) {
			endTime[i]=endTime[i-1]+map.get(i);
		}
		
		for (int i=1; i<aroundTime.length; i++) {
			aroundTime[i]=endTime[i]-waitTime[i];
			System.out.print("P"+i+":"+aroundTime[i]+". ");
			res+=aroundTime[i];
		}
		System.out.print("AVG: ");
		System.out.println(((double)res/(aroundTime.length-1)));
	}

}