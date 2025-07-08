import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static boolean ans;
  public static char[][] arr;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static ArrayList<Node> teachers = new ArrayList<Node>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    arr = new char[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        char tmp = st.nextToken().charAt(0);
        if (tmp == 'T') {
          teachers.add(new Node(i, j));
        }
        arr[i][j] = tmp;
      }
    }
    ans = false;
    dfs(0);
    System.out.println(ans ? "YES" : "NO");

  }

  public static void dfs(int cnt) {
    if (cnt == 3) {
      if (move()) {
        ans = true;
      }
      return;
    }

    if (ans)
      return;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] == 'X') {
          arr[i][j] = 'O';
          dfs(cnt + 1);
          arr[i][j] = 'X';
        }
      }
    }
  }

  public static boolean move() {
    for (Node cur : teachers) {
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        while (true) {
          if (!check(nx, ny))
            break;

          if (arr[nx][ny] == 'O')
            break;

          if (arr[nx][ny] == 'S')
            return false;

          nx = nx + dx[i];
          ny = ny + dy[i];
        }
      }
    }
    return true;
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < N);
  }
}

class Node {
  int x;
  int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}