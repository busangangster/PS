import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

			while (true) {
				String s = br.readLine();
				if (s.equals("0")) break;

				int pos = s.length()/2;
				
				int lt = 0;
				int rt = s.length()-1;
				boolean flag = true;
	
				while (lt < rt) {
					if (s.charAt(lt) != s.charAt(rt)) {
						flag = false;
						break;
					}
					lt++;
					rt--;
				}
	
				if (!flag) sb.append("no");
				else sb.append("yes");
				sb.append("\n");

			}
			System.out.println(sb);		
	}
}