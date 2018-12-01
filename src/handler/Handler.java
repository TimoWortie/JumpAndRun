package handler;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import objects.GameObject;
import objects.blocks.Stone;
import objects.player.Player;

public class Handler {

	private ArrayList<GameObject> blocks = new ArrayList<>();
	private Player player;

	public void tick() {
		 player.fall();
	}

	public void render(Graphics g) {
		/*
		 * For later use 
		 */
		g.setColor(Color.green);
		g.fillRect(player.getX(),player.getY(), player.getWidth(), player.getHeight());
		for(GameObject bl:blocks){ bl.render(g); }
		/* 
		 * player.render(g);
		 */
	}

	public void init() {
		player = new Player(100,100,100,100);
		// Add blocks here:
		blocks.add(new Stone(200,100,200,100));
		blocks.add(new Stone(50,50,500,100));

	}

}
