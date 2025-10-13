class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class Binary_Tree {
    Node root;

    public Binary_Tree() {
        root = null;
    }

    // In-order traversal
    public void in_order(Node node) {
        if (node != null) {
            in_order(node.left);
            System.out.print(node.value + " ");
            in_order(node.right);
        }
    }

    // Pre-order traversal
    public void pre_order(Node node){
        if(node != null){
            System.out.print(node.value + " ");
            pre_order(node.left);
            pre_order(node.right);
        }
    }

    // Post-order traversal
    public void post_order(Node node){
        if(node != null){
            post_order(node.left);
            post_order(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();

        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(7);

        System.out.println("Tree created successfully\n");
        System.out.print("In-order traversal: ");
        tree.in_order(tree.root);

        System.out.print("\nPre-order traversal: ");
        tree.pre_order(tree.root);

        System.out.print("\nPost-order traversal: ");
        tree.post_order(tree.root);
    }
}