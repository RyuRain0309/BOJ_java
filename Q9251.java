import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int[][] dp = new int[A.length+1][B.length+1];
        for(int i = 0 ; i <= A.length ; i++){
            dp[i][0] = i;
        }
        for(int i = 0 ; i <= B.length ; i++){
            dp[0][i] = i;
        }
        for(int i = 1 ; i <= A.length ; i++){
            for(int j = 1 ; j <= B.length ; j++){
                int val = (A[i-1] == B[j-1]) ? 0 : 1;
                dp[i][j] = Math.min(dp[i-1][j-1] + val,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
            }
        }
        for(int i = 0 ; i <= A.length ; i++) {
            for (int j = 0; j <= B.length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        System.out.print(dp[A.length][B.length]);
    }
}
