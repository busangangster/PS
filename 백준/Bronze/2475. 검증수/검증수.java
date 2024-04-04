import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		for (int i=0; i<5; i++) {
			ans += Math.pow(Integer.parseInt(st.nextToken()),2);
		}
		System.out.println(ans%10);
		
	}
}