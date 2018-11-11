package game;

import java.awt.Graphics2D;
import com.zalinius.utilities.time.GameClock;

public abstract class TimedNode extends Node {
	
	private double holdTime;
	
	public TimedNode(double holdTime)	
	{
		super();
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
		super.update(delta);
		if (isFull() && GameClock.isTimerDone(this))
		{
			outputItem(currentItem);
		}
	}

	@Override
	public void render(Graphics2D g) {	
		super.render(g);
	}
}
