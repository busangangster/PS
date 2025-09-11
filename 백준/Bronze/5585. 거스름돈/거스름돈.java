import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int m = Integer.parseInt(br.readLine());

    int k = 1000 - m;

    int[] coins = new int[] { 500, 100, 50, 10, 5, 1 };

    int ans = 0;
    for (int i = 0; i < 6; i++) {
      ans += k / coins[i];
      k %= coins[i];
    }

    System.out.println(ans);

  }
}
