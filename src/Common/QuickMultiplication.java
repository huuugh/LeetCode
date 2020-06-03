package Common;

import Utils.PrintUtil;

public class QuickMultiplication {

    public static void main(String[] args) {
        int i = quickMulti(3, 3);
        PrintUtil.print(i);
    }

    public static int quickMulti(int a, int b) {
        int sum = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                sum = sum + a;
            }
            b = b >> 1;
            a = a << 1;
        }
        return sum;
    }
}
