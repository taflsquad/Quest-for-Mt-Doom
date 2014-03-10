package questForMtDoom.gui;


import java.awt.*;

public class RollButton {
	public static int rollWidth = 1;
	public static int buttonSize = 320;
	public static int cellSpace = 2;
	public static int awayFromRoom = 60;
	public static int iconSize = 20;
	
	
	public Rectangle[] button = new Rectangle[rollWidth];
	public Rectangle buttonCoins;
	
	
	
	public RollButton(){
		define();
		
	}
	public void click(int mouseButton){
		if(mouseButton == 1){
			
		}
	}
	
	public void define(){
		for (int i=0;i<button.length;i++){
			button[i] = new Rectangle((Screen.myWidth/5) - ((rollWidth*(buttonSize + cellSpace))/2) + ((buttonSize + cellSpace)*i),
					(Screen.room.block[Screen.room.worldHeight-1][0].y) + Screen.room.blockSize + awayFromRoom,
					buttonSize, buttonSize);
		}
		buttonCoins = new Rectangle(Screen.room.block[0][0].x - 1, button[0].y + 150, iconSize,iconSize);
	}
	public void draw(Graphics g){
		for (int i=0;i<button.length;i++){
				
				if(button[i].contains(Screen.mse)){
					g.setColor(new Color(255,255,255));
					g.fillRect(button[i].x , button[i].y , button[i].width, button[i].height);
							
				}
					
			g.drawImage(Screen.roll_button_res[0], button[i].x , button[i].y , button[i].width
					, button[i].height, null);
		}
		g.fillRect(buttonCoins.x,buttonCoins.y,buttonCoins.width,buttonCoins.height);
	}
	
}
