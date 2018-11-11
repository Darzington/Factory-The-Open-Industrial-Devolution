package game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Prize extends Item
{
	public static final int PRIZE_HEIGHT = CerealBox.BOX_HEIGHT/2;
	
	public Prize()
	{
		super();
		color = Color.WHITE;
	}
	
	@Override
	public void update(double delta) {
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect((int)getPosition().x - PRIZE_HEIGHT/2, (int)(getPosition().y + Node.HALF_NODE_SIZE - PRIZE_HEIGHT - 1), PRIZE_HEIGHT, PRIZE_HEIGHT);
		g.setColor(Color.GREEN);
		g.fillOval((int)(getPosition().x + PRIZE_HEIGHT*0.2 - PRIZE_HEIGHT/2), (int)(getPosition().y  + PRIZE_HEIGHT*0.2 + Node.HALF_NODE_SIZE - PRIZE_HEIGHT - 1), (int)(PRIZE_HEIGHT*0.75), (int)(PRIZE_HEIGHT*0.75));
	}

	@Override
	public boolean isComplete() {
		return false;
	}
	
	@Override
	public Color getColor() {
		return Color.WHITE;
	}

	@Override
	public int getHeight() {
		return PRIZE_HEIGHT;
	}

	@Override
	public int getWidth() {
		return PRIZE_HEIGHT;
	}
	
}
