package zad_1_visitor_tree;


public abstract class Visitor {
    public abstract void visitBinaryOperationNode(BinaryOperatorNode node);
    public abstract void visitNumericNode(NumericNode node);
    
}
