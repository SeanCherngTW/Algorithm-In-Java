import java.util.Arrays;

/*
 * Primitive data types: byte, short, int, long, float, double, boolean, char
 * Non-primitive data types: String, Arrays, Classes
 * Pass-by-value: primitive data types, String
 * Pass-by-reference: Arrays, Classes
 */

class PassingParametersTest {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        modifyArray(arr);
        System.out.println("Modified Array: " + Arrays.toString(arr)); // It's [9, 9, 3], pass-by-reference

        Score score = new Score(60);
        System.out.println("Original Score: " + score.score);
        modifyScore(score);
        System.out.println("Modified Score: " + score.score); // It's 100, pass-by-reference

        int aInt = 4;
        System.out.println("Original Int: " + aInt);
        modifyInt(aInt);
        System.out.println("Modified Int: " + aInt); // It's 4, pass-by-value

        Integer aInteger = new Integer(5);
        System.out.println("Original Integer: " + aInteger);
        modifyInt(aInteger);
        System.out.println("Modified Integer: " + aInteger); // It's 5, pass-by-value

        String str = "hello";
        System.out.println("Original String: " + str);
        modifyString(str);
        System.out.println("Modified String: " + str); // It's hello, pass-by-value

        // Swap 2 int
        int a = 6;
        int b = 7;
        IntSwap is = new IntSwap(a, b);
        System.out.printf("Original a: %d, b: %d\n", is.a, is.b);
        swap(is);
        System.out.printf("Swapped  a: %d, b: %d\n", is.a, is.b);
    }

    private static void modifyArray(int[] arr) {
        arr[0] = 9;
        arr[1] = 9;
        return;
    }

    private static void modifyInt(int a) {
        a = 9;
        return;
    }

    private static void modifyString(String str) {
        str = "world";
        return;
    }

    private static void modifyScore(Score score) {
        score.score = 100;
        return;
    }

    private static void swap(IntSwap is) {
        int tmp = is.a;
        is.a = is.b;
        is.b = tmp;
        return;
    }
}