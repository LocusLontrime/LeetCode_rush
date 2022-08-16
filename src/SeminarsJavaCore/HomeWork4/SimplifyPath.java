package SeminarsJavaCore.HomeWork4;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {

        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
    }

    public static String simplifyPath(String path) {

        // Stack for directories' names
        Stack<String> directories = new Stack<String>();
        // splits the initial string on "/" as the delimiter
        String[] elements = path.split("/"); // some empty strings can be produced

        // cycling all over the split string
        for (String directory : elements) {

            // does nothing for "."-case or an empty string
            if (directory.equals(".") || directory.isEmpty()) {

                continue;
            } else if (directory.equals("..")) {

                // for ".."-case we should pop an entry from the stack if it's non-empty at the time being
                if (!directories.isEmpty()) {
                    directories.pop();
                }
            } else {

                // ads valid directory name to the stack
                directories.add(directory);
            }
        }

        // Builds a result path, gathering directories all together
        StringBuilder canonicalPath = new StringBuilder();
        for (String directory : directories) {
            canonicalPath.append("/");
            canonicalPath.append(directory);
        }

        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }
}
