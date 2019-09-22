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
		//flips value so that biggest is smallest and vice versa
		for(int i = 0; i < data.length; i++) {
			data[i] = -data[i];
		}
		//sorts the data
		InsertionSort.sort(data);
		//flips the number back to possitive/negative
		for(int i = 0; i < data.length; i++) {
			data[i] = -data[i];
		}
		//prints the data
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "  ");
		}
	}

}
