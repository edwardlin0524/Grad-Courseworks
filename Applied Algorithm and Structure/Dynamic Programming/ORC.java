public class ORC {

	/* Reference by pseudo code in textbook*/
	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		System.out.println("---Bottom Up version---" );
		System.out.print("Values of the array are: {" );
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
			if(i+1==array.length) {System.out.print("} \n");}
			else {System.out.print(" ,");}
			
		}
		for(int i=0;i< array.length;i++) {
			System.out.println("Maximum Obtainable revenue of index "+(i+1)+" is: " + BottomUpCutRod(array,i+1));
		}
	}
	
	static int BottomUpCutRod(int [] price, int n) {
		int [] rod = new int[n+1];
		rod[0] = 0;
		
		int revenue;
		for(int i = 1;i <= n;i++) {
			revenue = Integer.MIN_VALUE;
			for(int j = 1; j < i;j++) {
				revenue = Math.max(revenue, price[j]+rod[i-j-1]);
				rod[i] = revenue;
			}
			
		}
		return rod[n];
	}
}
