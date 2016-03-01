package my.tdl.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import my.project.gop.main.GameWindow;

import my.project.gop.main.SpriteSheet;
import my.tdl.gameloop.GameLoop;

public class Main {
	
	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
	public static int width = gd.getDisplayMode().getWidth();
	public static int height = gd.getDisplayMode().getHeight();
	
	public static void main(String[] args) {
		GameWindow frame = new GameWindow("The Dlooter", 1280, 720);
			frame.setFullscreen(1);
			frame.add(new GameLoop(width,height));
			frame.setVisible(true);
	}

}
