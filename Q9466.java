import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q9466 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static boolean[] isVisited;
    static boolean[] canNotMakeTeam;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            solve();
        }
        System.out.println(sb);
    }

    private static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        isVisited = new boolean[N + 1];
        canNotMakeTeam = new boolean[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= N; i++) {
            if (arr[i] == i) {
                isVisited[i] = true;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (isVisited[i] || canNotMakeTeam[i]) {
                continue;
            }
            dfs(i);
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                cnt++;
            }
        }
        sb.append(cnt).append("\n");
    }

    private static void dfs(int start) {
        ArrayList<Integer> t = new ArrayList<>();
        t.add(start);
        while (true) {
            if (t.contains(arr[t.getLast()])){
                int index =t.indexOf(arr[t.getLast()]);
                for (int i = 0; i < index; i++) {
                    canNotMakeTeam[t.get(i)] = true;
                }
                for (int i = index; i < t.size() ; i++) {
                    isVisited[t.get(i)] = true;
                }
                break;
            }
            if (isVisited[arr[t.getLast()]]){
                for (Integer integer : t) {
                    canNotMakeTeam[integer] = true;
                }
                break;
            }
            if (canNotMakeTeam[arr[t.getLast()]]){
                for (Integer integer : t) {
                    canNotMakeTeam[integer] = true;
                }
                break;
            }
            t.add(arr[t.getLast()]);
        }
    }
}
