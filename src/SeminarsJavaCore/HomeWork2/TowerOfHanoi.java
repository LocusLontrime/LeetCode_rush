package SeminarsJavaCore.HomeWork2;

public class TowerOfHanoi {

    public static void main(String[] args) {

        printHanoiSeqRec("1", "2", "3", 3);

        System.out.println(buildHanoiSeqRec("1", "2", "3", 3));

        System.out.println(buildHanoiSeq("1", "2", "3", 3));
    }

    public static void printHanoiSeqRec(String left, String middle, String right, int depth)
    {
        // border case
        if (depth == 0) return; // eventually we run out of discs...

        // first rec call
        printHanoiSeqRec(left, right, middle, depth - 1); // at first, we relieve the lower disc in the left tower of remained ones

        // do phase
        System.out.printf("Upper disc migration: {%s} -> {%s}\n", left, right); // then we move the largest disc from the left area to the right one

        // second rec call
        printHanoiSeqRec(middle, left, right, depth - 1); // finally we build the right tower, all we need is to move
        // the remained part of the tower from the middle area to the right one
    }

    public static String buildHanoiSeq(String left, String middle, String right, int depth) {
        String res = buildHanoiSeqRec(left, middle, right, depth).toString();
        return res.substring(3, res.length() - 3);
    }

    // one (a bit long) string solution...
    public static StringBuilder buildHanoiSeqRec(String left, String middle, String right, int depth) {return depth != 0 ? buildHanoiSeqRec(left, right, middle, depth - 1).append(String.format("{%s}->{%s}", left, right)).append(buildHanoiSeqRec(middle, left, right, depth - 1)) : new StringBuilder(" | ");}
}
