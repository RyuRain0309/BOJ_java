package BOJ_23_11_Until;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for (int i = 0 ; i < N ;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < M ; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];
        for (int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < K ; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < K ; j++){
                int temp = 0;
                for(int k = 0 ; k < M ; k++){
                    temp += A[i][k] * B[k][j];
                }
                sb.append(temp).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
