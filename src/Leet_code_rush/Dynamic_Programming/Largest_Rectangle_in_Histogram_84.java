package Leet_code_rush.Dynamic_Programming;
import java.util.ArrayDeque;
import java.util.Deque;

public class Largest_Rectangle_in_Histogram_84 {

    public static void main(String[] args) { /** accepted (speed: fast enough) */

        // ArrayDeque test
        Deque<Integer> stack = new ArrayDeque<>(); // here we are creating a stack

        stack.push(19); // some operations with stack
        stack.push(3);
        stack.push(66);
        stack.push(98);

        System.out.println(stack); // printing the main steps
        System.out.println("Pop element = " + stack.pop());
        System.out.println(stack);
        System.out.println("Peek element = " + stack.peek());
        System.out.println(stack);

        // method checking
        int[] array = new int[] {2, 4}; // {6, 7, 5, 2, 4, 5, 9, 3}; // {2, 3, 5, 2, 2, 6, 7, 6}; // {2,4}; // {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(array));
    }

    public static int largestRectangleArea(int[] heights) { // stack - method
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        stack.push(0);

        int maxRectangleArea = 0;
        int currentMaxArea;
        int forPrint;

        for (int i = 1; i < heights.length; i ++) {

            if (stack.peek() != -1 && heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                    forPrint = stack.pop();
                    currentMaxArea = heights[forPrint] * (i - stack.peek() - 1);
                    System.out.println("height = " +  heights[forPrint] + " width = " + (i - stack.peek() - 1));
                    if (maxRectangleArea < currentMaxArea) {
                        maxRectangleArea = currentMaxArea;
                    }
                }
                stack.push(i);
            }
        }

        while (stack.peek() != -1) {
            forPrint = stack.pop();
            currentMaxArea = heights[forPrint] * (heights.length - stack.peek() - 1);
            System.out.println("After for: height = " +  heights[forPrint] + " width = " + (heights.length - stack.peek() - 1));
            if (maxRectangleArea < currentMaxArea) {
                maxRectangleArea = currentMaxArea;
            }
        }

        return maxRectangleArea;

    }
}
