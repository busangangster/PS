import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    ArrayList<Integer> a, b;
    a = new ArrayList<>();
    b = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      b.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(a);
    Collections.sort(b, Collections.reverseOrder());

    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += a.get(i) * b.get(i);
    }
    System.out.println(ans);
  }
}