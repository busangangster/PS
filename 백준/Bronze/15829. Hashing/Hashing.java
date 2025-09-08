import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    long res = 0L;
    int mod = 1234567891;

    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    for (int i = 0; i < n; i++) {
      int tmp = (int) s.charAt(i) - 96;
      res += tmp * (Math.pow(31, i) % mod);
      res %= mod;
    }
    System.out.println(res % mod);
  }
}