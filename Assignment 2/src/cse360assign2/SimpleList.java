/**
 * @author Ethan Gilchrist <br>
 * <b> ClassID: </b> 144 <br>
 * <b> File: </b> SimpleList.java <br>
 * <b> Assignment 1: </b> This program contains a simple list class where the
 * objects will contain a list of with 10 integers and a count. The simpleList class 
 * contains methods for adding an int to the list, removing an int, getting the count,
 * getting the list as a string separated by spaces, and a search method
 * for getting index of an element. Note the package is called assign1.<br> 
 */
package cse360assign2;


/**
 * <b> Class: SimpleList </b> <br>
 * The SimpleList class contains a private int array and a private int. The array 
 * stores the list and the count stores the current number of elements in the list.
 * It has 6 methods including the base constructor. These include SimpleList(), add(int),
 * remove(int), int count(), String toString(), and int search(). 
 * @author Ethan Gilchrist
 * @since 2020-02-10 
 */
public class SimpleList
{
	/**
	 * <b> Private variable: int[] list </b> <br>
	 * This int array will store up to 10 int values throughout the program. 
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
	 * integers in array over. If list is full, last element is removed from list.
	 * Increments the count every-time a value is added.
	 * @param input an integer value to add to the array
	 */
	public void add(int input)
	{
		if(this.count == 0)
		{
			list[0] = input;
		}
		else if (this.count < this.list.length)
		{
			for(int loopCounter = count-1; loopCounter >= 0; loopCounter--) //push values forward by traversing array backwards
			{
				list[loopCounter+1] = list[loopCounter];
			}
			list[0] = input;
		}
		else //when the count reaches 10 we lower the count back to 9 and make index 9 fall out of the array
		{
			count = 9; 
			for(int loopCounter = count-1; loopCounter >= 0; loopCounter--)
			{
				list[loopCounter+1] = list[loopCounter];
			}
			list[0] = input;
		}
		count++;
	}
	
	/**
	 * <b> Method: remove() </b> <br>
	 * The remove method will check if the parameter is in the list and remove it.
	 * If the value is repeated, it only removes the first instance. The other
	 * values in the list are shifted down. Count is also lowered.
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
						list[secondLoopCounter++] = list[loopCounter];
					}
				}
				count--;
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
			{ //once first instance of value found, set boolean true to prevent getting index of later occurence
				searchIndex = loopCounter;
				valueFound = true;
			}
		}
		return searchIndex;
	}
}
