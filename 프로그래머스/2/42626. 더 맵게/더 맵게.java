import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Num> pq = new PriorityQueue<Num>((o1,o2) -> o1.x - o2.x);
        
        for (int val : scoville) {
            pq.offer(new Num(val));
        }
        
        while (true) {
            if (pq.peek().x >= K) {
                return answer;
            }
            
            if (pq.size() < 2) return -1;
            
            int first = pq.poll().x;
            int second = pq.poll().x;
            
            int total = first + (second*2);
            
            pq.offer(new Num(total));
            
            answer++;
        }
    }
}

class Num{
    int x;
    public Num(int x) {
        this.x = x;
    }
    @Override
    public String toString() {
        return x + " ";
    }
}