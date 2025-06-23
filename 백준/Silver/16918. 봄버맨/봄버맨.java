import java.util.*;
import java.io.*;

public class Main {
  public static int[][] count;
  public static char[][] arr;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };
  public static int R, C, N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new char[R][C];
    count = new int[R][C];

    for (int i = 0; i < R; i++) {
      String s = br.readLine();
      for (int j = 0; j < C; j++) {
        char tmp = s.charAt(j);
        if (tmp == 'O') {
          count[i][j] = 1;
        }
        arr[i][j] = tmp;
      }
    }

    int time = 1;

    while (true) {
      if (time == N)
        break;

      if (time % 2 == 1) {
        setUp();
      }

      else {
        blowUp();
      }
      time++;
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        sb.append(arr[i][j]);
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }

  public static void setUp() {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (arr[i][j] == '.') {
          arr[i][j] = 'O';
          count[i][j] = 1;
        } else {
          count[i][j]++;
        }
      }
    }
  }

  public static void blowUp() {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (count[i][j] == 2) {
          for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (check(nx, ny)) {
              if (count[nx][ny] == 1) {
                arr[nx][ny] = '.';
                count[nx][ny] = 0;
              }
            }
          }
          arr[i][j] = '.';
          count[i][j] = 0;
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < R && 0 <= y && y < C);
  }
}