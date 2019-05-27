package com.corejava.practice.datatypes;

import com.corejava.practice.utils.Log;

public class UsingLogicalOperators {

  public static void main(String[] args) {

    int numberX = -4;
    int numberY = 4;
    /* Integer is 4 byte (32 bit) so binary of -4 would
     * be 11111111 11111111 11111111 11111100. If we do
     * two right shift of this number then binary for
     * the same would be 11111111 11111111 11111111 11111111
     * which means number -1. Hence the result would be -1.
     **/

    Log.logInfo("Right Shift of number {0} is {1}", numberX, numberX >> 2);
    /* In this case two unsigned right shift operation
     * is going to happen. 2's complement of 4 is 100,
     * so the number would be 11111111 11111111 11111111 11111100
     * Now by doing two right shift it would become
     * 00111111 11111111 11111111 11111111 which means
     * number 1073741823. Hence the result would be
     * 1073741823.*/
    Log.logInfo("Unsigned right shift of number {0} is {1}", numberX, numberX >>> 2);
    Log.logInfo("Left shift of number {0} is {1}", numberX, numberX << 2);
    numberX = 14;
    Log.logInfo("{0} AND {1} = {2}", numberX, numberY, numberX & numberY);
    Log.logInfo("{0} OR {1} = {2}", numberX, numberY, numberX | numberY);
    Log.logInfo(~4);
  }
}
