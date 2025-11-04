package HashTable;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Meric
 * @CreateTime: 2025-10-31
 * @Description: 73. 矩阵置零
 * @Version: 1.0
 */

/**
 * 用哈希表存储0元素的行列位置，再遍历哈希表使得数组元素为0
 */
public class setMatrixZeroes_73 {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, List<Integer>> multiValueMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            multiValueMap.put(i, new ArrayList<>());
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    multiValueMap.get(i).add(j);
                }
            }
        }

        for (Map.Entry <Integer, List<Integer>>  entry : multiValueMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            //此行没有0元素
            if(entry.getValue().size() == 0){
                continue;
            }
            int row = entry.getKey();
            List<Integer> list = entry.getValue();
            //行置零
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }

            //列置零
            for(int j : list){
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean line = false;

        //记录第一行原本是否有0
        for(int i : matrix[0]){
            if(i == 0){
                row = true;
            }
        }

        //记录第一列原本是否有0
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                line = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //每个元素根据行或者列判断是否为0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(row){
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if(line){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    public static void printArr(int[][] arr) {
        //遍历二维数组中每一个一维数组
        for(int[] cells : arr) {
            //遍历一维数组中每一个元素
            for(int cell : cells) {
                System.out.print(cell+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix = { {0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        int[][] matrix2 = {{1,0,3}};
        setZeroes2(matrix2);
        printArr(matrix2);
    }
}
