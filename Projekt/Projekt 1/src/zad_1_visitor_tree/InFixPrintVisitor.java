package zad_1_visitor_tree;

public class InFixPrintVisitor extends Visitor{
 
    @Override
    public void visitBinaryOperationNode(BinaryOperatorNode node) {
       System.out.print("( ");
       node.getLeft().accept(this);
       System.out.print(" "+node.getLabel()+" ");
       node.getRight().accept(this);
       System.out.print(" )");
    }

    @Override
    public void visitNumericNode(NumericNode node) {
        System.out.print(" "+node.getLabel()+" ");
    }
    
}
