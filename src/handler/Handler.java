package handler;

import java.awt.Graphics;
import java.util.ArrayList;

import objects.GameObject;
import objects.player.Player;

public class Handler {

	private ArrayList<GameObject> blocks = new ArrayList<>();
	private Player player = new Player();

	public void tick() {
		// player.tick();
	}

	public void render(Graphics g) {
		/*
		 * For later use for(Block bl:blocks){ bl.render(g); }
		 * 
		 * player.render(g);
		 */
	}

	public void init() {
		player = new Player();
		// Add blocks here:
		// blocks.add(new Stone());

	}

}
