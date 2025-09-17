import java.util.*;
import java.io.*;

public class Main {
  public static int cnt;
  public static int[][] arr;
  public static HashSet<String> hs = new HashSet<String>();
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    arr = new int[5][5];

    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    cnt = 0;

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        dfs(i, j, 0, "" + arr[i][j]);
      }
    }

    System.out.println(hs.size());
  }

  public static void dfs(int x, int y, int cnt, String cur) {
    if (cnt == 5) {
      hs.add(cur);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
        dfs(nx, ny, cnt + 1, cur + arr[nx][ny]);
      }
    }

  }
}