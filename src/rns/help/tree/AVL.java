package rns.help.tree;

import java.util.ArrayList;
import java.util.List;

public class AVL extends Node {

    private List<Node> nodes = new ArrayList<>();


    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void insert(Integer id) {

        nodes.add(new Node(id, ));

    }

    private void isBigger(Integer id) {
        for (Node node: nodes) {
            if(node.getId() > id){
                
            }
        }
    }

    public void delete(Integer id) {

    }

    public void search(Integer id) {

    }

}
