package com.doniv.java.algorithms.sample;

import com.doniv.java.algorithms.sample.bubblesort.BallSorterBubbleSorting;
import com.doniv.java.algorithms.sample.selectionsort.BallSorterSelectionSorting;

public class SampleAlgorithms {
     
     private static AlgorithmDemo algoDemo;
    
     public static void main(String... argvs) {
        System.out.println("*********** DEMO BUBBLE SORT ALGORITHM **********");
        algoDemo = new BallSorterBubbleSorting();
        algoDemo.demo();
        System.out.println("*********** END BUBBLE SORT ALGORITHM **********");
        
        System.out.println("*********** DEMO SELECTION SORT ALGORITHM **********");
        algoDemo = new BallSorterSelectionSorting();
        algoDemo.demo();
        System.out.println("*********** END SELECTION SORT ALGORITHM **********");
    }
}
