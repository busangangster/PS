import java.util.*;
import java.io.*;

public class Main {
  public static int L, C;
  public static char[] alpha;
  public static char[] selected;
  public static boolean[] vowel = new boolean[26];
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    alpha = new char[C];
    selected = new char[L];
    vowel['a' - 'a'] = true;
    vowel['e' - 'a'] = true;
    vowel['i' - 'a'] = true;
    vowel['o' - 'a'] = true;
    vowel['u' - 'a'] = true;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < C; i++) {
      alpha[i] = st.nextToken().charAt(0);
    }

    Arrays.sort(alpha);
    comb(0, 0);
    System.out.println(sb);

  }

  public static void comb(int start, int cnt) {
    if (cnt == L) {
      int v = 0;
      int c = 0;
      String s = "";
      for (int i = 0; i < L; i++) {
        char tmp = selected[i];
        if (vowel[tmp - 'a'])
          v++;
        else
          c++;
        s += tmp;
      }
      if (v >= 1 && c >= 2)
        sb.append(s).append("\n");
      return;
    }

    for (int i = start; i < C; i++) {
      selected[cnt] = alpha[i];
      comb(i + 1, cnt + 1);
    }
  }
}