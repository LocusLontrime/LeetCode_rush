package Code_wars_rush;

public class Simple_Fun_335_Two_Programmers_And_Gold_5kyu {

    public static void main(String[] args) {

        int[] res = distributionOf(new int[]{140, 649, 340, 982, 105, 86, 56, 610, 340, 879}); // 36 98 989
        int[] res1 = distributionOf(new int[]{10, 1000, 2, 1});
        int[] res2 = distributionOf(new int[]{10, 1000, 2});

        System.out.println(res[0] + " " + res[1]);
        System.out.println(res1[0] + " " + res1[1]);
        System.out.println(res2[0] + " " + res2[1]);
    }

    public static int[] distributionOf(int[] golds) {

        int[] results = new int[2];

        int lP = 0, rP = golds.length - 1;

        while (lP <= rP) {

            if (golds[lP] >= golds[rP]) {

                results[(lP + golds.length - 1 - rP) % 2] += golds[lP++];

            } else {

                results[(lP + golds.length - 1 - rP) % 2] += golds[rP--];

            }
        }

        return results;
    }
}
