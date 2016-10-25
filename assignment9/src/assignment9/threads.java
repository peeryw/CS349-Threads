package assignment9;

import java.util.Random;

public class threads {
	private static int x,y,z;
	//public static synchronized void f() { //uncomment when running part 3
	public static void f() {//comment out when running part 3
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
		public  void run(){
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
		//comment out block when running any other part, uncomment when running part one
		Thread Lonewolf = new Thread(Assignment9_1);
		long startTime = System.nanoTime();
		Lonewolf.start();

		Lonewolf.join();
		long endTime = System.nanoTime();
		System.out.println("Part1 Computation took " + ((endTime - startTime) / 1000000) + " ms");
		printValues();
		
		//Assignment9.2
		/* Uncomment block when running part two and comment out when running any other part
		Thread MarriedCouple = new Thread(Assignment9_2);
		Thread EveryCouple = new Thread(Assignment9_2);
		long startTime2 = System.nanoTime();
		MarriedCouple.start();
		EveryCouple.start();
		
		MarriedCouple.join();
		EveryCouple.join();
		
		long endTime2 = System.nanoTime();
		System.out.println("Part2 Computation took " + ((endTime - startTime) / 1000000) + " ms");
		printValues();
		*/
		//Assignment9.3
		/* Uncomment block when running part three and comment out when running any other part
		Thread MythicalCouple = new Thread(Assignment9_3);
		Thread ManWhoSaysYesDear = new Thread(Assignment9_3);
		long startTime3 = System.nanoTime();
		MythicalCouple.start();
		ManWhoSaysYesDear.start();
		
		MythicalCouple.join();
		ManWhoSaysYesDear.join();
		
		long endTime3 = System.nanoTime();
		System.out.println("Part3 Computation took " + ((endTime - startTime) / 1000000) + " ms");
		printValues();
		*/
	}
}
