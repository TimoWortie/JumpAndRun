
package objects.player;

import java.awt.Graphics;
import objects.GameObject;

public class Player extends GameObject {

	private boolean playerIsMoving = false;
	private boolean directionRight = false;
	private boolean directionLeft = false;
	private int gravity = 1;
	private boolean falling = true;
	private boolean playerJump = false;

	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void tick() {
		if (playerIsMoving) {
			if (directionLeft) {
				x-=5;
			}
			// gehe nach links mit key a
		} else if (directionRight) {
			x+=5;
			// gehe nach rechts key d
		}
		if (playerJump) {
			y-=5;
			// springe nach oben key space
		}
	}
	
	@Override
	public void render(Graphics g) {
		// graphic buffered image
	}

	private void checkCollision(GameObject object) {

		// Kollision mit Block (Handler)

	}

	public void fall() {
		if (falling)
			y += gravity;
		// fall wert nach jump
	}
}
