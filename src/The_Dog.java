public class The_Dog {
    public static void main(String[] args) { // concept with minimal distance (dog_length) between A and B

        double count = 0;
        double va = 1, vb = 2, v = 5;
        double length = 1000, dog_length = 10;

        int xA, xB;

        double xa = 0, xb = length;

        while (xb - xa > dog_length) {

            if (count % 2 == 0) {
                xb -= vb * (xb - xa)/(v + vb);
                xa += va * (xb - xa)/(v + vb);
            }

            else {
                xa += va * (xb - xa)/(v + va);
                xb -= vb * (xb - xa)/(v + va);
            }

            xA = (int) xa;
            xB = (int) xb;

            System.out.println("xa = " + xA + " xb = " + xB);

            count ++;
        }

        System.out.println("Counter equals " + count);
    }
}
