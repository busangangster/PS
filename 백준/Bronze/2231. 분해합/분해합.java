import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int answer = 0;

    for (int i = 1; i <= 1000000; i++) {
      int res = i;
      for (int tmp = i; tmp > 0; tmp /= 10) {
        res += tmp % 10;
      }

      if (res == n) {
        answer = i;
        break;
      }
    }

    System.out.println(answer);

  }
}