package zad_1_visitor_tree;


public class PostFixPrintVisitor extends Visitor{
    @Override
    public void visitBinaryOperationNode(BinaryOperatorNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        System.out.print(" "+node.getLabel()+" ");
    }

    @Override
    public void visitNumericNode(NumericNode node) {
       System.out.print(" "+node.getLabel()+" ");
    }
    
}
