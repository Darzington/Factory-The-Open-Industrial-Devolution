package game;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zalinius.architecture.IGameObject;
import com.zalinius.physics.Point2D;
import com.zalinius.physics.Vector2D;
import com.zalinius.utilities.ZMath;

public class Edge implements IGameObject {
	
	private double length, speed;
	private Point2D start, end;
	private double deltaX, deltaY;
	private ArrayList<Item> currentItems;
	private Node nextNode;	
	
	public Edge(double speed, Point2D start, Point2D end,  Node nextNode) {
		this.start = start;
		this.end = end;
		this.currentItems = new ArrayList<>();
		this.nextNode = nextNode;
		
		setSpeed(speed);
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
	
	private void setSpeed(double newSpeed)
	{
		this.speed = newSpeed;
		Vector2D deltaPos = new Vector2D(start, end);
		deltaPos.scale(speed);
		deltaX = deltaPos.x;
		deltaY = deltaPos.y;
	}
	
	@Override
	public void update(double delta) {
		for (Item item : currentItems) {
			Point2D newPos = item.getPosition();
			newPos.add(deltaX, deltaY);
			newPos = ZMath.clamp(newPos, start, end);
			item.move(newPos);
			
			if(newPos.equals(end))
			{
				outputItem(item);
			}
		}
	}

	@Override
	public void render(Graphics2D g) {	
		
	}
}
