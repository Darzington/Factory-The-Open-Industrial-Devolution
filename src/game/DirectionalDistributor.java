package game;

import java.awt.Event;

import com.zalinius.architecture.input.Inputtable;

public class DirectionalDistributor extends Node {

	private int activeEdge;

	protected Edge selectOutgoingEdge()
	{
		return outgoingEdges.get(activeEdge);
	}
	
	public void changeDirection()
	{
		activeEdge = (activeEdge + 1) % outgoingEdges.size();
	}
	
	public Inputtable getControls()
	{
		return new Inputtable() {
			
			@Override
			public void released() {
				changeDirection();
			}
			
			@Override
			public void pressed() {
				
			}
			
			@Override
			public int keyCode() {
				return Event.MOUSE_DOWN;
			}
		};
	}
	
}
