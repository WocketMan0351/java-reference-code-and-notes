package arrays;

import java.util.List;

public class ArraysDemo {
	public static void main(String[] args) {
		double[] nums = {2, 9, 1};
		double min = nums[0];
		double max = nums[0];
		double sum = 0;
		
		nums[0] = nums[0] + 1;		// changes value of index 0
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			if (nums[i] > max) {
				max = nums[i];
			}
			
			if (nums[i] < min) {
				min = nums[i];
			}
		}
		
		double avg = sum / nums.length;
		System.out.printf("%s %.2f %s %.2f %s %.2f", "Min:", min, "Max:", max, "Avg:", avg);
	}

	public static List<Integer> asList(int i, int j, int k, int l, int m) {
		// TODO Auto-generated method stub
		return null;
	}
}
