import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1991 {
    static ArrayList<Character> pre = new ArrayList<>();
    static ArrayList<Character> in = new ArrayList<>();
    static ArrayList<Character> post = new ArrayList<>();
    static char[][] node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        node = new char[N][2];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int par = st.nextToken().charAt(0) - 'A';
            node[par][0] = st.nextToken().charAt(0);
            node[par][1] = st.nextToken().charAt(0);
        }

        preorder(0);
        inorder(0);
        postorder(0);

        StringBuilder sb = new StringBuilder();
        for(Character c : pre){
            sb.append(c);
        }
        sb.append("\n");
        for(Character c : in){
            sb.append(c);
        }
        sb.append("\n");
        for(Character c : post){
            sb.append(c);
        }
        sb.append("\n");
        System.out.print(sb);
    }

    private static void postorder(int num) {
        if(node[num][0] != '.'){
            postorder(node[num][0] - 'A');
        }
        if(node[num][1] != '.'){
            postorder(node[num][1] - 'A');
        }
        post.add((char) (num + 'A'));
    }

    private static void inorder(int num) {
        if(node[num][0] != '.'){
            inorder(node[num][0] - 'A');
        }
        in.add((char) (num + 'A'));
        if(node[num][1] != '.'){
            inorder(node[num][1] - 'A');
        }
    }
    private static void preorder(int num) {
        pre.add((char) (num + 'A'));
        if(node[num][0] != '.'){
            preorder(node[num][0] - 'A');
        }
        if(node[num][1] != '.'){
            preorder(node[num][1] - 'A');
        }
    }
}
