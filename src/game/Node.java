package game;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zalinius.architecture.IGameObject;
import com.zalinius.utilities.time.GameClock;

public abstract class Node implements IGameObject {
	
	private double holdTime;
	private Item currentItem;
	protected ArrayList<Edge> outgoingEdges;
	
	public Node(double holdTime)	
	{
		this.holdTime = holdTime;
		this.outgoingEdges = new ArrayList<>();
	}
	
	public boolean inputItem(Item item)
	{
		if (currentItem == null)
		{
			currentItem = item;
			GameClock.addTimer(this, holdTime);
			return true;
		}
		else
		{
			outputItem(item);
			return false;
		}
	}
	
	private void outputItem(Item item)
	{
		Edge correctEdge = selectOutgoingEdge();
		correctEdge.inputItem(item);
		currentItem = null;	
	}
	
	public boolean isFull() {
		return currentItem != null;
	}
	
	protected abstract Edge selectOutgoingEdge();
	
	@Override
	public void update(double delta) {
		if (GameClock.isTimerDone(this))
		{
			outputItem(currentItem);
		}
	}

	@Override
	public void render(Graphics2D g) {	
		
	}
}
