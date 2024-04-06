import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c ==0) break;
			int[] arr = new int[3];
			arr[0] = a;
			arr[1] = b;
			arr[2] = c;

			Arrays.sort(arr);
			int first = arr[0]*arr[0];
			int second = arr[1]*arr[1];
			int third = arr[2]*arr[2];
			if (first+second == third) {
				sb.append("right");
			}
			else sb.append("wrong");
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}