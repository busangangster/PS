import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while (true) {
      st = new StringTokenizer(br.readLine());
      int[] arr = new int[3];
      for (int i = 0; i < 3; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      if (arr[2] == 0)
        break;

      Arrays.sort(arr);

      if (Math.pow(arr[2], 2) == Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) {
        sb.append("right");
      } else
        sb.append("wrong");
      sb.append("\n");
    }

    System.out.println(sb);
  }
}