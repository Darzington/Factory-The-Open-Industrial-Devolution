package game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Garbage extends Item{
	
	private int height;
	
	public Garbage()
	{
		super();
		height = Prize.PRIZE_HEIGHT;
		color = Color.GREEN;
	}
	
	public Garbage(int originalItemHeight, Color originalItemColor)
	{
		height = (int)(originalItemHeight*0.8);
		color = originalItemColor.darker();
	}
	
	@Override
	public void update(double delta) {
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect((int)getPosition().x, (int)(getPosition().y + Node.HALF_NODE_SIZE - height - 1), height, height);
	}

	@Override
	public boolean isComplete() {
		return false;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getHeight() {
		return height;
	}
}
