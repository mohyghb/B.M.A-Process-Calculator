package App;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Button {
	
	private JButton jb; 
	private int x;
	private int y;
	private int w;
	private int h;
	
	Button(int x,int y)
	{
		this.x = x;
		this.y = y;
		w = 60;
		h = 40;
		jb = new JButton();
		customJButton();
	}
	public void customJButton()
	{
		this.jb.setBounds(this.x,this.y,this.w,this.h);
		this.jb.setText("ok");
		this.jb.setForeground(Color.white);
		this.jb.setFont(new Font("Serfi",Font.ITALIC,20));
	}
	public JButton getButton()
	{
		return this.jb;
	}

}
