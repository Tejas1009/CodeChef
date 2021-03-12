import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.abs;

public class collegelife4 {
    int n, e, h, a, b, c;
    int c_cake, c_shake, o, item_prepared = 0, cost = 0;

    public collegelife4(int n, int e, int h, int a, int b, int c) {
        this.n = n;
        this.e = e;
        this.h = h;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(reader.readLine());
        for (int i = 0; i < tc; i++) {
            int[] s = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int n = s[0], e = s[1], h = s[2], a = s[3], b = s[4], c = s[5];
            collegelife4 cl = new collegelife4(n, e, h, a, b, c);
            cl.calculate();
        }
    }

    private void execute() {
        if (a <= b && a <= c) {
            this.executeA();
            if (b <= c) {
                this.executeB();
                this.executeC();
            } else {
                this.executeC();
                this.executeB();
            }
        } else if (b <= a && b <= c) {
            this.executeB();
            if (a <= c) {
                this.executeA();
                this.executeC();
            } else {
                this.executeC();
                this.executeA();
            }
        } else {
            this.executeC();
            if (b <= a) {
                this.executeB();
                this.executeA();
            } else {
                this.executeA();
                this.executeB();
            }
        }
    }

    private void executeA() {
        this.calculate_o();
    }

    private void executeB() {
        this.calculate_c_shake();
    }

    private void executeC() {
        this.calculate_c_cake();
    }

    private void calculate() {
        this.execute();
        if (this.c_shake + this.c_cake + this.o < this.n) {
            System.out.println(-1);
        } else {
            int r = this.o * this.a;
            r = r + (this.c_shake * this.b);
            r = r + (this.c_cake * this.c);
            System.out.println(cost);
        }
    }

    private void calculate_c_cake() {
        this.c_cake = Math.min(this.e, this.h);
        this.e = this.e - this.c_cake;
        this.h = this.h - this.c_cake;
        this.addPreparedItems(this.c_cake, this.c);
    }

    private void calculate_c_shake() {
        this.c_shake = this.h / 3;
        this.h = this.h % 3;
        this.addPreparedItems(this.c_shake, this.b);
    }

    private void calculate_o() {
        this.o = this.e / 2;
        this.e = this.e % 2;
        this.addPreparedItems(this.o, this.a);
    }

    private void addPreparedItems(int value, int c) {
        if (value <= 0) {
            return;
        }
        if ((this.item_prepared + value) > this.n) {
            int i = abs(this.n - this.item_prepared);
            this.item_prepared = this.item_prepared + i;
            if (i > 0)
                this.cost = this.cost + (i * c);
        } else {
            this.item_prepared = this.item_prepared + value;
            this.cost = this.cost + (value * c);
        }
    }
}
