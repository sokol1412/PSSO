package zad_1_visitor_tree;


public class SubstractionNode extends BinaryOperatorNode{
    
    public SubstractionNode(TreeNode left, TreeNode right, String label){
        super(left,right,label);
    }
    
    public int compute(int x, int y){
        return x-y;
    }
}
