package classes_methods_4;

public class Max3 {
    public static int max3(int x, int y, int z) {
        int max =x;
        if (y>x) max=y;
        if (z>max) max=z;
        return max;

    }

}
