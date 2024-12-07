import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<Integer> D = new ArrayList<>();
        Map<Integer, Integer> ABMap = new HashMap<>();
        Map<Integer, Integer> CDMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A.add(Integer.parseInt(st.nextToken()));
            B.add(Integer.parseInt(st.nextToken()));
            C.add(Integer.parseInt(st.nextToken()));
            D.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int ApB = A.get(i) + B.get(j);
                int CpD = C.get(i) + D.get(j);
                ABMap.put(ApB, ABMap.getOrDefault(ApB, 0) + 1);
                CDMap.put(CpD, CDMap.getOrDefault(CpD, 0) + 1);
            }
        }
        ArrayList<Integer> AB = new ArrayList<>(ABMap.keySet());
        Collections.sort(AB);
        ArrayList<Integer> CD = new ArrayList<>(CDMap.keySet());
        Collections.sort(CD);
        long res = 0;
        int left = 0, right = CD.size() - 1;
        while (left < AB.size() && right > 0) {
            if (AB.get(left) + CD.get(right) < 0) {
                left++;
            } else if (AB.get(left) + CD.get(right) > 0) {
                right--;
            } else {
                res += (long) ABMap.get(AB.get(left)) * CDMap.get(CD.get(right));
                left++;
                right--;
            }
        }
        System.out.println(res);
    }
}
