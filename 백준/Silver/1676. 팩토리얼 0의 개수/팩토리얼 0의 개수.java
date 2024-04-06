import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while (n >= 5) {
			cnt += n /5;
			n = n/5;
		}
		System.out.println(cnt);
	}
}