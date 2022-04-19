import javafx.util.Pair;
import java.util.ArrayList;

public class Wave_maze_solving { // it needs to change 0 to -1 and 1 to 0 in the maze array

    final static int i_max = 10; //1;
    final static int j_max = 10;

    final static int i_start = 3; //0; // starting point coordinates (A point)
    final static int j_start = 7; //0;

    final static int i_end = 9; //0; // ending point coordinates (B point)
    final static int j_end = 4; //9;

    static int [][] maze = new int [i_max][j_max]; // 0 for walls and 1 for empty cells

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

       for (int i = 0; i  < i_max; i ++) {
           for (int j = 0; j < j_max; j ++) {
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

    static ArrayList<Pair<Integer, Integer>> front_wave = new ArrayList<>(); // keeps the coordinates of cells which constitute the front wave in the current step of algorithm
    static ArrayList<Pair<Integer, Integer>> new_front_wave = new ArrayList<>(); // keeps the new cells found
    static ArrayList<Pair<Integer, Integer>> the_way_back = new ArrayList<>(); // here we will be storing all the cells of the restoring way back

    static int wave_steps_counter = 2; // the first step is the initialization of the front wave (point A)

    static int iP, jP; // auxiliary coordinate variables

    static {
        front_wave.add(new Pair<Integer, Integer>(i_start,j_start)); // initialization of the starting front wave
        maze[i_start][j_start] = 1;
    }

    public static void main(String[] args) {

        print_2D_array(maze);
        System.out.println();

        while (true) { // body of wave_emitting cycle

            if (maze[i_end][j_end] == 0) {

                if (front_wave.size() == 0) {

                    System.out.println("The way between A and B does not exist!");
                    break;

                } else {

                    for (Pair<Integer, Integer> p : front_wave)  { // four-links scheme of wave spreading

                        iP = p.getKey();
                        jP = p.getValue();

                        if (jP + 1 < maze[0].length && maze[iP][jP + 1] == 0) {
                            maze[iP][jP + 1] = wave_steps_counter;
                            new_front_wave.add(new Pair<Integer, Integer>(iP, jP + 1));
                        }

                        if (iP - 1 >= 0 && maze[iP - 1][jP] == 0) {
                            maze[iP - 1][jP] = wave_steps_counter;
                            new_front_wave.add(new Pair<Integer, Integer>(iP - 1, jP));
                        }

                        if (jP - 1 >= 0 && maze[iP][jP - 1] == 0) {
                            maze[iP][jP - 1] = wave_steps_counter;
                            new_front_wave.add(new Pair<Integer, Integer>(iP, jP - 1));
                        }

                        if (iP + 1 < maze.length && maze[iP + 1][jP] == 0) {
                            maze[iP + 1][jP] = wave_steps_counter;
                            new_front_wave.add(new Pair<Integer, Integer>(iP + 1, jP));
                        }

                    }

                    front_wave.clear();
                    front_wave.addAll(new_front_wave);
                    new_front_wave.clear();

                    System.out.print("front wave: ");
                    System.out.println(front_wave);
                    System.out.println();

                    wave_steps_counter++;
                }

            } else { // if the value in B point has been changed we proceed to the pass restoration

                pass_restoration();

                break;
            }
        }

        System.out.println();
        print_2D_array(maze);
    }

    public static void wave_spreading_step () { // turned to be unnecessary

    }

    public static void pass_restoration () {

        System.out.println("Pass restored");

        iP = i_end;
        jP = j_end;

        System.out.println("B value is " + maze[iP][jP]);

        the_way_back.add(new Pair<Integer, Integer>(iP, jP)); // adding B point to the end of the way back

        for (int i = maze[iP][jP]; i >= 0 ; i --) {
            if (iP != i_start || jP + 1 != j_start) {
                if (jP + 1 < maze[0].length) {
                    if (maze[iP][jP] - maze[iP][jP + 1] == 1) {
                        jP++;
                        the_way_back.add(new Pair<Integer, Integer>(iP, jP));
                        System.out.println("adding (" + iP + "," + jP + ") " + i + "-iteration");
                        continue;
                    }
                }
            } else {
                the_way_back.add( new Pair<Integer, Integer>(iP, jP + 1));
                System.out.println("Pass restored");
                System.out.println(the_way_back);
                break;
            }

            if (iP - 1 != i_start || jP != j_start) {
                if (iP - 1 >= 0) {
                    if (maze[iP][jP] - maze[iP - 1][jP] == 1) {
                        iP --;
                        the_way_back.add(new Pair<Integer, Integer>(iP, jP));
                        System.out.println("adding (" + iP + "," + jP + ") " + i + "-iteration");
                        continue;
                    }
                }
            } else {
                the_way_back.add( new Pair<Integer, Integer>(iP - 1, jP));
                System.out.println("Pass restored");
                System.out.println(the_way_back);
                break;
            }

            if (iP != i_start || jP - 1 != j_start) {
                if (jP - 1 >= 0) {
                    if (maze[iP][jP] - maze[iP][jP - 1] == 1) {
                        jP --;
                        the_way_back.add(new Pair<Integer, Integer>(iP, jP));
                        System.out.println("adding (" + iP + "," + jP + ") " + i + "-iteration");
                        continue;
                    }
                }
            } else {
                the_way_back.add( new Pair<Integer, Integer>(iP, jP - 1));
                System.out.println("Pass restored");
                System.out.println(the_way_back);
                break;
            }

            if (iP + 1 != i_start || jP != j_start) {
                if (iP + 1 < maze.length) {
                    if (maze[iP][jP] - maze[iP + 1][jP] == 1) {
                        iP ++;
                        the_way_back.add( new Pair<Integer, Integer>(iP, jP));
                        System.out.println("adding (" + iP + "," + jP + ") " + i + "-iteration");
                    }
                }
            } else {
                the_way_back.add( new Pair<Integer, Integer>(iP + 1, jP));
                System.out.println("Pass restored");
                System.out.println(the_way_back);
                break;
            }
        }
    }

    public static void print_2D_array (int [][] array) {
        for (int j = 0; j < array[0].length; j ++) {
            for (int i = 0; i < array.length; i ++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
