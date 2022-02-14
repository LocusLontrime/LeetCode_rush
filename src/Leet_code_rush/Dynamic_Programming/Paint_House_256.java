package Leet_code_rush.Dynamic_Programming;

public class Paint_House_256 {

    static int[][] costsMatrix;
    static int[][] memoTable;
    static int housesQuantity;

    public static void main(String[] args) { /** accepted (speed: 1ms, fast) **/

        long finish1 = System.nanoTime();

        System.out.println(minCost(new int[][] {{17,2,17},{16,16,5},{14,3,19},{15,15,15},{19,3,1},{1,1,5},{19,1,18},{19,2,17},{17,2,17},{16,16,5},{14,3,19},
                {15,15,15},{19,3,1},{1,1,5},{19,1,18},{19,2,17},{17,2,17},{16,16,5},{14,3,19},{15,15,15},{19,3,1},{1,1,5},{19,1,18},{19,2,17},{17,2,17},
                {16,16,5},{14,3,19},{15,15,15},{19,3,1},{1,1,5},{19,1,18},{19,2,17},{17,2,17},{16,16,5},{14,3,19},{15,15,15},{19,3,1},{1,1,5},{19,1,18},
                {19,2,17},{17,2,17},{16,16,5},{14,3,19},{15,15,15},{19,3,1},{1,1,5},{19,1,18},{19,2,17},{17,2,17},{16,16,5},{14,3,19},{15,15,15},{19,3,1},
                {1,1,5},{19,1,18},{19,2,17},{17,2,17},{16,16,5},{14,3,19},{15,15,15},{19,3,1},{1,1,5},{19,1,18},{19,2,17},{17,2,17},{16,16,5},{14,3,19},
                {15,15,15},{19,3,1},{1,1,5},{19,1,18},{19,2,17},{17,2,17},{16,16,5},{14,3,19},{15,15,15},{19,3,1},{1,1,5},{19,1,18},{19,2,17},{17,2,17},
                {16,16,5},{14,3,19},{15,15,15},{19,3,1},{1,1,5},{19,1,18},{19,2,17}}));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

        System.out.println(minCost(new int[][] {{7,6,2}}));

        System.out.println(minCost(new int[][] {{17,2,17},{16,16,5},{14,3,19}}));

    }

    public static int minCost(int[][] costs) {

        costsMatrix = costs;

        memoTable = new int[costs.length][3];

        housesQuantity = costsMatrix.length;

        return Math.min(Math.min(recursiveSeeker(housesQuantity - 1, Colour.RED), recursiveSeeker(housesQuantity - 1, Colour.GREEN)),
                recursiveSeeker(housesQuantity - 1, Colour.BLUE));
    }

    public static int recursiveSeeker (int i, Colour colour) {

        if (i == 0) {
            switch (colour) {
                case RED: return costsMatrix[0][0];
                case GREEN: return costsMatrix[0][1];
                case BLUE: return costsMatrix[0][2];
            }
        }

        int k ;

        switch (colour) {
            case RED: k = 0;
                break;
            case GREEN: k = 1;
                break;
            case BLUE: k = 2;
                break;
            default: k = 4;
        }

        if (memoTable[i][k] == 0) {

            switch (colour) {
                case RED: memoTable[i][k] = Math.min(recursiveSeeker(i - 1, Colour.GREEN), recursiveSeeker(i - 1, Colour.BLUE)) +
                        costsMatrix[i][0];
                    break;
                case GREEN: memoTable[i][k] = Math.min(recursiveSeeker(i - 1, Colour.RED), recursiveSeeker(i - 1, Colour.BLUE)) +
                        costsMatrix[i][1];
                    break;
                case BLUE: memoTable[i][k] = Math.min(recursiveSeeker(i - 1, Colour.RED), recursiveSeeker(i - 1, Colour.GREEN)) +
                        costsMatrix[i][2];
                    break;
            }
        }

        return memoTable[i][k];
    }

    public enum Colour {
        RED,
        GREEN,
        BLUE,
        // DEFAULT
    }

}
