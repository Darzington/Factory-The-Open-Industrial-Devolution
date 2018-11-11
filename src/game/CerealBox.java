package game;

import java.awt.Color;
import java.awt.Graphics2D;

public class CerealBox extends Item {

	private boolean hasCereal, hasPrize;

  public final static int BOX_HEIGHT = 18;
	public final static int BOX_WIDTH = 10;

	public CerealBox()
	{
		super();
		color = Color.ORANGE;
	}
	
	public boolean hasCereal() {
		return hasCereal;
	}

	public boolean addCereal() {
		if (hasCereal)
		{
			return false;
		}
		else
		{
			hasCereal = true;
			return true;
		}
	}

	public boolean hasPrize() {
		return hasPrize;
	}

	public boolean addPrize() {
		if (hasPrize)
		{
			return false;
		}
		else
		{
			hasPrize = true;
			return true;
		}
	}
	
	public boolean isSameItem(Item box2)
	{
		if(super.isSameItem(box2))
		{
			CerealBox other = (CerealBox) box2;
			return hasCereal == other.hasCereal() 
				&& hasPrize == other.hasPrize();
		}	
		return false;
	}

	@Override
	public void update(double delta) {
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect((int)getPosition().x-BOX_WIDTH/2, (int)(getPosition().y + Node.HALF_NODE_SIZE - BOX_HEIGHT - 1), 10, BOX_HEIGHT);
	}

	@Override
	public boolean isComplete() {
		return hasCereal && hasPrize;
	}
	
	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getHeight() {
		return BOX_HEIGHT;
	}
	
	public static FillerFunction cerealFiller()
	{
		return new FillerFunction() {
			
			@Override
			public boolean fill(Item item) {
				CerealBox temp = new CerealBox();
				temp.addPrize();
				if (temp.isSameItem(item))
				{
					temp = (CerealBox)item;
					if (temp.addCereal())
					{
						return true;
					}
				}
				return false;				
			}
		};
	}
	
	public static FillerFunction prizeFiller()
	{
		return new FillerFunction() {
			
			@Override
			public boolean fill(Item item) {
				CerealBox temp = new CerealBox();
				if (temp.isSameItem(item))
				{
					temp = (CerealBox)item;
					if (temp.addPrize())
					{
						return true;
					}
				}
				return false;				
			}
		};
	}
	
}
