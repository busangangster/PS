import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i=0; i<10; i++) {
            hm.put(discount[i],hm.getOrDefault(discount[i],0)+1);
        }
        
        if (check(want,number,hm)) {
            answer++;
        }
            
        for (int i=0; i<discount.length-10;i++) {
            // i를 빼고 10+i를 추가해야하네
            hm.put(discount[i], hm.get(discount[i])-1);
            hm.put(discount[10+i],hm.getOrDefault(discount[10+i],0)+1);
            if (check(want, number, hm)) answer++;
        }
                
        return answer;
        
    }
    
    public static boolean check(String[] want, int[] number, HashMap<String,Integer> hm ) {
        for (int i=0; i<want.length; i++) {
            if (!hm.containsKey(want[i])) return false;
            if (hm.get(want[i]) != number[i]) return false;
        }
        return true;
    }
}