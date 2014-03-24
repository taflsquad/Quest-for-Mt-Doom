package questForMtDoom.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Hud extends JPanel {
	public static Image[] roll_button_res = new Image[100];
	public static RollButton store;

	public Hud() {
		setLayout(new GridLayout(1, 3));

		
		Icon rollDice = new ImageIcon("res/RollButton.png");
		JButton rollButton = new JButton(rollDice);
		
		JTextArea console = new JTextArea(20,50);
		console.setBackground(new Color(70,70,70));
		console.setForeground(Color.WHITE);
		rollButton.setBackground(new Color(70,70,70));
		
		console.setLineWrap(true);
		console.setWrapStyleWord(true);
		
		add(rollButton);
		add(console);
	}

	@Override
	protected void paintComponent(Graphics g) {
		store = new RollButton();
		g.setColor(new Color(70,70,70));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(0,0,0));

		roll_button_res[0] = new ImageIcon("res/RollButton.png").getImage();
		
		store.draw(g); //Drawing the store!
	}

	public Hud(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public Hud(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public Hud(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
