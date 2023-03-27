import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17472 {
    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int dist;
        Edge(int a, int b, int dist){
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge o) {
            return dist = o.dist;
        }
    }
    static int[] rangeX = {1, 0, -1, 0};
    static int[] rangeY = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isVisited;
    static int cnt = 1;
    static int[] parent;
    static int[][] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < M ; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    map[i][j] = -1;
                }
            }
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == -1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        parent = new int[cnt];
        dist = new int[cnt][cnt];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 0) continue;
                reSet();
                getDist(i,j,0,map[i][j]);
            }
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0 ; i < cnt ; i++){
            for(int j = i+1 ; j < cnt ; j++){
                edges.add(new Edge(i,j,dist[i][j]));
            }
        }
        int edgeCnt = 0;
        int ans = 0;
        for(Edge edge : edges){
            if(edgeCnt == cnt-1) break;
            if(find(edge.a) == find(edge.b)) continue;

            union(edge.a,edge.b);
            ans += edge.dist;
            edgeCnt++;
        }

        System.out.print(ans);
    }

    private static void reSet() {
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(isVisited[i],false);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a > b){
            parent[a] = b;
        }
        else{
            parent[b] = a;
        }
    }


    private static int find(int num) {
        if(num == parent[num]){
            return num;
        }
        return parent[num] = find(parent[num]);
    }

    private static void getDist(int y, int x, int cnt, int src) {
        isVisited[y][x] = true;

        for(int i = 0 ; i < 4 ; i++){
            int newY = y + rangeY[i];
            int newX = x + rangeX[i];
            if(newX < 0 || newY < 0 || newX >= M || newY >= N){
                continue;
            }
            if(map[newY][newX] == src || isVisited[newY][newX]){
                continue;
            }
            else if(map[newY][newX] == 0){
                getDist(newY,newX,cnt+1,src);
            }
            else{
                if(src < map[newY][newX]){
                    dist[src][map[newY][newX]] = Math.min(dist[src][map[newY][newX]],cnt);
                }
                else{
                    dist[map[newY][newX]][src] = Math.min(dist[map[newY][newX]][src],cnt);
                }
            }
        }
    }

    private static void dfs(int y, int x) {
        map[y][x] = cnt;
        for(int i = 0 ; i < 4 ; i++){
            int newY = y + rangeY[i];
            int newX = x + rangeX[i];
            if(newX < 0 || newY < 0 || newX >= M || newY >= N){
                continue;
            }
            if(map[newY][newX] == -1){
                dfs(newY,newX);
            }
        }
    }
}
