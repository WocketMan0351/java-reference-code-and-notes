package arrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo4 {
	public static void main(String[] args) {
		List<Integer> grades = Arrays.asList(1, 2, 3, 4, 5);

		// alters elements in grades
		for(int i = 0; i < grades.size(); i++) {
			grades.set(i, grades.get(i) * 2);
			
			System.out.println(grades.get(i));
		}
		
		System.out.println();
		
		// for each loop that can't alter elements in grades
		for (int grade : grades) {
			if (grade == 10) {
				System.out.println("10 found at index: " + grades.indexOf(10));
			}
		}
	}
}
