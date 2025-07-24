package test;

import java.util.Random;

public class ArrayRandom {

  public static void main(String[] args) {
    int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ,10 ,11 ,12, 13, 14, 15};

    Random random = new Random();
    for (int i = 0; i < tempArr.length; i++) {
      int index = random.nextInt(tempArr.length);
      int temp;
      temp = tempArr[i];
      tempArr[i] = tempArr[index];
      tempArr[index] = temp;
    }

    int[][] data = new int[4][4];
    for (int i = 0; i < tempArr.length; i++) {
      data[i / 4][i % 4] = tempArr[i];
    }
  }

}
