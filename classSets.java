import java.util.Vector;

public class classSets {
	private Vector<String> set = new Vector<String>(); //New vector 
	String nameOfSet; 										 //Unique name for this vector


	//Add element into the set
	public void addElement(String element) {					
		this.set.add(element);
	}
	
	//Return size of set
	public int getSize() {					
		return set.size();
	}
	
	
	//Returns true if set had element
	//False if element could not be removed (element did not exist)
	public boolean removeElement(String element) {					
				
		if (set.contains(element)) {
			set.remove(element);
			return true;
		} 
		return false;
		
		
	}

	//Print the name of the set and what it contains.
	public void printSet() {
		System.out.println(getName() + " = " + this.set);
	}

	//Returns the set as a vector.
	public Vector<String> getSet() {
		return this.set;
	}

	//Prints the set name and its cardinality (size).
	public void printCardinality() {
		System.out.println("|" + getName() + "| = " + this.set.size());
	}

	//Set the name of a set to a string.
	public void setName(String name) {
		this.nameOfSet = name;
	}

	//Get the name of the set.
	public String getName() {
		return this.nameOfSet;
	}

	// power set 
		public void printPowerSet() {
	        if (set == null || set.isEmpty()) {
	            System.out.println("Set is null or empty");
	            return;
	        }

	        // Get the set elements
	        Vector<String> elements = set;
	        int powerSetSize = (int) Math.pow(2, elements.size());

	        System.out.print("P(" + this.nameOfSet + ") = " + "{ { }, ");
	        powerSetSize = powerSetSize-1;
	        
	        for (int i = 0; i < set.size(); i++) {
	            System.out.print("{ " + set.get(i) + " }, ");
	        }
	        powerSetSize = powerSetSize - set.size();

	        for (int i = 0; i < set.size(); i++) {
	        	for (int j = 1; j < set.size(); j++) {
	        		if (i != j && j > i) {
	        		System.out.print("{ ");
	        		System.out.print( set.elementAt(i) + ", ");
	        		System.out.print( set.elementAt(j));
	        		System.out.print(" }, ");
	        		}
	        	}
	        }
	        
	        System.out.print("{ ");
			for (int i = 0; i < set.size(); i++) {
				System.out.print(set.get(i) + ", ");
			}	
			System.out.print("} }");
			System.out.println();
	    }
			
		
	
} //end class