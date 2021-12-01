package arrays;
import java.util.Arrays;

public class Arrays2D {
	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3, 4, 5},
				{2, 4, 6, 8, 10},
				{3, 6, 9, 12, 15}
		};
		
		System.out.println("Printing single element:");
		System.out.println(arr[1][4]); // prints 10
		System.out.println();
		
		System.out.println("Printing entire 2D array:");
		System.out.println(Arrays.deepToString(arr)); // prints entire array
		System.out.println();
		
		System.out.println("Getting length of a row at index 0:");
		System.out.println(arr[0].length);	// prints length of arr[0]
		System.out.println();
		
		System.out.println("Iterating thru 2D array w/ nested for loops:");
		for (int row = 0; row < arr.length; row ++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println(); // separates each individual array
		}
		
	}
	
}
