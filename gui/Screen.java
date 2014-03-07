package questForMtDoom.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.*;
public class Screen extends JPanel implements Runnable{
	
	public Thread thread = new Thread(this);
	
	public static int myWidth, myHeight;
	
	public static Image[] tileset_Forest = new Image[100];
	
	public static boolean isFirst = true;
	
	public static Room room;
	public static Save save;
	
	
	public Screen() {
		thread.start();
		setBackground(Color.BLACK);
	}
	
	public void define(){
		room = new Room();
		save = new Save();
		
		
		
		
			for (int i = 0;i<tileset_Forest.length;i++){
			tileset_Forest[i] = new ImageIcon("res/daImage.png").getImage();
			tileset_Forest[i] = createImage(new FilteredImageSource(tileset_Forest[i].getSource(), new CropImageFilter(0,128*i,128,128)));
			
			}
		save.loadSave(new File("save/boardLayout.fzk"));
		
	}
	
	public void paintComponent(Graphics g){
		if(isFirst){
			myWidth = getWidth();
			myHeight = getHeight();
			
			define();
			
			isFirst = false;
		}
		
		g.clearRect(0, 0, getWidth(), getHeight());
		
		room.draw(g); //Drawing the room!
	}
	
	public void run(){
		while (true){
			
			if(!isFirst){
				room.physic();
			}
			
			repaint();
			try{
				Thread.sleep(1);
			}catch(Exception e) { }
		}
	}
}