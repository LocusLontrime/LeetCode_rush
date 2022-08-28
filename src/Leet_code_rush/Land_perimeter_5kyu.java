package Leet_code_rush;

public class Land_perimeter_5kyu {

    public static void main(String[] args) {

        String[] strs = new String[] { // p = 60
                "OXOOOX",
                "OXOXOO",
                "XXOOOX",
                "OXXXOO",
                "OOXOOX",
                "OXOOOO",
                "OOXOOX",
                "OOXOOO",
                "OXOOOO",
                "OXOOXX"
        };

        System.out.println(landPerimeter(strs));
    }


    public static int landPerimeter(String[] arr) {
        char[][] charArray = new char[arr.length][arr[0].length()];

        for (int j = 0; j < arr.length; j ++) {
            for (int i = 0; i < arr[j].length(); i++) {
                charArray[j][i] = arr[j].charAt(i);
            }
        }

        return landPerimeterAuxiliary(charArray);
    }

    public static int landPerimeterAuxiliary(char[][] arr) {
        int xsQuantity = 0;
        int bridgesQuantity = 0;

        for(int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[0].length; i++) {

                if (arr[j][i] == 'X') xsQuantity++;

                if (i != arr[0].length - 1 && arr[j][i] == 'X' && arr[j][i + 1] == 'X') {
                    bridgesQuantity++;
                }

                if (j != arr.length - 1 && arr[j][i] == 'X' && arr[j + 1][i] == 'X') {
                    bridgesQuantity++;
                }
            }
        }

        return 4 * xsQuantity - 2 * bridgesQuantity;
    }
}
