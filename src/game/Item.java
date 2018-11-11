package game;

import java.awt.Color;

import com.zalinius.architecture.GameObject;
import com.zalinius.physics.Point2D;

public abstract class Item implements GameObject {

	private Point2D position;
	protected Color color;
	
	public Item() {
		this.position = new Point2D(0,0);
	}
	
	public Item(Point2D position) {
		this.position = position;
	}
	
	public void move(Point2D newPosition)
	{
		position = newPosition;
	}
	
	public Point2D getPosition()
	{
		return new Point2D(position.x, position.y);
	}
	
	public boolean isSameItem(Item item2)
	{
		return this.getClass() == item2.getClass();		
	}
	
	public abstract boolean isComplete();
	
	public abstract Color getColor();
	
	public abstract int getHeight();
	public abstract int getWidth();
}
