import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        
        int maxValue = Collections.max(hm.values());

        for (String key : hm.keySet()) {
            if (maxValue == hm.get(key)) {
                ans.add(key);
            }
        }
        
        Collections.sort(ans);
        System.out.println(ans.get(0));
      
    }  
}