import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    long T = Long.parseLong(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(arr); // 오름차순

    Stack<Integer> stack = new Stack<>(); 
    int i = 0; 
    int used = 0; 

    while (used < K) {
      while (i < N && arr[i] < T) {
        stack.push(arr[i]); 
        i++;
      }

      if (stack.isEmpty())
        break;

      T += stack.pop();
      used++;
    }

    System.out.println(T);
  }
}
