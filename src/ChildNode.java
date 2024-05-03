public class ChildNode extends Node {
    
    int distanceToRoot;

    public ChildNode(Node node, int distanceToRoot) {
        super(node.name, node.h, node.isGoal);
        this.distanceToRoot = distanceToRoot;
    }
}
