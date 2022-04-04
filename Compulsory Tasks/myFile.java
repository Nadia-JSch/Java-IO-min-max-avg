

import java.io.*;  // import the entire io package for BufferedReader and Writer
import java.util.Arrays;  // for the toString() method


public class myFile {
	
	public static void main(String[] args) {
		
		// initialise variables to hold the only the numbers of each line 
		String min = null;
		String max = null;
		String avg = null;
		String sumStr = null;
		String p70 = null;
		String p90 = null;
		
// === Objects to Read and Write to file ===			
		
		try {
			// read the content of the text file input.txt
			FileReader file = new FileReader("input.txt");
			BufferedReader textRead = new BufferedReader(file);
			
			// create FileWriter object to write to output.txt
			FileWriter outputFile = new FileWriter("output.txt");
			
			// heading for console
			System.out.println("File contents: ");
			
			// while loop to iterate through input.txt
			while (textRead.ready()) {
				
				// printing each line to console
				String input = textRead.readLine();
				System.out.println(input);
				
			
// === Conditional logic ===
			
				// find the MINIMUM number in corresponding input.txt line and write it to output.txt
				if (input.contains("Min")) {
					// get substring without word and store it in its variable
					min = input.substring(5, input.length());
					
					// convert String to int Array store reference to it 
					int [] minNumsArray = convertStringToIntArray(min);
					
					// call findMin method and write answer to output.txt		
					outputFile.write("The min of " + 
					Arrays.toString(minNumsArray) + " is " + findMin(minNumsArray) + "\r\n");
				}
				
				// find the MAXIMUM number in corresponding input.txt line and write it to output.txt
				if (input.contains("Max")) {
					// get substring without word and store it in its variable
					max = input.substring(5, input.length());
					
					// convert substring to int Array store reference to it 
					int[] maxNumsArray = convertStringToIntArray(max);
					
					// call the findMax function and write to output.txt
					outputFile.write("The max of " + 
					Arrays.toString(maxNumsArray) + " is " + findMax(maxNumsArray) + "\r\n");
				}
				
				// find the AVERAGE number of a line in input.txt and write it to output.txt
				if (input.contains("Avg")) {
					// get substring without word and store it in its variable
					avg = input.substring(5, input.length());
					
					// convert substring to int Array store reference to it 
					int[] avgNumsArray = convertStringToIntArray(avg);
					
					// call the findAvg function and write to output.txt
					outputFile.write("The avg of " + 
					Arrays.toString(avgNumsArray) + " is " + findAvg(avgNumsArray) + "\r\n");
				}
				
				// find the 90th PERCENTILE for line in input.txt and write it to output.txt
				if (input.contains("p90")) {
					// get substring without word and store it in its variable
					p90 = input.substring(5, input.length());
					
					// convert substring to int Array store reference to it 
					int[] p90NumsArray = convertStringToIntArray(p90);
					
					// call the findP90 function and write to output.txt
					outputFile.write("The 90th percentile of " + 
					Arrays.toString(p90NumsArray) + " is " + findP90(p90NumsArray) + "\r\n");
				}
				
				//find the SUM of a line in input.txt and writing it to output.txt
				if (input.contains("Sum")) {
					// get substring without word and store it in its variable
					sumStr = input.substring(5, input.length());
					
					// convert to int[] array
					int[] sumNumsArray = convertStringToIntArray(sumStr);
					
					// call the findSum method and write to output.txt
					outputFile.write("The sum of " + 
					Arrays.toString(sumNumsArray) + " is " + findSum(sumNumsArray) + "\r\n");
				}
				
				// find the 70th PERCENTILE for line in input.txt and writing it to output.txt
				if (input.contains("p70")) {
					// store reference to substring of numbers
					p70 = input.substring(5, input.length());
					
					// convert substring to int Array store reference to it 
					int[] p70NumsArray = convertStringToIntArray(p70);
					
					// call the findP90 function and write to output.txt
					outputFile.write("The 70th percentile of " + 
					Arrays.toString(p70NumsArray) + " is " + findP70(p70NumsArray) + "\r\n");
				}
		
		} 
		// close the files
		textRead.close();	
		outputFile.close();
		
		} // end of try block - catch exception if file isn't found
		catch (IOException e) {
			e.printStackTrace();   
		}
	} // end brace of Main method
	
	
// === Methods ===
	
	// Method to convert substring to an array of integers
	public static int[] convertStringToIntArray(String myString) {
		// create array by using split() on the string 
		String[] array = myString.split(",");
		
		// parse to integer and store in a new integer array
		int[] intArray = new int [array.length];
		for (int i = 0; i < array.length; i++) {
			intArray[i] = Integer.parseInt(array[i]);
		}
		return intArray;
	}
	
	
	// Method - return the maximum value of an array
	public static int findMax(int[] nums) {
		//sort the numbers and return the last number in the array
		Arrays.sort(nums);
		return nums[nums.length - 1];
	}
	
	
	// Method - return the minimum value of an array
		public static int findMin(int[] nums) {
			//sort the numbers and return the first number in the array
			Arrays.sort(nums);
			return nums[0];
		}
	
		
	// Method - return the sum of numbers in an array
		public static int findSum(int[] nums) {
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
			}
			return sum;
		}
		
		
	// Method - return the average of numbers in an array
		public static double findAvg(int[] nums) {
			 // divide the sum by the array length
			return (double) findSum(nums) / nums.length;			
		}
		
		
	// Method - return the 90th percentile of an array of numbers
		public static int findP90(int[] nums) {
			// sort numbers ascending order in case they aren't already
			Arrays.sort(nums);
			// use formula n = (P/100) * N and cast to integer
			return (int)(0.9 * nums.length);
		}
		
		
	// Method - return the 70th percentile of an array of numbers
		public static int findP70(int[] nums) {
			// sort numbers ascending order in case they aren't already
			Arrays.sort(nums);
			// use formula n = (P/100) * N 
			return (int)(0.7 * nums.length);	
		}
}

