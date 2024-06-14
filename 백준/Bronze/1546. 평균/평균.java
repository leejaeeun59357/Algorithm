import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] arr = new int[count];

        for(int i =0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = arr[arr.length - 1];

        int sum = Arrays.stream(arr).sum() * 100;

        double tmp = (double) sum / (count  * max);

        System.out.print(tmp);
    }
}