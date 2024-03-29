package sorting;

import java.util.Scanner;

public class Uppg4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] data = new Integer[sc.nextInt()];
		for(int i = 0; i < data.length && sc.hasNextInt(); i++) {
			data[i] = sc.nextInt();
		}
		sc.close();
		//counts inversions, then sorts and prints swaps to validate that they are the same
		InsertionSort.inversionCount(data);
		InsertionSort.sort(data);
	}
}
