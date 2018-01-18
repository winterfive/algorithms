package com.LeeGainer.arrayStructures;
/*
 * Writing out some of the built in array methods.
 * Magic numbers are used as I am not using any of the
 * built in methods (setInt, getInt, newInstance, etc).
 */

public class ArrayStructure {
	
	// Fields w/ magic numbers
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	/*
	 * Generate an array of random ints
	 * void -> void
	 */	
	public void generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int)(Math.random()* 10) + 10;
		}
	}
	
	/*
	 * Print array horizontally within a frame of pipes
	 * void -> void
	 */	
	public void printArray() {
		for(int i = 0; i < arraySize - 1; i++) {
			if(theArray[i] < 10) {
				System.out.print("|  " + theArray[i] + " ");
			} else {
				System.out.print("| " + theArray[i] + " ");
			}			
		}
		System.out.print("|\n");
		for(int i = 0; i < arraySize - 1; i++) {
			System.out.print("|  " + i + " ");
		}
		System.out.println("|\n");		
	}
		
	/*
	 * Return element found at index
	 * int -> int
	 */	
	public int getElementAtIndex(int i) {
		int x = 0;
		if(i < arraySize) {
			x = theArray[i];		}
		return x;		
	}
	
	/*
	 * Checks array for value
	 * int -> boolean
	 */	
	public boolean doesArrayContain(int i) {
		boolean inArray = false;
		for(int x = 0; x < arraySize; x++) {
			if(theArray[x] == i) {
				inArray = true;
			}
		}
		return inArray;		
	}
	
	/*
	 * Deletes an element and moves all
	 * elements behind that element up
	 * int -> void
	 */	
	public void deleteElementInArray(int index) {
		if(index < arraySize) {
			for(int i = index; i < arraySize - 1; i++) {
				theArray[i] = theArray[i + 1];
			}			
		}
		arraySize--;
	}
	
	/*
	 * Insert new element at the end of the array
	 * int -> void
	 */	
	public void insertElementAtEnd(int value) {
		if(arraySize < 50) {
			theArray[arraySize] = value;
			arraySize++;	
		}
	}
	
	/*
	 * Linear Search
	 * int -> String
	 */	
	public String linearSearchforValue(int value) {
		boolean valueInArray = false;		
		String indexesWithValue = "";
		
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == value) {
				valueInArray = true;
				indexesWithValue+= i + " ";
			}
		}
		if(!valueInArray) {
			indexesWithValue = "value was not found in the Array\n";
		}		
		return indexesWithValue;
	}
	
	/*
	 * Bubble Sort
	 * void -> void
	 */
	public void bubbleSort() {
		for(int i = arraySize - 1; i > 1; i--) {
			for(int j = 0; j < i; j++) {
				if(theArray[j] > theArray[j + 1]) {
					swap(j, j + 1);					
				}
			}
		}
	}
	
	/*
	 * Swap values at 2 indexes
	 * int, int -> void
	 */	
	public void swap(int index1, int index2) {
		int swap = theArray[index1];
		theArray[index1] = theArray[index2];
		theArray[index2] = swap;
	}
	
	
	
	public static void main(String[] args) {
		
		ArrayStructure myArray = new ArrayStructure();
		
		myArray.generateRandomArray();
		
		myArray.printArray();
		
		System.out.println(myArray.getElementAtIndex(3) + "\n");
		
		System.out.println(myArray.doesArrayContain(33) + "\n");
		
		myArray.deleteElementInArray(7);
		
		myArray.printArray();
		
		myArray.insertElementAtEnd(45);
		
		myArray.printArray();
		
		String indexList = myArray.linearSearchforValue(9);
		System.out.print("The value was found at index: " + indexList + "\n");	
		
		myArray.bubbleSort();
		myArray.printArray();
	}

}