package SomeTasksFromGB;

import Other.Vector_of_movement;

public class Maze {

    final static int x_max = 5;
    final static int y_max = 4;

    final static Maze_room[][] maze_rooms = new Maze_room[x_max][y_max]; // all the maze described here

    static { // defining of the rooms, this kind of algorithm works for simply-connected maze without loops and unreachable areas: there is the only one way from one random room to another.
        maze_rooms[0][0] = new Maze_room(false,true,false,true); // the most routine part
        maze_rooms[1][0] = new Maze_room(true,true,false,false); // thus, we define every room
        maze_rooms[2][0] = new Maze_room(true,false,false,true); // all the room consist of 4 walls
        maze_rooms[3][0] = new Maze_room(true,true,false,false); // every wall can exist or not
        maze_rooms[4][0] = new Maze_room(true,false,false,true); // true or false
        maze_rooms[0][1] = new Maze_room(false,true,true,false);
        maze_rooms[1][1] = new Maze_room(false,false,true,true);
        maze_rooms[2][1] = new Maze_room(false,true,true,false);
        maze_rooms[3][1] = new Maze_room(false,false,true,true);
        maze_rooms[4][1] = new Maze_room(false,true,false,true);
        maze_rooms[0][2] = new Maze_room(true,true,true,false);
        maze_rooms[1][2] = new Maze_room(true,false,true,false);
        maze_rooms[2][2] = new Maze_room(true,false,false,false);
        maze_rooms[3][2] = new Maze_room(true,false,true,false);
        maze_rooms[4][2] = new Maze_room(false,false,true,true);
        maze_rooms[0][3] = new Maze_room(true,true,true,false);
        maze_rooms[1][3] = new Maze_room(true,false,true,false);
        maze_rooms[2][3] = new Maze_room(false,false,true,false);
        maze_rooms[3][3] = new Maze_room(true,false,true,false);
        maze_rooms[4][3] = new Maze_room(true,false,true,false);
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {

        Vector_of_movement current_direction = Vector_of_movement.LEFT; // the direction a stranger has while entering the maze given
        int x = 4; //x coordinate in the rooms massive / defining the starting position
        int y = 3; //y coordinate in the room massive / defining the starting position

        while (x!= 0 || y!= 0) { // easy algorithm based on the "left-hand rule"

            System.out.println("Now entering the room: (" + ANSI_PURPLE + x + ANSI_RESET + "," + ANSI_PURPLE + y + ANSI_RESET + ")........................................");
            System.out.println("The current direction is: " + ANSI_GREEN + current_direction + ANSI_RESET);

            switch (current_direction) {

                case TOP:
                    if (maze_rooms[x][y].left) { // is there a wall on the lift side of the room?
                        if (maze_rooms[x][y].top) { // if yes - then answer is there a wall in front of a stranger?
                            current_direction = Vector_of_movement.RIGHT; // if yes - then turn to the right
                            System.out.println(ANSI_BLUE + "turning to the right" + ANSI_RESET);
                        } else {
                            y--; // if no - then go ahead
                            System.out.println(ANSI_BLUE + "going ahead" + ANSI_RESET);
                        }
                    } else { // if no wall on the left side
                        current_direction = Vector_of_movement.LEFT; // then turn to the left
                        System.out.println(ANSI_BLUE + "turning to the left" + ANSI_RESET);
                        if (maze_rooms[x][y].left) { // answer is there a wall in front of a stranger?
                            current_direction = Vector_of_movement.BOTTOM; // if yes - then turn to the left
                            System.out.println(ANSI_BLUE + "turning to the left" + ANSI_RESET);
                        } else {
                            x--; // if no - then go ahead
                            System.out.println(ANSI_BLUE + "going ahead" + ANSI_RESET);
                        }
                    }
                    break;
                case LEFT:
                    if (maze_rooms[x][y].bottom) {
                        if (maze_rooms[x][y].left) {
                            current_direction = Vector_of_movement.TOP;
                            System.out.println(ANSI_BLUE + "turning to the right" + ANSI_RESET);
                        } else {
                            x--;
                            System.out.println(ANSI_BLUE + "going ahead" + ANSI_RESET);
                        }
                    } else {
                        current_direction = Vector_of_movement.BOTTOM;
                        System.out.println(ANSI_BLUE + "turning to the left" + ANSI_RESET);
                        if (maze_rooms[x][y].bottom) {
                            current_direction = Vector_of_movement.RIGHT;
                            System.out.println(ANSI_BLUE + "turning to the left" + ANSI_RESET);
                        } else {
                            y++;
                            System.out.println(ANSI_BLUE + "going ahead" + ANSI_RESET);
                        }
                    }
                    break;
                case BOTTOM:
                    if (maze_rooms[x][y].right) {
                        if (maze_rooms[x][y].bottom) {
                            current_direction = Vector_of_movement.LEFT;
                            System.out.println(ANSI_BLUE + "turning to the right" + ANSI_RESET);
                        } else {
                            y++;
                            System.out.println(ANSI_BLUE + "going ahead" + ANSI_RESET);
                        }
                    } else {
                        current_direction = Vector_of_movement.RIGHT;
                        System.out.println(ANSI_BLUE + "turning to the left" + ANSI_RESET);
                        if (maze_rooms[x][y].right) {
                            current_direction = Vector_of_movement.TOP;
                            System.out.println(ANSI_BLUE + "turning to the left" + ANSI_RESET);
                        } else {
                            x++;
                            System.out.println(ANSI_BLUE + "going ahead" + ANSI_RESET);
                        }
                    }
                    break;
                case RIGHT:
                    if (maze_rooms[x][y].top) {
                        if (maze_rooms[x][y].right) {
                            current_direction = Vector_of_movement.BOTTOM;
                            System.out.println(ANSI_BLUE + "turning to the right" + ANSI_RESET);
                        } else {
                            x++;
                            System.out.println(ANSI_BLUE + "going ahead" + ANSI_RESET);
                        }
                    } else {
                        current_direction = Vector_of_movement.TOP;
                        System.out.println(ANSI_BLUE + "turning to the left" + ANSI_RESET);
                        if (maze_rooms[x][y].top) {
                            current_direction = Vector_of_movement.LEFT;
                            System.out.println(ANSI_BLUE + "turning to the left" + ANSI_RESET);
                        } else {
                            y--;
                            System.out.println(ANSI_BLUE + "going ahead" + ANSI_RESET);
                        }
                    }
                    break;
            }

        }

        System.out.println(ANSI_RED + "We have won!" + ANSI_RESET);

    }
}
