/**
 * @author Ethan Gilchrist <br>
 * <b> ClassID: </b> 144 <br>
 * <b> File: </b> SimpleListTest.java <br>
 * <b> Assignment 1: </b> This program contains 36 test cases (18 success, 18 fail)
 * that run through the different requirements of each function in order to make sure  
 * the program functions correctly. Note the package is called assign1.<br> 
 */
package cse360assign2;
import static org.junit.jupiter.api.Assertions.*; //import all assertions from JUnit
import org.junit.jupiter.api.AfterEach; //import AfterEach for running statement after every test
import org.junit.jupiter.api.BeforeEach; //import BeforeEach for running statement before every test
import org.junit.jupiter.api.Test; //import Test for all @test references

/**
 * <b> Class: SimpleListTest </b> <br>
 * The SimpleListTest class contains 36 test cases (18 success, 18 fail). It has 
 * a private SimpleList object. The test object is used in every test to provide
 * a basic simple list for modification. It tests all 6 methods including the base
 * constructor SimpleList(), add(int),remove(int), int count(), String toString(), and int search(). 
 * @author Ethan Gilchrist
 * @since 2020-02-10 
 */
public class SimpleListTest
{
	/**
	 * <b> Private variable: SimpleList testObject </b> <br>
	 * This SimpleList object will be instantiated for every test.
	 * This is done to manipulate a new array and count each time. 
	 */
	private SimpleList testObject;

	/**
	 * <b> Method: setUp() </b> <br>
	 * The setUp method will instantiate the testObject to a new SimpleList before every 
	 * iteration of any test. It is a BeforeEach and will execute before every test.
	 * @throws java.lang.Exception to catch any errors in object creation
	 */
	@BeforeEach
	public void setUp() throws Exception
	{
		testObject = new SimpleList();
	}

	/**
	 * <b> Method: tearDown() </b> <br>
	 * The tearDown method will set the testObject to null after every 
	 * iteration of any test. It is an AfterEach and will execute after every test.
	 * @throws java.lang.Exception to catch any errors in object creation
	 */
	@AfterEach
	public void tearDown() throws Exception
	{
		testObject = null;
	}

	/**
	 * <b> Method: testSimpleListCase1NullSuccess() </b> <br>
	 * The testSimpleListCase1NullSuccess method is case 1 for the SimpleList() constructor. 
	 * It tests if the constructor succeeds in instantiating the object by checking if it's null.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#SimpleList()}.
	 */
	@Test
	public void testSimpleListCase1NullSuccess()
	{
		assertNotNull(testObject);
	}
	
	/**
	 * <b> Method: testSimpleListCase1NullFail() </b> <br>
	 * The testSimpleListCase1NullFail method is case 1 for the SimpleList() constructor. 
	 * It tests if the constructor succeeds in instantiating the object by checking if it's null.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#SimpleList()}.
	 */
	@Test
	public void testSimpleListCase1NullFail()
	{
		assertNull(testObject);
	}
	
	/**
	 * <b> Method: testSimpleListCase2ListCreatedSuccess() </b> <br>
	 * The testSimpleListCase2ListCreatedSuccess method is case 2 for the SimpleList() constructor. 
	 * It tests if the constructor succeeds in creating the list by seeing if the toString is currently empty since list is empty.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#SimpleList()}.
	 */
	@Test
	public void testSimpleListCase2ListCreatedSuccess()
	{
		String comparisonString = "";
		assertEquals(comparisonString, testObject.toString());
	}
	
	/**
	 * <b> Method: testSimpleListCase2ListCreatedFail() </b> <br>
	 * The testSimpleListCase2ListCreatedFail method is case 2 for the SimpleList() constructor. 
	 * It tests if the constructor succeeds in creating the list by seeing if the toString is currently empty since list is empty.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#SimpleList()}.
	 */
	@Test
	public void testSimpleListCase2ListCreatedFail()
	{
		String comparisonString = "";
		assertNotEquals(comparisonString, testObject.toString());
	}
	
	/**
	 * <b> Method: testSimpleListCase3CountSuccess() </b> <br>
	 * The testSimpleListCase3CountSuccess method is case 3 for the SimpleList() constructor. 
	 * It tests if the constructor succeeds in creating the count by seeing if it is 0 as the list is empty.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#SimpleList()}.
	 */
	@Test
	public void testSimpleListCase3CountSuccess()
	{
		int testCount = 0;
		assertEquals(testCount, testObject.count());
	}
	
	/**
	 * <b> Method: testSimpleListCase3CountFail() </b> <br>
	 * The testSimpleListCase3CountFail method is case 3 for the SimpleList() constructor. 
	 * It tests if the constructor succeeds in creating the count by seeing if it is 0 as the list is empty.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#SimpleList()}.
	 */
	@Test
	public void testSimpleListCase3CountFail()
	{
		int testCount = 0;
		assertNotEquals(testCount, testObject.count());
	}

