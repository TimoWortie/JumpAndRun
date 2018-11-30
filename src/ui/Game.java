package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import handler.Handler;

public class Game extends Canvas implements Runnable {

	private Handler handler = new Handler();
	private Thread thread = new Thread();
	private boolean running = false;

	public void init() {
		handler.init();
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double nanosecounds = 1000000000.0 / 60.0;
		int frames = 0;
		int ticks = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nanosecounds;
			lastTime = now;
			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
				ticks = 0;
			}
		}
		stop();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
	

		// -------------------

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.red);
		g.fillRect(100, 100, 100, 100);
		handler.render(g);
		// -------------------
		g.dispose();
		bs.show();
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
		}
	}

	public void tick() {
		handler.tick();
	}

}
