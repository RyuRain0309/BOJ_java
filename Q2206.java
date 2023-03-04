import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
    static int[] rangeX = { 1, 0, -1, 0};
    static int[] rangeY = { 0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        boolean[][][] isVisited = new boolean[N][M][2];
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < M ; j++){
                if(s.charAt(j) == '1'){
                    map[i][j] = true;
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1, false));
        isVisited[0][0][0] = true;
        while (!q.isEmpty()){
            Pair pair = q.poll();
//            System.out.println(pair.y + " "+ pair.x + " "+ pair.cnt + " " + pair.isBreak);
            if(pair.y == N-1 && pair.x == M-1){
                System.out.print(pair.cnt);
                System.exit(0);
            }
            for(int i = 0 ; i < 4 ; i++){
                int moveY = pair.y + rangeY[i];
                int moveX = pair.x + rangeX[i];
                if(moveY < 0 || moveX < 0 || moveY >= N || moveX >= M){
                    continue; //ArrayIndexOutBound Remove
                }

                if(isVisited[moveY][moveX][pair.isBreak ? 1 : 0]){
                    continue; //Duplication Remove
                }

                if(map[moveY][moveX]){
                    if(!pair.isBreak){
                        q.add(new Pair(moveY,moveX, pair.cnt + 1,true ));
                        isVisited[moveY][moveX][1] = true;
                    }
                }
                else{
                    q.add(new Pair(moveY,moveX, pair.cnt + 1, pair.isBreak ));
                    isVisited[moveY][moveX][pair.isBreak ? 1 : 0] = true;
                }
            }
        }
        System.out.print(-1);
    }

    private static class Pair{
        final int y;
        final int x;
        final int cnt;
        final boolean isBreak;
        Pair(int y, int x, int cnt, boolean isBreak){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.isBreak = isBreak;
        }
    }
}
