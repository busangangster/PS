import java.util.*;
import java.io.*;

public class Main {
  public static int N, answer;
  public static int[][] arr;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    answer = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    visited = new boolean[N][N];
    dfs(0, 0);
    System.out.println(answer);
  }

  public static void dfs(int cnt, int sum) {
    if (cnt == 3) {
      answer = Math.min(answer, sum);
      return;
    }

    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < N - 1; j++) {
        if (visited[i][j] || visited[i - 1][j] || visited[i][j - 1] || visited[i + 1][j] || visited[i][j + 1])
          continue;

        int cost = arr[i][j] + arr[i][j - 1] + arr[i - 1][j] + arr[i + 1][j] + arr[i][j + 1];
        visited[i][j] = visited[i - 1][j] = visited[i][j - 1] = visited[i + 1][j] = visited[i][j + 1] = true;
        dfs(cnt + 1, sum + cost);
        visited[i][j] = visited[i - 1][j] = visited[i][j - 1] = visited[i + 1][j] = visited[i][j + 1] = false;
      }
    }
  }
}
