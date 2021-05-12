package inloop.functions;

public class Functions {

    public static int factorial (int n) {
        int fac = 1;
        for (int i= 2; i<=n; i++) {
            fac = fac * i;
        }
        return fac;
    }
}