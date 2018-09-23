package nk.bat;

public class BinTreeQuestion {
    public static MyBinTree createBinTree(int[] arr,int d) {
        MyBinTree<Integer> root = new MyBinTree<>(arr[d]);
        if (d<arr.length-1)
            root.setLeftChild(createBinTree(arr,++d));
        if (d<arr.length-1)
            root.setRightChild(createBinTree(arr,++d));
        return root;
    }

    public static void main(String[] args) {
        int[] tree = {1,2,3};
        MyBinTree root = createBinTree(tree, 0);
        printTree(root);
    }

    public static void printTree(MyBinTree root){
        if (root==null)
            return;
        System.out.print(root.getNode()+" ");
        printTree(root.getLeftChild());
        printTree(root.getRightChild());
    }
}

