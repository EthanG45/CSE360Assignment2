/**
 * @author Ethan Gilchrist <br>
 * <b> ClassID: </b> 144 <br>
 * <b> File: </b> SimpleList.java <br>
 * <b> GitHub Repo Link: </b> https://github.com/EthanG45/CSE360Assignment2 <br>
 * <b> Assignment 2: </b> The primary focus of this assignment is to use GitHub for
 * committing to a repository containing this Assignment 2 package. This assignment modifies
 * assigment 1 by changing the add method, remove method, and adding four other new methods.<br> 
 */
package cse360assign2;


/**
 * <b> Class: SimpleList </b> <br>
 * The SimpleList class contains a private int array and a private int. The array 
 * stores the list and the count stores the current number of elements in the list.
 * It has 10 methods including the base constructor. These include SimpleList(), add(int),
 * remove(int), int count(), String toString(), int search(), append(int), int first(),
 * int last(), and int size(). Note the add method and remove method have been changed see their respective JavaDoc comments.
 * @author Ethan Gilchrist
 * @since 2020-02-27
 */
public class SimpleList
{
	/**
	 * <b> Private variable: int[] list </b> <br>
	 * This int array will store up at first 10 int values.
	 * As a user adds value it can expand in size by increments of 50%.
	 */
	private int[] list;
	/**
	 * <b> Private variable: int count </b> <br>
	 * This int will contain the current amount of numbers in the array. 
	 */
	private int count;
	
	/**
	 * <b> Constructor: simpleList() </b> <br>
	 * The simpleList constructor initialize the list int array to 10 values
	 * and sets count to 0. 
	 */
	public SimpleList()
	{
		this.list = new int[10];
		this.count = 0;
	}
	
	/**
	 * <b> Method: add() </b> <br>
	 * The add method will add values to index 0 of the array. It moves all other
	 * integers in array over. If list is full, the list is increased in size by 50%.
	 * This means for example a list of size 10 would increase to a size of 15.
	 * Increments the count every time a value is added.
	 * @param input an integer value to add to the array
	 */
	public void add(int input)
	{
		if(this.count == 0)
		{
			this.list[0] = input;
		}
		else if (this.count < this.list.length)
		{
			for(int loopCounter = count-1; loopCounter >= 0; loopCounter--) //push values forward by traversing array backwards
			{
				this.list[loopCounter+1] = this.list[loopCounter];
			}
			this.list[0] = input;
		}
		else //when the count reaches max value we increase array size by 50%
		{ 
			int newSize = this.list.length + (int)(this.list.length * .5); //calculate new array size with int arithmetic
			int[] biggerList = new int[newSize]; //create new array with the 50% size increase
			System.arraycopy(this.list, 0, biggerList, 0, this.list.length); //use arraycopy to move previous values into new array
			this.list = biggerList; //remove our smaller list by pointing this.list to the new list
			
			for(int loopCounter = this.count-1; loopCounter >= 0; loopCounter--) //push values forward by traversing array backwards
			{
				this.list[loopCounter+1] = this.list[loopCounter];
			}
			this.list[0] = input;
		}
		this.count++;
	}
	
	/**
	 * <b> Method: remove() </b> <br>
	 * The remove method will check if the parameter is in the list and remove it.
	 * If the value is repeated, it only removes the first instance. The other
	 * values in the list are shifted down. Count is also lowered.
	 * If the list has more than 25% empty spots, the size of the list is decremented by 25%.
	 * For example if a list of 10 has only 7 filled spots it will be decremented to a size of 8.
	 * Note the list can't be reduced to less than 1 entry.
	 * @param input an integer value to remove from the array
	 */
	public void remove(int input)
	{
		int indexToRemove = -1;
		if(this.count != 0)
		{
			indexToRemove = search(input);
			if (indexToRemove != -1)
			{
				for(int loopCounter = 0, secondLoopCounter = 0; loopCounter < this.count; loopCounter++)
				{ //we implement two loopCounters. The first is compared with removal index.
					if(loopCounter != indexToRemove) //this causes the indexToRemove value to be overwritten in array
					{ //second loop counter is used to to shift the other values down.
						this.list[secondLoopCounter++] = this.list[loopCounter];
					}
				}
				this.count--;
			}
			double sizeChecker = (double) this.count / (double) this.list.length; //use double arithmetic to get the percentage of array filled
			if(!(this.count <= 1) && sizeChecker <= .75)  //check if array isn't one entry and if the array size is 25% empty
			{
				int newSize = this.list.length - (int)(this.list.length * .25); //calculate new array size with int arithmetic
				int[] smallerList = new int[newSize]; //create new array with the 25% size decrease
				System.arraycopy(this.list, 0, smallerList, 0, newSize-1); //use arraycopy to move previous values into new array
				this.list = smallerList; //remove the larger list by pointing this.list to the new list
			}
		}
	}
	
