import java.security.SecureRandom;


public class Lab6 {
	static final int TOTAL_NUMBERS = 100,
			NUMBER_OF_RANGES = 6;
	private static void print(String a, int i) {
		System.out.print(a);
		for(int j=0;j<i;j++) {
			System.out.print("*");
		}	
		System.out.println();
	}

	public static void main(String[] args) {
		
		int[] temperatureData = new int[TOTAL_NUMBERS];
		int sum = 0, maxTemp = Integer.MIN_VALUE,
				minTemp = Integer.MAX_VALUE;
		double averageTemp = 0.0;
		 int[] frequencyOfTemp = new int [NUMBER_OF_RANGES];
		 
		SecureRandom random = new SecureRandom();
		//SecureRandom.getSeed(TOTAL_NUMBERS);
		
		for(int i=0;i<TOTAL_NUMBERS;i++) {
			temperatureData[i] = random.nextInt(81)-40;  //couldn't find a way to get negative numbers without using IntStream
									//these few lines are my hacked together method that works to get
				 									//negative numbers.
				sum+= temperatureData[i];
				if (temperatureData[i]<-10) {
					frequencyOfTemp[0]++;
				}else if (temperatureData[i]<=0) {
					frequencyOfTemp[1]++;
				}
				else if (temperatureData[i]<=10) {
					frequencyOfTemp[2]++;
				}else if(temperatureData[i]<=20) {
					frequencyOfTemp[3]++;
				}else if (temperatureData[i]<=30) {
					frequencyOfTemp[4]++;
				}else if (temperatureData[i]>30) {
					frequencyOfTemp[5]++;
				}
			}	
		
		for (int i=0;i<TOTAL_NUMBERS;i++) {
			if (minTemp>temperatureData[i]) {
				minTemp = temperatureData[i];
			}
		}
		for (int i=0;i<TOTAL_NUMBERS;i++) {
			if (maxTemp<temperatureData[i]) {
				maxTemp = temperatureData[i];
			}
		}
		System.out.println("Max temp: "+maxTemp);
		System.out.println("Min temp: "+minTemp);
		averageTemp = sum/TOTAL_NUMBERS;
		System.out.println("Average Temp: "+averageTemp);
		System.out.println("\nFrequency of temperature ranges:");
		Lab6.print("Less than -10 \t",frequencyOfTemp[0]);
		Lab6.print("-10 to 0 \t",frequencyOfTemp[1]);
		Lab6.print("0 to 10 \t",frequencyOfTemp[2]);
		Lab6.print("10 to 20 \t",frequencyOfTemp[3]);
		Lab6.print("20 to 30 \t",frequencyOfTemp[4]);
		Lab6.print("30 to 40 \t",frequencyOfTemp[5]);
	}

}
