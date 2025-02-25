import java.util.*;

public class Main {

    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int add, sub, mul, div;

    public static int minValue = (int) 1e9;
    public static int maxValue = (int) -1e9;

    public static void dfs(int i, int now) {
        if (i == n) {
            minValue = Math.min(minValue, now);
            maxValue = Math.max(maxValue, now);
        } else {
            if (add > 0) {
                add--;
                dfs(i + 1, now + arr.get(i));
                add++;
            }
            if (sub > 0) {
                sub--;
                dfs(i + 1, now - arr.get(i));
                sub++;
            }
            if (mul > 0) {
                mul--;
                dfs(i + 1, now * arr.get(i));
                mul++;
            }
            if (div > 0) {
                div--;
                dfs(i + 1, now / arr.get(i));
                div++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr.add(x);
        }

        add = sc.nextInt();
        sub = sc.nextInt();
        mul = sc.nextInt();
        div = sc.nextInt();

        dfs(1, arr.get(0));

        System.out.println(maxValue);
        System.out.println(minValue);
    }
}