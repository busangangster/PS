import java.util.*;
import java.io.*;

public class Main {
  public static int A, B;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    int ans = 0;
    while (B > A) {
      if (B % 10 == 1) {
        B = B / 10;
      } else if (B % 2 == 0) {
        B = B / 2;
      } else {
        break;
      }
      ans++;
    }

    System.out.println(B == A ? ans + 1 : -1);

  }

}