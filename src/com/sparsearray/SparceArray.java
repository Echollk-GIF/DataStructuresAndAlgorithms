package com.sparsearray;

public class SparceArray {
  public static void main(String[] args) {
    //创建一个原始的二维数组棋盘11*11
    //0表示没有子 1表示黑子 2表示白子
    int[][] chessArr1 = new int[11][11];
    chessArr1[1][2] = 1;
    chessArr1[2][3] = 2;
    //输出原始的二维数组
    System.out.println("原始的二维数组~~~");
    for (int i = 0; i < chessArr1.length; i++) {
      for (int j = 0; j < chessArr1[i].length; j++) {
        System.out.printf(String.valueOf(chessArr1[i][j]));
      }
      System.out.println();
    }
    //将二维数组转化为稀疏数组
    //1.先遍历二维数组得到非0数据的个数
    int sum = 0;
    for (int i = 0; i < chessArr1.length; i++) {
      for (int j = 0; j < chessArr1[i].length; j++) {
        if (chessArr1[i][j] != 0) {
          sum++;
        }
      }
    }
    //2.创建对应的稀疏数组
    int[][] sparseArr = new int[sum + 1][3];
    //给稀疏数组赋值
    sparseArr[0][0] = chessArr1.length;
    sparseArr[0][1] = chessArr1[0].length;
    sparseArr[0][2] = sum;

    //遍历二维数组，将非0的值存放到稀疏数组中
    int count = 0;//count用于记录是第几个非0数据
    for (int i = 0; i < chessArr1.length; i++) {
      for (int j = 0; j < chessArr1[i].length; j++) {
        if (chessArr1[i][j] != 0) {
          count++;
          sparseArr[count][0] = i;
          sparseArr[count][1] = j;
          sparseArr[count][2] = chessArr1[i][j];
        }
      }
    }
    //输出稀疏数组的形式
    System.out.println("得到的稀疏数组为如下形式");
    for (int i = 0; i < sparseArr.length; i++) {
      System.out.printf("%d\t%d\t%d", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
      System.out.println();
    }

    //将稀疏数组->恢复成原始的二维数组
    //1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
    int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
    //2.读取稀疏数组后几行的数据，并赋给原始的二维数组即可.
    for (int i = 1; i < sparseArr.length; i++) {
      chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
    }
    //输出恢复后的二维数组
    System.out.println("恢复后的二维数组");
    for (int i = 0; i < chessArr2.length; i++) {
      for (int j = 0; j < chessArr2[i].length; j++) {
        System.out.printf(String.valueOf(chessArr2[i][j]));
      }
      System.out.println();
    }
  }
}
