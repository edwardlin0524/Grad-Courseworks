public class MORC {
	
	/* Reference by pseudo code in textbook*/
	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		System.out.println("---Memoization version---" );
		System.out.print("Values of the array are: {" );
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
			if(i+1==array.length) {System.out.print("} \n");}
			else {System.out.print(" ,");}
			
		}
		for(int i=0;i< array.length;i++) {
			System.out.println("Maximum Obtainable revenue of index "+(i+1)+" is: " + MORCut(array,i+1));
		}
	}

	static int MORCut(int[] array, int size) {
		int[] MemoArray = new int[size+1];
		/*
		 * Initialize a new auxiliary array to help us memorize values of previous procedure
		 */
		for (int i = 0; i < size+1; i++) {
			/*
			 * From text book p.366 a convenient choice with which to denote ¡§unknown.¡¨
			 * (Known revenue values are always nonnegative.)
			 */
			MemoArray[i] = Integer.MIN_VALUE;
		}
		return MORCAUX(array, size, MemoArray);
	}

	private static int MORCAUX(int[] array, int size, int[] MemoArray) {
		/* If we've already calculated this index and stored into our memoArray*/
		if (MemoArray[size] >= 0) {
			return MemoArray[size];
		}
		/* The value we want*/
		int revenue;
		
		/* Base case*/
		if(size==0) {
			revenue = 0;			
		}
		else {
			revenue = Integer.MIN_VALUE;
			/* Key is over here at the size-i-1 and i < size*/
			for(int i=0;i<size;i++) {
				revenue = Math.max(revenue, (array[i] + MORCAUX(array, size-i-1, MemoArray)));
			}
		}
		MemoArray[size] = revenue;
		
		return revenue;

	}

}
