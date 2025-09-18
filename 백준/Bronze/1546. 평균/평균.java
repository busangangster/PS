import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int[] score = new int[n];
    int max = Integer.MIN_VALUE;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      score[i] = tmp;
      max = Math.max(max, tmp);
    }
    double sum = 0;
    for (int i = 0; i < n; i++) {
      double k = (double) score[i] / (double) max * 100;
      sum += k;
    }

    System.out.println(sum / n);

  }
}
