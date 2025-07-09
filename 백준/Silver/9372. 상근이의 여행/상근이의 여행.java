import java.util.*;
import java.io.*;

public class Main {
  public static int N, M;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      arr = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i <= N; i++) {
        arr.add(new ArrayList<>());
      }
      visited = new boolean[N + 1];

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr.get(a).add(b);
        arr.get(b).add(a);
      }

      sb.append(N - 1).append("\n");
    }
    System.out.println(sb);
  }
}