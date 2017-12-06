/**
 * 
 */
package com.scheid.Main;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.scheid.CommonUtils.Population;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Alvaro Scheid
 *
 */
public class Main extends JPanel {

	static ArrayList<Rectangle> r;
	static Population population;
	Integer[][] map;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4006180390801595153L;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException{
		Main main = new Main();
		population = new Population();
		r = new ArrayList<Rectangle>();
		
		while(true) {
			main.population.reprodution();
		}
	}
	
	

	public Rectangle newRecWall(int i, int j) {
		Rectangle r = new Rectangle();
		r.setArcHeight(10);
		r.setArcWidth(10);
		r.setHeight(20);
		r.setWidth(20);
		r.setX(j * 25);
		r.setY(i * 25);
		r.setStroke(Color.BLACK);
		return r;
	}

	public Rectangle newRecStart(int i, int j) {
		Rectangle r = new Rectangle();
		r.setArcHeight(10);
		r.setArcWidth(10);
		r.setHeight(20);
		r.setWidth(20);
		r.setX(j * 25);
		r.setY(i * 25);
		r.setStroke(Color.GREY);
		r.setFill(Color.GREY);
		return r;
	}

	public Rectangle newRecRobot(int i, int j) {
		Rectangle rec = new Rectangle();
		rec.setArcHeight(10);
		rec.setArcWidth(10);
		rec.setHeight(20);
		rec.setWidth(20);
		rec.setX(j * 25);
		rec.setY(i * 25);
		rec.setStroke(Color.RED);
		rec.setFill(Color.RED);
		return rec;
	}

	public Rectangle newRecEnd(int i, int j) {
		Rectangle rec = new Rectangle();
		rec.setArcHeight(10);
		rec.setArcWidth(10);
		rec.setHeight(20);
		rec.setWidth(20);
		rec.setX(j * 25);
		rec.setY(i * 25);
		rec.setStroke(Color.GREEN);
		rec.setFill(Color.GREEN);
		return rec;
	}


	

}
