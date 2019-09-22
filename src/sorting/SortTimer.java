package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SortTimer {
	public static void main(String[] args) throws IOException {
		System.out.println("enter how big data you want to use");
		Scanner sc = new Scanner(System.in);
		//creates 2 arrays of the same length
		Integer[] data = new Integer[sc.nextInt()];
		Integer[] data2 = new Integer[data.length];
		//creates a filewriter if i want to use the data to make a graphical representation
		File f = new File("data");
		if(!f.exists()) {
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(new File("data"));
		//allows the user to determine how many times the program should be repeated
		System.out.println("enter how many random inputs you want to sort");
		int runs = sc.nextInt();
		sc.close();
		//creates 2 longs which keeps the time for quicksort and mergesort.
		long timeQuick = 0;
		long timeMerge = 0;
		long initTime;
		long logTime;
		QuickBentleyMcIlroy.setCutoff(8);
		for(int i = 0; i < runs; i++) {
			//fills up the arrays with the same random numbers
			Random rdm = new Random();
			for(int j = 0; j < data.length; j++) {
				data[j] = rdm.nextInt();
				data2[j] = data[j];
			}
			//logs the time to execute the quicksort
			initTime = System.nanoTime();
			QuickBentleyMcIlroy.sort(data);
			logTime = System.nanoTime() - initTime;
			fw.write("quick:" + logTime);
			timeQuick += logTime;
			//logs the time to execute the mergesort
			initTime = System.nanoTime();
			MergeSort.sort(data2);
			logTime = System.nanoTime() - initTime;
			fw.write("   merge:" + logTime + "\n");
			timeMerge += logTime;
		}
		fw.close();
		System.out.println("Quicksort time:" + timeQuick + " ns for " + runs + "sorts");
		System.out.println("Mergesort time:" + timeMerge + " ns for " + runs + "sorts");
		System.out.println("Quicksort time:" + timeQuick/1000000 + " ms for " + runs + "sorts");
		System.out.println("Mergesort time:" + timeMerge/1000000 + " ms for " + runs + "sorts");
		//quicksort and mergesort for an ordered array
		for(int j = 0; j < data.length; j++) {
			data[j] = j;
			data2[j] = data[j];
		}
		initTime = System.nanoTime();
		QuickBentleyMcIlroy.sort(data);
		logTime = System.nanoTime() - initTime;
		System.out.println("quicksort för sorterad vektor: " + logTime);
		initTime = System.nanoTime();
		MergeSort.sort(data2);
		logTime = System.nanoTime() - initTime;
		System.out.println("mergesort för sorterad vektor: " + logTime);
		//quicksort and mergesort for a reversed order array 
		for(int j = 0; j < data.length; j++) {
			data[data.length -j - 1] = j;
			data2[data.length -j - 1] = j;
		}
		initTime = System.nanoTime();
		QuickBentleyMcIlroy.sort(data);
		logTime = System.nanoTime() - initTime;
		System.out.println("quicksort för omvänt sorterad vektor: " + logTime);
		initTime = System.nanoTime();
		MergeSort.sort(data2);
		logTime = System.nanoTime() - initTime;
		System.out.println("mergesort för omvänt sorterad vektor: " + logTime);
		//quicksort and mergesort for an array with the same value at each index 
		for(int j = 0; j < data.length; j++) {
			data[j] = 1;
			data2[j] = data[j];
		}
		initTime = System.nanoTime();
		QuickBentleyMcIlroy.sort(data);
		logTime = System.nanoTime() - initTime;
		System.out.println("quicksort för vektor med samma värde: " + logTime);
		initTime = System.nanoTime();
		MergeSort.sort(data2);
		logTime = System.nanoTime() - initTime;
		System.out.println("mergesort för vektor med samma värde: " + logTime);
	}
}
