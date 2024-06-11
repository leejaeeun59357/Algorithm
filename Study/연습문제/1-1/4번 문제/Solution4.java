class Solution4 {
    public int solution(String s) {
        int answer = -1;

        int[] numsCount = new int[10];

        for (int i = 0; i < s.length(); i++) {
            int num = Integer.parseInt(s.substring(i,i+1));
            numsCount[num]++;
        }

        int maxCount = 0;
        for (int i = 0; i < numsCount.length; i++) {
            if(maxCount < numsCount[i]) {
                maxCount = numsCount[i];
                answer = i;
            }
        }

        return answer;
    }
}