	/**
	 * <b> Method: testAddCase1Index0Success() </b> <br>
	 * The testAddCase1Index0Success method is case 1 for the add(int) method. 
	 * It tests if the add succeeds in adding a value to index 0 by seeing if added value has index 0.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#add(int)}.
	 */
	@Test
	public void testAddCase1Index0Success()
	{
		testObject.add(2);
		assertEquals(testObject.search(2), 0);
	}
	
	/**
	 * <b> Method: testAddCase1Index0Fail() </b> <br>
	 * The testAddCase1Index0Fail method is case 1 for the add(int) method. 
	 * It tests if the add succeeds in adding a value to index 0 by seeing if added value has index 0.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#add(int)}.
	 */
	@Test
	public void testAddCase1Index0Fail()
	{
		testObject.add(2);
		assertNotEquals(testObject.search(2), 0);
	}

	/**
	 * <b> Method: testAddCase2IndexOverflowSuccess() </b> <br>
	 * The testAddCase2IndexOverflowSuccess method is case 2 for the add(int) method. 
	 * It tests if the add succeeds in overflowing when reaching 11 inputs.
	 * It uses the search method to see if the value has an index of 10.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#add(int)}.
	 */
	@Test
	public void testAddCase2IndexOverflowSuccess()
	{
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
		testObject.add(22);
		assertEquals(testObject.search(2), 10);
	}
	
	/**
	 * <b> Method: testAddCase2IndexOverflowFail() </b> <br>
	 * The testAddCase2IndexOverflowFail method is case 2 for the add(int) method. 
	 * It tests if the add succeeds in overflowing when reaching 11 inputs.
	 * It uses the search method to see if the value has an index of 10.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#add(int)}.
	 */
	@Test
	public void testAddCase2IndexOverflowFail()
	{
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
		testObject.add(22);
		assertNotEquals(testObject.search(2), 10);
	}
	
	/**
	 * <b> Method: testAddCase3IndexShiftSuccess() </b> <br>
	 * The testAddCase3IndexShiftSuccess method is case 3 for the add(int) method. 
	 * It tests if the add succeeds in shifting the index by seeing if the first input has its index moved after further input.
	 * It uses the search method to see if the value has the correct index.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#add(int)}.
	 */
	@Test
	public void testAddCase3IndexShiftSuccess()
	{
		testObject.add(2);
		testObject.add(4);
		testObject.add(6);
		testObject.add(8);
		assertEquals(testObject.search(2), 3);
	}
	
	/**
	 * <b> Method: testAddCase3IndexShiftFail() </b> <br>
	 * The testAddCase3IndexShiftFail method is case 3 for the add(int) method. 
	 * It tests if the add succeeds in shifting the index by seeing if the first input has its index moved after further input.
	 * It uses the search method to see if the value has the correct index.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#add(int)}.
	 */
	@Test
	public void testAddCase3IndexShiftFail()
	{
		testObject.add(2);
		testObject.add(4);
		testObject.add(6);
		testObject.add(8);
		assertNotEquals(testObject.search(2), 3);
	}
	
	/**
	 * <b> Method: testAddCase4CountSuccess() </b> <br>
	 * The testAddCase4CountSuccess method is case 4 for the add(int) method. 
	 * It tests if the add succeeds in counting the number of inputs.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#add(int)}.
	 */
	@Test
	public void testAddCase4CountSuccess()
	{
		testObject.add(2);
		testObject.add(4);
		testObject.add(6);
		testObject.add(8);
		assertEquals(testObject.count(), 4);
	}
	
	/**
	 * <b> Method: testAddCase4CountFail() </b> <br>
	 * The testAddCase4CountFail method is case 4 for the add(int) method. 
	 * It tests if the add succeeds in counting the number of inputs.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#add(int)}.
	 */
	@Test
	public void testAddCase4CountFail()
	{
		testObject.add(2);
		testObject.add(4);
		testObject.add(6);
		testObject.add(8);
		assertNotEquals(testObject.count(), 4);
	}

