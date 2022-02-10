public class The_Dog_2 {
    public static void main(String[] args) { // concept with dog reaction timing
        double count = 0;
        double va = 1, vb = 2, v = 5;
        double length = 1000, dog_length = 10, minimal_turning_back_time = 1.0d; // the time of turning back

        int xA, xB; // just for convenience, not for coding

        double xa = 0, xb = length;

        while (xb - xa > dog_length) { // algorithm from dog_1 class needs some improvement

            if (count % 2 == 0) {
                xb -= vb * (xb - xa)/(v + vb);
                xb -= vb * minimal_turning_back_time;
                xa += va * (xb - xa)/(v + vb);
                xa += vb * minimal_turning_back_time;
            }
            else {
                xa += va * (xb - xa)/(v + va);
                xa += vb * minimal_turning_back_time;
                xb -= vb * (xb - xa)/(v + va);
                xb -= vb * minimal_turning_back_time;
            }

            xA = (int) xa;
            xB = (int) xb;

            System.out.println("xa = " + xA + " xb = " + xB);

            count ++;
        }

        System.out.println("Counter equals " + count);

    }
}
