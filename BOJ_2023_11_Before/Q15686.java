package BOJ_2023_11_Before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15686 {
    static  int N, M, chickenHouse;
    static int[][] map;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickenHouse++;
                }
            }
        }
        backTracking(0,0, chickenHouse);

        System.out.println(res);
    }

    static void backTracking(int y, int x, int chick) {
        if(chick == 0){
            return;
        }
        if(y >= N){
            if(chick <= M) {
                res = Math.min(res,getDist());
            }
            return;
        }

        if(map[y][x] != 2) {
            if (x == N - 1) {
                backTracking(y + 1, 0, chick);
            } else {
                backTracking(y, x + 1, chick);
            }
        }
        else if(map[y][x] == 2){
            map[y][x] = 0;
            if (x == N - 1) {
                backTracking(y + 1, 0, chick-1);
            } else {
                backTracking(y, x + 1, chick-1);
            }

            map[y][x] = 2;
            if (x == N - 1) {
                backTracking(y + 1, 0, chick);
            } else {
                backTracking(y, x + 1, chick);
            }
        }
    }

    private static int getDist() {
        int dist = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1){
                    int tempDist = Integer.MAX_VALUE;
                    for(int i1 = 0 ; i1 < N ; i1++){
                        for(int j1 = 0 ; j1 < N ; j1++){
                            if(map[i1][j1] == 2){
                                tempDist = Math.min(tempDist, Math.abs(i-i1) + Math.abs(j-j1));
                            }
                        }
                    }
                    dist += tempDist;
                }
            }
        }

        return dist;
    }
}
