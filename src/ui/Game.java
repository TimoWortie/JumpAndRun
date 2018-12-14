package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import handler.Handler;
import input.Key;

/**
 * Game creation for JumpAndRun.
 * 
 * @author Timo Wortmann
 * @since 27.11.2018
 * @version 1.0
 */
public class Game extends Canvas implements Runnable {

	private Handler handler;
	private Thread thread = new Thread();
	private boolean running = false;
	private Key key=new Key();

	/**
	 * Initializes the handler. This method is only executed once at the start of
	 * the game. In the future: initializes everything else that needs to be done at
	 * the start of the game.
	 *
	 */
	public void init() {
		handler=new Handler(key);
		addKeyListener(key);
		handler.init();
	}

	@Override /**
				 * Creates the game loop Will run 60 times per second while running is true.
				 * Calls the render and tick methods
				 *
				 */
	public void run() {
		init();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double nanosecounds = 1000000000.0 / 60.0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nanosecounds;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			render();
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}
		stop();
	}

	/**
	 * Creates a BufferedStrategy and Graphics object to render. Executes the render
	 * method of handler.
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		// -------------------
		// For test purpose only
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.red);
		g.fillRect(100, 100, 100, 100);
		// -------------------
		handler.render(g);
		g.dispose();
		bs.show();
	}

	/**
	 * Starts the game and a new Thread.
	 * 
	 */
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Forces the game to close
	 */
	public synchronized void shutdown() {
		if (running)
			running = false;
		thread.stop();
	}

	/**
	 * Stops the game and waits for everything to finish.
	 */
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Calls the tick method of the handler.
	 */
	public void tick() {
		handler.tick();
	}

}
