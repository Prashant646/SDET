package interview;


public class Mainclass implements Function1 {

    public Mainclass() {

    }

    public static void main(String[] args) {
        System.out.println(Function1.name);
    }

    // Function to print all the permutations of str
    static void printPermutn(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            printPermutn(ros, ans + ch);
        }
    }
}
