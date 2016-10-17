package zad_1_visitor_tree;

public class ModuloNode extends BinaryOperatorNode{
    
    public ModuloNode(TreeNode left, TreeNode right, String label){
        super(left,right,label);
    }
    
    public int compute(int x, int y){
        return x%y;
    }
    
}
