package game;

import java.awt.Graphics2D;

import com.zalinius.physics.Point2D;

public class CerealBox extends Item {

	private boolean hasCereal, hasPrize;
	
	public CerealBox(Point2D position) {
		super(position);
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
	
	public boolean isSameItem(CerealBox box2)
	{
		return super.isSameItem(box2) 
				&& hasCereal == box2.hasCereal 
				&& hasPrize == box2.hasPrize;
	}

	@Override
	public void update(double delta) {
		
	}

	@Override
	public void render(Graphics2D g) {
		
	}
}
