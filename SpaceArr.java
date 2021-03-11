import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;

public class SpaceArr {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(reader.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> data = new ArrayList<>();
            String[] str_num = reader.readLine().split("\\s");
            for (int k = 0; k < str_num.length; k++) {
                data.add(Integer.parseInt(str_num[k]));
            }

            calculate(n, data);
        }
    }

    private static void calculate(int n, List<Integer> data) {
        Collections.sort(data);
        int sum = 0;
        boolean done = false;
        for (int i = 0; i < n; i++) {
            if (data.get(i) > (i + 1)) {
                System.out.println("second");
                done = true;
                break;
            }
            if (data.get(i) != (i + 1)) {
                sum = sum + abs(data.get(i) - (i + 1));
            }
        }
        if (!done && (sum % 2 == 0)) {
            System.out.println("second");
        } else {
            if(!done)
                System.out.println("first");
        }
    }
}
