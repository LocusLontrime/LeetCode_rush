public class Translation {

    public static void main(String[] args) {

        int[] array = dec_to_n_array(16, 999);
        System.out.print("999 (hex) = ");
        array_print(array);

        array = dec_to_n_array(3, 28);
        System.out.print("28 (3) = ");
        array_print(array);

        array = dec_to_n_array(2, 1024);
        System.out.print("1024 (bin) = ");
        array_print(array);

        array = dec_to_n_array(2, 1023);
        System.out.print("1023 (bin) ");
        array_print(array);
    }

    public static int[] dec_to_n_array (int new_system_base, int number) {

        if (number == 0) return new int[] {0}; // if number equals zero -> its n-ary representations will be consisted of the only one symbol - zero

        if (new_system_base <= 0 || new_system_base == 1) { // base number restriction
            System.out.println("New system base cannot be less than 2");
            return null;
        }

        int [] array = new int[(int) (Math.log(number)/Math.log(new_system_base)) + 1]; // we are defining capacity of the array created
        int counter = 0;

        while (number > 0) { // integer division with reminder and array's fulfilling
            array[array.length - 1 - counter] = number % new_system_base;
            number /= new_system_base;
            counter ++;
        }

        return array;
    }

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }

}