	/**
	 * <b> Method: count() </b> <br>
	 * This getter method returns the current count value of the class object.
	 * The count value is the number of elements in the array max at 10.
	 * @return count the current number of elements in array
	 */
	public int count()
	{
		return this.count;
	}
	
	/**
	 * <b> Method: toString() </b> <br>
	 * This toString method converts the array to a string. The values are separated by
	 * a space where the last integer does not have a space after it.
	 * @return printList the list array as a string separated by spaces
	 */
	public String toString()
	{
		String printList = "";
		for(int loopCounter = 0; loopCounter < this.count; loopCounter++)
		{
			if(loopCounter != this.count - 1)
			{
				printList = printList + this.list[loopCounter] + " ";	
			}
			else //when last value is reached don't include space at end
			{
				printList = printList + this.list[loopCounter];
			}
		}
		return printList;
	}
	
	/**
	 * <b> Method: search() </b> <br>
	 * The search method will traverse the array to find the first instance of
	 * an integer, and then return the index of it. If not in the list return -1.
	 * @param input an integer value to search for in the array
	 * @return searchIndex an integer representing the index of the desired element
	 */
	public int search(int input)
	{
		int searchIndex = -1;
		boolean valueFound = false;
		for(int loopCounter = 0; loopCounter < this.count; loopCounter++)
		{
			if(list[loopCounter] == input && valueFound == false)
			{ //once first instance of value found, set boolean true to prevent getting index of later occurrence
				searchIndex = loopCounter;
				valueFound = true;
			}
		}
		return searchIndex;
	}
	
	/**
	 * <b> Method: append() </b> <br>
	 * The add method will append values to the last index of the array.
	 * Note this is the "count" index or the end of the list.
	 * If list is full, the list is increased in size by 50%.
	 * This means for example a list of size 10 would increase to a size of 15.
	 * Increments the count every time a value is added.
	 * @param input an integer value to append to the array
	 */
	public void append(int input) 
	{
		if(this.count == 0) //if list is empty we still insert at head
		{
			this.list[0] = input;
		}
		else if (this.count < this.list.length)
		{
			this.list[count] = input;
		}
		else //when the count reaches value we increase array size by 50%
		{ 
			int newSize = this.list.length + (int)(this.list.length * .5); //calculate new array size with int arithmetic
			int[] biggerList = new int[newSize]; //create new array with the 50% size increase
			System.arraycopy(this.list, 0, biggerList, 0, this.list.length); //use arraycopy to move previous values into new array
			this.list = biggerList; //remove our smaller list by pointing this.list to the new list
			
			this.list[count] = input;
		}
		this.count++;
	}
	
	/**
	 * <b> Method: first() </b> <br>
	 * This getter method returns the first value of the class object array list.
	 * The first value is just the value at index 0. We either return this value or
	 * if the list is empty (count = 0) return -1.
	 * @return the first element of the array
	 */
	public int first()
	{
		if(this.count != 0)
		{
			return this.list[0];
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * <b> Method: last() </b> <br>
	 * This getter method returns the last value of the class object array list.
	 * The last value is just the value at index count-1. We either return this value or
	 * if the list is empty (count = 0) return -1.
	 * @return the last element of the array
	 */
	public int last()
	{
		if(this.count != 0)
		{
			return this.list[count-1];
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * <b> Method: size() </b> <br>
	 * This getter method returns the size of the class object array list.
	 * The size is always this.list.length. This tells the user how many spaces are open for input.
	 * @return the length of the array
	 */
	public int size()
	{
		return this.list.length;
	}
}