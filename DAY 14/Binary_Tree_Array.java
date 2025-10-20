class Binary_Tree_Array {
    private int size;
    private int[] tree;

    public Binary_Tree_Array(int size){
        this.size = size;
        tree = new int[size];
    }

    public void setLeft(int parentIndex, int value){
        int leftIndex = 2 * parentIndex + 1;
        if(leftIndex < size){
            tree[leftIndex] = value;
        } else{
            System.out.println("Left child index is out of range!");
        }
    }

    public void setRight(int parentIndex, int value){
        int rightIndex = 2 * parentIndex + 2;
        if(rightIndex < size){
            tree[rightIndex] = value;
        } else{
            System.out.println("Right child index is out of range!");
        }
    }
    
    // In-order traversal (left → root → right)
    public void inorder(int index) {
        if (!(index >= size || tree[index] == 0)){
            inorder(2 * index + 1);
            System.out.print(tree[index] + " ");
            inorder(2 * index + 2);
        }
    }

    // Pre-order traversal (root → left → right)
    public void preorder(int index) {
        if (!(index >= size || tree[index] == 0)){
            System.out.print(tree[index] + " ");
            preorder(2 * index + 1);
            preorder(2 * index + 2);
        }
    }
    
    // Post-order traversal (left → right → root)
    public void postorder(int index) {
        if (!(index >= size || tree[index] == 0)){
            postorder(2 * index + 1);
            postorder(2 * index + 2);
            System.out.print(tree[index] + " ");
        }
    }

    public void printTree(){
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Binary_Tree_Array binaryTree = new Binary_Tree_Array(7);
    
        binaryTree.tree[0] = 1; // set root node
    
        binaryTree.setLeft(0, 2);
        binaryTree.setRight(0, 3);
        binaryTree.setLeft(1, 4);
        binaryTree.setRight(1, 5);
        binaryTree.setLeft(2, 6);
    
        binaryTree.printTree();
    
        System.out.print("Preorder: ");
        binaryTree.preorder(0);
    
        System.out.print("\nInorder: ");
        binaryTree.inorder(0);
    
        System.out.print("\nPostorder: ");
        binaryTree.postorder(0);
    }
}