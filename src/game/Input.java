package game;

import java.awt.Graphics2D;
import java.util.Queue;

import com.zalinius.physics.Point2D;
import com.zalinius.utilities.Debug;

import java.awt.*;

public class Input extends TimedNode {

	private Queue<Item> itemQueue;
	
	public Input(Queue<Item> itemQueue, double delayTime, Point2D center) {
		super(null, delayTime, center);
		this.itemQueue = itemQueue;
	}

		
	public void update(double delta) {
		super.update(delta);
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

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		g.setColor(Color.RED);
		drawRectangle(g);
	}

}
