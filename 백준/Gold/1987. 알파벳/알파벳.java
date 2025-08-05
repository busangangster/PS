import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, ans;
  public static char[][] arr;
  public static boolean[] alpha;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    alpha = new boolean[26];
    ans = Integer.MIN_VALUE;

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    int cur = (int) arr[0][0] - 65;
    alpha[cur] = true;
    play(0, 0, 1);

    System.out.println(ans);
  }

  public static void play(int x, int y, int cnt) {
    ans = Math.max(ans, cnt);

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (check(nx, ny)) {
        int cur = (int) arr[nx][ny] - 65;
        if (!alpha[cur]) {
          alpha[cur] = true;
          play(nx, ny, cnt + 1);
          alpha[cur] = false;
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }
}