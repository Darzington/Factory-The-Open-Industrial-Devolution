package game;

import java.awt.Graphics2D;

import com.zalinius.physics.Point2D;
import com.zalinius.utilities.Debug;
import com.zalinius.utilities.time.GameClock;

public abstract class TimedNode extends Node {
	
	private double holdTime;
	
	public TimedNode(Edge outgoingEdge, double holdTime, Point2D center)	
	{
		super(outgoingEdge, center);
		this.center = center;
		this.holdTime = holdTime;
	}
	
	@Override
	public boolean inputItem(Item item)
	{
		if (isOn && super.inputItem(item))
		{
			GameClock.addTimer(this, holdTime);
			return true;
		}
		else
		{
			return false;
		}
	}
			
	@Override
	public void update(double delta) {
		if (isFull() && GameClock.isTimerDone(this))
		{
			outputItem();
		}
	}

	@Override
	public void render(Graphics2D g) {	
		super.render(g);
	}
}
