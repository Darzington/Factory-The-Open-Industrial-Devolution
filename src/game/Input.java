package game;

import java.util.Queue;

public class Input extends TimedNode {

	private Queue<Item> itemQueue;
	
	public Input(Queue<Item> itemQueue, double delayTime) {
		super(delayTime);
		this.itemQueue = itemQueue;
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
