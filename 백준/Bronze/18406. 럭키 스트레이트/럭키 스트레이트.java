import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int left = 0, right = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() / 2) {
                left += str.charAt(i) - '0';
            } else {
                right += str.charAt(i) - '0';
            }
        }
        if(left == right) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}