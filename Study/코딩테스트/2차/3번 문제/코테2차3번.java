import java.util.*;

class 코테2차3번 {

    int i = 0;
    public String solution1(String code) {
        return recursive(code);
    }

    public String recursive(String s) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        String temp;

        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                num = Character.getNumericValue(s.charAt(i));
                i++;
            } else if (s.charAt(i) == '{') {
                i++;
                temp = recursive(s);
                sb.append(temp.repeat(num));
            } else if (s.charAt(i) == '}') {
                i++;
                break;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}