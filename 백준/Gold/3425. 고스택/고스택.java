import java.io.*;
import java.util.*;
public class Main {
	
	static int INF = 1000000000;
	static ArrayList<String> commands = new ArrayList<>();
	static ArrayList<Integer> addValue = new ArrayList<>();
	static long first;
	static long second;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
			
		first = 0;
		second = 0;
		
		while (true) {
			commands.clear();
			addValue.clear();
			
			String cmd = br.readLine();
			if ("".equals(cmd)) continue;
			if ("QUIT".equals(cmd)) break;
			
			while (!cmd.equals("END")) {
				String[] cmdLine = cmd.split(" ");
				
				if (cmdLine.length == 1) {
					commands.add(cmdLine[0]);
				}
				else {
					commands.add(cmdLine[0]);
					addValue.add(Integer.parseInt(cmdLine[1]));
					}
					cmd = br.readLine();
				}
				
				int t_case = Integer.parseInt(br.readLine());
				
				for (int i=0; i<t_case; i++) {
					Stack<Long> stack = new Stack<>();
					long k = Integer.parseInt(br.readLine());
					boolean flag = true;
					int numCnt = 0;
					stack.add(k);
					
					for (int j=0; j<commands.size(); j++) {
						String cal = commands.get(j);
						if (cal.equals("NUM")) {
							stack.add((long) addValue.get(numCnt));
							numCnt++;
						}
						else if (cal.equals("POP")) {
							if (stack.isEmpty()) {
								flag = false;
								break;
							}
							else {
								stack.pop();	
							}
						}
						else if (cal.equals("INV")) {
							if (stack.isEmpty()) {
								flag = false;
								break;
							}
							else {
								long sPop = stack.pop();
								sPop = -sPop;
								stack.add(sPop);
							}
						}
						else if (cal.equals("DUP")) {
							if (stack.isEmpty()) {
								flag = false;
								break;
							}
							else {
								long sFirst = stack.peek();
								stack.add(sFirst);
							}
						}
						else if (cal.equals("SWP")) {
							if (stack.size() < 2) {
								flag = false;
								break;
							}
							else {
								first = stack.pop();
								second = stack.pop();
								stack.add(first);
								stack.add(second);
							}
							
						}
						else if (cal.equals("ADD")) {
							if (stack.size() < 2) {
								flag = false;
								break;
							}
							else {
								first = stack.pop();
								second = stack.pop();
								long sum = first + second;
								if (Math.abs(sum) > INF) {
									flag = false;
									break;
								}
								else stack.add(sum);
							}
						}
						else if (cal.equals("SUB")) {
							if (stack.size() < 2) {
								flag = false;
								break;
							}
							else {
								first = stack.pop();
								second = stack.pop();
								long sub = second - first;
								if (Math.abs(sub) > INF ) {
									flag = false;
									break;
								}
								else stack.add(sub);
							}
						}
						else if (cal.equals("MUL")) {
							if (stack.size() < 2) {
								flag = false;
								break;
							}
							else {
								first = stack.pop();
								second = stack.pop();
								long mul = first * second;
								if (Math.abs(mul) > INF) {
									flag = false;
									break;
								}
								else {
									stack.add(mul);
								}
							}
						}
						else if (cal.equals("DIV")) {
							if (stack.size() < 2) {
								flag = false;
								break;
							}
							else {
								first = stack.pop();
								second = stack.pop();
								int sign = 0;
								if (first <0) sign++;
								if (second <0) sign++;
								
								if (first == 0) {
									flag = false;
									break;
								}
								else {
									long div = Math.abs(second) / Math.abs(first);
									if (sign == 1) {
										stack.add(-div);
									}
									else {
										stack.add(div);
									}
								}
							}
						}
						else if (cal.equals("MOD")) {
							if (stack.size() < 2) {
								flag = false;
								break;
							}
							else {
								first = stack.pop();
								second = stack.pop();
								if (first == 0) {
									flag = false;
									break;
								}
								else {
									long mod = Math.abs(second) % Math.abs(first);
									if(second <0) {
										stack.add(-mod);
									}
									else {
										stack.add(mod);	
									}
									
								}
							}
						}
					
					}
					
					if (stack.size() != 1 || flag == false) {
						sb.append("ERROR\n");
					}
					else {
						sb.append(stack.peek()).append("\n");
					}
					
				}
				 sb.append("\n");
			}
		System.out.println(sb);
	}
}