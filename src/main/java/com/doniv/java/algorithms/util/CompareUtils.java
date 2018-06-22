package com.doniv.java.algorithms.util;

import com.doniv.java.algorithms.enumeration.SortOrder;

/**
 * This util class is used for standard compartion operations
 */

public class CompareUtils {
 
  public static int compareGTLT(int num1, int num2, SortOrder sortOrder) {
        if(SortOrder.ASCENDING.name().equals(sortOrder.name())) {
            if(num1<=num2) {
                return num2;
            } else {
                return num1;
            }
        }
        if(SortOrder.DESCENDING.name().equals(sortOrder.name())) {
            if(num1>=num2) {
                return num2;
            } else {
                return num1;
            }
        }
        return 0;
    }
}
