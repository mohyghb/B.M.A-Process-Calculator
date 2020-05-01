package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class TextInput {
	
	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private JTextField jtf;
	
	TextInput(int x,int y)
	{
		this.xpos = x;
		this.ypos = y;
		this.width = 100;
		this.height = 60;
		this.jtf = new JTextField("");
		customTextField();
	}
	public void customTextField()
	{
		this.jtf.setBounds(xpos, ypos, width, height);
		this.jtf.setForeground(Color.RED);
		this.jtf.setHorizontalAlignment(JTextField.CENTER);
		this.jtf.setFont(new Font("Serfi",Font.PLAIN,20));
		this.jtf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				if (jtf.getText().length()>=10)
				{
					jtf.setFont(new Font("Serfi",Font.PLAIN,12));
				}
				else if(jtf.getText().length()>=6)
				{
					jtf.setFont(new Font("Serfi",Font.PLAIN,15));
				}
				else if(jtf.getText().length()<5)
				{
					jtf.setFont(new Font("Serfi",Font.PLAIN,20));
				}
			}
		});
		this.jtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if (jtf.getText().length()>=10)
				{
					jtf.setFont(new Font("Serfi",Font.PLAIN,12));
				}
				else if(jtf.getText().length()>=5)
				{
					jtf.setFont(new Font("Serfi",Font.PLAIN,15));
				}
				else if(jtf.getText().length()<5)
				{
					jtf.setFont(new Font("Serfi",Font.PLAIN,20));
				}
			}
		});
	}
	public void checkTheSize()
	{
		if (jtf.getText().length()>=10)
		{
			jtf.setFont(new Font("Serfi",Font.PLAIN,10));
		}
		else if(jtf.getText().length()>=6)
		{
			jtf.setFont(new Font("Serfi",Font.PLAIN,15));
		}
	}
	public String getText()
	{
		return this.jtf.getText();
	}
	public void setText(String s) {
		this.jtf.setText(s);
	}
	public JTextField getField()
	{
		return this.jtf;
	}
	public int getx()
	{
		return this.xpos;
	}
	public int gety()
	{
		return this.ypos;
	}
	public void setToolTip()
	{
		this.jtf.setToolTipText(jtf.getText());
	}
	public void green()
	{
		this.jtf.setForeground(Color.green);
	}
	public void pink()
	{
		this.jtf.setForeground(Color.pink);
	}
	
		
	

}
