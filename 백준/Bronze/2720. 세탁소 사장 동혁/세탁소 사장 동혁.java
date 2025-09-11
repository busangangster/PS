import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] coin = new int[] { 25, 10, 5, 1 };
    for (int i = 0; i < n; i++) {
      int tmp = Integer.parseInt(br.readLine());
      for (int j = 0; j < 4; j++) {
        sb.append(tmp / coin[j]).append(" ");
        tmp %= coin[j];
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
