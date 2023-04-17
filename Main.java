import java.util.Vector;

public class Main {

	public static void equals(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to compare.
		Vector<Character> firstOne = firstSet.getSet();
		Vector<Character> secondOne = secondSet.getSet();

		//Check if the two vectors are equal, and print the result.
		if (firstOne.equals(secondOne)) {
			System.out.println(firstSet.getName() + " = " + secondSet.getName() + ": true");
		} else {
			System.out.println(firstSet.getName() + " = " + secondSet.getName() + ": false");
		}
	}

	public static void union(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to get values from, and make set the union to newVector.
		Vector<Character> firstOne = firstSet.getSet();
		Vector<Character> secondOne = secondSet.getSet();
		Vector<Character> newVector = new Vector<Character>();

		newVector.addAll(firstOne); 	//Add all of the first set into the new vector.
		//secondOne.removeAll(firstOne);	//Remove all of the first elements from the second Set.
		newVector.addAll(secondOne);	//Add the remaining second Set into the new Vector.

		System.out.println("Union(" + firstSet.getName() + "," + secondSet.getName() + ") = " + newVector);
	}
	
	public static void intersection(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to get values from, and make set the intersection to newVector.
		Vector<Character> firstOne = firstSet.getSet();
		Vector<Character> secondOne = secondSet.getSet();
		Vector<Character> newVector = new Vector<Character>();
		
		// use for loop to add values to new vector for intersection
		for(int i = 0; i < firstOne.size(); i++) {
			for(int j = 0; j < secondOne.size(); j++) {
				if (firstOne.get(i) == secondOne.get(j)) {
					newVector.add(firstOne.get(i));
				}
			}
		}
		
		System.out.println("Intersection(" + firstSet.getName() + "," + secondSet.getName() + ") = " + newVector);
	}

	public static void difference(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to get values from, and make set the intersection to newVector.
		Vector<Character> firstOne = firstSet.getSet();
		Vector<Character> secondOne = secondSet.getSet();
		Vector<Character> newVector = new Vector<Character>();
		
		// use for loop to add values to new vector for intersection
		firstOne.removeAll(secondOne);
		/*for(int i = 0; i < firstOne.size(); i++) {
			for(int j = 0; j < secondOne.size(); j++) {
				if (firstOne.get(i) == secondOne.get(j)) {
					continue;
				}
				else {
					newVector.add(firstOne.get(i));
				}
			}
		}*/
		
		System.out.println("Difference(" + firstSet.getName() + "," + secondSet.getName() + ") = " + firstOne);
	}
	
	public static void isSubset(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to compare.
		Vector<Character> firstOne = firstSet.getSet();
		Vector<Character> secondOne = secondSet.getSet();

		//Check if the first vector is inside the second vector and print result.
		if (secondOne.containsAll(firstOne)) {
			System.out.println(firstSet.getName() + " is a subset of " + secondSet.getName() + ": true" );
		} else {
			System.out.println(firstSet.getName() + " is a subset of " + secondSet.getName() + ": false" );
		}
	}




	public static void main(String[] args) {
		//Default Examples Classes and their values.
		classSets set1 = new classSets();
		classSets set2 = new classSets();

		//Set their names properly.
		set1.setName("A"); 
		set2.setName("B");	

		//Set their values properly.
		set1.addElement('1'); set1.addElement('2'); set1.addElement('3'); set1.addElement('4'); set1.addElement('5');
		set2.addElement('1'); set2.addElement('2'); set2.addElement('5');

		//Test printing out the sets using the classSets class.
		set1.printSet();
		set2.printSet();
		System.out.println();	

		//Test printing the Cardinality of the set using the classSets class.
		set1.printCardinality();
		set2.printCardinality();
		System.out.println();	

		//Test various methods and stuff.
		equals(set1, set2);
		isSubset(set1, set2);
		isSubset(set2, set1);
		System.out.println();	

		//union(set1, set2);
		intersection(set1, set2);
		difference(set1, set2);
		System.out.println();	

	} //ends main
}	//ends class
