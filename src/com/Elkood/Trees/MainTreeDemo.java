package com.Elkood.Trees;

public class MainTreeDemo {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(19, 10);
        tree.Insert(10, 3);
        tree.Insert(7, 3);
        tree.Insert(8, 3);
        tree.Insert(5, 3);
        tree.Insert(1, 3);
        tree.Insert(33, 3);
        tree.InOrder(tree.root);
        tree.delete(10);
        System.out.println();
        tree.InOrder(tree.root);
        System.out.println();
        tree.delete(19);
        tree.PreOrder(tree.root);
        System.out.println();
        tree.InOrder(tree.root);
        System.out.println();
        tree.PostOrder(tree.root);

    }

}
