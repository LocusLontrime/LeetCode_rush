package SomeTasksFromGB;

public class Tutorial {

    public static void main(String[] args) {

        int [] array = {1, 2, 3, 4, 5, 6, 7};

        print_array(array);

        mirror_reverse(array);

        print_array(array);


    }

    public static void mirror_reverse (int [] array) {

        int i = 0;
        int temp;

        while (i < array.length - 1 - i) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;

            i ++;
        }

    }

    public static void print_array (int [] array) {
        for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
        System.out.println();
    }

}
