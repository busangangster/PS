import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            ArrayList<Character> arr = new ArrayList<>();
            char current = 'a';
            boolean flag = true;
            
            for (int j = 0; j < s.length(); j++) {
                char val = s.charAt(j);
                if (j == 0) {
                    arr.add(val);
                    current = val;
                } else {
                    if (arr.contains(val) && current != val) {
                        flag = false;
                        break;
                    } else if (!arr.contains(val)) {
                        arr.add(val);
                    }
                    current = val;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}