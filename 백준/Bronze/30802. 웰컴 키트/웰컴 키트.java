import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[6];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 6; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());

    int shirt = 0;
    int dozen = 0;
    int sol = 0;

    for (int i = 0; i < 6; i++) {
      if (arr[i] % t == 0)
        shirt += arr[i] / t;
      else if (arr[i] != 0) {
        shirt += arr[i] / t + 1;
      }
    }

    dozen = n / p;
    sol = n % p;

    System.out.println(shirt);
    System.out.println(dozen + " " + sol);
  }
}