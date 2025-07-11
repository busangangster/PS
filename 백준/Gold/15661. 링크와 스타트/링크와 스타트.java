import java.util.*;
import java.io.*;

public class Main {
  public static int N, ans;
  public static int[][] arr;
  public static boolean[] selected;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];
    selected = new boolean[N];
    ans = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    selected[0] = true;
    subset(1);
    System.out.println(ans);
  }

  public static int getScore() {
    int firstTeamScore = 0;
    int secondTeamScore = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i == j)
          continue;
        if (selected[i]) {
          if (selected[j]) {
            firstTeamScore += arr[i][j];
          }
        } else {
          if (!selected[j]) {
            secondTeamScore += arr[i][j];
          }
        }
      }
    }

    if (firstTeamScore == 0 || secondTeamScore == 0)
      return -1;
    else
      return Math.abs(firstTeamScore - secondTeamScore);
  }

  public static void subset(int cnt) {

    if (cnt == N) {
      int res = getScore();
      if (res != -1) {
        ans = Math.min(ans, res);
        if (ans == 0) {
          System.out.println(0);
          System.exit(0);
        }
      }
      return;
    }

    selected[cnt] = true;
    subset(cnt + 1);

    selected[cnt] = false;
    subset(cnt + 1);
  }
}