import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int cnt = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      boolean yes = true;
      int tmp = Integer.parseInt(st.nextToken());

      if (tmp == 1)
        yes = false;
      for (int j = 2; j < tmp; j++) {
        if (tmp % j == 0) {
          yes = false;
          break;
        }
      }
      if (yes) {
        cnt++;
      }
    }

    System.out.println(cnt);

  }
}