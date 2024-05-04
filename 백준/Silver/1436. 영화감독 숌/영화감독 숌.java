import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		long num = 1;

		while (true) {
			if (Long.toString(num).contains("666")) {
				cnt++;
				if (cnt == N) {
					System.out.println(num);
					break;
				}
			}
			num++;
		}
	}
}