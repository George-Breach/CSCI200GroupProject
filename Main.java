import java.util.Vector;
import java.util.Scanner;


public class Main {
	
	static void printPowerSet(classSets firstSet, int setSize)
	{
		Vector<String> firstOne = firstSet.getSet();
		
		long powerSet = (long)Math.pow(2, setSize);

		System.out.print("P(" + firstSet.getName() + ") = { ");
		for(int i = 0; i < powerSet; i++)
		{
			System.out.print("{ ");
			for(int j = 0; j < setSize; j++)
			{
				
				if((i & (1 << j)) > 0)
					System.out.print(firstOne.elementAt(j) + " ");
			}
			System.out.print("}");
		}
		System.out.print(" }");
		System.out.println();
	}

	
	// check equality of a and b
	
	public static void equals(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to compare.
		Vector<String> firstOne = firstSet.getSet();
		Vector<String> secondOne = secondSet.getSet();

		//Check if the two vectors are equal, and print the result.
		if (firstOne.equals(secondOne)) {
			System.out.println(firstSet.getName() + " = " + secondSet.getName() + ": true");
		} else {
			System.out.println(firstSet.getName() + " = " + secondSet.getName() + ": false");
		}
	}

	// union of a and b
	
	public static void union(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to get values from, and make set the union to newVector.
		Vector<String> firstOne = firstSet.getSet();
		Vector<String> secondOne = secondSet.getSet();
		Vector<String> newVector = new Vector<String>();	
		Vector<String> original = new Vector<String>();	
		
		for (int i = 0; i < secondOne.size(); i++) {
			original.add(secondOne.elementAt(i)); 
		}
		
		newVector.addAll(firstOne); 	//Add all of the first set into the new vector.
		secondOne.removeAll(firstOne);	//Remove all of the first elements from the second Set.
		newVector.addAll(secondOne);	//Add the remaining second Set into the new Vector.
		
		System.out.println("Union(" + firstSet.getName() + "," + secondSet.getName() + ") = " + newVector);
		
		
		secondOne.clear();
		for (int i = 0; i < original.size(); i++) {
			secondOne.add(original.elementAt(i)); 
		}
	}
	
	// intersection of a and b
	
	public static void intersection(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to get values from, and make set the intersection to newVector.
		Vector<String> firstOne = firstSet.getSet();
		Vector<String> secondOne = secondSet.getSet();
		Vector<String> newVector = new Vector<String>();
		Vector<String> original1 = new Vector<String>();	
		Vector<String> original2 = new Vector<String>();	
		
		for (int i = 0; i < firstOne.size(); i++) {
			original1.add(firstOne.elementAt(i)); 
		}
		
		for (int i = 0; i < secondOne.size(); i++) {
			original2.add(secondOne.elementAt(i)); 
		}
		
		// use for loop to add values to new vector for intersection
		for(int i = 0; i < firstOne.size(); i++) {
			for(int j = 0; j < secondOne.size(); j++) {
				if (firstOne.get(i).equals(secondOne.get(j))) {
					newVector.add(firstOne.get(i));
				}
			}
		}
		
		System.out.println("Intersection(" + firstSet.getName() + "," + secondSet.getName() + ") = " + newVector);
		
		firstOne.clear();
		secondOne.clear();
		for (int i = 0; i < original1.size(); i++) {
			firstOne.add(original1.elementAt(i)); 
		}
		for (int i = 0; i < original2.size(); i++) {
			secondOne.add(original2.elementAt(i)); 
		}
	}

	// difference from a to b
	
	public static void difference(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to get values from, and make set the intersection to newVector.
		Vector<String> firstOne = firstSet.getSet();
		Vector<String> secondOne = secondSet.getSet();
		Vector<String> original1 = new Vector<String>();	
		Vector<String> original2 = new Vector<String>();	
		
		for (int i = 0; i < firstOne.size(); i++) {
			original1.add(firstOne.elementAt(i)); 
		}
		
		for (int i = 0; i < secondOne.size(); i++) {
			original2.add(secondOne.elementAt(i)); 
		}
	
		// use for loop to add values to new vector for intersection
		firstOne.removeAll(secondOne);
		
		System.out.println("Difference(" + firstSet.getName() + "," + secondSet.getName() + ") = " + firstOne);
		
		firstOne.clear();
		secondOne.clear();
		for (int i = 0; i < original1.size(); i++) {
			firstOne.add(original1.elementAt(i)); 
		}
		for (int i = 0; i < original2.size(); i++) {
			secondOne.add(original2.elementAt(i)); 
		}
	}
	
