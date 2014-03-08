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
	public static Image[] roll_button_res = new Image[100];
	
	public static boolean isFirst = true;
	
	public static Point mse = new Point(0,0);
	
	public static Room room;
	public static Save save;
	public static Store store;
	
	
	public Screen() {
		thread.start();
		setBackground(Color.BLACK);
	}
	
	public void define(){
		room = new Room();
		save = new Save();
		store = new Store();
		
		
		
		
			for (int i = 0;i<tileset_Forest.length;i++){
			tileset_Forest[i] = new ImageIcon("res/daImage.png").getImage();
			tileset_Forest[i] = createImage(new FilteredImageSource(tileset_Forest[i].getSource(), new CropImageFilter(0,64*i,64,64)));
			
			}
		roll_button_res[0] = new ImageIcon("res/RollButton.png").getImage();
			
		save.loadSave(new File("save/boardLayout.fzk"));
		
	}
	
	public void paintComponent(Graphics g){
		if(isFirst){
			myWidth = getWidth();
			myHeight = getHeight();
			
			define();
			
			isFirst = false;
		}
		g.setColor(new Color(70,70,70));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(0,0,0));
		g.drawLine(room.block[0][0].x-1, 0, room.block[0][0].x-1, room.block[room.worldHeight-1][0].y-1 + room.blockSize + 1);//Draw left line
		g.drawLine(room.block[0][0].x-1, 0, 
				room.block[0][room.worldWidth-1].x + room.blockSize, room.block[room.worldHeight-1][0].y-1 + room.blockSize + 1);//draw right line
		g.drawLine(room.block[0][0].x, room.block[room.worldHeight-1][0].y + room.blockSize,
				room.block[0][room.worldWidth-1].x + room.blockSize,  room.block[room.worldHeight-1][0].y + room.blockSize);
		
		room.draw(g); //Drawing the room!
		store.draw(g); //Drawing the store!
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