import java.util.*;
import java.io.*;

public class Main {
  public static int N, mp, mf, ms, mv, cost;
  public static ArrayList<Food> arr;
  public static boolean[] selected;
  public static ArrayList<Integer> answers;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    mp = Integer.parseInt(st.nextToken());
    mf = Integer.parseInt(st.nextToken());
    ms = Integer.parseInt(st.nextToken());
    mv = Integer.parseInt(st.nextToken());

    arr = new ArrayList<>();
    selected = new boolean[N];
    cost = Integer.MAX_VALUE;
    answers = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      arr.add(new Food(a, b, c, d, e));
    }

    subset(0, 0, 0, 0, 0, 0);
    if (cost == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(cost);
      for (int x : answers) {
        System.out.print(x + " ");

      }
    }
  }

  public static void subset(int cnt, int cp, int cf, int cs, int cv, int curPrice) {
    if (cnt == N) {
      if (curPrice > cost)
        return;
      if (possible(cp, cf, cs, cv)) {
        if (curPrice < cost) {
          cost = curPrice;
          answers.clear();
          for (int i = 0; i < N; i++) {
            if (selected[i]) {
              answers.add(i + 1);
            }
          }
        } else if (curPrice == cost) {
          ArrayList<Integer> newList = new ArrayList<>();
          for (int i = 0; i < N; i++) {
            if (selected[i])
              newList.add(i + 1);
          }

          boolean newIsBetter = false;
          for (int k = 0; k < Math.min(answers.size(), newList.size()); k++) {
            if (!answers.get(k).equals(newList.get(k))) {
              newIsBetter = newList.get(k) < answers.get(k);
              break;
            }
          }

          if (!newIsBetter && answers.size() > newList.size()
              && answers.subList(0, newList.size()).equals(newList)) {
            newIsBetter = true;
          }

          if (newIsBetter) {
            answers = newList;
          }
        }
      }
      return;
    }

    selected[cnt] = true;
    subset(cnt + 1, cp + arr.get(cnt).p, cf + arr.get(cnt).f, cs + arr.get(cnt).s,
        cv + arr.get(cnt).v, curPrice + arr.get(cnt).price);

    selected[cnt] = false;
    subset(cnt + 1, cp, cf, cs, cv, curPrice);

  }

  public static boolean possible(int p, int f, int s, int v) {
    return (p >= mp && f >= mf && s >= ms && v >= mv);
  }
}

class Food {
  int p;
  int f;
  int s;
  int v;
  int price;

  public Food(int p, int f, int s, int v, int price) {
    this.p = p;
    this.f = f;
    this.s = s;
    this.v = v;
    this.price = price;
  }
}