	/**
	 * <b> Method: testRemoveCase1NumberRemovedSuccess() </b> <br>
	 * The testRemoveCase1NumberRemovedSuccess method is case 1 for the remove(int) method. 
	 * It tests if the remove succeeds in removing a value by searching for it and finding a null index -1.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase1NumberRemovedSuccess()
	{
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
		testObject.remove(14);
		assertEquals(testObject.search(14), -1);
	}
	
	/**
	 * <b> Method: testRemoveCase1NumberRemovedFail() </b> <br>
	 * The testRemoveCase1NumberRemovedFail method is case 1 for the remove(int) method. 
	 * It tests if the remove succeeds in removing a value by searching for it and finding a null index -1.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase1NumberRemovedFail()
	{
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
		testObject.remove(14);
		assertNotEquals(testObject.search(14), -1);
	}
	
	/**
	 * <b> Method: testRemoveCase2NumberNotInArraySuccess() </b> <br>
	 * The testRemoveCase2NumberNotInArraySuccess method is case 2 for the remove(int) method. 
	 * It tests if the remove fails to take out a fake number by comparing the toString from before and after removal.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase2NumberNotInArraySuccess()
	{
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
		String testArray = testObject.toString();
		testObject.remove(60);
		assertEquals(testArray, testObject.toString());
	}
	
	/**
	 * <b> Method: testRemoveCase2NumberNotInArrayFail() </b> <br>
	 * The testRemoveCase2NumberNotInArrayFail method is case 2 for the remove(int) method. 
	 * It tests if the remove fails to take out a fake number by comparing the toString from before and after removal.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase2NumberNotInArrayFail()
	{
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
		String testArray = testObject.toString();
		testObject.remove(60);
		assertNotEquals(testArray, testObject.toString());
	}
	
	/**
	 * <b> Method: testRemoveCase3NumberShiftedSuccess() </b> <br>
	 * The testRemoveCase3NumberShiftedSuccess method is case 3 for the remove(int) method. 
	 * It tests if the remove shifts the index when removing values.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase3NumberShiftedSuccess()
	{
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
		testObject.remove(14);
		assertEquals(testObject.search(12), 3);
	}
	
	/**
	 * <b> Method: testRemoveCase3NumberShiftedFail() </b> <br>
	 * The testRemoveCase3NumberShiftedFail method is case 3 for the remove(int) method. 
	 * It tests if the remove shifts the index when removing values.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase3NumberShiftedFail()
	{
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
		testObject.remove(14);
		assertNotEquals(testObject.search(12), 3);
	}
	
	/**
	 * <b> Method: testRemoveCase4NumberRepeatedRemovedSuccess() </b> <br>
	 * The testRemoveCase4NumberRepeatedRemovedSuccess method is case 4 for the remove(int) method. 
	 * It tests if the remove only takes out the first instance of a repeated value by comparing indexes.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase4NumberRepeatedRemovedSuccess()
	{
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(16);
		testObject.add(14);
		testObject.add(20);
		testObject.remove(14);
		assertEquals(testObject.search(14), 2);
	}
	
	/**
	 * <b> Method: testRemoveCase4NumberRepeatedRemovedFail() </b> <br>
	 * The testRemoveCase4NumberRepeatedRemovedFail method is case 4 for the remove(int) method. 
	 * It tests if the remove only takes out the first instance of a repeated value by comparing indexes.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase4NumberRepeatedRemovedFail()
	{
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(16);
		testObject.add(14);
		testObject.add(20);
		testObject.remove(14);
		assertNotEquals(testObject.search(14), 2);
	}
	
	/**
	 * <b> Method: testRemoveCase5CountAdjustedSuccess() </b> <br>
	 * The testRemoveCase5CountAdjustedSuccess method is case 5 for the remove(int) method. 
	 * It tests if the remove properly adjusts the count.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase5CountAdjustedSuccess()
	{
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(16);
		testObject.add(14);
		testObject.add(20);
		testObject.remove(14);
		assertEquals(testObject.count(), 9);
	}
	
	/**
	 * <b> Method: testRemoveCase5CountAdjustedFail() </b> <br>
	 * The testRemoveCase5CountAdjustedFail method is case 5 for the remove(int) method. 
	 * It tests if the remove properly adjusts the count.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#remove(int)}.
	 */
	@Test
	public void testRemoveCase5CountAdjustedFail()
	{
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(16);
		testObject.add(14);
		testObject.add(20);
		testObject.remove(14);
		assertNotEquals(testObject.count(), 9);
	}
	
	/**
	 * <b> Method: testCountCase1CorrectValueSuccess() </b> <br>
	 * The testCountCase1CorrectValueSuccess method is case 1 for the int count() method. 
	 * It tests if the count is counting the values right.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#count()}.
	 */
	@Test
	public void testCountCase1CorrectValueSuccess()
	{
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(20);
		assertEquals(testObject.count(), 8);
	}
	
	/**
	 * <b> Method: testCountCase1CorrectValueFail() </b> <br>
	 * The testCountCase1CorrectValueFail method is case 1 for the int count() method. 
	 * It tests if the count is counting the values right.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#count()}.
	 */
	@Test
	public void testCountCase1CorrectValueFail()
	{
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(20);
		assertNotEquals(testObject.count(), 8);
	}
	
