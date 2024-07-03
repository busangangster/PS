import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> tm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Long k = Long.parseLong(br.readLine());
            tm.put(k, tm.getOrDefault(k, 0) + 1);
        }

        int maxValue = Collections.max(tm.values());
        List<Long> ans = new ArrayList<>();

        for (Long key : tm.keySet()) {
            if (tm.get(key) == maxValue) {
                ans.add(key);
            }
        }
        Collections.sort(ans);

        System.out.println(ans.get(0));
    }
}