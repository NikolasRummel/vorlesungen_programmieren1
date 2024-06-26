package de.dhbw.nikolas.exercise.datastructures.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public List<T> traverse() {
        return traverse(null);
    }


    // not finished yet
    public boolean add(T value) {
        if (value != null) {
            this.value = value;
        }

        assert value != null;
        if (value.compareTo(this.value) == 0) {
            return false;

        } else if (value.compareTo(this.value) < 0) {
            if (this.right == null) {
                this.right = new BinaryTree<>();
            }
            return this.right.add(value);
        } else if (value.compareTo(this.value) > 0) {
            if (this.left == null) {
                this.left = new BinaryTree<>();
            }
            return this.left.add(value);
        }

        return false;
    }

    public List<T> traverse(List<T> sorted) {
        if (sorted == null) {
            sorted = new LinkedList<>();
        }

        if (this.left != null) {
            sorted = this.left.traverse(sorted);
        }

        if (this.value != null) {
            sorted.add(this.value);
        }

        if (this.right != null) {
            sorted = this.right.traverse(sorted);
        }

        return sorted;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> myTree = new BinaryTree<>();
        myTree.add(22);
        myTree.add(10);
        myTree.add(12);
        myTree.add(5);
        myTree.add(27);
        myTree.add(26);
        myTree.add(70);

        System.out.println(myTree.traverse());
    }

}
