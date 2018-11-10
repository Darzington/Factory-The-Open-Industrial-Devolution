package game;

public class DirectionalDistributor extends Node {

	private int activeEdge;

	protected Edge selectOutgoingEdge()
	{
		return outgoingEdges.get(activeEdge);
	}
	
	public void changeDirection()
	{
		activeEdge = (activeEdge + 1) % outgoingEdges.size();
	}
	
}
