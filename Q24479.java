import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q24479 {
    static int N;
    static int M;
    static int[] visited;
    static LinkedList<PriorityQueue<Integer>> v = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i <= N ; i++){
            v.add(new PriorityQueue<>());
        }

        for(int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            v.get(from).add(to);
            v.get(to).add(from);

        }
        dfs(start,1);
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int node, int order) {
        if(visited[node] != 0){
            return;
        }
        visited[node] = order;
        for(Integer i : v.get(node)){
            dfs(i,order+1);
        }
    }
}
