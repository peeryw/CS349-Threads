package assignment9;

import java.util.Random;

public class threads {
	private static int x,y,z;
	public static void f() {
		x = x + 1;
		y = y + 1;
		z = z + x - y;
	}
	
	static Runnable Assignment9_1 = new Runnable(){
		public void run(){
			for (int i = 0; i <2000000000; i++){
				f();
			}			
		}
	};
	
	static Runnable Assignment9_2 = new Runnable(){
		public void run(){
			for (int i = 0; i <1000000000; i++){
				f();
			}			
		}
	};
	
	static Runnable Assignment9_3 = new Runnable(){
		public synchronized void run(){
			for (int i = 0; i <1000000000; i++){
				f();
			}			
		}
	};
	public static void printValues() {
	    System.out.println("x = " + x);
	    System.out.println("y = " + y);
	    System.out.println("z = " + z);
	}
	

	public static void main(String[] args) throws InterruptedException {
		//Assignment9.1
		
		Thread Lonewolf = new Thread(Assignment9_1);
		long startTime = System.nanoTime();
		// put computation you want to measure here
		Lonewolf.start();

		Lonewolf.join();
		long endTime = System.nanoTime();
		System.out.println("Part1 Computation took " + ((endTime - startTime) / 1000000) + " milliseconds");
		printValues();
		
		//Assignment9.2
		
		Thread MarriedCouple = new Thread(Assignment9_2);
		Thread EveryCouple = new Thread(Assignment9_2);
		long startTime2 = System.nanoTime();
		MarriedCouple.start();
		EveryCouple.start();
		
		MarriedCouple.join();
		EveryCouple.join();
		
		long endTime2 = System.nanoTime();
		System.out.println("Part2 Computation took " + ((endTime - startTime) / 1000000) + " milliseconds");
		printValues();
		
		//Assignment9.3
		
		Thread MythicalCouple = new Thread(Assignment9_3);
		Thread ManWhoSaysYesDear = new Thread(Assignment9_3);
		long startTime3 = System.nanoTime();
		MythicalCouple.start();
		ManWhoSaysYesDear.start();
		
		MythicalCouple.join();
		ManWhoSaysYesDear.join();
		
		long endTime3 = System.nanoTime();
		System.out.println("Part3 Computation took " + ((endTime - startTime) / 1000000) + " milliseconds");
		printValues();
		
	}
}
