package BOJ_2023_11_Before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] time, res;
    static boolean[] checkStart;
    static ArrayList<Integer>[] node;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            time = new int[N+1];
            node = new ArrayList[N+1];
            for(int i = 1 ; i <= N ; i++){
                node[i] = new ArrayList<>();
            }
            res = new int[N+1];
            Arrays.fill(res,Integer.MIN_VALUE);
            checkStart = new boolean[N+1];
            Arrays.fill(checkStart,true);

            st = new StringTokenizer(br.readLine()," ");
            for(int i = 1 ; i <= N ; i++){
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0 ; i < K ; i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                node[to].add(from);
                checkStart[to] = false;
            }

            int dest = Integer.parseInt(br.readLine());

            res[dest] = time[dest];
            Queue<Integer> q = new LinkedList<>();
            q.add(dest);
            while (!q.isEmpty()){
                int temp = q.poll();
                for(Integer i : node[temp]){
                    res[i] = Math.max(res[i], res[temp] + time[i]);
                    q.add(i);
                }
            }
            int ans = 0;
            for(Integer i : res){
                ans = Math.max(ans,i);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
