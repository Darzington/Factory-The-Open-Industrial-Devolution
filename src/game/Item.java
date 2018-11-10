package game;

import com.zalinius.architecture.IGameObject;
import com.zalinius.physics.Point2D;

public abstract class Item implements IGameObject {

	private Point2D position;
	
	public void move(Point2D newPosition)
	{
		position = newPosition;
	}
	
	public Point2D getPosition()
	{
		return position;
	}
}
