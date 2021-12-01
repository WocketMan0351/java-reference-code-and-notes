package arrays;

import java.util.Arrays;

public class CustomArrayMethods {
	public static void main(String[] args) {
		int[] nums = { 8, 18, 31, 7, 99};
		
		System.out.println(Arrays.toString(nums));
		
		System.out.printf("%s %d %s %d %s %.2f", "Min:", min(nums), "Max:", max(nums), "Average:", sum(nums) / nums.length);
	}
	
	/**
		Determine the smallest value within an array
		@param array an array of integers
		@return the smallest value
	*/
	public static int min(int[] array) {
		int min = array[0];
		
		for(int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		
		return min;
	}
	
	/**
		Determine the largest value within an array
		@param array an array of integers
		@return the largest values
	*/
	public static int max(int[] array) {
		int max = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}
	
	/**
	Determine the sum of all values within an array
	@param array an array of integers
	@return the sum
	*/
	public static double sum(int[] array) {
		double sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum;
	}
}
