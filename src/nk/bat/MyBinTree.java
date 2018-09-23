package nk.bat;

public class MyBinTree<T> {
    private  T node;
    private MyBinTree leftChild;
    private MyBinTree rightChild;
    public MyBinTree(T node){
        leftChild = null;
        rightChild = null;
        this.node = node;
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public MyBinTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MyBinTree leftChild) {
        this.leftChild = leftChild;
    }

    public MyBinTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(MyBinTree rightChild) {
        this.rightChild = rightChild;
    }
}
