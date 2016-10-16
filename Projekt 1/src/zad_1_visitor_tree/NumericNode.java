package zad_1_visitor_tree;


public class NumericNode implements TreeNode{
    private int value;
   
    public int getValue(){
        return this.value;
    }

    public NumericNode(int value){
        this.value = value;
    }
    
    @Override
    public String getLabel() {
        return String.valueOf(this.value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitNumericNode(this);
    }

    
    
}
