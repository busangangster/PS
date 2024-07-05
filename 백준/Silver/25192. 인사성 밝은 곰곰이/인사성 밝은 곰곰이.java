import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hm = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (s.equals("ENTER")) {
                for (String key : hm.keySet()) {
                    if (hm.get(key) >= 1) {
                        cnt++;
                    }
                }
                hm = new HashMap<>();
            } else {
                hm.put(s, hm.getOrDefault(s, 0) + 1);
            }
        
        }
                        for (String key : hm.keySet()) {
                    if (hm.get(key) >= 1) {
                        cnt++;
                    }
                }
        System.out.println(cnt);
        
    }
}