	// cartesian product from a to b
	
	public static void cartesianProduct(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to get values from, and make set the intersection to newVector.
		Vector<String> firstOne = firstSet.getSet();
		Vector<String> secondOne = secondSet.getSet();
		Vector<String> original1 = new Vector<String>();	
		Vector<String> original2 = new Vector<String>();	
		
		for (int i = 0; i < firstOne.size(); i++) {
			original1.add(firstOne.elementAt(i)); 
		}
		
		for (int i = 0; i < secondOne.size(); i++) {
			original2.add(secondOne.elementAt(i)); 
		}
		
		System.out.print("Cartesian Product(" + firstSet.getName() + "," + secondSet.getName() + ") = {");
		
		for(int i = 0; i < firstOne.size(); i++) {
			for(int j = 0; j < secondOne.size(); j++) {
				System.out.print("(" + firstOne.get(i) + ", " + secondOne.get(j) + ")");
			}
		}
		
		System.out.print("}");
		
		firstOne.clear();
		secondOne.clear();
		for (int i = 0; i < original1.size(); i++) {
			firstOne.add(original1.elementAt(i)); 
		}
		for (int i = 0; i < original2.size(); i++) {
			secondOne.add(original2.elementAt(i)); 
		}
		
		System.out.println();
	}
	
	// are the sets subsets
	
	public static void isSubset(classSets firstSet, classSets secondSet) {
		//Make 2 vectors to compare.
		Vector<String> firstOne = firstSet.getSet();
		Vector<String> secondOne = secondSet.getSet();

		//Check if the first vector is inside the second vector and print result.
		if (secondOne.containsAll(firstOne)) {
			System.out.println(firstSet.getName() + " is a subset of " + secondSet.getName() + ": true" );
		} else {
			System.out.println(firstSet.getName() + " is a subset of " + secondSet.getName() + ": false" );
		}
	}

	// entering main
	
	public static void testFunctions(classSets firstSet, classSets secondSet) {
		//Default Examples Classes and their values.
		classSets set1 = firstSet;
		classSets set2 = secondSet;

		//Test printing out the sets using the classSets class.
		set1.printSet();
		set2.printSet();
		System.out.println();	
		
		//Test printing the Cardinality of the set using the classSets class.
		set1.printCardinality();
		set2.printCardinality();
		System.out.println();	

		//Test various methods and stuff.
		printPowerSet(set1, set1.getSize());
		printPowerSet(set2, set2.getSize());
		//set1.printPowerSet();
		//set2.printPowerSet();
		System.out.println();
		
		equals(set1, set2);
		isSubset(set1, set2);
		isSubset(set2, set1);
		System.out.println();	

		union(set1, set2);
		intersection(set1, set2);
		difference(set1, set2);
		difference(set2, set1);
		cartesianProduct(set1, set2);
		cartesianProduct(set1, set2);
		System.out.println();	
	}
	
