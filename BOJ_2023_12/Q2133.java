package BOJ_2023_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = N * 3;
        if( size % 2 != 0){
            System.out.println(0);
            return;
        }
//        TBU
    }
}
