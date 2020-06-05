package Common;

import Utils.PrintUtil;

public class SimpleRecursion {

    public static void main(String[] args) {
        int summation = summation(5);
        PrintUtil.print(summation);
        int multi = multi(4);
        PrintUtil.print(multi);
    }

    public static int summation(int n) {
        if (n > 1) {
            return n + summation(n - 1);
        }else {
            return n;
        }
    }

    public static int multi(int n){
        if (n>1){
            return n*multi(n-1);
        }else {
            return n;
        }
    }
}
