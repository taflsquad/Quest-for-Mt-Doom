package questForMtDoom.gui;


import java.awt.*;

public class Store {
	public static int shopWidth = 1;
	public static int buttonSize = 320;
	public static int cellSpace = 2;
	public static int awayFromRoom = 70;
	
	
	public Rectangle[] button = new Rectangle[shopWidth];
	
	
	public Store(){
		define();
		
	}
	public void define(){
		for (int i=0;i<button.length;i++){
			button[i] = new Rectangle((Screen.myWidth/5) - ((shopWidth*(buttonSize + cellSpace))/2) + ((buttonSize + cellSpace)*i),
					(Screen.room.block[Screen.room.worldHeight-1][0].y) + Screen.room.blockSize + awayFromRoom,
					buttonSize, buttonSize);
		}
		
	}
	public void draw(Graphics g){
		for (int i=0;i<button.length;i++){
			g.drawImage(Screen.roll_button_res[0], button[i].x , button[i].y , button[i].width
					, button[i].height, null);
		}
		
	}
	
}
