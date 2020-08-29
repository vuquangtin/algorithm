package problems.gui.towerofhanoi;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */


public class Hanoi extends JPanel
{
	private static final long serialVersionUID = 1L;	
	public static final String resourcePath="java/src/resources/images/towerofhanoi/";
	ImageIcon background=new ImageIcon(resourcePath+"background.png");
	ImageIcon disc1=new ImageIcon(resourcePath+"disc1.png");
    ImageIcon disc2=new ImageIcon(resourcePath+"disc2.png");
    ImageIcon disc3=new ImageIcon(resourcePath+"disc3.png");
    ImageIcon disc4=new ImageIcon(resourcePath+"disc4.png");
    ImageIcon disc5=new ImageIcon(resourcePath+"disc5.png");
    ImageIcon disc6=new ImageIcon(resourcePath+"disc6.png");
    ImageIcon disc7=new ImageIcon(resourcePath+"disc7.png");
    ImageIcon disc8=new ImageIcon(resourcePath+"disc8.png");
    ImageIcon disc9=new ImageIcon(resourcePath+"disc9.png");
    ImageIcon disc10=new ImageIcon(resourcePath+"disc10.png");
    ImageIcon discs[] ={disc1,disc2,disc3,disc4,disc5,disc6,disc7,disc8,disc9,disc10};
	Vector<Move> log = new Vector<Move>();
	public int n,moves,i=0;
	private Tower A, B, C;
	boolean done = false;
	/// timers
    Timer t1,t2,t3;
    
    /// constructor
	public Hanoi(int discs)
	{
		 setBorder(new TitledBorder(null, "Tower of Hanoi - "+discs+" discs", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
		 /// number of discs
	     this.n = discs;
	     /// tower A
	     this.A = new Tower(90,"A");
	     /// tower B
	     this.B = new Tower(260,"B");
	     /// tower C
	     this.C = new Tower(430,"C");
		 
	     this.moves = 0;
	     
		 for (int i = 0; i < n; i++)
	     {
	        A.pole.push(this.discs[i]);
	     }
	     B.pole.setSize(0);
	     C.pole.setSize(0);
	     
	     Begin();
	     
		t1 = new Timer(500, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {  
		    	if(i!=moves)
				{
		    	 log.elementAt(i).A.top = log.elementAt(i).A.pole.pop();
				 repaint();
				 t2.start(); 
				 t1.stop(); 
                }
				else
				{
				 done=true;
				 repaint();
				 t1.stop();
				}
		    }
		});
		
		t2 = new Timer(500, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {  
		    	log.elementAt(i).B.top=log.elementAt(i).A.top;
		    	log.elementAt(i).A.top=null;
		    	repaint();
		    	t3.start();
		    	t2.stop();
		    }
		});
		
		t3 = new Timer(500, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {  
		    	log.elementAt(i).B.pole.push(log.elementAt(i).B.top);
		    	log.elementAt(i).B.top=null;
		    	repaint();
		    	t3.stop();
		    	i++;
		    	t1.start();
		    }
		});	
		
		t1.start();
	}
	
	public void paintComponent(Graphics g)
	{
	   super.paintComponent(g);
       g.drawImage(background.getImage(),0,0,getWidth(),getHeight(),null);
       A.DrawTower(g);
       B.DrawTower(g);
       C.DrawTower(g);
       A.DrawTop(g);
       B.DrawTop(g);
       C.DrawTop(g);
       g.setColor(Color.blue);
       g.drawString("Move: "+i, 10, 30);  
       if(done)
       {
    	   g.setFont(new Font(null, Font.PLAIN, 20)); 
    	   g.setColor(Color.green);
           g.drawString("DONE!!!",(getWidth()/2)-30, 40); 
       }
	}
	
	/// Recursion Boot Method
	public void Begin()
	{
		HanoiRecursive(n, A, B, C);  
	}
	
	/// Hanoi recursive method
	public void HanoiRecursive(int n, Tower A, Tower B, Tower C) 
	{
	    if(n==0)
	    {
	    	return;
	    }
	    else
	    {
	    	HanoiRecursive(n-1,A,C,B);
	    	moves++;
	    	move(A,C);
	    	HanoiRecursive(n-1,B,A,C);
	    }
	}
    
	public void move(Tower a, Tower b) 
    {
		log.addElement(new Move(a,b));
	}
}