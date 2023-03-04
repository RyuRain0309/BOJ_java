import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1753 {
    static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int[] res = new int[V+1];
        boolean[] isVisited = new boolean[V+1];
        Arrays.fill(res,INF);
        ArrayList<ArrayList<Pair>> node = new ArrayList<>();

        for(int i = 0 ; i <= V ; i++){
            node.add(new ArrayList<>());
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            node.get(from).add(new Pair(to,weight));
        }

        for(int i = 1 ; i <= V ; i++){
            if(!node.get(i).isEmpty()){
                node.get(i).sort(Comparator.comparingInt(o -> o.weight));
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(o -> res[o]));
        q.add(start);
        res[start] = 0;
        isVisited[start] = true;

        while (!q.isEmpty()){
            int temp = q.poll();
            for(Pair i : node.get(temp)){
                res[i.vertex] = Math.min(res[i.vertex],res[temp] + i.weight);
                if(!isVisited[i.vertex]){
                    q.add(i.vertex);
                    isVisited[i.vertex] = true;
                }
            }
        }
        for(int i = 1 ; i <= V ; i++){
            sb.append(res[i] == INF ? "INF" : res[i]).append("\n");
        }
        System.out.print(sb);
    }
    private static class Pair{
        final int vertex;
        final int weight;
        Pair(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
