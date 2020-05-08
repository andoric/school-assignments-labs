package cst8284.lab8.generic;

import java.util.*;

public class DataCreator {
	
	public static <E extends Comparable<E>> void outputData(List<E>I) {
		Iterator<E> itr = I.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	public static void createIntegers(ArrayList<Integer>a, int num) {
		for(int i=0;i<num;i++) {
			int x;
			x= (int) (Math.random()*((100-1)+1))+1;
			a.add(new Integer(x));
		}
		
	}
	public static void createData(ArrayList<InterviewSlot> slots, int num) {
		
		for(int i=0;i<num;i++) {
			Calendar cal = Calendar.getInstance();
			Date start;
			int dur, x;
			x=(int) (Math.random()*((720-1)+1))+1;
			dur=(int) (Math.random()*((60-1)+1))+1;
			cal.add(Calendar.HOUR_OF_DAY, x);
			start = cal.getTime();
			slots.add(new InterviewSlot(start,dur));
		}
	}
	

}
