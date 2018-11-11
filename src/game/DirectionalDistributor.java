package game;

import java.awt.event.*;
import java.awt.*;

import com.zalinius.architecture.GameStage;
import com.zalinius.architecture.input.Clickable;
import com.zalinius.physics.Point2D;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Collection;

public class DirectionalDistributor extends Node {

	private int activeEdge;
	
	public DirectionalDistributor(Point2D center, Collection<Edge> edges) {
		super(center);
		for (Edge edge : edges) {
			addOutgoingEdge(edge);
		}
		
		GameStage.addInput(getControls());
		highlight = Color.RED;
	}

	protected Edge selectOutgoingEdge()
	{
		return outgoingEdges.get(activeEdge);
	}
	
	public void changeDirection()
	{
		activeEdge = (activeEdge + 1) % outgoingEdges.size();
	}
	
	Color highlight;

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.draw(getClickArea());
		
		g.setColor(highlight);
		if(activeEdge == 0) {
			int centerX = (int)center.x;
			int leftX = centerX - 15;
			int rightX = centerX + 15;
			int innerLX = centerX - 10;
			int innerRX = centerX + 10;
			int centerY = (int) center.y;
			int upY = centerY - 5;
			int downY = centerY + 5;
			g.drawLine(leftX, centerY, rightX, centerY);
			g.drawLine(leftX, centerY, innerLX, upY);
			g.drawLine(leftX, centerY, innerLX, downY);
			g.drawLine(rightX, centerY, innerRX, upY);
			g.drawLine(rightX, centerY, innerRX, downY);
		}
		else {
			int centerX = (int)center.x;
			int centerY = (int) center.y;
			int leftX = centerX - 5;
			int rightX = centerX + 5;
			int upY = centerY - 15;
			int downY = centerY + 15;
			int innerDownY = centerY + 10;
			
			g.drawLine(centerX, upY, centerX, downY);
			g.drawLine(leftX, innerDownY, centerX, downY);
			g.drawLine(rightX, innerDownY, centerX, downY);
		}
	}
	

	public Clickable getControls() {
		return new Clickable() {
			
			@Override
			public void mouseReleased() {
				highlight = Color.RED;
			}
			
			@Override
			public void mousePressed() {
				highlight = Color.GRAY;
			}
			
			@Override
			public void mouseClicked() {
				changeDirection();
			}
			
			@Override
			public int mouseButtonCode() {
				return MouseEvent.BUTTON1;
			}
			
			@Override
			public Shape clickArea() {
				return getClickArea();
			}
		};
	}
}
