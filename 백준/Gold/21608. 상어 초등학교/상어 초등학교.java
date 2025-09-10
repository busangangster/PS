import java.util.*;
import java.io.*;

public class Main {
  public static HashMap<Integer, Integer> hm = new HashMap<>();
  public static ArrayList<ArrayList<Integer>> student = new ArrayList<ArrayList<Integer>>();
  public static int N, tx, ty;
  public static int[] order;
  public static int[][] arr;
  public static int[][] emptySpace;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i <= N * N; i++) {
      student.add(new ArrayList<>());
    }

    order = new int[N * N];
    emptySpace = new int[N][N];
    arr = new int[N][N];

    for (int i = 0; i < N * N; i++) {
      st = new StringTokenizer(br.readLine());
      int f = Integer.parseInt(st.nextToken());
      for (int j = 0; j < 4; j++) {
        student.get(f).add(Integer.parseInt(st.nextToken()));
      }
      order[i] = f;
    }

    for (int i = 1; i <= N * N; i++) {
      hm.put(i, 0);
    }

    checkEmptySpace();
    play();

    int ans = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int tmp = arr[i][j];
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];
          if (check(nx, ny)) {
            if (student.get(tmp).contains(arr[nx][ny])) {
              cnt++;
            }
          }
        }
        if (cnt == 1)
          ans += 1;
        else if (cnt == 2)
          ans += 10;
        else if (cnt == 3)
          ans += 100;
        else if (cnt == 4)
          ans += 1000;
      }
    }
    System.out.println(ans);
  }

  public static void play() {
    for (int i = 0; i < N * N; i++) {
      int tmp = order[i];
      boolean flag = false;
      for (int next : student.get(tmp)) {
        if (hm.get(next) != 0) {
          flag = true;
          break;
        }
      }

      if (!flag) {
        findSpot();
        calculate(tmp);
      } else {
        findFriend(tmp);
        calculate(tmp);
      }
    }
  }

  public static void calculate(int t) {
    arr[tx][ty] = t;
    hm.put(t, hm.get(t) + 1);
    emptySpace[tx][ty] = 0;
    for (int j = 0; j < 4; j++) {
      int nx = tx + dx[j];
      int ny = ty + dy[j];
      if (check(nx, ny)) {
        emptySpace[nx][ny]--;
      }
    }
  }

  public static void findFriend(int cur) {
    tx = 0;
    ty = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int friendCnt = 0;
        int emptyCnt = 0;
        if (arr[i][j] == 0) {
          for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            for (int p : student.get(cur)) {
              if (check(nx, ny)) {
                if (arr[nx][ny] == p) {
                  friendCnt++;
                }
              }
            }
            if (check(nx, ny) && arr[nx][ny] == 0)
              emptyCnt++;
          }
          pq.offer(new Node(i, j, friendCnt, emptyCnt));

        }
      }
    }
    tx = pq.peek().x;
    ty = pq.peek().y;
  }

  public static void checkEmptySpace() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < 4; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];
          if (check(nx, ny)) {
            if (arr[nx][ny] == 0) {
              emptySpace[i][j]++;
            }
          }
        }
      }
    }
  }

  public static void findSpot() {
    tx = 0;
    ty = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] != 0)
          continue;
        if (emptySpace[i][j] > max) {
          max = emptySpace[i][j];
          tx = i;
          ty = j;
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
  int friend;
  int empty;

  public Node(int x, int y, int friend, int empty) {
    this.x = x;
    this.y = y;
    this.friend = friend;
    this.empty = empty;
  }

  @Override
  public int compareTo(Node o) {
    if (this.friend == o.friend) {
      if (this.empty == o.empty) {
        if (this.x == o.x) {
          return this.y - o.y;
        }
        return this.x - o.x;
      }
      return o.empty - this.empty;
    }
    return o.friend - this.friend;
  }
}