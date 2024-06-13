import java.util.*;

class 코테2차4번 {
    public int solution(int delay, int capacity, int[] times) {
        int answer = 0;
        int currentTime = 0;
        int currentQueue = 0;

        for (int time : times) {
            currentTime += time;
            int sent = currentTime / delay;

            currentQueue = Math.max(0, currentQueue - sent);

            if (currentQueue == capacity) {
                answer += 1;
            } else {
                currentQueue += 1;
            }

            currentTime %= delay;
        }

        return answer;
    }
}