import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K];
            int[] sum = new int[K];
            int[][] dp = new int[K][K];
            st = new StringTokenizer(br.readLine()," ");
            arr[0] = Integer.parseInt(st.nextToken());
            sum[0] = arr[0];
            for(int i = 1 ; i < K ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + arr[i];
            }

            for(int n = 1 ; n <= K ; n++){
                for(int from = 0 ; from+n < K ; from++){
                    int to = from+n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int div = from ; div < to ; div++){
                        if(from == 0){
                            dp[from][to] = Math.min(dp[from][to],dp[from][div] + dp[div+1][to] + sum[to]);
                        }
                        else {
                            dp[from][to] = Math.min(dp[from][to],dp[from][div] + dp[div+1][to] + sum[to] - sum[from - 1]);
                        }
                    }
                }
            }
            sb.append(dp[1][K-1]).append("\n");
        }
        System.out.print(sb);
    }
}
