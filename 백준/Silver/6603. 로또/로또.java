import java.util.*;
import java.io.*;

public class Main {
  public static int k;
  public static int[] arr, selected;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());

      k = Integer.parseInt(st.nextToken());
      if (k == 0)
        break;

      arr = new int[k];
      selected = new int[6];
      for (int i = 0; i < k; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      comb(0, 0);
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void comb(int start, int cnt) {
    if (cnt == 6) {
      for (int i = 0; i < 6; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i < k; i++) {
      selected[cnt] = arr[i];
      comb(i + 1, cnt + 1);
    }

  }
}