package Path_finding;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class Wave_maze_solving { // it needs to change 0 to -1 and 1 to 0 in the maze array

    final static int iMax = 10; //1;
    final static int jMax = 10;

    final static int iStart = 3; //0; // starting point coordinates (A point)
    final static int jStart = 7; //0;

    final static int iEnd = 9; //0; // ending point coordinates (B point)
    final static int jEnd = 4; //9;

    static int [][] maze = new int [iMax][jMax]; // 0 for walls and 1 for empty cells

    /* static { line maze check
        maze[0][0] = 0;
        maze[0][1] = 0;
        maze[0][2] = 0;
        maze[0][3] = 0;
        maze[0][4] = 0; // -1 if it is a wall then wave stops
        maze[0][5] = 0;
        maze[0][6] = 0;
        maze[0][7] = 0;
        maze[0][8] = 0;
        maze[0][9] = 0;
    } */

    static { // maze initialization

       for (int i = 0; i  < iMax; i ++) {
           for (int j = 0; j < jMax; j ++) {
               maze[i][j] = 0;
           }
       }

       maze[0][8] = -1;
       maze[0][9] = -1;
       maze[1][9] = -1;
       maze[2][9] = -1;
       maze[4][9] = -1;
       maze[4][8] = -1;
       maze[4][7] = -1;
       maze[7][8] = -1;
       maze[7][7] = -1;
       maze[7][6] = -1;
       maze[7][5] = -1;
       maze[6][5] = -1;
       maze[5][5] = -1;
       maze[4][5] = -1;
       maze[3][5] = -1;
       maze[3][4] = -1;
       maze[3][3] = -1;
       maze[4][0] = -1;
       maze[4][1] = -1;
       maze[3][1] = -1;
       maze[2][1] = -1;
       maze[5][3] = -1;
       maze[7][0] = -1;
       maze[7][1] = -1;
    }

    static List<Pair<Integer, Integer>> frontWave = new ArrayList<>(); // keeps the coordinates of cells which constitute the front wave in the current step of algorithm
    static List<Pair<Integer, Integer>> newFrontWave = new ArrayList<>(); // keeps the new cells found
    static List<Pair<Integer, Integer>> theWayBack = new ArrayList<>(); // here we will be storing all the cells of the restoring way back

    static int waveStepsCounter = 2; // the first step is the initialization of the front wave (point A)

    static int iP, jP; // auxiliary coordinate variables

    static {
        frontWave.add(new Pair<Integer, Integer>(iStart,jStart)); // initialization of the starting front wave
        maze[iStart][jStart] = 1;
    }

    public static void main(String[] args) {

        findWay();

    }

    public static void findWay (/* int [][] maze, int iStart, int jStart, int jEnd, int iEnd */) {

        print2dArray(maze);
        System.out.println();

        while (true) { // body of wave_emitting cycle

            if (maze[iEnd][jEnd] == 0) {

                if (frontWave.size() == 0) {

                    System.out.println("The way between A and B does not exist!");
                    break;

                } else {

                    for (Pair<Integer, Integer> p : frontWave)  { // four-links scheme of wave spreading

                        iP = p.getKey();
                        jP = p.getValue();

                        if (jP + 1 < maze[0].length && maze[iP][jP + 1] == 0) {
                            maze[iP][jP + 1] = waveStepsCounter;
                            newFrontWave.add(new Pair<Integer, Integer>(iP, jP + 1));
                        }

                        if (iP - 1 >= 0 && maze[iP - 1][jP] == 0) {
                            maze[iP - 1][jP] = waveStepsCounter;
                            newFrontWave.add(new Pair<Integer, Integer>(iP - 1, jP));
                        }

                        if (jP - 1 >= 0 && maze[iP][jP - 1] == 0) {
                            maze[iP][jP - 1] = waveStepsCounter;
                            newFrontWave.add(new Pair<Integer, Integer>(iP, jP - 1));
                        }

                        if (iP + 1 < maze.length && maze[iP + 1][jP] == 0) {
                            maze[iP + 1][jP] = waveStepsCounter;
                            newFrontWave.add(new Pair<Integer, Integer>(iP + 1, jP));
                        }

                    }

                    frontWave.clear();
                    frontWave.addAll(newFrontWave);
                    newFrontWave.clear();

                    System.out.print("front wave: ");
                    System.out.println(frontWave);
                    System.out.println();

                    waveStepsCounter++;
                }

            } else { // if the value in B point has been changed we proceed to the pass restoration

                passRestoration();

                break;
            }
        }

        System.out.println();
        print2dArray(maze);
    }

    public static void passRestoration () {

        System.out.println("Pass restored");

        iP = iEnd;
        jP = jEnd;

        System.out.println("B coordinates: (" + iEnd + "," + jEnd + ")" + ", value: " + maze[iP][jP]);

        theWayBack.add(new Pair<Integer, Integer>(iP, jP)); // adding B point to the end of the way back

        for (int i = maze[iP][jP]; i >= 0 ; i--) {
            if (iP != iStart || jP + 1 != jStart) {
                if (jP + 1 < maze[0].length) {
                    if (maze[iP][jP] - maze[iP][jP + 1] == 1) {
                        jP++;
                        theWayBack.add(new Pair<Integer, Integer>(iP, jP));
                        System.out.println("adding (" + iP + "," + jP + ")" + ", cell value: " + (i - 1) + ", " + (waveStepsCounter - i) + "-iteration");
                        continue;
                    }
                }
            } else {
                System.out.println("A coordinates: (" + iStart + "," + jStart + ")" + ", value: " + maze[iStart][jStart]);
                theWayBack.add(new Pair<Integer, Integer>(iP, jP + 1));
                System.out.println("Pass restored");
                System.out.println(theWayBack);
                break;
            }

            if (iP - 1 != iStart || jP != jStart) {
                if (iP - 1 >= 0) {
                    if (maze[iP][jP] - maze[iP - 1][jP] == 1) {
                        iP --;
                        theWayBack.add(new Pair<Integer, Integer>(iP, jP));
                        System.out.println("adding (" + iP + "," + jP + ")" + ", cell value: " + (i - 1) + ", " + (waveStepsCounter - i) + "-iteration");
                        continue;
                    }
                }
            } else {
                System.out.println("A coordinates: (" + iStart + "," + jStart + ")" + ", value: " + maze[iStart][jStart]);
                theWayBack.add( new Pair<Integer, Integer>(iP - 1, jP));
                System.out.println("Pass restored");
                System.out.println(theWayBack);
                break;
            }

            if (iP != iStart || jP - 1 != jStart) {
                if (jP - 1 >= 0) {
                    if (maze[iP][jP] - maze[iP][jP - 1] == 1) {
                        jP --;
                        theWayBack.add(new Pair<Integer, Integer>(iP, jP));
                        System.out.println("adding (" + iP + "," + jP + ")" + ", cell value: " + (i - 1) + ", " + (waveStepsCounter - i) + "-iteration");
                        continue;
                    }
                }
            } else {
                System.out.println("A coordinates: (" + iStart + "," + jStart + ")" + ", value: " + maze[iStart][jStart]);
                theWayBack.add( new Pair<Integer, Integer>(iP, jP - 1));
                System.out.println("Pass restored");
                System.out.println(theWayBack);
                break;
            }

            if (iP + 1 != iStart || jP != jStart) {
                if (iP + 1 < maze.length) {
                    if (maze[iP][jP] - maze[iP + 1][jP] == 1) {
                        iP ++;
                        theWayBack.add( new Pair<Integer, Integer>(iP, jP));
                        System.out.println("adding (" + iP + "," + jP + ")" + ", cell value: " + (i - 1) + ", " + (waveStepsCounter - i) + "-iteration");
                    }
                }
            } else {
                System.out.println("A coordinates: (" + iStart + "," + jStart + ")" + ", value: " + maze[iStart][jStart]);
                theWayBack.add( new Pair<Integer, Integer>(iP + 1, jP));
                System.out.println("Pass restored");
                System.out.println(theWayBack);
                break;
            }
        }
    }

    public static void print2dArray (int [][] array) {
        for (int j = 0; j < array[0].length; j ++) {
            for (int i = 0; i < array.length; i ++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
