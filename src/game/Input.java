package game;

import java.util.Queue;

public class Input extends Node {

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
		if(!itemQueue.isEmpty()) {
			if(!isFull()) {
				Item next = itemQueue.remove();
				inputItem(next);
			}
		}
	}

	public void addToQueue(Item item) {
		itemQueue.add(item);
	}

}
