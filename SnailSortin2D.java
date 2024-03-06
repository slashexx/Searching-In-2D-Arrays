import java.util.Arrays;
import java.util.Scanner;

public class SnailSortin2D{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the dimensions of the matrix : ");
        int m = in.nextInt(), n = in.nextInt();

        int[][] arr = new int[m][n];

        System.out.println("Enter the values of matrix : ");
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int[] result = snailsort(arr);

        System.out.println("The sorted 1D array is : " + Arrays.toString(result));

    }

    public static int[] snailsort(int[][] matrix) {
        if (matrix[0].length==0){
            return new int[0];
        } else{
            int n = matrix.length;
            int[] arr = new int[n*n];
            int count=0;

            for (int i = 0; i < n/2; i++) {
                for(int j=i; j<n-i; j++) arr[count++] = matrix[i][j];
                for(int j=i+1; j< n-i; j++) arr[count++] = matrix[j][n - i - 1];
                for(int j = i+1; j<n-i; j++) arr[count++] = matrix[n - i - 1][n - j - 1];
                for(int j = i+1; j< n-i-1; j++) arr[count++] = matrix[n - j - 1][i];
            }
            if(n%2 !=0){
                arr[count++] = matrix[n/2][n/2];
            }

            Arrays.sort(arr);
            return arr;
        }

    }
}
