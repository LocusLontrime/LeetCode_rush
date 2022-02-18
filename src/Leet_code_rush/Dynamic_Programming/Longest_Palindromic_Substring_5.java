package Leet_code_rush.Dynamic_Programming;

public class Longest_Palindromic_Substring_5 {

    public static void main(String[] args) {
        String s = "aabacabaatttt"; //"anmbbgtabbffbbabbjoffat";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeManacherAlgo(s));

    }

    public static String longestPalindrome(String s) { /** accepted (speed: 63ms, average) **/
        // a pre-step before the fastest Manacher's algo
        String sModified = "";

        for (int i = 0; i < s.length(); i++) {
            sModified = sModified.concat(i != s.length() - 1 ? "|".concat(s.substring(i, i + 1)) : "|".concat(s.substring(i, i + 1)).concat("|"));
        }

        int currentRadius;
        int maxRadius = 0;
        int maxRadiusCenter = 0;

        for (int center = 0; center < sModified.length(); center++) {
            currentRadius = 0;

            while (center - currentRadius >= 0 && center + currentRadius < sModified.length() &&
                    sModified.charAt(center - currentRadius) == sModified.charAt(center + currentRadius)) {
                currentRadius++;
            }

            if (maxRadius < currentRadius) {
                maxRadius = currentRadius;
                maxRadiusCenter = center;
            }
        }

        return sModified.substring(maxRadiusCenter - maxRadius + 1, maxRadiusCenter + maxRadius).replace("|", "");
    }

    public static String longestPalindromeManacherAlgo(String s) { /** accepted (speed: 21ms, very fast) may be increased by decreasing the number of conditions **/

        String sModified = "";

        for (int i = 0; i < s.length(); i++) {
            sModified = sModified.concat(i != s.length() - 1 ? "|".concat(s.substring(i, i + 1)) : "|".concat(s.substring(i, i + 1)).concat("|"));
        }

        System.out.println(sModified);

        int[] maxRadii = new int[sModified.length()];

        int center = 0;
        int maxPalindromeCenter = 0;
        int currentRadius = 0;
        int maxRadius = 0;

        int oldCenter;
        int oldMaxRadius;

        while (center < sModified.length()) {

            while (center - (currentRadius) >= 0 && center + (currentRadius) < sModified.length() &&
                    sModified.charAt(center - currentRadius) == sModified.charAt(center + currentRadius)) {
                currentRadius++;
            }

            currentRadius--; // one step back (we may change the cycling condition, but it will require more actions)

            maxRadii[center] = currentRadius;
            if (maxRadius < currentRadius) {
                maxRadius = currentRadius;
                maxPalindromeCenter = center;
                System.out.println("maxRadius = " + maxRadius + " maxPalindromeCenter = " + maxPalindromeCenter );
            }

            oldCenter = center; // saved copy of center
            oldMaxRadius = currentRadius; // saved copy of maxCurrentRadius

            center++; // a one step to the right
            currentRadius = 0; // nullification current radius, we are now proceeding to the "mirror" section
            // of palindrome analysis

            while (center <= oldCenter + oldMaxRadius) { // the main cycling condition, while we are inside oldMaxPalindrome,
                // we can use some previously calculated values to fasten the algo

                int mirroredCenter = oldCenter - (center - oldCenter);
                int maxMirroredRadius = oldCenter + oldMaxRadius - center;

                if (maxRadii[mirroredCenter] < maxMirroredRadius) { // if mirroredMaxPalindrome located inside oldMaxPalindrome then
                    // we can return maxRadii[mirroredCenter];

                    maxRadii[center] = maxRadii[mirroredCenter];
                    if (maxRadius < maxRadii[mirroredCenter]) {
                        maxRadius = maxRadii[mirroredCenter];
                        maxPalindromeCenter = center;
                    }
                    center++;

                } else if (maxRadii[mirroredCenter] > maxMirroredRadius) { // if mirroredMaxPalindrome extends beyond the border of oldMaxPalindrome then
                    // we can say that maxRadius of newPalindrome located around the center has maxRadius equals maxMirroredRadius,
                    // as the symbols at the edges of oldMaxPalindrome are different, because it is a max possible palindrome
                    // located in the oldCenter point

                    maxRadii[center] = maxMirroredRadius;
                    if (maxRadius < maxMirroredRadius) {
                        maxRadius = maxMirroredRadius;
                        maxPalindromeCenter = center;
                    }
                    center++;


                } else { // bottleneck point -> here we cannot predict a length of maxPalindrome located around the center, but
                    // we can continue calculating its length from maxMirroredRadius

                    currentRadius = maxMirroredRadius;

                    break; // we can break the cycle early

                }

            }

        }

        return sModified.substring(maxPalindromeCenter - maxRadius + 1, maxPalindromeCenter + maxRadius).replace("|", "");

    }

}
