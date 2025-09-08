import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    long res = 0L;
    long mod = 1234567891L;
    long k = 1L;

    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    for (int i = 0; i < n; i++) {
      long tmp = s.charAt(i) - 'a' + 1;

      res += (tmp * k) % mod;
      res %= mod;
      k *= 31L;
      k %= mod;
    }
    System.out.println(res % mod);
  }
}