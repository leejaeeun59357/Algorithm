import java.util.*;

class 코테2차2번 {
    public List<Integer> solution1(int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();

        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        Stack<Integer> answerStack = new Stack<>();
        int aVal;
        int bVal;
        int sum;
        int mok = 0;

        for (int i = 0; i < a.length; i++) {
            stackA.push(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            stackB.push(b[i]);
        }

        while(true) {
            if(stackA.isEmpty() && stackB.isEmpty()) {
                if (mok != 0) {
                    answerStack.push(1);
                }
                break;
            }


            if(!stackA.isEmpty()) {
                aVal = stackA.pop();
            } else {
                aVal = 0;
            }

            if(!stackB.isEmpty()) {
                bVal = stackB.pop();
            } else {
                bVal = 0;
            }

            sum = aVal + bVal + mok;
            if(sum >= 10) {
                mok = sum / 10 ;
                sum %= 10;
            } else {
                mok = 0;
            }

            answerStack.push(sum);

        }

        while(!answerStack.isEmpty()) {
            answer.add(answerStack.pop());
        }

        return answer;

    }

    public int[] solution2(int[] a, int[] b) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = Math.max(a.length, b.length);
        int offsetA = maxLen - a.length;
        int offsetB = maxLen - b.length;

        if(a.length == 0) {
            return b;
        }

        if(b.length == 0) {
            return a;
        }

        int overflow = 0;

        for (int i = maxLen - 1; i >= 0 ; i--) {
            int aVal = (i - offsetA < 0) ? 0 : a[i];
            int bVal = (i - offsetB < 0) ? 0 : b[i];
            int cVal = aVal + bVal + overflow;

            if(cVal >= 10) {
                overflow = 1;
                stack.push(cVal-10);
            } else {
                overflow = 0;
                stack.push(cVal);
            }
        }

        if(overflow == 1) {
            stack.push(1);
        }

        int stackSize = stack.size();

        int[] answer = new int[stackSize];

        for (int i = 0; i < stackSize; i++) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}