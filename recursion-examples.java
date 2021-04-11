public class SubStr {

    static void printSubStr(int[] arr, int i, int n, String osf) {
        if (i == n) {
            System.out.println(osf);
            return;
        }
        printSubStr(arr, i + 1, n, osf);
        printSubStr(arr, i + 1, n, osf + arr[i] + ",");
    }

    static void printStar(int n) {
        if (n == 0) {
            return;
        }
        for (int k = 0; k < n; k++) {
            System.out.print("* ");
        }
        System.out.println();
        printStar(n - 1);
    }

    static void printStarWOLoop(int n, int i) {
        if (n == 0) {
            return;
        }
        if (i < n) {
            System.out.print("* ");
            printStarWOLoop(n, i + 1);
        } else {
            System.out.println();
            printStarWOLoop(n - 1, 0);
        }
    }

    static void checkSort(int[] arr, int n, int i, int j) {
        if (j > (n - 1)) {
            System.out.println("Yes");
            return;
        }
        if (arr[i] < arr[j]) {
            checkSort(arr, n, i + 1, j + 1);
        } else {
            System.out.println("No");
        }
    }

    /*  [start          ]
        [               ]
        [            end]
    */
    static void mazePath(int i, int j, int n, int m, String osf) {
        if (i == m - 1 && j == n - 1) {
            System.out.println(osf);
        }
        if (i > n || j > m) {
            return;
        }
        mazePath(i, j + 1, n, m, "R" + osf);
        mazePath(i + 1, j, n, m, "D" + osf);
        mazePath(i + 1, j + 1, n, m, "X" + osf);
    }

    /*
    Find all paths to reach from 0 to n
    Wherein you can have a jump from {1,2,3,4,5,6}
    * */
    static void dicePath(int i, int n, String osf) {
        if (i >= n) {
            return;
        }
        if (i == n - 1) {
            System.out.println(osf);
            return;
        }
        for (int j = 1; j <= 6; j++) {
            dicePath(i + j, n, osf + j + "->");
            //here we append j at all result
        }
    }

    static void lexiOrder(int n, int i) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        for (int j = (i == 0 ? 1 : 0); j < 9; j++) {
            lexiOrder(n, 10 * i + j);
        }
    }

    static void allSubStr(String str, String osf, int n) {
        if (osf.length() == n) {
            System.out.println(osf);
            return;
        }
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            String ros = str.substring(0, j) + str.substring(j + 1);
            allSubStr(ros, c + osf, n);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3};
        //printSubStr(arr, 0, 3, "");
        //printStar(5);
        //printStarWOLoop(5, 0);
        //checkSort(arr, arr.length, 0, 1);
        //mazePath(0, 0, 3, 3, "");
        //dicePath(0, 4, "");
        //lexiOrder(13, 0);
        //allSubStr("ABC", "", 3);

        //printSubStr2(arr, 0, 3, "");
        //printStar2(5);
        //printStarWOLoop2(5, 0);
        //checkSort2(arr, arr.length - 1, 0, 1);
        //mazePath2(0, 0, 3, 3, "");
    }
}
