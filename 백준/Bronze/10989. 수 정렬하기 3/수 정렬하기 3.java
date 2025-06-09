import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] count = new int[10001];

    for (int i = 0; i < n; i++) {
      count[Integer.parseInt(br.readLine())]++;
    }

    for (int i = 1; i <= 10000; i++) {
      int c = count[i];
      while (c-- > 0) {
        sb.append(i).append("\n");
      }
    }
    System.out.println(sb);
  }
}