class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int max_hp = health; 
        int cooldown = bandage[0];
        int gain = bandage[1];
        int plus = bandage[2];
        int time = 1;
        int cnt = 0;
        boolean flag = true;
        
        for (int i=0; i<attacks.length; i++) {
            while (true) {
                if (time == attacks[i][0]) {
                    health -= attacks[i][1];
                    if (health <= 0) flag = false;
                    else {
                        time++;
                        cnt=0;
                    }
                    break;
                }
                else {
                    time++;
                    health += gain;
                    cnt++;
                    if (cnt == cooldown) {
                        health += plus;
                        cnt = 0;
                    }
                    if (health > max_hp) {
                        health = max_hp;
                    }
                }
            }
            if (!flag) break;
        }
        if (!flag) answer = -1;
        else answer = health;
        
        return answer;
    }
}