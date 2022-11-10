import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리 순회
public class BOJ_1991 {
    static Node head = new Node('A', null, null); // 항상 A가 루트 노드가 됨

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 노드의 개수

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root,left,right); // 노드 입력
        }

        // 출력
        preOrder(head); // 전위
        System.out.println();
        inOrder(head); // 중위
        System.out.println();
        postOrder(head); // 후위
        System.out.println();
    }

    // 노드, char-data 와 leftChild 와 rightChild 를 가진 녿드 객체를 만들어 구현
    static class Node{
        char root; // rootData
        Node left; // leftChildData
        Node right; // rightChildData

        // 생성자
        Node(char root, Node left, Node right){
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    // 자식 노드 생성
    public static void insertNode(Node temp, char root, char left, char right) {
        /* A B C 를 입력 받아서 B 노드와 C 노드가 생겼는데, 이 B 노드를 루트 노드로 하는 값을
           입력 받으면 B 노드의 왼쪽 자식과 오른쪽 자식이 있는지 비교하고 그 자식들을 노드로 만듬
           B D . 을 입력받으면 B 노드를 루트로 하고 왼쪽 자식이 D 오른쪽 자식은 없는 노드가 생성 */
        if (temp.root == root) {
            temp.left = (left == '.' ? null : new Node(left,null,null));
            temp.right = (right == '.' ? null : new Node(right,null,null));
        }
        else {
            // 왼쪽 자식이 존재하면 insertNode() 호출
            if(temp.left != null) {
                insertNode(temp.left, root, left, right);
            }
            // 오른쪽 자식이 존재하면 insertNode() 호출
            if(temp.right != null) {
                insertNode(temp.right, root, left, right);
            }
        }
    }

    // 전위 순회
    public static void preOrder(Node node) {
        // 노드가 없으면 돌아감
        if(node == null) {
            return;
        }
        // data - root - right 순서
        System.out.print(node.root);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위 순회
    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        // left - root - right 순서
        inOrder(node.left);
        System.out.print(node.root);
        inOrder(node.right);
    }

    // 후위 순회
    public static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        // left - right - root 순서
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.root);
    }
}