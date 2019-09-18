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
		Integer[] data = new Integer[sc.nextInt()];
		Integer[] data2 = new Integer[data.length];
		File f = new File("data");
		if(!f.exists()) {
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(new File("data"));
		System.out.println("enter how many random inputs you want to sort");
		int runs = sc.nextInt();
		sc.close();
		Long timeQuick = new Long(0);
		Long timeMerge = new Long(0);
		long initTime;
		long logTime;
		QuickBentleyMcIlroy.setCutoff(8);
		for(int i = 0; i < runs; i++) {
			Random rdm = new Random();
			for(int j = 0; j < data.length; j++) {
				data[j] = rdm.nextInt();
				data2[j] = data[j];
			}
			initTime = System.nanoTime();
			QuickBentleyMcIlroy.sort(data);
			logTime = System.nanoTime() - initTime;
			fw.write("quick:" + logTime);
			timeQuick += logTime;
			initTime = System.nanoTime();
			MergeSort.sort(data2);
			logTime = System.nanoTime() - initTime;
			fw.write("   merge:" + logTime + "\n");
			timeMerge += logTime;
		}
		fw.close();
		System.out.println("Quicksort time:" + timeQuick + " for " + runs + "sorts");
		System.out.println("Mergesort time:" + timeMerge + " for " + runs + "sorts");
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
		for(int j = 0; j < data.length; j++) {
			data[data.length -j - 1] = j;
			data2[data.length -j - 1] = data[data.length -j - 1];
		}
		initTime = System.nanoTime();
		QuickBentleyMcIlroy.sort(data);
		logTime = System.nanoTime() - initTime;
		System.out.println("quicksort för omvänt sorterad vektor: " + logTime);
		initTime = System.nanoTime();
		MergeSort.sort(data2);
		logTime = System.nanoTime() - initTime;
		System.out.println("mergesort för omvänt sorterad vektor: " + logTime);
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
