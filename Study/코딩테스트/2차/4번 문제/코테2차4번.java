import java.util.*;

class 코테2차4번 {
    public int solution(int delay, int capacity, int[] times) {
        int answer = 0;
        int currentProcess = delay;
        int currentQueue = 0;

        for (int time : times) {
            if(time < currentProcess) {
                currentProcess -= time;
                if(currentQueue == capacity) {
                    answer++;
                } else {
                    currentQueue++;
                }
            } else if (time == currentProcess) {
                currentProcess = delay;
            } else {
                int maxSentFromQueue = (time - currentProcess) / delay;

                if (currentQueue <= maxSentFromQueue) {
                    currentProcess = delay;
                    currentQueue = 0;
                } else {
                    currentProcess = delay - (time - currentProcess) % delay;
                    currentQueue -= maxSentFromQueue;
                }
            }
        }
        return answer;
    }
}