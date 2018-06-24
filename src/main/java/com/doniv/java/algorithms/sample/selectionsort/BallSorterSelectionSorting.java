package com.doniv.java.algorithms.sample.selectionsort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.doniv.java.algorithms.enumeration.SortOrder;
import com.doniv.java.algorithms.sample.AlgorithmDemo;

public class BallSorterSelectionSorting implements AlgorithmDemo{
    
    /**
     * Selection Sort Algorithm to sort a set of Balls in an Array.
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
        
        System.out.println("Selection Sort Algorithm to sort a set of Balls in an Array.");
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
        baskets = returnSortedBallsWithSelectionSort(baskets, SortOrder.DESCENDING);
        System.out.println("Sorted Balls Descending Order Using Selection Sort");
        for (int i : baskets) {
            System.out.println(i);
        }

        baskets = returnSortedBallsWithSelectionSort(baskets, SortOrder.ASCENDING);
        System.out.println("Sorted Balls  Ascending Order Using Selection Sort");
        for (int i : baskets) {
            System.out.println(i);
        }
        
    }
    
     /**
     * Method to return the sorted balls based on the sort order using selection sort
     */
    public int[] returnSortedBallsWithSelectionSort(int[] baskets, SortOrder sortOrder) {
        int sortedIndexPosition = 0;
        int idx = 0;
        List<Integer> basketsList = Arrays.stream(baskets).boxed().collect(Collectors.toList());
        for (int k = sortedIndexPosition; k < baskets.length; k++) {
            if(sortOrder.name().equals(SortOrder.ASCENDING.name())) {
                idx = IntStream.range(sortedIndexPosition,basketsList.size())
                .reduce((i,j) -> basketsList.get(i) > basketsList.get(j) ? j : i)
                .getAsInt();
            } else {
                idx = IntStream.range(sortedIndexPosition,basketsList.size())
                .reduce((i,j) -> basketsList.get(i) < basketsList.get(j) ? j : i)
                .getAsInt();
            }
            Collections.swap(basketsList, sortedIndexPosition, idx);
            sortedIndexPosition++;
        }
        
        return basketsList.stream().mapToInt(Integer::intValue).toArray();
    }


}
