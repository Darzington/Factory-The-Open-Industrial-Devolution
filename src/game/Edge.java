package game;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zalinius.architecture.IGameObject;
import com.zalinius.physics.Point2D;

public class Edge implements IGameObject {
	
	private double length, speed;
	private Point2D start, end;
	private ArrayList<Item> currentItems;
	private Node nextNode;
	
	
	public Edge(double speed, Point2D start, Point2D end,  Node nextNode) {
		this.speed = speed;
		this.start = start;
		this.end = end;
		this.currentItems = new ArrayList<>();
		this.nextNode = nextNode;
		
		this.length = Point2D.distance(start, end);
	}

	public void inputItem(Item item)
	{
		currentItems.add(item);
	}
	
	private void outputItem(Item item)
	{
		currentItems.remove(item);
		nextNode.inputItem(item);
	}

	
	@Override
	public void update(double delta) {
		for (Item item : currentItems) {
			
		}
	}

	@Override
	public void render(Graphics2D g) {	
		
	}
}
