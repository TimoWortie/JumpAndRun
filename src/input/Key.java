package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {

	
	public void keyPressed(KeyEvent arg0) {
		if(!Game.launcher.launching){
			int key = e.getKeyCode();
			for(Entity en:Game.handler.entity){
				if(en.tot==false){
			if(key== KeyEvent.VK_D){
				d = true;
			}
			if(key== KeyEvent.VK_A){
				a=true;
			}
			if(key== KeyEvent.VK_W){
				if(!en.jumping&&!en.falling&&en.getId()!=Id.Player&&Game.player.getStunned()==false){
				if(!en.jumping&&!en.falling){
					Game.handler.ChangeMusic(4, 1, false);
					en.jumping=true;
					en.gravity=17.0f;
				}
				}
			}
			
			if(key== KeyEvent.VK_ESCAPE){
				Game.launcher.launching=true;
			}

			if(key== KeyEvent.VK_SHIFT){
				 shift = true;
			}}}}
	}

	
	public void keyReleased(KeyEvent arg0) {
		if(!Game.launcher.launching){
		int key = e.getKeyCode();
		for(Entity en:Game.handler.entity){
		if(key== KeyEvent.VK_D){
			Game.player.setVelX(0);
			Player.moving=-1;
			d=false;
		}
		if(key==e.VK_A){
			Game.player.setVelX(0);
			Player.moving=-2;
			a=false;
		}
		if(key==KeyEvent.VK_SHIFT){
			shift = false;
		}
	  }
		
	}}

	
	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
