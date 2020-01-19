package com.Elkood.Trees;

import java.io.PrintWriter;


class Tree {
    public Node root;

    public Node find(int key) {
        Node current = root;
        while (current.id != key) {
            if (key < current.id) {
                current = current.left;
            } else {
                current = current.Right;
            }
            if (current == null) return null;
        }
        return current;

    }

    public void Insert(int id, int dd) {
        Node NewNode = new Node(id, dd);
        Node current = root;
        Node Parent;
        if (current == null) root = NewNode;
        else {
            while (true) {
                Parent = current;
                if (id < current.id) {
                    current = current.left;
                    if (current == null) {
                        Parent.left = NewNode;
                        return;
                    }
                } else {
                    current = current.Right;
                    if (current == null) {
                        Parent.Right = NewNode;
                        return;
                    }
                }

            }

        }

    }

    public void PreOrder(Node Locale) {
        PrintWriter pw = new PrintWriter(System.out);
        //        //RLR ->root -> left ->right
        if (Locale != null) {
            pw.print(Locale.id + " ");
            pw.flush();
            PreOrder(Locale.left);
            PreOrder(Locale.Right);
        }
    }

    public void InOrder(Node Locale) {
        PrintWriter pw = new PrintWriter(System.out);
        //LRR->left -> root ->right
        if (Locale != null) {
            InOrder(Locale.left);
            pw.print(Locale.id + " ");
            pw.flush();
            InOrder(Locale.Right);
        }
    }

    public void PostOrder(Node Locale) {
        PrintWriter pw = new PrintWriter(System.out);
        //LRR->left -> right -> root
        if (Locale != null) {
            PostOrder(Locale.left);
            PostOrder(Locale.Right);
            pw.print(Locale.id + " ");
            pw.flush();
        }
    }

    public Node getMinNode() {
        Node Current, Last = root;
        Current = root;
        while (Current != null) {
            Last = Current;
            Current = Current.left;
        }
        return Last;

    }

    public Node getMaxNode() {
        Node Current = root;
        Node Last = root;
        while (Current != null) {
            Last = Current;
            Current = Current.Right;
        }
        return Last;
    }

    // for Delete node
    //*
    // no Child
    // one Child
    //Two Child
    // **/
    public boolean delete(int key) {
        Node Current = root;
        Node Parent = root;
        boolean isLeftChild = true;
        // Find Node
        while (Current.id != key) {
            Parent = Current;
            if (key < Current.id) {
                Current = Current.left;
                isLeftChild = true;
            } else {
                Current = Current.Right;
                isLeftChild = false;
            }
            if (Current == null) return false;
        }

        if (Current.Right == null && Current.left == null) {
            if (Current == root) root = null;
            if (isLeftChild)
                Parent.left = null;
            else Parent.Right = null;
            return true;
        }

        // and Delete Node has One Child
        else if (Current.Right == null) {
            if (Current == root)
                root = Current.left;

            if (isLeftChild) {
                Parent.left = Current.left;
            } else {
                Parent.Right = Current.left;
            }

        } else if (Current.left == null) {
            if (Current == root)
                root = Current.Right;
            if (isLeftChild) {
                Parent.left = Current.Right;
            } else {
                Parent.Right = Current.Right;
            }
        }
        // has two Child
        else {
            Node Successor = getSuccessor(Current);
            if (Current == root) root = Successor;
            else if (isLeftChild) {
                Parent.left = Successor;
            } else {
                Parent.Right = Successor;
            }
            Successor.left = Current.left;
        }
        return true;
    }

    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.Right;
        while ((current != null)) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != delNode.Right) {
            successorParent.left = successor.Right;
            successor.Right = delNode.Right;

        }
        return successor;

    }


}