	/**
	 * <b> Method: testCountCase2CountOver10Success() </b> <br>
	 * The testCountCase2CountOver10Success method is case 2 for the int count() method. 
	 * It tests if the count works for over 10 arrays.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#count()}.
	 */
	@Test
	public void testCountCase2CountOver10Success()
	{
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(20);
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(20);
		assertEquals(testObject.count(), 16);
	}

	/**
	 * <b> Method: testCountCase2CountOver10Fail() </b> <br>
	 * The testCountCase2CountOver10Fail method is case 2 for the int count() method. 
	 * It tests if the count works for over 10 arrays.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#count()}.
	 */
	@Test
	public void testCountCase2CountOver10Fail()
	{
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(20);
		testObject.add(2);
		testObject.add(14);
		testObject.add(6);
		testObject.add(8);
		testObject.add(10);
		testObject.add(12);
		testObject.add(14);
		testObject.add(20);
		assertNotEquals(testObject.count(), 16);
	}

	/**
	 * <b> Method: testToStringCase1CorrectFormatSuccess() </b> <br>
	 * The testToStringCase1CorrectFormatSuccess method is case 1 for the String toString() method. 
	 * It tests if the string has the correct formatting.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#toString()}.
	 */
	@Test
	public void testToStringCase1CorrectFormatSuccess()
	{
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
		String testArray = "20 18 16 14 12 10 8 6 4 2";
		assertEquals(testArray, testObject.toString());
	}
	
	/**
	 * <b> Method: testToStringCase1CorrectFormatFail() </b> <br>
	 * The testToStringCase1CorrectFormatFail method is case 1 for the String toString() method. 
	 * It tests if the string has the correct formatting.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#toString()}.
	 */
	@Test
	public void testToStringCase1CorrectFormatFail()
	{
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
		String testArray = "20 18 16 14 12 10 8 6 4 2";
		assertNotEquals(testArray, testObject.toString());
	}
	
	/**
	 * <b> Method: testToStringCase2NoSpaceAtEndSuccess() </b> <br>
	 * The testToStringCase2NoSpaceAtEndSuccess method is case 2 for the String toString() method. 
	 * It tests if the string has the correct formatting with no space at the end.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#toString()}.
	 */
	@Test
	public void testToStringCase2NoSpaceAtEndSuccess()
	{
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
		String testArray = "20 18 16 14 12 10 8 6 4 2 ";
		assertNotEquals(testArray, testObject.toString());
	}
	
	/**
	 * <b> Method: testToStringCase2NoSpaceAtEndFail() </b> <br>
	 * The testToStringCase2NoSpaceAtEndFail method is case 2 for the String toString() method. 
	 * It tests if the string has the correct formatting with no space at the end.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#toString()}.
	 */
	@Test
	public void testToStringCase2NoSpaceAtEndFail()
	{
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
		String testArray = "20 18 16 14 12 10 8 6 4 2 ";
		assertEquals(testArray, testObject.toString());
	}
	
	/**
	 * <b> Method: testSearchCase1LocationSuccess() </b> <br>
	 * The testSearchCase1LocationSuccess method is case 1 for the int search() method. 
	 * It tests if the search finds the correct location.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#search(int)}.
	 */
	@Test
	public void testSearchCase1LocationSuccess()
	{
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
		assertEquals(testObject.search(10), 5);
	}
	
	/**
	 * <b> Method: testSearchCase1LocationFail() </b> <br>
	 * The testSearchCase1LocationFail method is case 1 for the int search() method. 
	 * It tests if the search finds the correct location.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#search(int)}.
	 */
	@Test
	public void testSearchCase1LocationFail()
	{
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
		assertNotEquals(testObject.search(10), 5);
	}
	
	/**
	 * <b> Method: testSearchCase2NotInListSuccess() </b> <br>
	 * The testSearchCase2NotInListSuccess method is case 2 for the int search() method. 
	 * It tests if the search returns -1 for nonexistent values.
	 * This is the success case expected to work.
	 * Test method for {@link SimpleList#search(int)}.
	 */
	@Test
	public void testSearchCase2NotInListSuccess()
	{
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
		assertEquals(testObject.search(70), -1);
	}
	
	/**
	 * <b> Method: testSearchCase2NotInListFail() </b> <br>
	 * The testSearchCase2NotInListFail method is case 2 for the int search() method. 
	 * It tests if the search returns -1 for nonexistent values.
	 * This is the fail case expected to not work.
	 * Test method for {@link SimpleList#search(int)}.
	 */
	@Test
	public void testSearchCase2NotInListFail()
	{
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
		assertNotEquals(testObject.search(70), -1);
	}
}
