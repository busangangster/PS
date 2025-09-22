import java.util.*;
import java.io.*;

public class Main {
  public static int a, b;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    int res = gcd(a, b);
    System.out.println(res);
    System.out.println(a * b / res);
  }

  public static int gcd(int x, int y) {
    if (y == 0)
      return x;
    else
      return gcd(y, x % y);
  }
}
