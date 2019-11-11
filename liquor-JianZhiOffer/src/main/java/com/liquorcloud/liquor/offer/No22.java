package com.liquorcloud.liquor.offer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * @author zzc
 */
public class No22 {
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        int[][] a= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        System.out.println(printMatrix(a));
    }

    private static ArrayList<Integer> printMatrix(int[][] matrix) {
            if(matrix.length <= 0){return null;}
            return printMatrixRecu(matrix,0);
    }

    private static ArrayList<Integer> printMatrixRecu(int[][] matrix,int start){

        int row = matrix.length;//行数
        int col = matrix[0].length;//列数
        int xEnd = col-start-1;//x方向最后一个
        int yEnd = row-start-1;//y方向最后一个

        if(xEnd<start || yEnd<start){
            return result;
        }


        if(start==yEnd){
            //只有一行,从左向右打印即可
            for(int i=start;i<=xEnd;i++){
                result.add(matrix[start][i]);
            }
            return result;
        }
        if(start==xEnd){
            //只有一列，从上向下打印
            for (int i = start;i<=yEnd;i++){
                result.add(matrix[i][start]);
            }
            return result;
        }
        //打印上面横着的那一行，包括最后一个
        for(int i=start;i<=xEnd;i++){
            result.add(matrix[start][i]);
        }
        //打印右面竖着的一列，不包括第一个，包括最后一个
        for (int i = start+1;i<=yEnd;i++){
            result.add(matrix[i][xEnd]);
        }
        //打印下面横着的一行，不包括第一个，包括最后一个
        for (int i=xEnd-1;i>=start;i--){
            result.add(matrix[yEnd][i]);
        }
        //打印左边竖着的一列，不包括第一个，不包括最后一个
        for (int i = yEnd-1;i>start;i--){
            result.add(matrix[i][start]);
        }

        //递归的进去下一层
        return printMatrixRecu(matrix,start+1);
    }

}
