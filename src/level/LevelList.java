package level;

import java.util.ArrayList;

import objects.GameObject;
import objects.blocks.*;

public class LevelList {
	
	private ArrayList<GameObject> blocks=new ArrayList<GameObject>();
	public LevelList(int startX, int startY,int levelWidth, int levelHeight,int blockHeight, int blockWidth){
		levelHeight=levelHeight-(levelHeight%blockHeight);
		createBounds(levelWidth, levelHeight, blockHeight, blockWidth);
	}
	
	private void createBounds(int levelWidth, int levelHeight,int blockHeight, int blockWidth){
		for(int i=0;i*blockWidth<levelWidth;i++){
			for(int j=0;j*blockHeight<levelHeight;j++){
				if(i==0||levelWidth<=blockWidth*i+blockWidth)
				blocks.add(new Stone(i*blockWidth,j*blockHeight,blockWidth,blockHeight));
			}
		}
		for(int i=1;i*blockWidth+blockWidth<levelWidth;i++){

			blocks.add(new Stone(i*blockWidth,0,blockWidth,blockHeight));
			blocks.add(new Stone(i*blockWidth,levelHeight-blockHeight,blockWidth,blockHeight));
		}
	}

	public ArrayList<GameObject> getBlocks() {
		return blocks;
	}
	
	

}
