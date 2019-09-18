package sorting;

public class InsertionSort{
	public static void sort(Comparable[] data) {
		int len = data.length;
		int nrSwaps = 0;
		print(data);
		for(int i = 0; i < len; i++) {
			for(int j = i;j > 0 && data[j].compareTo(data[j-1]) ==-1; j-- ) {
				swap(data, j, j-1);
				nrSwaps++;
				print(data);
			}
			System.out.print("sorted " + (i+1) +" first elements, resulting in ");
			print(data);
			System.out.println("amount of swaps: " + nrSwaps);
		}
	}
	private static void swap(Comparable[] data, int i, int j) {
		Comparable k = data[i];
		data[i] = data[j];
		data[j] = k;
	}
	private static void print(Comparable[] data) {
		System.out.print("[");
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "    ");
		}
		System.out.println("]\n");
	}
	public static void inversionCount(Comparable[] data) {
		int inversions = 0;
		String textInversions = "";
		for(int i = 0; i < data.length; i++) {
			for(int j = i; j < data.length; j++) {
				if(data[j].compareTo(data[i]) == -1) {
					inversions++;
					textInversions+= "  [[" + i + "," + data[i] + "],[" + j + "," + data[j] + "]]  ";
				}
			}
		}
		System.out.println(inversions +" nr of inversions:\n" + textInversions);
	}
}
