package com.doniv.java.algorithms.sample;

import com.doniv.java.algorithms.enumeration.SortOrder;
import com.doniv.java.algorithms.util.CompareUtils;


/** 
 * This is a sample program to demonstrate how to use 
 * Bubble Sort Algorithm to sort a set of Balls in an Array.
 * Rules
 * 1. The balls are all placed in different baskets. One ball in one basket
 * 2. There is one extra empty basket that can be used for sorting.
 * 3. You can pick only one ball at a time.
 * 4. Before picking up a second ball you need to drop the first ball in the empty basket
 * Example : Basket 1 : Ball # 10 
 *           Basket 2 : Ball # 2
 *           Basket 3 : Ball # 8
 *           Basket 4 : Ball # 6
 *           Basket 5 : Ball # 7
 *           Basket 6 : Ball # 3         
 *  */
public class BallSorter {
    public static void main(String... argvs) {
        int[] baskets = {10,2,8,6,7,3,3,4};
        BallSorter sorter = new BallSorter();
        baskets  = sorter.returnSortedBalls(baskets, SortOrder.DESCENDING);
        System.out.println("Sorted Balls") ;
        for (int i : baskets) {
           System.out.println(i) ;
        }
    }
    
    /**
     * Method to return the sorted balls based on the sort order passed.
     */
    public int[] returnSortedBalls(int[] baskets, SortOrder sortOrder) {
        return returnSortedBalls(baskets,sortOrder,baskets.length);
    }
   
   
    /**
     * Overloaded method to perform the sorting of the balls.
     */
    private int[] returnSortedBalls(int[] baskets, SortOrder sortOrder,int lastSortedBallPosition) {
        int emptyBasketBallNo = 0; //Variable to indicate the empty basket
        for (int i =0; i<baskets.length; i++) {  //Loop thru all the baskets one by one.
            if(i < lastSortedBallPosition-1) {  //Check if the array has move to the last sorted position. We dont to go after that.
                emptyBasketBallNo = CompareUtils.compareGTLT(baskets[i],baskets[i+1],sortOrder); //Pick one of the two and drop to the empty basket.
                if(emptyBasketBallNo==baskets[i]) { //Swap the balls position depending on the sort order requirement
                    baskets[i]=baskets[i+1];
                    baskets[i+1] = emptyBasketBallNo;
                    emptyBasketBallNo = 0;
                }
            }
        }
        
        
        if(lastSortedBallPosition!=1) { //Continue with the sorting.
            lastSortedBallPosition = lastSortedBallPosition - 1;
            returnSortedBalls(baskets,sortOrder,lastSortedBallPosition);
        }
        
        //Break out of the recurssion if the sorting is complete
        return baskets;
    }
}


