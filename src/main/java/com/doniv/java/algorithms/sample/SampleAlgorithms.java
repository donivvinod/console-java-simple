package com.doniv.java.algorithms.sample;

import com.doniv.java.algorithms.sample.bubblesort.BallSorterBubbleSorting;

public class SampleAlgorithms {
     
     private static AlgorithmDemo algoDemo;
    
     public static void main(String... argvs) {
        System.out.println("*********** DEMO BUBBLE SORT ALGORITHM **********");
        algoDemo = new BallSorterBubbleSorting();
        algoDemo.demo();
        System.out.println("*********** END BUBBLE SORT ALGORITHM **********");
    }
}
