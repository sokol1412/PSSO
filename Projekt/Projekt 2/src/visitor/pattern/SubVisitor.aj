package visitor.pattern;

public aspect SubVisitor extends VisitorProtocol{
	declare parents: BinaryOperatorNode implements Node;
	declare parents: TreeNode implements Visitable; 
	declare parents: NumericNode implements Leaf; 
}
