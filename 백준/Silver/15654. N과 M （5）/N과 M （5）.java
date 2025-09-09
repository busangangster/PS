import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static int[] arr;
  public static int[] selected;
  public static boolean[] visited;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    selected = new int[M];
    visited = new boolean[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    comb(0);
    System.out.println(sb);

  }

  public static void comb(int cnt) {
    if (cnt == M) {
      for (int i = 0; i < M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        selected[cnt] = arr[i];
        comb(cnt + 1);
        visited[i] = false;
      }

    }
  }
}