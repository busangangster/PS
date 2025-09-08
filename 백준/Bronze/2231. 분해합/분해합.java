import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    for (int i = 1; i <= 1000000; i++) {
      int res = i;
      int tmp = i;

      while (tmp > 0) {
        res += tmp % 10;
        tmp = tmp / 10;
      }

      if (res == n) {
        System.out.println(i);
        System.exit(0);
      }
    }

    System.out.println(0);

  }
}