public class ArbolBinario<E extends Comparable<E>> {

    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<E> root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(E data) {
        root = insertRec(root, data);
    }

    private Node<E> insertRec(Node<E> node, E data) {

        if (node == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {

            node.left = insertRec(node.left, data);
        } else if (cmp > 0) {

            node.right = insertRec(node.right, data);
        }

        return node;
    }

    public E search(E data) {
        return searchRec(root, data);
    }

    private E searchRec(Node<E> node, E data) {
        if (node == null) {
            return null;
        }

        int cmp = data.compareTo(node.data);

        if (cmp == 0) {
            return node.data;
        } else if (cmp < 0) {
            return searchRec(node.left, data);
        } else {
            return searchRec(node.right, data);
        }
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println(); 
    }

    private void inOrderRec(Node<E> node) {
        if (node != null) {
            inOrderRec(node.left);          
            System.out.print(node.data + " "); 
            inOrderRec(node.right);         
        }
    }

    public boolean isEmpty() {
        return root == null;
    }
}