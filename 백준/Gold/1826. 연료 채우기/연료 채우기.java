import java.util.*;
import java.io.*;

class Station implements Comparable<Station> {
    int station;
    int fuel;
    public Station(int station, int fuel) {
        this.station = station;
        this.fuel = fuel;
    }
    
    @Override
    public int compareTo(Station o) {
        return this.station - o.station;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());  // 주유소 갯수
        PriorityQueue<Station> info = new PriorityQueue<Station>();  // 주유소에 대한 정보 담을 우선순위 큐
        String[] s;
        
        // 주유소 정보를 우선순위 큐에 저장
        for(int i=0 ; i < N ; i++) {
            s = br.readLine().split(" ");
            int stationLocation = Integer.parseInt(s[0]);
            int fuel = Integer.parseInt(s[1]);
            info.add(new Station(stationLocation, fuel));
        }
        
        s = br.readLine().split(" ");
        
        // 마을까지 거리
        int totalDistance = Integer.parseInt(s[0]);
        
        // 현재 가지고 있는 연료의 양
        int currentFuel = Integer.parseInt(s[1]);
        
        // 방문한 주유소의 갯수
        int result = 0;
        
        // 가장 큰 연료 순으로 내림차순
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        while(currentFuel < totalDistance) {
        
            while(!info.isEmpty() && currentFuel >= info.peek().station) {
                
                Station tmp = info.poll();
                queue.add(tmp.fuel);
            }
            
            if(queue.isEmpty()) {
                result = -1;
                break;
            }
            
            currentFuel += queue.poll();
            result++;
        }
        System.out.println(result);
    }
}