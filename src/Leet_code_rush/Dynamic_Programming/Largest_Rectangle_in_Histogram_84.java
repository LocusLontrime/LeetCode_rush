package Leet_code_rush.Dynamic_Programming;
import java.util.ArrayDeque;
import java.util.Deque;

public class Largest_Rectangle_in_Histogram_84 {

    public static void main(String[] args) { /** accepted (speed: fast enough) **/
        // method checking
        int[] array = new int[] {6, 7, 5, 2, 4, 5, 9, 3}; // {2, 3, 5, 2, 2, 6, 7, 6}; // {2,4}; // {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(array));
    }

    public static int largestRectangleArea(int[] heights) { // stack - method

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // basic stack element (bottom one)

        int maxRectangleArea = 0;
        int currentMaxArea;
        int forPrint; // just for convenience of printing

        for (int i = 0; i < heights.length; i ++) { // now we start iterating all over the heights[] array

            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {

                forPrint = stack.pop();
                currentMaxArea = heights[forPrint] * (i - stack.peek() - 1);
                System.out.println("height = " +  heights[forPrint] + " width = " + (i - stack.peek() - 1) +
                        "current Max  " + currentMaxArea); // printing current results
                maxRectangleArea = Math.max(maxRectangleArea, currentMaxArea);
            }

            stack.push(i);
        }

        while (stack.peek() != -1) { // we are operating with the stack remained after iterating from the first to the last element of heights[] array

            forPrint = stack.pop();
            currentMaxArea = heights[forPrint] * (heights.length - stack.peek() - 1);

            System.out.println("After for: height = " +  heights[forPrint] + " width = " + (heights.length - stack.peek() - 1));

            maxRectangleArea = Math.max(maxRectangleArea, currentMaxArea); // printing results
        }

        return maxRectangleArea;
    }


































}
