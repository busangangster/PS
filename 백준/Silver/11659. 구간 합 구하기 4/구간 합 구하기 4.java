import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N + 1];
    int[] sums = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      sums[i] = sums[i - 1] + tmp;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      sb.append(sums[b] - sums[a - 1]).append("\n");
    }
    System.out.println(sb);

  }
}