package game;

import java.awt.Graphics2D;

public class CerealBox extends Item {

	private boolean hasCereal, hasPrize;

	public boolean hasCereal() {
		return hasCereal;
	}

	public void setHasCereal(boolean hasCereal) {
		this.hasCereal = hasCereal;
	}

	public boolean hasPrize() {
		return hasPrize;
	}

	public void setHasPrize(boolean hasPrize) {
		this.hasPrize = hasPrize;
	}
	
	public boolean isSameItem(CerealBox box2)
	{
		return super.isSameItem(box2) 
				&& hasCereal == box2.hasCereal 
				&& hasPrize == box2.hasPrize;
	}

	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}
