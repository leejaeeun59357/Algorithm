import java.util.*;

class 코테1차2번 {
    public int solution(String[] names) {

        Set<String> set = new HashSet<>(Arrays.asList(names));
        int n = set.size();
        int nResult = 1;

        for (int i = n; i >= n - 3; i--) {
            nResult *= i;
        }
        int rResult = 1;

        for (int i = 1; i <= 4; i++) {
            rResult *= i;
        }

        return nResult / rResult;
    }
}
