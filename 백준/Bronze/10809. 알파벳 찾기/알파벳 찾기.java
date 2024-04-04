import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		for (int i=97; i<=122; i++) {
			int k = s.indexOf((char) i);
			sb.append(k).append(" ");
		}
		System.out.println(sb);
	}
}