	public static void main(String[] args) {
		
		String input, input2, input3, elements;
		Scanner userInput = new Scanner(System.in);
		Scanner userInput2 = new Scanner(System.in);
		Scanner userInput3 = new Scanner(System.in);
		
		System.out.println("Welcome to set calculator 3000");
		System.out.println("Please select from the following options:");
			
			System.out.println();
			System.out.println("1: Create a set.");
			System.out.println("q: QUIT");
			input = userInput.nextLine();
				
	
			switch (input) {
			case "q": 
				System.out.println();
				System.out.println("Goodbye.");
				System.exit(0);
			
			case "1": 
				//System.out.println("Placeholder");
				System.out.println();
				classSets set1 = new classSets();
				classSets set2 = new classSets();
				

				//Set their names properly.
				set1.setName("A"); 
				set2.setName("B");	
				System.out.println("****************");
				System.out.println("  Create a set  ");
				System.out.println("****************");
				System.out.println("Sets cannot be longer than 9 entries");
				System.out.println("This helps us conserve memory");
				System.out.println();
				System.out.println("Please enter the values for Set 1:");
				System.out.println("When finished, enter f");
				System.out.println();
				
				
				//Set their values properly.
				String value = "f";
				
				for(int i = 0; i < 9; i++) 
				{
					System.out.println("Enter value " + (i + 1) + ": ");
					String temp = userInput.nextLine();
					
					if(temp.equals(value)) {
						System.out.println("Set 1 complete");
						System.out.println();
						break;
					}
					else {
						set1.addElement(temp);
					}
				}
				
				System.out.println("Please enter the values for Set 2:");
				System.out.println("When finished, enter f");
				System.out.println();
				
				for(int i = 0; i < 9; i++) 
				{
					System.out.println("Enter value " + (i + 1) + ": ");
					String temp = userInput.nextLine();
					
					if(temp.equals(value)) {
						System.out.println("Set 2 complete");
						System.out.println();
						break;
					}
					else {
						set2.addElement(temp);
					}
				}
				
				set1.printSet();
				set2.printSet();
				System.out.println();	
				
				System.out.println("Sets created, what would you like to do?");
				
				do {
					System.out.println();
					System.out.println("1: Modify a set");
					System.out.println("2: Show methods");
					System.out.println("q: QUIT");
					input2 = userInput2.nextLine();
					
					switch (input2) {
					case "1":
						System.out.println("****************");
						System.out.println("  Modify a set  ");
						System.out.println("****************");
						System.out.println();
						set1.printSet();
						set2.printSet();
						System.out.println();
						System.out.println("1: Add an element to set A" );
						System.out.println("2: Remove an element from set A" );
						System.out.println("3: Add an element to set B" );
						System.out.println("4: Remove an element from set B" );
						System.out.println("q: QUIT");
						input3 = userInput3.nextLine();
						
						
						//new switch case for modify set
						switch (input3) {
						case "1":
							set1.printSet();
							System.out.println("Adding an element to set A" );
							if (set1.getSize() >= 9) {
								System.out.println("Unable to add element, this set is currently full.");
							} else {
								System.out.println("Enter an element to add: " );
								elements = userInput.nextLine();
								set1.addElement(elements);
								set1.printSet();
							}
							break;
							
						case "2":
							set1.printSet();
							System.out.println("Removing an element from set A" );
							if (set1.getSize() == 0) {  
									System.out.println("Unable to remove element, this set is already empty.");
								} else {
									System.out.println("Enter an element to remove: " );
									elements = userInput.nextLine();
									if (set1.removeElement(elements)) {
										System.out.println("Remove successful." );
										set1.printSet();
									} else {
										System.out.println("Set A did not contain: " + elements);
									}
							}
							break;
							
						case "3":
							set2.printSet();
							System.out.println("Adding an element to set B" );
							if (set2.getSize() >= 9) {
								System.out.println("Unable to add element, this set is currently full.");
							} else {
								System.out.println("Enter an element to add: " );
								elements = userInput.nextLine();
								set2.addElement(elements);
								set2.printSet();
							}
							break;
							
						case "4":
							set2.printSet();
							System.out.println("Removing an element from set B" );
							if (set2.getSize() == 0) {  
									System.out.println("Unable to remove element, this set is already empty.");
								} else {
									System.out.println("Enter an element to remove: " );
									elements = userInput.nextLine();
									if (set2.removeElement(elements)) {
										System.out.println("Remove successful." );
										set2.printSet();
									} else {
										System.out.println("Set B did not contain: " + elements);
									}
							}
							break;
							
						case "q":
							System.out.println();
							System.out.println("Goodbye.");
							System.exit(0);
							
						default: System.out.println("Unknown input: " + input3);	
						}	
						//end of new switch case for modify set
						break; //input2, case "1" break
					
					case "2":
						System.out.println("****************");
						System.out.println("    Methods  ");
						System.out.println("****************");
						System.out.println();
						testFunctions(set1, set2);
						System.out.println();
						break;
					
					case "q":
						System.out.println();
						System.out.println("Goodbye.");
						System.exit(0);
						
					}
				} while (!input.equals("q"));
			
				default: System.out.println("Unknown input: " + input);		
			}//end switch
			
		userInput.close();
		userInput2.close();
		userInput3.close();
		//Should be impossible to get here.
		System.out.println("How did you even get here?");	

	} //ends main
}	//ends class
