package Code_wars_rush;

public class Shortest_Knight_Path_4kyu { // accepted on codewars.com
    public static int[][] memoTable; // memo table for the recursion
    public static long recCounter; // how many times the recursion has been invoked
    public static final int jSize = 8;
    public static final int iSize = 8;

    public static void main(String[] args) {

        System.out.println(MinStepsToCell(5, 2, 2, 6));
        System.out.println(getCoords("h1")[0] + " " + getCoords("h1")[1]);
        System.out.println(knight("c5", "e6"));
    }

    public static int knight(String start, String finish) { // a3 b4 -> () ()

        int[] startCoords = getCoords(start);
        int[] finishCoords = getCoords(finish);

        return MinStepsToCell(startCoords[0], startCoords[1], finishCoords[0], finishCoords[1]);
    }

    public static int[] getCoords (String info) {

        int[] coords = new int[2];

        char symbol1 = info.charAt(0);
        char symbol2 = info.charAt(1);

        switch (symbol1) {
            case 'a':
                break;
            case 'b':
                coords[1] = 1;
                break;
            case 'c':
                coords[1] = 2;
                break;
            case 'd':
                coords[1] = 3;
                break;
            case 'e':
                coords[1] = 4;
                break;
            case 'f':
                coords[1] = 5;
                break;
            case 'g':
                coords[1] = 6;
                break;
            case 'h':
                coords[1] = 7;
                break;
        }

        switch (symbol2) {
            case '8':
                break;
            case '7':
                coords[0] = 1;
                break;
            case '6':
                coords[0] = 2;
                break;
            case '5':
                coords[0] = 3;
                break;
            case '4':
                coords[0] = 4;
                break;
            case '3':
                coords[0] = 5;
                break;
            case '2':
                coords[0] = 6;
                break;
            case '1':
                coords[0] = 7;
                break;
        }

        return coords;
    }

    public static int MinStepsToCell(int startJ, int startI, int endJ, int endI) // Method for the AddTask2 -> calcs min steps needed for the Knight
    // to reaches the cell (endJ, endI) from the cell (startJ, startI);
    {
        memoTable = new int[jSize][iSize];
        recCounter = 0;

        MemoInit(); // initialization of the memoTable
        RecSeeker(startJ, startI, 0); // recursion call

        System.out.println("MinSteps rec count: " + recCounter);

        return memoTable[endJ][endI]; // returning the resulting value (min steps)
    }

    public static void RecSeeker(int j, int i, int stepsCount) // recursive seeker for building the memoTable of steps needed for the Knight
    // located at the current position
    // to reach the every cell at the Chess-field
    {
        recCounter++; // rec_steps counter

        if (IsCoordsValid(j, i) && stepsCount < memoTable[j][i])
        {
            memoTable[j][i] = stepsCount; // here we fill thr memoTable or change the value if it is needed

            RecSeeker(j - 2, i - 1, stepsCount + 1); // further rec calls
            RecSeeker(j - 2, i + 1, stepsCount + 1);
            RecSeeker(j - 1, i - 2, stepsCount + 1);
            RecSeeker(j - 1, i + 2, stepsCount + 1);
            RecSeeker(j + 1, i - 2, stepsCount + 1);
            RecSeeker(j + 1, i + 2, stepsCount + 1);
            RecSeeker(j + 2, i - 1, stepsCount + 1);
            RecSeeker(j + 2, i + 1, stepsCount + 1);
        }
    }
    // auxiliary method for the one above, checks if the cell is Valid
    public static boolean IsCoordsValid(int j, int i)
    {
        return j >= 0 && i >= 0 && j < memoTable.length && i < memoTable[0].length;
    }
    public static void MemoInit() // initialization of thr memoTable with int.MinValue
    {
        for (int j = 0; j < memoTable.length; j++)
        {
            for (int i = 0; i < memoTable[0].length; i++)
            {
                memoTable[j][i] = Integer.MAX_VALUE;
            }
        }
    }
}
