
import java.util.*;

public class MSA {

	public static void main(String[] args) {
		int[] randomArray = new int[16];
		int max = 64;
		int min = -32;
		System.out.print("The randomly chosen array of length 16 in the range -32 to 32 is: \n [");
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = min+ new Random().nextInt(max);
			if (randomArray.length - i == 1) {
				System.out.print(randomArray[i] + "] \n");
			} else {
				System.out.print(randomArray[i] + ", ");
			}
		}
	    int size = randomArray.length; 
	    int [] max_sum = MaxSubArray(randomArray, 0, size-1); 
		System.out.print("\nThe maximum sum of this array is "+max_sum[2]+",\nstarts from index["+max_sum[0]+"],\nends at index["+max_sum[1]+"].");
		System.out.print("\n(index starts from 0)");
	}
	/*Using Kadane's algorithm*/
	static int [] MaxCrossSubArray(int[] array, int low, int midpoint , int high) {
		/* current sum */
		int sum = 0;
		
		/* Make sure no one is greater than left/right Sum */
		int leftSum = Integer.MIN_VALUE;
		
		
		/*maximum sum of left/right sub array*/
		int maxleft = 0;
		int maxright = 0;
		
		/* Find a maximum sub array of the left half */
		/*
		 * Since this sub array MUST CONTAIN MIDPOINT(important concept!) of array, the following loop
		 * starts at the index i at midpoint and works down to low
		 */
		for (int i = midpoint; i >= low; i--) {
			sum = sum + array[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxleft = i;
			}
		}
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		for (int i = midpoint + 1; i <= high; i++) {
			sum = sum + array[i];
			if (sum > rightSum) {
				rightSum = sum;
				maxright = i;
			}

		}
		int[] result = new int[3];
		/*0 & 1 represent indices of cross array*/
		result[0] = maxleft;
		result[1] = maxright;
		result[2] = leftSum + rightSum;
		return result;

	}

	static int [] MaxSubArray(int[] array, int low, int high) {
		/* Base case: Only one element in array */
		if (high == low) {
			return new int [] {low,high,array[low]};
		}
		int midpoint = (low + high) / 2;

		/* Find the maximum sum starting from low to midpoint */
		int []left = MaxSubArray(array, low, midpoint);
		/* Find the maximum sum starting from mid +1 to high.*/
		int []right = MaxSubArray(array, midpoint+1, high);
		int []cross = MaxCrossSubArray(array, low, midpoint, high);
		
		/* For observing how it works*/
//		System.out.print("Following are the information about the array I'm running now from "+low+" to "+high+": "+"\n Array{");
//		for(int i = low;i<=high;i++) {
//			if(i==high) {System.out.print(array[i]+"} ");}
//			else{ System.out.print(array[i]+", ");}
//		}
//		System.out.print("\n");
//		System.out.print("Current maximum sum of left sub array from "+low+" to "+midpoint+" I have for now: "+left[2]+"\n");
//		System.out.print("Current maximum sum of right sub array from "+(midpoint+1)+" to "+high+" I have for now: "+right[2]+"\n");
//		System.out.print("Current maximum sum of cross sub array from "+cross[0]+" to "+cross[1]+" I have: "+cross[2]+"\n");
//		System.out.print("---------"+"\n");

		
		/* By following comparison, we can aware what sum is when the array only have two elements
		 * (MaxCrossSubArray will do the calculation)
		 * */
		int [] result = new int [3];
		if (left[2]>= right[2] && left[2] >= cross[2]) {
			/* index 0 for low, 1 for high, 2 for sum */
			result[0] = low;
			result[1] = midpoint;
			result[2] = left[2];
			
		} else if (right[2]>= left[2] && right[2] >= cross[2]) {
			result[0] = midpoint+1;
			result[1] = high;
			result[2] = right[2];
		} else {
			result[0] = cross[0];
			result[1] = cross[1];
			result[2] = cross[2];
			
		}
		return result;
	}

}
