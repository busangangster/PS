import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            hm.put(k, hm.getOrDefault(k, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            hm.put(k, hm.getOrDefault(k, 0) + 1);
        }
        
        int ans = 0;

        for (Integer key : hm.keySet()) {
            if (hm.get(key) == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}