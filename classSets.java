import java.util.Vector;

public class classSets {
	private Vector<Character> set = new Vector<Character>(); //New vector 
	String nameOfSet; 										 //Unique name for this vector


	//Add element into the set
	public void addElement(char element) {					
		this.set.add(element);
	}

	//Print the name of the set and what it contains.
	public void printSet() {
		System.out.println(getName() + " = " + this.set);
	}

	//Returns the set as a vector.
	public Vector<Character> getSet() {
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


} //end class