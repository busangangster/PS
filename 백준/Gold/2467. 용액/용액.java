import java.util.*;
import java.io.*;

public class Main {
  public static int n, target;
  public static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    target = Integer.MAX_VALUE;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] res = bs();
    System.out.println(res[0] + " " + res[1]);

  }

  public static int[] bs() {
    int lt = 0;
    int rt = n - 1;
    int[] ans = new int[2];

    while (lt < rt) {
      int mid = arr[lt] + arr[rt];
      int tmp = Math.abs(mid);

      if (tmp < target) {
        ans[0] = arr[lt];
        ans[1] = arr[rt];
        target = tmp;
      }

      if (mid < 0) {
        lt++;
      } else if (mid > 0) {
        rt--;
      } else {
        break;
      }
    }
      
    return ans;
  }
}