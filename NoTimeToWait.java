import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NoTimeToWait {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int hours_left, exact_hours, time_zones_count;
        String[] s = reader.readLine().split(" ");
        time_zones_count = Integer.parseInt(s[0]);
        exact_hours = Integer.parseInt(s[1]);
        hours_left = Integer.parseInt(s[2]);
        int[] time_zones = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        System.out.println(canBeDone(hours_left, exact_hours, time_zones_count, time_zones));
    }

    private static String canBeDone(int hours_left, int exact_hours, int time_zones_count, int[] time_zones) {
        String can_be_done = "no";
        for (int i = 0; i < time_zones_count; i++) {
            if (hours_left + time_zones[i] >= exact_hours) {
                return "yes";
            }
        }
        return can_be_done;
    }
}
