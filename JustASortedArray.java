import java.util.Arrays;

public class JustASortedArray{
    public static void main(String[] args) {
        int[][] sortedArr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        //To sort an array like this, take the middle column and perform bubble sort on it to reduce the number of rows.
        // Alternatively, you can take the middle row and reduce the number of columns.


        System.out.println(Arrays.toString(search(sortedArr, 9)));



    }
    //search in the row provided between the columns
    static int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target){
        int mid=0;

        while(colStart <= colEnd){
            mid = (colStart+colEnd)/2;

            if(matrix[row][mid]  == target){
                return new int[]{row,mid};
            } else if (matrix[row][mid] > target) {
                colEnd = mid-1;
            } else{
                colStart = mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    static int[] search(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length; //finding the length of only the first row assuming the length of the rest to be same.

        if(rows == 1){
            return binarySearch(matrix, 0, 0, cols-1, target);
        }

        //run the loop till 2 rows are remaining
        int rowStart=0;
        int rowEnd = rows-1;
        int colMid = cols/2;

        while(rowStart < (rowEnd-1)){ //while this is true, it will have more than 2 rows
            int mid = (rowStart+rowEnd)/2;

            if(matrix[mid][colMid] == target){
                return new int[]{mid, colMid};
            } else if (matrix[mid][colMid] <target) {
                rowStart = mid;
            } else {
                rowEnd = mid;
            }

        }
        //now we have two rows
        //check whether the target is in the col of two rows

        if(matrix[rowStart+1][colMid] == target){
            return new int[]{rowStart+1,colMid};
        }

        //search in first half
        if(target <= matrix[rowStart][colMid-1]){
            return binarySearch(matrix, rowStart, 0, colMid-1,target);

        }
        //search in 2nd half
        if(target >= matrix[rowStart][colMid+1] && target <= matrix[rowStart][cols-1]){
            return binarySearch(matrix, rowStart, colMid+1, cols-1, target);

        }
        //search in 3rd half
        if(target <= matrix[rowStart+1][colMid-1]){
            return binarySearch(matrix, rowStart+1, 0, colMid-1, target);

        }
        //search in 4th half
        if(target >= matrix[rowStart+1][colMid+1]){
            return binarySearch(matrix, rowStart+1, colMid+1, cols-1, target);

        }

        return new int[]{-1,-1};

    }
}