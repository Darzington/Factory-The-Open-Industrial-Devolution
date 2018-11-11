package game;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zalinius.architecture.GameObject;
import com.zalinius.utilities.Debug;

public class Node implements GameObject {
	
	public final static int NODE_SIZE = 50;

	protected Item currentItem;
	protected ArrayList<Edge> outgoingEdges;
	
	public Node()	
	{
		this.outgoingEdges = new ArrayList<>();
	}
	
	public Node(Edge outgoingEdge)	
	{
		this.outgoingEdges = new ArrayList<>();
		outgoingEdges.add(outgoingEdge);
	}
	
	public boolean inputItem(Item item)
	{
		if (!isFull())
		{
			currentItem = item;
			return true;
		}
		else
		{
			outputItem(item);
			return false;
		}
	}
	
	protected void outputItem()
	{
		outputItem(currentItem);
		currentItem = null;	
	}
	
	protected void outputItem(Item item)
	{
		Edge correctEdge = selectOutgoingEdge();
		correctEdge.inputItem(item);
	}
	
	public boolean isFull() {
		return currentItem != null;
	}
	
	protected Edge selectOutgoingEdge()
	{
		return outgoingEdges.get(0);
	}

	
	public void addOutgoingEdge(Edge newEdge)
	{
		outgoingEdges.add(newEdge);
	}
	
	@Override
	public void update(double delta) {
		for (Edge edge : outgoingEdges) {
			edge.update(delta);
		}
	}
	
	@Override
	public void render(Graphics2D g) {	
		for (Edge e : outgoingEdges) {
			e.render(g);
		}
	}
}