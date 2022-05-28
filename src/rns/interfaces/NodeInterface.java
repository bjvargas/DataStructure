package rns.interfaces;

import rns.tree.Node;

public interface NodeInterface {

    Node insert(Node root, Integer info);

    Node rotate(Node parent, String position);

    Integer height(Node root);

    Integer bigger(Integer a, Integer b);

    Node newNode(Node root, Integer info);

    Node delete(Node root, Integer info);

    Node minValueNode(Node node);

    int getBalance(Node node);

    boolean search(Node root, Integer info);

}
