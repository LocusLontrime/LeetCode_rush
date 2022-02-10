public class Translation_String_Builder {

    public static void main(String[] args) {

    }

    public static String dec_to_n (int new_system_base, int number) {

        StringBuilder builder = new StringBuilder();

        while (number > 0) {

            builder.insert(0, number%new_system_base + " ");
            number /= new_system_base;

        }

        return builder.toString();

    }

}
