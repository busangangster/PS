import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] s = br.readLine().trim().split(" ");
		int cnt= 0; 
		for (int i=0; i<s.length; i++) {
			if (s[i].equals("")) {
				continue;
			}
			else cnt++;
		}
		System.out.println(cnt);
	}
}