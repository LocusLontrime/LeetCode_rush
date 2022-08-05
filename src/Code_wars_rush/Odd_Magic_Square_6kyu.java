package Code_wars_rush;

public class Odd_Magic_Square_6kyu {

    public static void main(String[] args) {

//        currPosition[0]--;
//        currPosition[1]++;
//
//        magicSquare[currPosition[0]][currPosition[1]] = i;

        int[][] matrix = magicSquare(99);

        printMatrix(matrix);
    }

    public static int[][] magicSquare (int dim) {

        int[][] magicSquare = new int[dim][dim];

        int[] currPosition = {0, (dim - 1) / 2};

        magicSquare[currPosition[0]][currPosition[1]] = 1;

        for (int i = 2; i <= dim * dim; i++) {

            // System.out.println(currPosition[0] + " " + currPosition[1] + " " + i);

            if (isValid(new int[]{currPosition[0] - 1, currPosition[1] + 1}, dim)) {
                if (magicSquare[currPosition[0] - 1][currPosition[1] + 1] == 0) {
                    currPosition[0]--;
                    currPosition[1]++;
                }
                else currPosition[0]++;

            }
            else {
                if (currPosition[1] + 1 < dim) {
                    currPosition[0] = dim - 1;
                    currPosition[1]++;
                } else if (currPosition[0] - 1 >= 0) {
                    currPosition[0]--;
                    currPosition[1] = 0;
                } else currPosition[0]++;
            }

            magicSquare[currPosition[0]][currPosition[1]] = i;
        }

        return magicSquare;
    }

    public static boolean isValid(int[] currentCoords, int dim) {
        return currentCoords[0] >= 0 && currentCoords[1] < dim;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
