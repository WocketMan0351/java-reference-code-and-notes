package arrayLists;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo3 {
	public static void main(String[] args) {
		// 2D List & nested for each loops
		List<List<Integer>> allGrades = new ArrayList<List<Integer>>();
		
		allGrades.add(Arrays.asList(1, 2, 3));
		allGrades.add(Arrays.asList(2, 4, 6, 8));
		
		for (List<Integer> grades : allGrades) {
			for (int grade : grades) {
				System.out.print(grade + " ");
			}
			System.out.println();
		}
	}
}
