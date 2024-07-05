import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int v = Integer.parseInt(st.nextToken());
                hm.put(v, 1);
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int v = Integer.parseInt(st.nextToken());
                if (hm.containsKey(v)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
        
    }
}