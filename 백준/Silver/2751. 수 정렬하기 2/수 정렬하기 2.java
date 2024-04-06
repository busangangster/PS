import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int  n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];

		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for (int x: arr) {
			sb.append(x).append("\n");
		}
		System.out.println(sb);
	}
}