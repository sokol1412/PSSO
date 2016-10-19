package visitor.pattern;

public abstract aspect VisitorProtocol {
	public interface Visitable {}
	protected interface Leaf extends Visitable{}
	protected interface Node extends Visitable{}
	
	public interface Visitor{
		public void visit(Node node);
		public void visit(Leaf leaf);
	}
	
	public void Node.accept(Visitor visitor){
		visitor.visit(this);
	}
	
	public void Leaf.accept(Visitor visitor){
		visitor.visit(this);
	}
	
	public void Visitable.accept(Visitor visitor){}
	
}
