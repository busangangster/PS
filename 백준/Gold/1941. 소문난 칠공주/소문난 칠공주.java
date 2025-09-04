import java.util.*;
import java.io.*;

public class Main {
  public static int ans;
  public static char[][] arr;
  public static ArrayList<Character> group = new ArrayList<>();
  public static boolean[] selected;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    arr = new char[5][5];

    for (int i = 0; i < 5; i++) {
      String s = br.readLine();
      for (int j = 0; j < 5; j++) {
        arr[i][j] = s.charAt(j);
      }
    }
    selected = new boolean[25];

    dfs(0, 0, 0);
    System.out.println(ans);

  }

  public static void dfs(int start, int cnt, int scnt) {
    if (scnt + (7 - cnt) < 4)
      return;
    if (cnt == 7) {
      if (scnt >= 4 && bfs())
        ans++;
      return;
    }

    for (int i = start; i < 25; i++) {
      int r = i / 5;
      int c = i % 5;
      selected[i] = true;
      dfs(i + 1, cnt + 1, arr[r][c] == 'S' ? scnt + 1 : scnt);
      selected[i] = false;
    }
  }

  public static boolean bfs() {
    int start = -1;
    for (int i = 0; i < 25; i++) {
      if (selected[i]) {
        start = i;
        break;
      }
    }

    boolean[] visited = new boolean[25];
    int found = 1;

    Queue<Integer> q = new ArrayDeque<>();
    q.offer(start);
    visited[start] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();

      int r = cur / 5;
      int c = cur % 5;

      for (int i = 0; i < 4; i++) {
        int nx = r + dx[i];
        int ny = c + dy[i];

        if (check(nx, ny)) {
          int next = nx * 5 + ny;
          if (!visited[next] && selected[next]) {
            visited[next] = true;
            q.offer(next);
            found++;
          }
        }
      }
    }
    return found == 7;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < 5 && 0 <= y && y < 5);
  }
}