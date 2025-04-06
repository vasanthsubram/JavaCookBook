package collection_lambda.collection.array;

import java.util.Arrays;

public class TwoDArrayExample {
    public static void main(String[] args) {
        // Declare and initialize a 2D array (3 rows x 2 columns)
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6, 7}
        };

        System.out.println("1st row -> " + Arrays.toString(matrix[0]));
        System.out.println("2nd row -> " + Arrays.toString(matrix[1]));
        System.out.println("3rd row -> " + Arrays.toString(matrix[2]));

        // Print the array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }
    }
}
