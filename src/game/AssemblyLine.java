package game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;

import com.zalinius.architecture.GameObject;
import com.zalinius.utilities.Debug;

public abstract class AssemblyLine implements GameObject {

	private Input input;
	private Collection<Node> nodes;
	private Collection<Edge> edges;
	
	public AssemblyLine(Input input) {
		this.input = input;
		this.nodes = new ArrayList<>();
		this.edges = new ArrayList<>();
		
		findEdgesAndNodes(input);
	}
	
	private void findEdgesAndNodes(Node node) {
		nodes.add(node);
//		if(node.getClass() == StorageNode.class) {
//			Debug.log("In storage");
//			node = ((StorageNode)node).getBase();
//			nodes.add(node);
//		}

		edges.addAll(node.outgoingEdges);
		
		node.outgoingEdges.forEach(child -> findEdgesAndNodes(child.getNextNode()));
	}
	
	public void inputItem(Item item) {
		input.addToQueue(item);
	}
	
	public void update(double delta) {
		edges.forEach(edge -> edge.update(delta));
		nodes.forEach(node -> node.update(delta));
	}
	
	@Override
	public void render(Graphics2D g) {
		edges.forEach(edge -> edge.render(g));
		nodes.forEach(node -> node.render(g));
	}

}
