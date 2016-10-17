package zad_1_visitor_tree;


public interface TreeNode {
    public void accept(Visitor visitor);
    public String getLabel();
    
}
