import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int cnt = 0;

    boolean[] prime = new boolean[1001];

    Arrays.fill(prime, true);
    prime[1] = false;

    for (int i = 2; i <= 1000; i++) {
      if (prime[i]) {
        for (int j = i + i; j <= 1000; j += i) {
          prime[j] = false;
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      if (prime[Integer.parseInt(st.nextToken())])
        cnt++;
    }

    System.out.println(cnt);

  }
}