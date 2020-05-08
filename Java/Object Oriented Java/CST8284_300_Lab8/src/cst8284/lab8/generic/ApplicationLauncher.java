package cst8284.lab8.generic;

import java.util.ArrayList;
import java.util.Collections;


public class ApplicationLauncher {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		DataCreator.createIntegers(a, 10);
		System.out.println("Before Sorting: ");
		DataCreator.outputData(a);
		Collections.sort(a);
		System.out.println("After Sorting: ");
		DataCreator.outputData(a);
		
		ArrayList<InterviewSlot> ivSlots = new ArrayList<>();
		DataCreator.createData(ivSlots, 20);
		System.out.println("Before Sorting: ");
		DataCreator.outputData(ivSlots);
		Collections.sort(ivSlots);
		System.out.println("After Sorting: ");
		DataCreator.outputData(ivSlots);
	}

}
