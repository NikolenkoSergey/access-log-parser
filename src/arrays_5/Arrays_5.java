package arrays_5;

public class Arrays_5 {
    public static int[] add(int[] arr, int[] ins, int pos) {
        int[] arr1 = new int[arr.length + ins.length];
        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (i != pos) {
                arr1[i] = arr[j++];
            } else {
                for (int k = 0; k < ins.length; k++) {
                    arr1[i] = ins[k];
                    if (k == ins.length - 1) break;
                    i++;
                }
            }
        }
        return arr1;
    }

    public static int[] add(int[] arr, int x, int pos) {
        int[] arr1 = new int[arr.length + 1];
        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (i != pos) {
                arr1[i] = arr[j++];
            } else {
                arr1[i] = x;
            }
        }
        return arr1;
    }

    public static int[] deleteNegative(int[] arr) {
        int[] arr1 = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                arr1[j] = arr[i];
                j++;
            }
        }
        int[] arr2 = new int[j];
        for (int i = 0; i < j; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }
    public static int[] findAll(int[] arr, int x) {
        int[] arr2 = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==x) {
                arr2[j]=i; j++;
            }
        }
        int[] arr3 = new int[j];
        for (int i = 0; i < j; i++) {
            arr3[i]=arr2[i];
        }
        return arr3;
    }

    public static int[] concat(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i]=arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length+i]=arr2[i];
        }
        return arr3;
    }

    public static int[] reverseBack(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[arr2.length - 1 - i] = arr[i];
        }
        return arr2;
    }

    public static void reverse(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[arr2.length - 1 - i] = arr[i];
        }
        arr = arr2;
    }


    public static boolean palindrom(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != arr[arr.length - 1 - i]) return false;
        return true;
    }

    public static int countPositive(int[] arr) {
        int j = 0;
        for (int i : arr) {
            if (i > 0) j++;
        }
        return j;
    }

    public static int maxAbs(int[] arr) {
        int max = Math.abs(arr[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(i) > Math.abs(max)) max = arr[i];
        }
        return max;
    }

    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }
}
