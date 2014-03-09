package questForMtDoom.gui;

	
	import javax.swing.*;
	import java.awt.*;
	public class Frame extends JFrame {
		public static String title = "Quest For Mt.Doom";
		public static Dimension size = new Dimension(1286, 800);
	 	
		public Frame(){
			setTitle(title);
			setSize(size);
			setResizable(true);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			init();
			
		}
		
		public void init(){
			setLayout(new GridLayout(1 , 1 , 0 , 0));
			
			Screen screen = new Screen(this);
			add(screen);
			
			
			setVisible(true);
		}
		
		public static void main(String Args[]){
			Frame frame = new Frame();
		}
	
}
