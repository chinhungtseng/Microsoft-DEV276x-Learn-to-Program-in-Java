package module2;

public class RecursiveAlgorithms {
	
	public static String starString(int n){
	 	if (n <= 0) {
			return "*";
		} else {
			return starString(n-1) + starString(n-1);   
		}
	}
	
	
	
	public static void main(String[] args) {
		starString(5);
	
	/*
	 *  
	 * starString(0)  *                  return *     
	 * starString(1)  * *                return starString(0) + starString(0) 
	 * starString(2)  ** **              return starString(2 - 1) + starString(2 - 1)
	 * starString(3)  **** ****          return starString(3 - 1) + starString(3 - 1)
	 * starString(4)  ******** ********  return starString(4 - 1) + starString(4 - 1)
	 *      .
	 *      .
	 *      .
	 * starString(n)  ***** ...... ****  return starString(n - 1) + starString(n - 1)
	 * 
	 * 
	 * 
	public static String starString(int n){
	 	if (n <= 0) {
			return "*";
		} else {
			return starString(n-1) + starString(n-1);   
		}
	}
	 * 
	 * 
	 * 
	 */
		
		


		
		
	}

}
