package sorting;

import java.util.Scanner;

public class Uppg1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] data = new Integer[sc.nextInt()];
		for(int i = 0; i < data.length && sc.hasNextInt(); i++) {
			data[i] = sc.nextInt();
		}
		sc.close();
		InsertionSort.sort(data);
	}
}
