import java.util.Arrays;

public class RowAndColSortedArray {
    public static void main(String[] args) {

        int[][] matrix = {
                {10, 20, 30, 40},
                {11, 24, 33, 42},
                {20, 27, 37, 49},
                {25, 33, 48, 50}
        };

        System.out.println("The matrix is : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
//
        int[] result = search(matrix, 48);

        if (result[0] == -1 && result[1] == -1) {
            System.out.println("Key not found in the matrix");
        } else {
            result[0] = result[0] + 1;
            result[1] = result[1] + 1;
            System.out.println("The position of the target in the matrix is : " + Arrays.toString(result));
        }

    }

    static int[] search(int[][] matrix, int target) {
        int r=0;
        int c = matrix.length-1;

        while(r < matrix.length && c>=0){
            if(matrix[r][c] == target){
                return new int[]{r,c};
            } else if (matrix[r][c]<target) {
                r++;
            } else{
                c--;
            }
        }
        return new int[]{-1,-1};

    }
}