package visitor.pattern;

public aspect Visiting extends VisitorProtocol{
	declare parents: BinaryOperatorNode implements Node; // BinaryTreeNode -> Node
	declare parents: TreeNode implements Visitable; // BinaryTree -> Visitable
	declare parents: NumericNode implements Leaf; // BinaryTreeLeaf -> Leaf

}
