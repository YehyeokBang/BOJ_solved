import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

// 이진 검색 트리 - 못품
public class BOJ_5639 {
    public static int N;
    public static Tree[] trees;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        trees = new Tree[N];
        String[] input = new String[3];


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[0] = st.nextToken();
            input[1] = st.nextToken();
            input[1] = input[1].equals(".") ? null : input[1];
            input[2] = st.nextToken();
            input[2] = input[2].equals(".") ? null : input[2];
            trees[i] = new Tree(input[0], input[1], input[2]);
        }

        preorder(0);

        bw.write(String.valueOf(sb));
        bw.flush();

    }

    public static class Tree {
        private String node;
        private String llink;
        private String rlink;

        public Tree(String n, String l, String r) {
            this.node = n;
            this.llink = l;
            this.rlink = r;
        }

        public String getNode() {
            return node;
        }

        public String getLlink() {
            return llink;
        }

        public String getRlink() {
            return rlink;
        }
    }

    public static void preorder(int n) {
        sb.append(trees[n].getNode());
        if(trees[n].getLlink() != null) {
            for(int i = 0; i < N; i++) {
                if(trees[i].getNode().equals(trees[n].getLlink())) {
                    preorder(i);
                }
            }
        }
        else {
            for(int i = 0; i < N; i++) {
                if(trees[i].getLlink().equals(trees[n].getNode())) {
                    preorder(i);
                }
            }
        }
    }
}
