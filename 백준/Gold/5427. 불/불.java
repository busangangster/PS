import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, sx, sy;
  public static char[][] arr;
  public static int[][] map;
  public static boolean[][] visited;
  public static ArrayList<Node> fire;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());

      fire = new ArrayList<>();
      map = new int[N][M];

      for (int[] m : map) {
        Arrays.fill(m, 1000 * 1000 + 1);
      }
      arr = new char[N][M];
      for (int i = 0; i < N; i++) {
        String s = br.readLine();
        for (int j = 0; j < M; j++) {
          char tmp = s.charAt(j);
          if (tmp == '@') {
            sx = i;
            sy = j;
          } else if (tmp == '*') {
            fire.add(new Node(i, j, 0));
          }
          arr[i][j] = tmp;
        }
      }
      moveFire();
      int res = movePerson();
      sb.append(res == -1 ? "IMPOSSIBLE" : res).append("\n");
    }
    System.out.println(sb);
  }

  public static void moveFire() {
    visited = new boolean[N][M];
    Queue<Node> q = new ArrayDeque<>();
    for (Node f : fire) {
      visited[f.x][f.y] = true;
      q.offer(new Node(f.x, f.y, f.time));
      map[f.x][f.y] = 0;
    }

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (check(nx, ny)) {
          if (!visited[nx][ny] && arr[nx][ny] != '#') {
            map[nx][ny] = cur.time + 1;
            visited[nx][ny] = true;
            q.offer(new Node(nx, ny, cur.time + 1));
          }
        }
      }
    }
  }

  public static int movePerson() {
    visited = new boolean[N][M];
    Queue<Node> q = new ArrayDeque<>();
    q.offer(new Node(sx, sy, 0));
    visited[sx][sy] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (!check(nx, ny)) {
          return cur.time + 1;
        }

        else {
          if (!visited[nx][ny] && arr[nx][ny] != '#' && arr[nx][ny] != '*' && map[nx][ny] > cur.time + 1) {
            visited[nx][ny] = true;
            q.offer(new Node(nx, ny, cur.time + 1));
          }
        }
      }
    }
    return -1;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
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