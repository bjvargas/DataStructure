package rns.tree;

public class Node {

   private Node right;
   private Node left;
   private Integer info;
   private Integer height;

   public Node(){
      this.height = 1;
   }

   public Node getRight() {
      return right;
   }

   public void setRight(Node right) {
      this.right = right;
   }

   public Node getLeft() {
      return left;
   }

   public void setLeft(Node left) {
      this.left = left;
   }

   public Integer getInfo() {
      return info;
   }

   public void setInfo(Integer info) {
      this.info = info;
   }

   public Integer getHeight() {
      return height;
   }

   public void setHeight(Integer height) {
      this.height = height;
   }
}
