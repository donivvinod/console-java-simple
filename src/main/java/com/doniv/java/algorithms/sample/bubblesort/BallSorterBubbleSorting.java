package com.doniv.java.algorithms.sample.bubblesort;

import com.doniv.java.algorithms.enumeration.SortOrder;
import com.doniv.java.algorithms.sample.AlgorithmDemo;
import com.doniv.java.algorithms.util.CompareUtils;


/** 
 * This is a sample program to demonstrate how to use algorithms
 *  */
public class BallSorterBubbleSorting implements AlgorithmDemo{
  

    /**
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
     */
    @Override
    public void demo() {
        System.out.println("Bubble Sort Algorithm to sort a set of Balls in an Array.");
        System.out.println("Rules");
        System.out.println("1. The balls are all placed in different baskets. One ball in one basket");        
        System.out.println("2. There is one extra empty basket that can be used for sorting.");        
        System.out.println("3. You can pick only one ball at a time.");        
        System.out.println("4. Before picking up a second ball you need to drop the first ball in the empty basket");        
        System.out.println("Example : Basket 1 : Ball # 10 ");        
        System.out.println("          Basket 2 : Ball # 2");        
        System.out.println("          Basket 3 : Ball # 8");        
        System.out.println("          Basket 4 : Ball # 6");        
        System.out.println("          Basket 5 : Ball # 7");        
        System.out.println("          Basket 6 : Ball # 3");        
        System.out.println("          Basket 7 : Ball # 3");        
        System.out.println("          Basket 8 : Ball # 3");           
        int[] baskets = {10, 2, 8, 6, 7, 3, 3, 4};
        baskets = returnSortedBallsWithRecurssion(baskets, SortOrder.DESCENDING);
        System.out.println("Sorted Balls Using Recurssion Descending Order");
        for (int i : baskets) {
            System.out.println(i);
        }

        baskets = returnSortedBallsWithoutRecurssion(baskets, SortOrder.ASCENDING);
        System.out.println("Sorted Balls Without Using Recursion Ascending Order");
        for (int i : baskets) {
            System.out.println(i);
        }
    }

    /**
     * Method to return the sorted balls based on the sort order without using recurssion
     */
    public int[] returnSortedBallsWithoutRecurssion(int[] baskets, SortOrder sortOrder) {
        int emptyBasketBallNo = 0;
        for (int i = 0; i < baskets.length - 1; i++) {
            for (int j = 0; j < baskets.length - 1 - i; j++) {
                if (sortOrder.name().equals(SortOrder.ASCENDING.name())) {
                    if (baskets[j] > baskets[j + 1]) {
                        emptyBasketBallNo = baskets[j];
                        baskets[j] = baskets[j + 1];
                        baskets[j + 1] = emptyBasketBallNo;
                    }
                } else {
                    if (baskets[j] < baskets[j + 1]) {
                        emptyBasketBallNo = baskets[j];
                        baskets[j] = baskets[j + 1];
                        baskets[j + 1] = emptyBasketBallNo;
                    }
                }
            }

        }
        return baskets;
    }


    /**
     * Method to return the sorted balls based on the sort order passed using recurssion.
     */
    public int[] returnSortedBallsWithRecurssion(int[] baskets, SortOrder sortOrder) {
        return returnSortedBallsWithRecurssion(baskets, sortOrder, baskets.length);
    }


    /**
     * Overloaded method to perform the sorting of the balls.
     */
    private int[] returnSortedBallsWithRecurssion(int[] baskets, SortOrder sortOrder, int lastSortedBallPosition) {
        int emptyBasketBallNo = 0; //Variable to indicate the empty basket
        for (int i = 0; i < baskets.length; i++) { //Loop thru all the baskets one by one.
            if (i < lastSortedBallPosition - 1) { //Check if the array has move to the last sorted position. We dont to go after that.
                emptyBasketBallNo = CompareUtils.compareGTLT(baskets[i], baskets[i + 1], sortOrder); //Pick one of the two and drop to the empty basket.
                if (emptyBasketBallNo == baskets[i]) { //Swap the balls position depending on the sort order requirement
                    baskets[i] = baskets[i + 1];
                    baskets[i + 1] = emptyBasketBallNo;
                    emptyBasketBallNo = 0;
                }
            }
        }


        if (lastSortedBallPosition != 1) { //Continue with the sorting.
            lastSortedBallPosition = lastSortedBallPosition - 1;
            returnSortedBallsWithRecurssion(baskets, sortOrder, lastSortedBallPosition);
        }

        //Break out of the recurssion if the sorting is complete
        return baskets;
    }
}
