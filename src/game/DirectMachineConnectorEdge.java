package game;

import com.zalinius.physics.Point2D;

public class DirectMachineConnectorEdge extends Edge{

	public DirectMachineConnectorEdge(Point2D start, Point2D end, Node nextNode) {
		super(start, end, nextNode);
	}

	@Override
	protected void outputItem(Item item)
	{
		currentItems.remove(item);
		nextNode.feedInItem(item);
	}
	
}
