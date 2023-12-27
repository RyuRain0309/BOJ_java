package unknown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {
    static int N;
    static int[] arr;
    static int[] oper = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }
        result(2,0,1);
        System.out.print(MAX + "\n" + MIN);
    }

    private static void result(int what, int n, int value) {
        value = operate(what,n,value);
        if(n==N-1){
            if(value > MAX){
                MAX = value;
            }
            if(value < MIN){
                MIN = value;
            }
            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            if(oper[i] > 0){
                oper[i]--;
                result(i,n+1,value);
                oper[i]++;
            }
        }
    }

    private static int operate(int i,int n, int value) {
        return switch (i) {
            case 0 -> value + arr[n];
            case 1 -> value - arr[n];
            case 2 -> value * arr[n];
            case 3 -> value / arr[n];
            default -> 0;
        };
    }
}
