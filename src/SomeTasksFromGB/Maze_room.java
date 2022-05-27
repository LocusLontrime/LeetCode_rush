package SomeTasksFromGB;

public class Maze_room {

    boolean top; // is there a wall at the top of the room? true=yes, false = no
    boolean left; // so on
    boolean bottom; //...
    boolean right; //...

    public Maze_room (boolean top, boolean left, boolean bottom, boolean right) {
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

}
