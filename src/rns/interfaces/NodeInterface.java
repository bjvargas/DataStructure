package rns.interfaces;

import rns.tree.Node;

public interface NodeInterface {

    public Node insert(Node root, Integer info);

    public Node rotate(Node parent, String position);

    public Integer height(Node root);

    public Integer bigger(Integer a, Integer b);

    public void organize(Node root);

    public void reOrganize(Node root);

    public Node newNode(Node root, Integer info);

    public Node delete(Node root, Integer info);

    public Node minValueNode(Node node);

    public int getBalance(Node node);

}
