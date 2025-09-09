import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static int[] selected;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    selected = new int[M];

    perm(1, 0);
    System.out.println(sb);
  }

  public static void perm(int start, int cnt) {
    if (cnt == M) {
      for (int i = 0; i < M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i <= N; i++) {
      selected[cnt] = i;
      perm(i + 1, cnt + 1);

    }
  }
}