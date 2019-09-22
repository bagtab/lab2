package sorting;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class CutoffTimer {
	public static void main(String[] args) {
		System.out.println("enter how big data you want to use");
		Scanner sc = new Scanner(System.in);
		//creates a 2d array with arrays to sort
		Integer[][] data = new Integer[30][sc.nextInt()];
		System.out.println("enter how many runs you want to use");
		int runs = sc.nextInt();
		//creates an array that keeps the time to execute quicksort
		Long[][] timeQuick = new Long[30][runs];
		long initTime;
		for (int i = 0; i < runs; i++) {
			Random rdm = new Random();
			//fills up data with random integers
			for (int j = 0; j < data[0].length; j++) {
				data[0][j] = rdm.nextInt();
				for (int k = 1; k < 30; k++) {
					data[k][j] = data[0][j];
				}
			}
			//sorts each of the array with respective cutoff level
			for(int j = 0; j < 30; j++) {
				QuickBentleyMcIlroy.setCutoff(j+1);
				initTime = System.nanoTime();
				QuickBentleyMcIlroy.sort(data[j]);
				long log = System.nanoTime() - initTime;
				timeQuick[j][i] = log;				
			}
		}
		
		for(int i = 0; i < 30; i++) {
			long t = 0;
			for(int j = 0; j < runs; j++) {
				t+=timeQuick[i][j];
			}
			System.out.println("time in ns for " + (i+1) + " as cutoff for insertionsort:" + t);
		}
		sc.close();
	}
}
