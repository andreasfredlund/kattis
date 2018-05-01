import java.util.*;
import java.util.Scanner;

/*
Sort of sorted - kattis. Sorts a namelist based on only the two first letters in the name. If AAB has been placed before AAA the order should be [AAB AAA]
*/

public class SortStudents {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (!scan.hasNext("0")) {

			LinkedList<String> nameList = new LinkedList<String>();
			int numberOfNames = scan.nextInt();

			for (int i = 0; i < numberOfNames; i++) {

				String name = scan.next();
				int sizeOfList = nameList.size();

				if (sizeOfList == 0) {
					nameList.add(name);
				}

				else {

					for (int j = 0; j < sizeOfList; j++) {

						String nameOnIndex = nameList.get(j);

						if (name.charAt(0) < nameOnIndex.charAt(0)) {
							nameList.add(j, name);
							break;
						}

						if (name.charAt(0) == nameOnIndex.charAt(0) && name.charAt(1) < nameOnIndex.charAt(1)) {
							nameList.add(j, name);
							break;
						}

						if (j == sizeOfList - 1) {
							nameList.addLast(name);
						}
					}
				}
			}

			for (int k = 0; k < numberOfNames; k++) {
				System.out.println(nameList.get(k));
			}

			if (!scan.hasNext("0")) {
				System.out.println();
			}

		}
		scan.close();
	}
}
