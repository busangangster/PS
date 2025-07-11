import java.util.*;
import java.io.*;

public class Main {
  public static int N, ans;
  public static int[][] arr;
  public static boolean[] selected;
  public static ArrayList<Integer> firstTeam;
  public static ArrayList<Integer> secondTeam;

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

    subset(0);
    System.out.println(ans);
  }

  public static int getScore() {
    int firstTeamScore = 0;
    int secondTeamScore = 0;

    for (int i = 0; i < firstTeam.size(); i++) {
      for (int j = 0; j < firstTeam.size(); j++) {
        if (i == j)
          continue;
        firstTeamScore += arr[firstTeam.get(i)][firstTeam.get(j)];
      }
    }

    for (int i = 0; i < secondTeam.size(); i++) {
      for (int j = 0; j < secondTeam.size(); j++) {
        if (i == j)
          continue;
        secondTeamScore += arr[secondTeam.get(i)][secondTeam.get(j)];
      }
    }

    if (firstTeamScore == 0 || secondTeamScore == 0)
      return -1;
    else
      return Math.abs(firstTeamScore - secondTeamScore);
  }

  public static void subset(int cnt) {
    if (cnt == N) {
      firstTeam = new ArrayList<>();
      secondTeam = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        if (selected[i]) {
          firstTeam.add(i);
        } else {
          secondTeam.add(i);
        }
      }
      int res = getScore();
      if (res != -1) {
        ans = Math.min(ans, res);
      }
      return;
    }

    selected[cnt] = true;
    subset(cnt + 1);

    selected[cnt] = false;
    subset(cnt + 1);
  }
}