package game;

import java.util.ArrayList;

public class DirectionalDistributor extends TimedNode {

	private int activeEdge;
	
	public DirectionalDistributor(double holdTime, ArrayList<Edge> edges) {
		super(holdTime);
		this.activeEdge = 0;
		outgoingEdges = edges;
	}

	protected Edge selectOutgoingEdge()
	{
		return outgoingEdges.get(activeEdge);
	}
	
	public void changeDirection()
	{
		activeEdge = (activeEdge + 1) % outgoingEdges.size();
	}
	
}
