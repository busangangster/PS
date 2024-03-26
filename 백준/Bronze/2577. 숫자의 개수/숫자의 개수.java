import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[10];
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int ans =  a*b*c;
		
		String s = Integer.toString(ans);
		for (int i=0; i<s.length(); i++) {
			int tmp = s.charAt(i) - '0';
			arr[tmp]++;
		}
		
		for (int x: arr) {
			System.out.println(x);
		}
	}	

}