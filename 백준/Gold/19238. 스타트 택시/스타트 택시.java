import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, F, sx, sy;
  public static int[][] arr, map;
  public static boolean[][] visited;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static PriorityQueue<Node> pq = new PriorityQueue<>();
  public static ArrayList<int[]> destinationList = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    F = Integer.parseInt(st.nextToken());

    arr = new int[N][N];
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    sx = Integer.parseInt(st.nextToken()) - 1;
    sy = Integer.parseInt(st.nextToken()) - 1;

    destinationList.add(new int[] {});

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      int tx = Integer.parseInt(st.nextToken()) - 1;
      int ty = Integer.parseInt(st.nextToken()) - 1;

      map[x][y] = i;
      destinationList.add(new int[] { tx, ty });
    }

    boolean flag = true;
    for (int i = 0; i < M; i++) {
      pq.clear();
      taxiToPerson();
      if (pq.isEmpty()) {
        flag = false;
        break;
      }
      int res = personToDestination();
      if (res == -1) {
        flag = false;
        break;
      }
    }

    System.out.println(flag ? F : -1);

  }

  public static int personToDestination() {
    Node person = pq.poll();
    int[] destination = destinationList.get(person.number);
    visited = new boolean[N][N];
    Queue<int[]> q = new ArrayDeque<>();
    visited[person.x][person.y] = true;
    q.offer(new int[] { person.x, person.y, 0 }); // x,y,이동거리

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      if (cur[0] == destination[0] && cur[1] == destination[1]) {
        if (F - (person.dis + cur[2]) < 0) {
          return -1;
        } else {
          F -= person.dis + cur[2];
          F += cur[2] * 2;
          sx = destination[0];
          sy = destination[1];
          map[person.x][person.y] = 0;
          return 1;
        }
      }

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] != 1) {
            if (!visited[nx][ny]) {
              visited[nx][ny] = true;
              q.offer(new int[] { nx, ny, cur[2] + 1 });
            }
          }
        }
      }
    }
    return -1;
  }

  public static void taxiToPerson() {
    visited = new boolean[N][N];
    Queue<int[]> q = new ArrayDeque<>();
    visited[sx][sy] = true;
    q.offer(new int[] { sx, sy, 0 }); // x,y,거리

    if (map[sx][sy] != 0) {
      pq.offer(new Node(sx, sy, 0, map[sx][sy]));
      return;
    }

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (check(nx, ny)) {
          if (arr[nx][ny] != 1) {
            if (!visited[nx][ny]) {
              if (map[nx][ny] != 0) {
                pq.offer(new Node(nx, ny, cur[2] + 1, map[nx][ny]));
              }
              q.offer(new int[] { nx, ny, cur[2] + 1 });
              visited[nx][ny] = true;
            }
          }
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < N);
  }
}

class Node implements Comparable<Node> {
  int x;
  int y;
  int dis;
  int number;

  public Node(int x, int y, int dis, int number) {
    this.x = x;
    this.y = y;
    this.dis = dis;
    this.number = number;
  }

  @Override
  public String toString() {
    return "(" + x + " " + y + " " + dis + " " + number + " " + ")";
  }

  @Override
  public int compareTo(Node o) {
    if (this.dis == o.dis) {
      if (this.x == o.x) {
        return this.y - o.y;
      }
      return this.x - o.x;
    }
    return this.dis - o.dis;
  }
}