import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, D, enemies, opp, kill, ans;
  public static int[][] arr, copyArr;
  public static boolean[][] getShot;
  public static int[] selected;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    copyArr = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 1)
          enemies++;
        arr[i][j] = tmp;
      }
    }

    selected = new int[3];
    ans = Integer.MIN_VALUE;
    comb(0, 0);
    System.out.println(ans);
  }

  public static void comb(int start, int cnt) {
    if (cnt == 3) {
      copy();
      opp = enemies;
      kill = 0;
      while (true) {
        getShot = new boolean[N][M];
        if (opp == 0)
          break;

        attack();
        moveAndRemove();
      }

      ans = Math.max(ans, kill);
      return;
    }

    for (int i = start; i < M; i++) {
      selected[cnt] = i;
      comb(i + 1, cnt + 1);
    }
  }

  public static void copy() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        copyArr[i][j] = arr[i][j];
      }
    }
  }

  public static void attack() {
    for (int t = 0; t < 3; t++) {
      int[] target = { -100, -100 };
      int distance = Integer.MAX_VALUE;
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (copyArr[j][i] == 1) {
            int dis = Math.abs(N - j) + Math.abs(selected[t] - i);
            if (dis <= D && dis < distance) {
              target[0] = j;
              target[1] = i;
              distance = dis;
            }
          }
        }
      }
      if (target[0] == -100 || target[1] == -100)
        continue;
      getShot[target[0]][target[1]] = true;
    }
  }

  public static void moveAndRemove() {
    boolean[][] newMove = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (getShot[i][j] && copyArr[i][j] == 1) {
          copyArr[i][j] = 0;
          opp--;
          kill++;
        }
        if (copyArr[i][j] == 1 && !getShot[i][j]) {
          if (check(i + 1, j)) {
            copyArr[i][j] = 0;
            newMove[i + 1][j] = true;
          } else {
            copyArr[i][j] = 0;
            opp--;
          }
        }
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (newMove[i][j]) {
          copyArr[i][j] = 1;
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < M);
  }

}