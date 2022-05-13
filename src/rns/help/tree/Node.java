package rns.help.tree;

public class Node {

   private Integer id;
   private Integer parent;
   private Integer childLeft;
   private Integer childRight;

   public Node(Integer id, Integer parent, Integer childLeft, Integer childRight) {
      this.id = id;
      this.parent = parent;
      this.childLeft = childLeft;
      this.childRight = childRight;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getParent() {
      return parent;
   }

   public void setParent(Integer parent) {
      this.parent = parent;
   }

   public Integer getChildLeft() {
      return childLeft;
   }

   public void setChildLeft(Integer childLeft) {
      this.childLeft = childLeft;
   }

   public Integer getChildRight() {
      return childRight;
   }

   public void setChildRight(Integer childRight) {
      this.childRight = childRight;
   }
}
