package questForMtDoom.gui;

import java.awt.BorderLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JTextField;

import questForMtDoom.game.Game;


public class Frame extends JFrame{
	
	
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		        Game.class.getResourceAsStream("../audio/" + url));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
	
	public static void main(String[] args) {
		new Frame(); 
		}
	public Frame(){
		new JFrame();
		this.setSize(800,600);
		this.setTitle("Quest for Mt.Doom");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		playSound("BattleMusicDemo.Wav");
		
		JFrame vindu = new JFrame("Border Layout Demo");
		this.setLayout(new BorderLayout());
		
		JTextField tallFelt = new JTextField(10);
		this.add(tallFelt, BorderLayout.NORTH);
		
		
		
		Screen screen = new Screen(this);
		this.add(screen);
		
		
		
			
			
		
	}

}
