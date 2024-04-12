import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		while (n!=0) {
			if (n == 1) break;

			if (n% 5 == 0) {
				cnt += n/5;
				n = n%5;
			}
			else {
				n -= 3;
				cnt++;
			}
		}
		if (n != 0) System.out.println(-1);
		else System.out.println(cnt);
	}
}