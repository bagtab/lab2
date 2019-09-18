package sorting;

import java.util.Scanner;

public class Uppg2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] data = new Integer[sc.nextInt()];
		for (int i = 0; i < data.length && sc.hasNextInt(); i++) {
			data[i] = sc.nextInt();
		}
		sc.close();
		for(int i = 0; i < data.length; i++) {
			data[i] = -data[i];
		}
		InsertionSort.sort(data);
		for(int i = 0; i < data.length; i++) {
			data[i] = -data[i];
		}
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "  ");
		}
	}

}
