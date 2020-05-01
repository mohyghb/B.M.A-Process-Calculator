package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JPanel_Class extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	//initial
	TextInput t1;
	TextInput t2;
	TextInput t3;
	TextInput t4;
	
	//Reaction
	TextInput t5;
	TextInput t6;
	TextInput t7;
	TextInput t8;
	
	
	//Equilibrium
	TextInput t9;
	TextInput t10;
	TextInput t11;
	TextInput t12;
	
	//moles
	TextInput t13;
	TextInput t14;
	TextInput t15;
	
	TextInput currTemp;
	TextInput currKeq;
	
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Timer timer;
	
	JLabel jl;
	JLabel plus;
	JLabel plus1;
	JLabel equilibriumSign;
	
	
	//drawing ire table
	JLabel I;
	JLabel R;
	JLabel E;
	
	JLabel l;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	
	JLabel CH4;
	JLabel CH4s;
	JLabel NH3;
	JLabel NH3s;
	JLabel HCN;
	JLabel HCNs;
	JLabel H2;
	JLabel H2s;
	
	
	
	
	//sliders
	private JSlider temperatureSlider;
	private JSlider volumeSlider;
	
	
	private double irx = 0;
	private double volume;
	
	private double initialCH4 = 0;
	private double initialNH3 = 0;
	private double initialHCN = 0;
	private double initialH2 = 0;
	
	private double ratioCH4 = 0;
	private double ratioNH3 = 0;
	private double ratioHCN = 0;
	private double ratioH2 = 0;
	
	private double equilibriumCH4 = 0;
	private double equilibriumNH3 = 0;
	private double equilibriumHCN = 0;
	private double equilibriumH2 = 0;
	
	private double KEQAT25 =0.01;
	private double currentTem = 25;
	
	
	
	private static final long serialVersionUID = 1L;

	JPanel_Class()
	{
		super.setLayout(null);
		super.setFocusable(true);
		super.setBackground(Color.WHITE);
		initClass();
		
	}
	
	public void initClass()
	{
		initButtons();
		initSliders();
		initTextFields();
		initIRE();
		initTimer();
		initJL();
		
	}

	public void actionPerformed(ActionEvent e) {
		if(!this.currTemp.getField().hasFocus())
		{
			this.currentTem = this.temperatureSlider.getValue();
			this.currTemp.setText(String.format("%.1f C", this.currentTem));
		}
		
		repaint();
	}
	public void initTextFields()
	{
		this.t1 = new TextInput(100+113,(170));
		this.t1.getField().setEditable(false);
		this.t1.setText("CH4 (M)");
		
		this.t2 = new TextInput(250+125,170);
		this.t2.getField().setEditable(false);
		this.t2.setText("NH3 (M)");
		
		this.t3 = new TextInput(603,170);
		this.t3.getField().setEditable(false);
		this.t3.setText("0 M");
		
		this.t4 = new TextInput(780,170);
		this.t4.getField().setEditable(false);
		this.t4.setText("0 M");
		
		add(t1.getField());
		add(t2.getField());
		add(t3.getField());
		add(t4.getField());
	
		
		//Ratios
		
		this.t5 = new TextInput(100+113,(317));
		this.t5.getField().setEditable(false);
		this.t5.setText("x M");
		
		this.t6 = new TextInput(250+125,317);
		this.t6.getField().setEditable(false);
		this.t6.setText("x M");
	
		this.t7 = new TextInput(603,317);
		this.t7.getField().setEditable(false);
		this.t7.setText("x M");
		
		this.t8 = new TextInput(780,317);
		this.t8.getField().setEditable(false);
		this.t8.setText("3x M");
		
		
		
		
		add(t5.getField());
		add(t6.getField());
		add(t7.getField());
		add(t8.getField());
		
		
		
		
		//Calculated values
		this.t9 = new TextInput(100+113,450);
		this.t9.setText("CH4 (M)");
		this.t9.getField().setEditable(false);
		
		this.t10 = new TextInput(250+125,450);
		this.t10.setText("NH3 (M)");
		this.t10.getField().setEditable(false);
		
		
		this.t11 = new TextInput(603,450);
		this.t11.setText("HCN (M)");
		this.t11.getField().setEditable(false);
		
		this.t12 = new TextInput(780,450);
		this.t12.setText("H2 (M)");
		this.t12.getField().setEditable(false);
		
		add(t9.getField());
		add(t10.getField());
		add(t11.getField());
		add(t12.getField());
		
		
		this.t13 = new TextInput(1,Support.Height-89);
		this.t13.green();
		this.t13.setText("Volume(L)");
		
		this.t14 = new TextInput(111,Support.Height-89);
		this.t14.green();
		this.t14.setText("mol CH4");
		
		this.t15 = new TextInput(222,Support.Height-89);
		this.t15.green();
		this.t15.setText("mol NH3");
		
		add(this.t13.getField());
		add(this.t14.getField());
		add(this.t15.getField());
		
		
		this.currKeq = new TextInput(1000,50);
		this.currKeq.getField().setForeground(Color.orange);
		this.currKeq.setText(String.format("%.3f", this.KEQAT25));
		this.currKeq.getField().addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					KEQAT25 = Double.parseDouble(currKeq.getText());
					setTemNewKeq(Double.parseDouble(currKeq.getText()),45000,8.31451,25);
				}
			}
		});
		add(this.currKeq.getField());
		
		
	}
	public void initTimer()
	{
		this.timer = new Timer(Support.DELAY,this);
		timer.start();
	}
	public void initButtons()
	{
		this.b1 = new Button(333,Support.Height-78);
		this.b1.getButton().setBackground(Color.green);
		add(b1.getButton());
		b1.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==b1.getButton())
				{
					try
					{
						
					
					if(Integer.parseInt(t13.getText())<=0||Integer.parseInt(t14.getText())<=0||Integer.parseInt(t15.getText())<=0)
					{
						jl.setBounds(Support.Width/2-400,-10,830,80);
						jl.setText("Number of the moles and volume should be greater than zero for a reaction to happen");
					}
					else {
						initialCH4 = Double.parseDouble(t14.getText())/Double.parseDouble(t13.getText());
						initialNH3 = Double.parseDouble(t15.getText())/Double.parseDouble(t13.getText());
						jl.setText("");
						function(KEQAT25,initialCH4,initialNH3,0,0);
						t1.setText(String.format("%.3f M", initialCH4));
						t2.setText(String.format("%.3f M", initialNH3));
						
						t13.setText(t13.getText()+" L");
						t14.setText(t14.getText()+ " mol");
						t15.setText(t15.getText()+ " mol");
					}
					}catch(NumberFormatException el)
					{
						jl.setText("Enter integers please!");
						jl.setBounds(Support.Width/2-100, -10, 750, 80);
					}
					
					
				}
				
			}
		});
	}
	public void initJL()
	{
		this.jl = new JLabel();
		this.jl.setBounds(Support.Width/2-340,10,750,80);
		this.jl.setFont(new Font("Serfi",Font.BOLD,20));
		this.jl.setForeground(Color.red);
		add(jl);
		
		
		this.plus = new JLabel("+");
		this.plus.setBounds(330, 20, 120,100);
		this.plus.setFont(new Font("Serfi",Font.BOLD,40));
		add(plus);
		
		this.equilibriumSign = new JLabel("<==>");
		this.equilibriumSign.setBounds(490,20,120,100);
		this.equilibriumSign.setFont(new Font("Serfi",Font.BOLD,40));
		add(this.equilibriumSign);
		
		this.plus1 = new JLabel("+");
		this.plus1.setBounds(735, 20, 120,100);
		this.plus1.setFont(new Font("Serfi",Font.BOLD,40));
		add(plus1);
	}
	public void initIRE()
	{
		//ire words
		this.I = new JLabel("I");
		this.I.setBounds(120,150,100,100);
		this.I.setFont(new Font("Serfi",Font.BOLD,80));
		
		this.R = new JLabel("R");
		this.R.setBounds(100,290,100,100);
		this.R.setFont(new Font("Serfi",Font.BOLD,80));
		
		this.E = new JLabel("E");
		this.E.setBounds(100,430,100,100);
		this.E.setFont(new Font("Serfi",Font.BOLD,80));
		
		
		
		
		
		add(this.I);
		add(this.R);
		add(this.E);
		
		//end ire words
		
		this.CH4 = new JLabel("CH");
		this.CH4.setBounds(225,20,100,100);
		this.CH4.setFont(new Font("Serfi",Font.PLAIN,40));
		
		this.CH4s = new JLabel("4(g)");
		this.CH4s.setBounds(282,30,100,100);
		this.CH4s.setFont(new Font("Serfi",Font.PLAIN,20));
		
		add(CH4);
		add(CH4s);
		
		
		
		this.NH3 = new JLabel("NH");
		this.NH3.setBounds(375,20,100,100);
		this.NH3.setFont(new Font("Serfi",Font.PLAIN,40));
		
		this.NH3s = new JLabel("3(g)");
		this.NH3s.setBounds(432,30,100,100);
		this.NH3s.setFont(new Font("Serfi",Font.PLAIN,20));
		
		add(NH3);
		add(NH3s);
		
		
		
		this.HCN = new JLabel("HCN");
		this.HCN.setBounds(375+230,20,100,100);
		this.HCN.setFont(new Font("Serfi",Font.PLAIN,40));
		
		this.HCNs = new JLabel("(g)");
		this.HCNs.setBounds(432+260,30,100,100);
		this.HCNs.setFont(new Font("Serfi",Font.PLAIN,20));
		
		add(HCN);
		add(HCNs);
		
		
		
		
		this.H2 = new JLabel("3H");
		this.H2.setBounds(375+415,20,100,100);
		this.H2.setFont(new Font("Serfi",Font.PLAIN,40));
		
		this.H2s = new JLabel("2(g)");
		this.H2s.setBounds(432+410,30,100,100);
		this.H2s.setFont(new Font("Serfi",Font.PLAIN,20));
		
		add(H2);
		add(H2s);
		
		
		
		//drawing table
		this.l = new JLabel("|");
		this.l.setBounds(120,50,150,500);
		this.l.setFont(new Font("Serfi",Font.PLAIN,500));
		this.l.setForeground(Color.YELLOW);
		
		this.l2 = new JLabel("|");
		this.l2.setBounds(275,50,150,500);
		this.l2.setFont(new Font("Serfi",Font.PLAIN,500));
		this.l2.setForeground(Color.YELLOW);
		
		this.l3 = new JLabel("|");
		this.l3.setBounds(448,50,150,500);
		this.l3.setFont(new Font("Serfi",Font.BOLD,500));
		this.l3.setForeground(Color.yellow);
		this.l4 = new JLabel("|");
		this.l4.setBounds(483,50,150,500);
		this.l4.setFont(new Font("Serfi",Font.BOLD,500));
		this.l4.setForeground(Color.yellow);
		
		this.l5 = new JLabel("|");
		this.l5.setBounds(680,50,150,500);
		this.l5.setFont(new Font("Serfi",Font.PLAIN,500));
		this.l5.setForeground(Color.YELLOW);

		
		add(l);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		
		
		this.currTemp = new TextInput(990,500);
		this.currTemp.getField().setFont(new Font("Serfi",Font.PLAIN,25));
		this.currTemp.getField().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try
					{
						currentTem = Double.parseDouble(currTemp.getText());
						temperatureSlider.setMaximum((int) currentTem+50);
						temperatureSlider.setMinimum((int)currentTem-50);
						temperatureSlider.setValue((int)currentTem);
						jl.setText("");
						getKeqNewTem(0.01, 45000, 8.31451, 25, Double.parseDouble(currTemp.getText()));
						currKeq.checkTheSize();
						currKeq.setToolTip();
					}
					catch(NumberFormatException ess)
					{
						jl.setText("Enter integers please!");
						jl.setBounds(Support.Width/2-100, -10, 750, 80);
					}
					
				}
			}
		});
		
		
		add(currTemp.getField());
		
	}
	public void initSliders()
	{
		this.temperatureSlider = new JSlider(JSlider.VERTICAL,-20,100,25);
		this.temperatureSlider.setBounds(1001,190,100,300);
		this.temperatureSlider.setBackground(Color.white);
		this.temperatureSlider.setPaintTicks(true);
	    this.temperatureSlider.setPaintLabels(true);
	    this.temperatureSlider.setMinorTickSpacing(5);
	    this.temperatureSlider.setMajorTickSpacing(10);
	    this.temperatureSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent er) {
				getKeqNewTem(0.01, 45000, 8.31451, 25, temperatureSlider.getValue());
				currKeq.checkTheSize();
				currKeq.setToolTip();
				
			}
	    });
		add(this.temperatureSlider);
	}
	public void function(double value,double voCH4,double voNH3,double voHCN,double voH2) throws NumberFormatException
	{
		double keq = value;
		double x = 0;
		boolean control = true;
		long initialTime = System.currentTimeMillis();
		System.out.print(initialTime);
		if(keq>0.02&&keq<0.1)
		{
			while(control&&System.currentTimeMillis()<initialTime+2000)
			{
				if(calculated(x,voCH4,voNH3,0,0)<=keq+0.0009&&calculated(x,voCH4,voNH3,0,0)>=keq-0.0009)
				{
					this.irx = x;
					System.out.print(x);
					implementRatios(irx);
					control = false;
					break;
				}
				x+=0.001;
			}
		}
		 if(keq<=0.02)
		{
			while(control&&System.currentTimeMillis()<initialTime+2000)
			{
				if(calculated(x,voCH4,voNH3,0,0)<=keq+0.0002&&calculated(x,voCH4,voNH3,0,0)>=keq-0.0002)
				{
					this.irx = x;
					System.out.print(x);
					implementRatios(irx);
					control = false;
					break;
				}
				x+=0.001;
			}
		}
		else if(keq>=0.1&&keq<=2.7)
		{
			while(control&&System.currentTimeMillis()<initialTime+2000)
			{
				if(calculated(x,voCH4,voNH3,0,0)<=keq+0.002&&calculated(x,voCH4,voNH3,0,0)>=keq-0.002)
				{
					this.irx = x;
					System.out.print(x);
					implementRatios(irx);
					control = false;
					break;
				}
				x+=0.001;
			}
		}
		else if(keq>2.7&&keq<=10)
		{
			while(control&&System.currentTimeMillis()<initialTime+2000)
			{
				if(calculated(x,voCH4,voNH3,0,0)<=keq+0.01&&calculated(x,voCH4,voNH3,0,0)>=keq-0.01)
				{
					this.irx = x;
					System.out.print(x);
					implementRatios(irx);
					control = false;
					break;
				}
				x+=0.001;
			}
		}
		else if(keq>10&&keq<=100)
		{
			while(control&&System.currentTimeMillis()<initialTime+2000)
			{
				if(calculated(x,voCH4,voNH3,0,0)<=keq+0.1&&calculated(x,voCH4,voNH3,0,0)>=keq-0.1)
				{
					this.irx = x;
					System.out.print(x);
					implementRatios(irx);
					control = false;
					break;
				}
				x+=0.001;
			}
		}
		else if(keq>100&&keq<=299)
		{
			while(control&&System.currentTimeMillis()<initialTime+2000)
			{
				if(calculated(x,voCH4,voNH3,0,0)<=keq+1&&calculated(x,voCH4,voNH3,0,0)>=keq-1)
				{
					this.irx = x;
					System.out.print(x);
					implementRatios(irx);
					control = false;
					break;
				}
				x+=0.001;
			}
		}
		else if (keq>299&&keq<=1697)
		{
			while(control&&System.currentTimeMillis()<initialTime+2000)
			{
				if(calculated(x,voCH4,voNH3,0,0)<=keq+10&&calculated(x,voCH4,voNH3,0,0)>=keq-10)
				{
					this.irx = x;
					System.out.print(x);
					implementRatios(irx);
					control = false;
					break;
				}
				x+=0.001;
			}
		}
		else if(keq>1697&&keq<=2430)
		{
			while(control&&System.currentTimeMillis()<initialTime+2000)
			{
				if(calculated(x,voCH4,voNH3,0,0)<=keq+20&&calculated(x,voCH4,voNH3,0,0)>=keq-20)
				{
					this.irx = x;
					System.out.print(x);
					implementRatios(irx);
					control = false;
					break;
				}
				x+=0.001;
			}
		}
		else if(keq>2430)
		{
			while(control&&System.currentTimeMillis()<initialTime+2000)
			{
				if(calculated(x,voCH4,voNH3,0,0)<=keq+40&&calculated(x,voCH4,voNH3,0,0)>=keq-40)
				{
					this.irx = x;
					System.out.print(x);
					implementRatios(irx);
					control = false;
					break;
				}
				x+=0.001;
			}
		}
		 
		 if(control==true)
		 {
			 control = false;
			 jl.setText("Sorry there was a problem");
			 jl.setBounds(Support.Width/2-100, -10, 750, 80);
		 }
		 else 
		 {
			 jl.setText("");
		 }
		
		
	}
	public void implementRatios(double ratio)
	{
		this.ratioCH4 = ratio;
		this.ratioNH3 = ratio;
		this.ratioHCN = ratio;
		this.ratioH2 = 3*ratio;
		
		this.t5.setText(String.format("%.3f M", ratioCH4));
		this.t6.setText(String.format("%.3f M", ratioNH3));
		this.t7.setText(String.format("%.3f M", ratioHCN));
		this.t8.setText(String.format("%.3f M", ratioH2));
		
		
		calculateEquilibrium();
		
	}
	
	
	public void calculateEquilibrium()
	{
		this.equilibriumCH4 = this.initialCH4 - this.ratioCH4;
		this.equilibriumNH3 = this.initialNH3 - this.ratioNH3;
		this.equilibriumHCN = this.initialHCN + this.ratioHCN;
		this.equilibriumH2 = this.initialH2 + this.ratioH2;
		
		this.t9.setText(String.format("%.3f M",this.equilibriumCH4));
		this.t10.setText(String.format("%.3f M",this.equilibriumNH3));
		this.t11.setText(String.format("%.3f M",this.equilibriumHCN));
		this.t12.setText(String.format("%.3f M",this.equilibriumH2));
		
		checkSize();
		setToolTip();
		
	}
	public double calculated(double x,double voch4,double vonh3,double vohcn,double voh2)
	{	
	double top = Math.pow((voh2+(3*x)), 3)*(vohcn+x); 
	double bottom = (voch4-x)*(vonh3-x);
    double finalkeq = top/bottom;
	return finalkeq;
	}
	public void checkSize()
	{
		t1.checkTheSize();
		t2.checkTheSize();
		t3.checkTheSize();
		t4.checkTheSize();
		t5.checkTheSize();
		t6.checkTheSize();
		t7.checkTheSize();
		t8.checkTheSize();
		t9.checkTheSize();
		t10.checkTheSize();
		t11.checkTheSize();
		t12.checkTheSize();
		t13.checkTheSize();
		t14.checkTheSize();
		t15.checkTheSize();
	}
	public void setToolTip()
	{
		t1.setToolTip();
		t2.setToolTip();
		t3.setToolTip();
		t4.setToolTip();
		t5.setToolTip();
		t6.setToolTip();
		t7.setToolTip();
		t8.setToolTip();
		t9.setToolTip();
		t10.setToolTip();
		t11.setToolTip();
		t12.setToolTip();
		t13.setToolTip();
		t14.setToolTip();
		t15.setToolTip();
	}
	
	public void getKeqNewTem(double k1,double deltaH,double R,double T1,double T2)
	{
		double kt1 = T1+273.15;
		double kt2 = T2+273.15;
		double newKeq = k1*(Math.pow(Math.E, ((deltaH/R)*((1/kt2)-(1/kt1)))));
		this.KEQAT25 = newKeq;
		currKeq.setText(String.format("%.3f", this.KEQAT25));
	}
	public void setTemNewKeq(double k2,double deltaH,double R,double T1)
	{
		double kt1 = T1+273.15;
		double newTem = 1/((Math.log(k2/0.01)*R/deltaH)+(1/kt1));
		currentTem = newTem-273.15;
		temperatureSlider.setMaximum((int) currentTem+50);
		temperatureSlider.setMinimum((int)currentTem-50);
		temperatureSlider.setValue((int)currentTem);
		
	}
	
	
}
