
public class DynamicKnapsack {

	public static void main(String[] args) {
		//the array of item values
		int value[] = new int[]{10, 5, 30, 8, 12, 30, 50, 10, 2, 10, 40, 80, 100, 25, 10, 5}; 
		//the array of item weights
	    int weight[] = new int[]{1, 4, 6, 2, 5, 10, 8, 3, 9, 1, 4, 2, 5, 8, 9, 1}; 
	    //Knapsack capacity
	    int W = 20; 
	    //the number of items
	    int n = value.length; 
	    //call the knapsack function with the set values
	    System.out.println(dynamicKnapsack(weight, value, n, W));  
	}
	
    // A helper function that compares two integers and returns the largest one. 
    static int max(int x, int y) { 
    	if(x > y)
    		return x;
    	else
    		return y;
    }
       
    // The main knapsack function takes 4 parameters: 
    //array of item weights, array of item values, number of items, and maximum weight
    static int dynamicKnapsack(int weight[], int value[], int n, int W) 
    { 
     //the variables to hold the current item and the current weight	
     int i, wi; 
     //2D array to hold all the solved subproblems
     int A[][] = new int[n+1][W+1]; 
       
     System.out.println("The constructed table:");
     //this is the main nested for loop that builds the table
     //for every item
     for (i = 0; i <= n; i++) 
     { 
    	 //for every item weight
         for (wi = 0; wi <= W; wi++) 
         { 
        	 //if either item or weight are 0, the solution is 0
             if (i==0 || wi==0) 
                  A[i][wi] = 0; 
             //if current item weight is more than or equal to previous item weight
             else if (wi >= weight[i-1]) 
            	 //the solution is the max value of 
            	 //either the sum of the previous solution and the current solution 
            	 //or keep the current item
                 A[i][wi] = max(value[i-1] + A[i-1][wi-weight[i-1]],  A[i-1][wi]); 
             else
            	 //the solution is the solution from the previous row
                   A[i][wi] = A[i-1][wi]; 
             //print the current solution
             System.out.print(A[i][wi] + " ");
         } 
         System.out.print("\n");
      } 
     System.out.print("\n"); 
     System.out.println("Selected items: ");
     //variables to store the total weight and value of selected items
     int tWeight = 0;
     int tValue = 0;
     //while loop that prints the selected items and calculates their total weight and value
     while (n != 0) {
    	 //as long as there are items remaining
    	 if (A[n][W] != A[n - 1][W]) {
    		 //print the item number (counts from 1, not 0!), the item weight, and value
 			 System.out.println("Item " + n + " with weight = " + weight[n - 1] + " and value = " + value[n - 1]);	
 			 //add the item weight to the total weight
 			 tWeight = tWeight + weight[n - 1];
 			 //add the item value to the total value
 			 tValue = tValue + value[n - 1];
 			 //remove the current weight
 			 W = W - weight[n-1];
 		}		
 		n--;
 	}
      
     System.out.print("\n");
     System.out.println("Total weight = " + tWeight);
     System.out.print("Total value = ");
     return tValue; 
  
    }
    
}
