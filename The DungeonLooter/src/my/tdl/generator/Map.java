package my.tdl.generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import my.project.gop.main.Vector2F;
import my.project.gop.main.loadImageFrom;
import my.tdl.generator.Block.BlockType;
import my.tdl.main.Main;

public class Map {

	TileManager tiles = new TileManager();
	
	public Map() {
		
	}
	public void init(){
		BufferedImage map = null;
		
		try {
			map = loadImageFrom.LoadImageFrom(Main.class, "map.png");
		} catch (Exception e) {
			
		}
		
		for (int x = 0;x < 100; x++){
			for (int y = 0;y < 100; y++){
				int col = map.getRGB(x, y);
				
				switch(col & 0xFFFFFF){
				case 0x404040:
					tiles.blocks.add( new Block(new Vector2F(x*48, y*48),BlockType.STONE_1));
					break;
				}
			}
		}
	}
	
	public void tick(double deltaTime){
		tiles.tick(deltaTime);
	}
	
	public void render(Graphics2D g){
		tiles.render(g);
	}

}
