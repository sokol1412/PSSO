package zad_1_visitor_tree;


public class PreFixPrintVisitor extends Visitor{

  
    @Override
    public void visitBinaryOperationNode(BinaryOperatorNode node) {
        System.out.print(" "+node.getLabel()+" ");
        node.getLeft().accept(this);
        node.getRight().accept(this);
    }

    @Override
    public void visitNumericNode(NumericNode node) {
        System.out.print(" "+node.getLabel()+" ");
    }
    

    
}
