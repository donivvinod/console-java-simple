package com.doniv.java.algorithms.sample.binarysearch;

import com.doniv.java.algorithms.sample.AlgorithmDemo;

public class BinarySearch implements AlgorithmDemo {
    
    @Override
    public void demo() {
        int[] baskets = {2,23,56,78,189,474,687};
        System.out.println("We will be performing binary search in this demo on an ordered basket of balls (ordered array)");
        System.out.println("Each basket has a number starting with zero and increments sequentially");
        System.out.println("Each basket has a ball and each ball is tagged with a number");
        System.out.println("");
        System.out.println("Demo 1 : Look for a ball that is present in one of the baskets");
        searchBallIndex(baskets,78);
        System.out.println("***************************************************************");
        System.out.println("");
        System.out.println("Demo 2 : Look for a ball that is not present in one of the baskets");
        searchBallIndex(baskets,399393);
        System.out.println("***************************************************************");
    }
    
     /**
     * Method to find the basket number that holds a ball with the given value
     */
    public int searchBallIndex(int[] baskets, int ballToFind) {
        System.out.println("Number of baskets = " + baskets.length);
        System.out.print("Ball values of the balls in the basket are = ");
        System.out.print("[");
        for (int i : baskets) {
            System.out.print(i + ",");
        }
        System.out.println("]");
        System.out.println("We are looking for the ball = " + ballToFind);
        int ballBasketNumber = searchBallIndex(baskets,ballToFind,baskets.length-1,0,-1);
        if(ballBasketNumber!=-1) {
            System.out.println("Ball found in basket # ==>" + ballBasketNumber);
        } else  {
            System.out.println("Ball was not found in any of the baskets");
        }
        return ballBasketNumber;
    }

     /**
     * Method to find the basket number that holds a ball with the given value
     */
    private int searchBallIndex(int[] baskets, int ballToFind,int maxIndex, int minIndex,int ballBasketNum) {
        if(baskets.length==1) {
            if(baskets[0]==ballToFind) {
                ballBasketNum = 0; 
                return ballBasketNum;
            } 
        }
        System.out.println("Let's find the middle index of the baskets collection");
        int middleIndex = (int)Math.round(Math.floor((maxIndex+minIndex)/2));
        System.out.println("this will be round(floor((max index + min index )/ 2 )) => "  + middleIndex);
        System.out.println("Lets check if the ball no " +  ballToFind + " is present in the basket # " + middleIndex );
        if(ballToFind > baskets[middleIndex]) {
            minIndex = middleIndex+1;
            if(minIndex==baskets.length)
                return ballBasketNum;
            System.out.println("We did not find the ball here. Lets look for the ball in the baskets between basket # " + minIndex + " to " + maxIndex);
            ballBasketNum =searchBallIndex(baskets,ballToFind,maxIndex,minIndex,ballBasketNum);
        } else if (ballToFind < baskets[middleIndex]) {
            maxIndex = middleIndex-1;
            System.out.println("We did not find the ball here. Lets look for the ball in the baskets between basket # " + minIndex + " to " + maxIndex);
            ballBasketNum = searchBallIndex(baskets,ballToFind,maxIndex,minIndex,ballBasketNum);
        }  else if(ballToFind == baskets[middleIndex]) {
            System.out.println("Yooohooo!!! We have a match here. We found our ball");
            ballBasketNum = middleIndex;
        }
        return ballBasketNum;
    }

}
