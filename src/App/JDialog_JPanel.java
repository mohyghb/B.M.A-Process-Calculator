package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JDialog_JPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextInput t1;
	TextInput t2;
	@SuppressWarnings("rawtypes")
	JComboBox box;
	private final String[] name  = {"moles","grams","ton"};
	Button cal;
	JLabel show;
	JLabel warning;
	JDialog_JPanel()
	{
		super.setLayout(null);
		super.setFocusable(true);
		super.setBackground(Color.WHITE);
		initClass();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initClass()
	{
		box = new JComboBox(name);
		box.setMaximumRowCount(2);
		box.setBackground(Color.white);
		box.setBounds(310,65,70,30);
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				t1.setText(name[box.getSelectedIndex()]+" of CH4");
				t2.setText(name[box.getSelectedIndex()]+" of NH3");
				t1.checkTheSize1();
				t1.setToolTip();
				t2.checkTheSize1();
				t2.setToolTip();
			}
			
		});
		show = new JLabel();
		this.show.setBounds(200,200,160,40);
		this.show.setForeground(Color.black);
		this.show.setFont(new Font("Serfi",Font.BOLD,20));
		
		warning = new JLabel();
		this.warning.setBounds(140,2,260,40);
		this.warning.setForeground(Color.red);
		this.warning.setFont(new Font("Serfi",Font.BOLD,16));
		this.warning.setText("These values are approximations");
		
		this.t1 = new TextInput(75,50);
		this.t1.setText(name[box.getSelectedIndex()]+" of CH4");
		t1.checkTheSize1();
		t1.setToolTip();
		
		this.t2 = new TextInput(185,50);
		this.t2.setText(name[box.getSelectedIndex()]+" of NH3");
		t2.checkTheSize1();
		t2.setToolTip();
		
		
		
		cal = new Button(390,60);
		cal.getButton().setBackground(Color.BLUE);
	
		this.cal.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calCost(Double.parseDouble(t1.getText()),Double.parseDouble(t2.getText()),box.getSelectedIndex());
					warning.setText("These values are approximations");
				}catch(NumberFormatException ex) {
					warning.setText("Please enter numbers!");
				}
				
			}
		});
		
		add(t1.getField());
		add(t2.getField());
		add(box);
		add(cal.getButton());
		add(show);
		add(warning);
		
		
		
	}
	public void calCost(double ch4,double nh3,int num) {
		double cost = 0;
		double ton = 907185;
		if(num==2)
		{
			cost = (ch4*3500)+(nh3*103);
		}
		else if(num==1)
		{
			cost = ((3500/ton)*ch4)+((103/ton)*nh3);
		}
		else if(num==0)
		{
			cost = ((3500/ton)*(18*ch4))+((103/ton)*(17*nh3));
		}
		this.show.setText(String.format("~ %.5f $", cost));
		
		
	}

}
