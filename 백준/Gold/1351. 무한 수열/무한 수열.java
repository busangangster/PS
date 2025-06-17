import java.util.*;
import java.io.*;

public class Main {
  public static long N, P, Q;
  public static HashMap<Long, Long> hm;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    hm = new HashMap<Long, Long>();
    st = new StringTokenizer(br.readLine());
    N = Long.parseLong(st.nextToken());
    P = Long.parseLong(st.nextToken());
    Q = Long.parseLong(st.nextToken());

    hm.put(0L, 1L);
    System.out.println(recur(N));

  }

  public static long recur(long x) {
    if (hm.containsKey(x))
      return hm.get(x);
    long res = recur(x / P) + recur(x / Q);
    hm.put(x, res);
    return res;
  }
}
