import java.util.ArrayList;

class Solution3 {
    public int solution(int[] A) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
                arr.add(A[j] - A[i]);
            }
        }

        int answer =0;

        for (int i = 0; i < arr.size(); i++) {
            if (answer <= arr.get(i)) {
                answer = arr.get(i);
            }
        }
        return answer;
    }
}