import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static char[][] arr;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static boolean[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    arr = new char[N][N];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    visited = new boolean[N][N];
    int number = 0;
    ArrayList<Integer> houses = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && arr[i][j] == '1') {
          int tmp = bfs(i, j);
          houses.add(tmp);
          number++;
        }
      }
    }

    System.out.println(number);
    Collections.sort(houses);
    for (int x : houses) {
      System.out.println(x);
    }

  }

  public static int bfs(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] { x, y });
    visited[x][y] = true;
    int cnt = 1;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] == '1') {
            q.offer(new int[] { nx, ny });
            visited[nx][ny] = true;
            cnt++;
          }
        }
      }
    }
    return cnt;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < N);
  }
}