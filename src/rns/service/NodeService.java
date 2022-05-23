package rns.service;

import rns.interfaces.NodeInterface;
import rns.tree.Node;

public class NodeService implements NodeInterface {

    Node root;

    public NodeService() {
        root = null;
    }

    @Override
    public Node insert(Node root, Integer info) {
        if (root == null) {
            return newNode(null, info);
        }
        //if root's data is greater than data then
        //create a node left side
        if (root.getInfo() > info) {
            root.setLeft(insert(root.getLeft(), info));
        }
        //if root's data is greater than data then
        //create a node on right side
        else if (root.getInfo() < info) {
            root.setRight(insert(root.getRight(), info));
        } else {
            //update the height of node
            root.setHeight(1 + bigger(height(root.getRight()), height(root.getLeft())));
        }
        //get the balance factor of the node
        //bf = hl - hr
        int balanceFactor = height(root.getLeft()) - height(root.getRight());

        //Now we have four cases

        //left left - rightRotate
        if (balanceFactor > 1 && info < root.getLeft().getInfo()) {
            return rotate(root, "r");
        }

        //right right - leftRotate
        if (balanceFactor < -1 && info > root.getRight().getInfo()) {
            return rotate(root, "left");
        }

        //left right - leftRotate followed by rightRotate
        if (balanceFactor > 1 && info > root.getLeft().getInfo()) {

            root.setLeft(rotate(root.getLeft(), "left"));
            return rotate(root, "r");
        }

        //right left - rightRotate followed by leftRotate
        if (balanceFactor < -1 && info < root.getRight().getInfo()) {

            root.setRight(rotate(root.getRight(), "r"));
            return rotate(root, "left");
        }
        return root;

    }

    @Override
    public Node newNode(Node root, Integer info) {
        Node newNode = new Node();
        newNode.setInfo(info);
        return newNode;
    }

    @Override
    public Node rotate(Node parent, String position) {
        Node child;
        if ("left".equals(position)) {
            child = parent.getRight();
            Node temp = child.getLeft();

            child.setLeft(parent);
            parent.setRight(temp);
        } else {
            child = parent.getLeft();
            Node temp = child.getRight();

            child.setRight(parent);
            parent.setLeft(temp);

        }
        return child;
    }


    @Override
    public Integer height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.getHeight();
    }

    @Override
    public Integer bigger(Integer a, Integer b) {
        return ((a > b) ? a : b);
    }

    @Override
    public void organize(Node root) {
        if (root == null)
            return;
        organize(root.getLeft());
        System.out.print(root.getInfo() + "->");
        organize(root.getRight());
    }

    @Override
    public void reOrganize(Node root) {
        if (root == null)
            return;
        System.out.print(root.getInfo() + "->");
        reOrganize(root.getLeft());
        reOrganize(root.getRight());
    }


    @Override
    public Node delete(Node root, Integer info) {
        if (root == null) {
            return null;
        }

        if (info < root.getInfo()) {
            root.setLeft(delete(root.getLeft(), info));
        } else if (info > root.getInfo()) {
            root.setRight(delete(root.getRight(), info));
        } else {
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                Node temp = null;
                if (null == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();

                if (temp == null) {
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = minValueNode(root.getRight());

                root.setInfo(temp.getInfo());

                root.setRight(delete(root.getRight(), temp.getInfo()));
            }
        }

        if (root == null) {
            return null;
        }

        root.setHeight(bigger(height(root.getLeft()), height(root.getRight())) + 1);

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return rotate(root, "r");

        if (balance > 1 && getBalance(root.getLeft()) < 0) {
            root.setLeft(rotate(root.getLeft(), "left"));
            return rotate(root, "r");
        }

        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return rotate(root, "left");

        if (balance < -1 && getBalance(root.getRight()) > 0) {
            root.setRight(rotate(root.getRight(), "r"));
            return rotate(root, "left");
        }

        return root;
    }

   @Override
   public Node minValueNode(Node node)
    {
        Node current = node;

        while (current.getLeft() != null)
            current = current.getLeft();

        return current;
    }

    @Override
    public int getBalance(Node node)
    {
        if (node == null)
            return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    @Override
    public boolean search(Node root, Integer info) {
        if(root == null) return false;
        if(root.getInfo().compareTo(info) == 0) return true;
        else if(root.getInfo().compareTo(info) > 0)
            return search(root.getLeft(), info);
        else
            return search(root.getRight(), info);
    }

    public String toTreeString(String prefix, boolean top, String tree, Node node) {
        Node left;
        Node right;
        String temp;

        if (node == null) {
            return "";
        }

        left = node.getLeft();
        right = node.getRight();

        if (right != null) {

            temp = path(top, "" + prefix, "│   ", "    ");

            tree = toTreeString(temp, false, tree, right);
        }

        tree = path(top, tree + prefix, "└──", "┌──");

        tree += " " + node.getInfo() + "\n";

        if (left != null) {

            temp = path(top, "" + prefix, "    ", "│   ");

            tree = toTreeString(temp, true, tree, left);
        }

        return tree;
    }

    private String path(boolean condition, String s, String choice1, String choice2) {

        if (condition) {
            s += choice1;
        } else {
            s += choice2;
        }

        return s;
    }

    public int isBalanced(Node node) {
        if (node == null)
            return 0;

        // Get heights of subtrees
        int h1 = isBalanced(node.getLeft());
        int h2 = isBalanced(node.getRight());

        if (h1 == -1 || h2 == -1)
            return -1;

        if (Math.abs(h1 - h2) > 1)
            return -1;

        if (h1 > h2)
            return h1 + 1;
        else
            return h2 + 1;
    }

}
