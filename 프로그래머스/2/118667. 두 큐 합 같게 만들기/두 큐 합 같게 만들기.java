import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> q1 = new ArrayDeque<Integer>();
        Queue<Integer> q2 = new ArrayDeque<Integer>();
        
        for (int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
        }
        for (int i=0; i<queue2.length; i++) {
            q2.add(queue2[i]);
        }
        
        int answer = 0; 
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 =  Arrays.stream(queue2).sum();
        long target = (sum1 + sum2) / 2;
        
        while (true) {
            if (sum1 == sum2) {
                return answer;
            }
            if (answer >= 5000000) {
                return -1;
            }
            else {
                if (sum1 > sum2) {
                    int res = q1.poll();
                    q2.add(res);
                    sum1 -= res;
                    sum2 += res;
                }   
                else if (sum1 < sum2) {
                    int res = q2.poll();
                    q1.add(res);
                    sum1 += res;
                    sum2 -= res;
                }
            }
            answer++;
        } 
    }
}

