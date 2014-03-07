package questForMtDoom.gui;

import java.awt.*;
public class Block extends Rectangle {
	public int id;
	
	public Block(int x, int y, int width, int height, int id){
		setBounds(x, y, width, height);
		this.id = id;
		
	}
	
	public void Draw(Graphics g){
		g.drawImage(Screen.tileset_Forest[id],x,y,width,height,null);
	}
}