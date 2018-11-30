
public class Player {
	
	package objects.player;
	import gfx.Sprite;
	import java.awt.Color;
	import java.awt.Graphics;
	import objects.GameObject;
	import Input.Key;
	import Main.Game;
	import Main.Handler;
	import Main.Id;
	

	public class Player extends GameObject{
		
		private in gravity = 1;
		private boolean falling = true;
		private boolean jumping = false;

	    public Player (int x, int y, int breite, int höhe, Handler handler, Id id) {
	        super(x, y, breite, höhe, handler, id);
	    }
	    	public void tick() {
	    		if(playerIsMoving) {
	    			if(directionLeft) {
	    				left = true; }
	    				//gehe nach links mit key a
		} 
		   else if(directionRight) {
				right = true; 
					//gehe nach rechts key d
		}  	
		   else if (playerJump) {
				jump = true;
					//springe nach oben key space
		   }
	    }
	    	public void render(Graphics g) {
	    		//graphic buffered image
	    	}
	    	private void checkCollision(){
	    		for(CoreObject obj: blocks) {
	    			if(obj.getId() == Identities.Block_Stone) {
	    				block = (Block) obj;
	    				 // Kollision mit Block (Handler)
	    			}
	    		}
	    	}
	    	public void fall() {
	    		if(falling)
	    			yelY += gravity;
	    				//fall wert nach jump
	    	}
	  }
	
				   
			   
		   
	   