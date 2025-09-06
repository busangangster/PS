import java.util.*;
import java.io.*;

public class Main {
  public static char[][] arr;
  public static int[] dx = { 0, 1, 0, -1, -1, -1, 1, 1, 0 };
  public static int[] dy = { 1, 0, -1, 0, -1, 1, -1, 1, 0 };
  public static boolean[][][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    arr = new char[8][8];

    for (int i = 0; i < 8; i++) {
      String s = br.readLine();
      for (int j = 0; j < 8; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    visited = new boolean[8][8][9];

    System.out.println(bfs());

  }

  public static boolean isWall(int x, int y, int t) {
    int srcRow = x - t;

    if (srcRow < 0)
      return false;
    return arr[srcRow][y] == '#';
  }

  public static int bfs() {
    Queue<Node> q = new ArrayDeque<>();
    q.offer(new Node(7, 0, 0));
    visited[7][0][0] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (isWall(cur.x, cur.y, cur.time))
        continue;

      if (cur.x == 0 && cur.y == 7) {
        return 1;
      }

      for (int i = 0; i < 9; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        int nt = Math.min(cur.time + 1, 8);

        if (!check(nx, ny))
          continue;

        if (isWall(nx, ny, cur.time))
          continue;
        if (isWall(nx, ny, nt))
          continue;

        if (!visited[nx][ny][nt]) {
          visited[nx][ny][nt] = true;
          q.offer(new Node(nx, ny, nt));
        }
      }
    }
    return 0;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < 8 && 0 <= y && y < 8);
  }
}

class Node {
  int x;
  int y;
  int time;

  public Node(int x, int y, int time) {
    this.x = x;
    this.y = y;
    this.time = time;
  }
}
