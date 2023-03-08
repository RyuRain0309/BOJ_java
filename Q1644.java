import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q1644 {
    static final int MAX = 4_000_00;
    static ArrayList<Long> primeSum = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        getPrime();
        int res = 0;
        int sPoint = 0;
        int ePoint = 1;
        while (ePoint < primeSum.size() && primeSum.get(ePoint) - primeSum.get(ePoint-1) <= N){
            long sum = primeSum.get(ePoint) - primeSum.get(sPoint);
            //System.out.println(primeSum.get(ePoint) - primeSum.get(ePoint-1) + " " + primeSum.get(ePoint)+ " " + primeSum.get(sPoint) + " " + sum);
            if(sum > N){
                sPoint++;
            }
            else if(sum == N){
                res++;
                sPoint++;
            }
            else{
                ePoint++;
            }
        }
        System.out.print(res);
    }

    private static void getPrime() {
        boolean[] isPrime = new boolean[MAX+1];
        Arrays.fill(isPrime,true);
        for(int i = 3 ; i < Math.sqrt(MAX+1) ; i+= 2){
            isPrime[1] = false;
            if(isPrime[i]){
                for(int j = i + i ; j <= MAX ; j += i  ){
                    isPrime[j] = false;
                }
            }
        }
        primeSum.add(0L);
        primeSum.add(2L);
        for(int i = 3 ; i <= MAX ; i+= 2){
            if(isPrime[i]){
                primeSum.add(primeSum.get(primeSum.size() - 1) + i);
            }
        }
    }
}
