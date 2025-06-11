import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, B, max_v, min_v, ans, time;
  public static int[][] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    max_v = Integer.MIN_VALUE;
    min_v = Integer.MAX_VALUE;
    ans = 0;
    time = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp > max_v) {
          max_v = tmp;
        }
        if (tmp < min_v) {
          min_v = tmp;
        }
        arr[i][j] = tmp;
      }
    }

    for (int i = min_v; i <= max_v; i++) {
      find(i);
    }

    System.out.println(time + " " + ans);

  }

  public static void find(int target) {
    int block = B;
    int cur_time = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] > target) {
          int diff = arr[i][j] - target;
          block += diff;
          cur_time += diff * 2;
        } else {
          int diff = target - arr[i][j];
          block -= diff;
          cur_time += diff;
        }
      }
    }

    if (block >= 0 && cur_time <= time) {
      ans = Math.max(ans, target);
      time = cur_time;
    }
  }
}