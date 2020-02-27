/**
 * @author Ethan Gilchrist <br>
 * <b> ClassID: </b> 144 <br>
 * <b> File: </b> SimpleList.java <br>
 * <b> GitHub Repo Link: </b> https://github.com/EthanG45/CSE360Assignment2 <br>
 * <b> Assignment 2: </b> Update description!<br> 
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
		else //when the count reaches 10 we increase array size by 50%
		{ 
			int newSize = this.list.length + (int)(this.list.length * .5); 
			int[] biggerList = new int[newSize];
			System.arraycopy(this.list, 0, biggerList, 0, this.list.length);
			this.list = biggerList;
			for(int loopCounter = count-1; loopCounter >= 0; loopCounter--)
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
				count--;
			}
			double sizeChecker = (double) this.count / (double) this.list.length;
			if(this.list.length != 1 && sizeChecker <= .75) 
			{
				int newSize = this.list.length - (int)(this.list.length * .25);
				int[] smallerList = new int[newSize];
				System.arraycopy(this.list, 0, smallerList, 0, newSize-1);
				this.list = smallerList;
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
	
	public static void main(String[] args)
	{
		SimpleList testObject = new SimpleList();
		testObject.add(2);
		testObject.add(4);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(16);
		testObject.add(18);
		testObject.add(20);
		testObject.remove(2);
		testObject.remove(4);
		testObject.remove(6);
//		testObject.add(22);
//		testObject.add(24);
		
		for(int i = 0; i<testObject.count(); i++)
		{
			System.out.println(testObject.list[i]);
		}
		System.out.println(testObject.toString());
		
	}

}