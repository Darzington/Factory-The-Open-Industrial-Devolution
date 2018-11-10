package game;

import java.awt.Graphics2D;
import java.util.Queue;
import com.zalinius.utilities.Debug;

import java.awt.*;

public class Input extends TimedNode {

	private Queue<Item> itemQueue;
	
	public Input(Queue<Item> itemQueue, double delayTime) {
		super(delayTime);
		this.itemQueue = itemQueue;
	}

	@Override
	protected Edge selectOutgoingEdge() {
		return outgoingEdges.get(0);
	}
	
	public void update(double delta) {
		super.update(delta);
		if(!itemQueue.isEmpty()) {
			if(!isFull()) {
				Debug.log("Ding!");
				Item next = itemQueue.remove();
				inputItem(next);
			}
		}
	}

	public void addToQueue(Item item) {
		itemQueue.add(item);
	}

	@Override
	public void render(Graphics2D g) {
		
		g.setColor(Color.RED);
		g.drawRect(20, 500, 50, 50);
	}

}
