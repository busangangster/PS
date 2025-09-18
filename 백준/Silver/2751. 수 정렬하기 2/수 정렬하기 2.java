import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    while (!pq.isEmpty()) {
      sb.append(pq.poll()).append("\n");
    }

    System.out.println(sb);
  }
}