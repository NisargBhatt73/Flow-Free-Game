/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
class Dimension
{
    int x,y;
    
}
 public class Game extends JFrame implements MouseMotionListener,MouseListener,ActionListener {
     boolean drawL=false,flag=true;
     boolean win;
     int noOfColors,y=0,cellPos;
     static int levelNo;
    // String levelLoc="S:\\FlowFreeLevels\\dot2.txt";
     int noofCells=4;
     JFrame frame;
     boolean[] winCond=new boolean[noofCells*noofCells];
     
   boolean[] cellVisible = new boolean[noofCells*noofCells];
   boolean[] clearcell = new boolean[noOfColors];
  
    ArrayList<Integer> []color_select;
      int color[][]=new int[noofCells][noofCells];
      int pos_color[];
          
     Dimension q=new Dimension();
   
     int xd,yd,activeCell=1;
Dimension operate(int activeCell){
    if(activeCell%noofCells==0)
    {
        q.x=100*noofCells;
        q.y=100+100*((int)(activeCell/noofCells)-1);
        
    }
    else
    {
     q.x=100+100*((activeCell)%noofCells-1);
     q.y=100+100*((int)activeCell/noofCells);
    }
  
     return q;
}
 public Game(String levelLoc,int levelNo)    { 
     setTitle("Flow-Free Game");
     setLayout(null);
     JButton reset=new JButton("RESET");
     reset.setBounds(100,5,100,50);
     reset.addActionListener(this);
     add(reset);
     setVisible(true);
     levelNo=this.levelNo;
     frame=new JFrame();
   BufferedReader br = null;
  
       BufferedReader br2 = null;
       try{	
           br = new BufferedReader(new FileReader(levelLoc));		

	   String contentLine = br.readLine();
           noofCells=Integer.parseInt(contentLine);
           contentLine=br.readLine();
           noOfColors=Integer.parseInt(contentLine);
           pos_color=new int[noOfColors*2];
             winCond=new boolean[noofCells*noofCells];    
            cellVisible = new boolean[noofCells*noofCells];
            clearcell = new boolean[noOfColors];
           color=new int[noofCells][noofCells];
              int i=0;
	   while (contentLine != null&&i<noOfColors*2) {
               contentLine = br.readLine();
	     
              pos_color[i]=Integer.parseInt(contentLine);
              i++;
             
	      
	   }
           

    }
       catch (IOException ioe) 
       {
	   ioe.printStackTrace(); 
       } 
       finally 
       {
	   try {
	      if (br != null)
		 br.close();
	      if (br2 != null)
		 br2.close();
	   } 
	   catch (IOException ioe) 
           {
		System.out.println("Error in closing the BufferedReader");
	   }
	}
      
 setSize( 200+100*noofCells, 200+100*noofCells );
 setVisible(true);   
 addMouseMotionListener(this);
 addMouseListener(this);
color_select =new ArrayList[noOfColors];
for (int i = 0; i < noOfColors; i++) { 
            color_select[i] = new ArrayList<Integer>(); 
        } 
 } 
 //------------------------------------------------------------------------------------
 
 
 
 

    @Override    
  public void paint( Graphics g )    
 { 
    g.setColor(Color.GRAY);
    g.fillRect(0,0,200+100*noofCells,200+100*noofCells);
    g.setColor(Color.BLACK);
 for ( int x = 100; x < 100+100*noofCells; x += 100 )
     {
         for ( int y = 100; y <100+100*noofCells; y += 100 )
         {
             g.drawRect( x, y, 100, 100 );
         }
     }
          
          
          for(int m=0;m<noOfColors*2;m++)
          {
              if(m<2)////------------------------cyan=5-------------------------
              {   
                  activeCell=pos_color[m];
                  g.setColor(Color.CYAN);
                  q=operate(activeCell);
                  cellVisible[activeCell-1]=true;
                  g.fillOval(q.x+20, q.y+20, 60, 60);
                 color[(int)(q.y/100)-1][(int)(q.x/100)-1]=5;
              }
              else if(m<4)///---------------------yellow=6---------------
              {   
                  activeCell=pos_color[m];
                  g.setColor(Color.YELLOW);
                  q=operate(activeCell);
                  cellVisible[activeCell-1]=true;
                  g.fillOval(q.x+20, q.y+20, 60, 60);
                 color[(int)(q.y/100)-1][(int)(q.x/100)-1]=6;
              }
               else if(m<6)//-------------------red=7----------------
              {   
                  activeCell=pos_color[m];
                  g.setColor(Color.RED);
                  q=operate(activeCell);
                  cellVisible[activeCell-1]=true;
                  g.fillOval(q.x+20, q.y+20, 60, 60);
                 color[(int)(q.y/100)-1][(int)(q.x/100)-1]=7;
              }
                else if(m<8)//---------------------magenta=8---------
              {   
                  activeCell=pos_color[m];
                  g.setColor(Color.MAGENTA);
                  q=operate(activeCell);
                  cellVisible[activeCell-1]=true;
                  g.fillOval(q.x+20, q.y+20, 60, 60);
                 color[(int)(q.y/100)-1][(int)(q.x/100)-1]=8;
              }
                 else if(m<10)//------------------green=9---------------
              {   
                  activeCell=pos_color[m];
                  g.setColor(Color.GREEN);
                  q=operate(activeCell);
                  cellVisible[activeCell-1]=true;
                  g.fillOval(q.x+20, q.y+20, 60, 60);
                 color[(int)(q.y/100)-1][(int)(q.x/100)-1]=9;
              }
                 else  if(m<12)//------------------orange=10---------------
              {   
                  activeCell=pos_color[m];
                  g.setColor(Color.ORANGE);
                  q=operate(activeCell);
                  cellVisible[activeCell-1]=true;
                  g.fillOval(q.x+20, q.y+20, 60, 60);
                 color[(int)(q.y/100)-1][(int)(q.x/100)-1]=10;
              }
                  else  if(m<14)//--------------white=11-----------------
              {   
                  activeCell=pos_color[m];
                  g.setColor(Color.WHITE);
                  q=operate(activeCell);
                  cellVisible[activeCell-1]=true;
                  g.fillOval(q.x+20, q.y+20, 60, 60);
                 color[(int)(q.y/100)-1][(int)(q.x/100)-1]=11;
              }
                    else if(m<16)//----------------pink=12--------------
              {   
                  activeCell=pos_color[m];
                  g.setColor(Color.PINK);
                  q=operate(activeCell);
                  cellVisible[activeCell-1]=true;
                  g.fillOval(q.x+20, q.y+20, 60, 60);
                 color[(int)(q.y/100)-1][(int)(q.x/100)-1]=12;
              }
                   else   if(m<18)//--------------lightgray=13-------------------
              {   
                  activeCell=pos_color[m];
                  g.setColor(Color.lightGray);
                  q=operate(activeCell);
                  cellVisible[activeCell-1]=true;
                  g.fillOval(q.x+20, q.y+20, 60, 60);
                 color[(int)(q.y/100)-1][(int)(q.x/100)-1]=13;
              }
          }
 
 /*for (int i = 0; i < noofCells; i++)
 {   
     //for(int j=0;j<noofCells;j++)
     //System.out.print(color[i][j]+" ");
      //System.out.println("");
 }*/
 Dimension prevXY=new Dimension();
 for(int i=0;i<noOfColors;i++)
 {
     if(i==0)g.setColor(Color.CYAN);
     else if(i==1)g.setColor(Color.YELLOW);
      else if(i==2)g.setColor(Color.RED);
      else if(i==3)g.setColor(Color.MAGENTA);
      else if(i==4)g.setColor(Color.GREEN);
      else if(i==5)g.setColor(Color.ORANGE);
      else if(i==6)g.setColor(Color.WHITE);
      else if(i==7)g.setColor(Color.PINK);
      else if(i==8)g.setColor(Color.LIGHT_GRAY);
     
     
     for(int j=1;j<color_select[i].size();j++)
     {
         int dx,dy;
         int ox,oy,px,py;
         
         Dimension drawe=new Dimension();
         drawe=operate(color_select[i].get(j));
         
        
         drawe.x+=50;drawe.y+=50;
          dx=drawe.x;dy=drawe.y;
         // System.out.println("draw**       "+dx+"  "+dy);
          prevXY=operate(color_select[i].get(j-1));
            
            
          prevXY.x+=50;prevXY.y+=50;
          px=prevXY.x;py=prevXY.y;
         // System.out.println("prev  **       "+px+"  "+py);
          int height,width;
          if(dx==px )
          {
              if(py>dy)
              {
                  ox=dx;oy=dy;
              }
              else
              { ox=px;oy=py;}
                  
              // System.out.println("Shnat it change**       "+drawe.x+"  "+prevXY.x);
              width=10;
              height=100;
           }
          else 
          {
              if(px>dx)
              {
                  ox=dx;oy=dy;
              }
              else
              {ox=px;oy=py;}
                  
            //  System.out.println("YAHAHHHHHHH   ");
              height=10;
              width=100;
          }
          g.fillRect(ox, oy, width, height);
         
     }  
 } 

 
 }
     @Override
    public void mouseDragged(MouseEvent e) { 
         //flag=true;
     int a,b,x=0;
     a=(int)((e.getX())/100);
     b=(int)(e.getY()/100);
   
     x++;
   // System.out.println(e.getX()+" ----------------- "+e.getY());
    if(e.getX()<=100||e.getX()>=100+100*noofCells||e.getY()<=100||e.getY()>=100+100*noofCells)
    {
        return;
    }
    else if(a>100||a<100+100*noofCells||b>100||b<100+100*noofCells)
     {
           System.out.println(x);
           
         
         if(flag)
         {
             if(cellVisible[(b-1)*noofCells+a-1])
             {
                y=color[b-1][a-1];
                flag=false;
                System.out.println(x); 
             }
             else
             {
                 
             }  
             
         }
         else
        {//-------------------celladding-------------------------------------------
            cellPos=(b-1)*noofCells+a-1;
            if(cellVisible[cellPos])//----------initial touch--------------
            {   
                
                if(color_select[y-5].size()==0 && y==color[b-1][a-1])
                {
                    
                    color_select[y-5].add(cellPos+1);
                     winCond[cellPos]=true;
                }
                if(color_select[y-5].get(color_select[y-5].size()-1)!=(b-1)*noofCells+a && y==color[b-1][a-1])
                {   
                    if(color_select[y-5].get(0)==cellPos+1)//---------clear if we start from first-------------------
                    {
                          for(int i=0;i<noOfColors;i++)
                        {
                            
                                for(int j=0;j<color_select[i].size();j++)
                                 {
                                    if(color_select[i].get(j)==cellPos+1)
                                        {   
                                            for(int k=0;k<color_select[i].size();k++)
                                             {
                                                  int p=color_select[i].get(k);
                                                   winCond[p-1]=false;
                                                    if(p%noofCells==0)
                                                     {
                                                          color[p/noofCells-1][3]=0;
                                                     }
                                                    else
                                                     {
                                                        color[p/noofCells][p%noofCells-1]=0;
                                                    }
                                             }
                                               color_select[i].clear();
                            
                                        }
                             
                                  }
                        }
                    }
                    else
                    {
                         color_select[y-5].add(cellPos+1);
                         winCond[cellPos]=true;   
                    }
                   
                }//-----------------------------------------clear if we start from first-----/////
            }//----------------------------------cell clear-----------------------------////////
            else if(color[b-1][a-1]==y && color_select[y-5].size()>2)//------------clear backward-----------////////////////////
            {
                for(int i=0;i<noOfColors;i++)
                 {
                     
                     for(int j=0;j<color_select[i].size()-1;j++)
                     {
                         if(color_select[i].get(j)==cellPos+1)
                         {   
                             for(int k=0;k<color_select[i].size();k++)
                             {  
                                 int p=color_select[i].get(k);
                                 winCond[p-1]=false;
                                 if(p%noofCells==0)
                                 {
                                     color[p/noofCells-1][3]=0;
                                 }
                                 else
                                 {
                                     color[p/noofCells][p%noofCells-1]=0;
                                 }
                                 
                             }
                               color_select[i].clear();
                               clearcell[i]=true;
                         }
                             
                     }
                 }
            }//-------------------------------------cell backward--------------///////////////
            else if(color[b-1][a-1]!=y && !cellVisible[cellPos])
             {     
                 for(int i=0;i<noOfColors;i++)
                 {
                     
                     for(int j=0;j<color_select[i].size();j++)
                     {
                         if(color_select[i].get(j)==cellPos+1)
                         {   
                             for(int k=0;k<color_select[i].size();k++)
                             {  
                                 int p=color_select[i].get(k);
                                 winCond[p-1]=false;
                                 if(p%noofCells==0)
                                 {
                                     color[p/noofCells-1][3]=0;
                                 }
                                 else
                                 {
                                     color[p/noofCells][p%noofCells-1]=0;
                                 }
                                 
                             }
                               color_select[i].clear();
                         }
                             
                     }
                 }
             color_select[y-5].add(cellPos+1);
             winCond[cellPos]=true;
             color[b-1][a-1]=y; 
             }//---------------------------------cell clear------------------------
            //---------------------------- second touch----------------------------
            else{
                color[b-1][a-1]=y;
                if(color_select[y-5].size()==0)
                {    
                   color_select[y-5].add(cellPos+1);
                    winCond[cellPos]=true;
                  
                }
               else
                {     
           
                    if(color_select[y-5].get(color_select[y-5].size()-1)!=cellPos+1)
                    {  
                 
                            color_select[y-5].add(cellPos+1);
                            winCond[cellPos]=true;                           
                    } 
                    
                    
                }
              //-------------------------------------------------------celladding--------------------
            }
                 
        }repaint();
        
       /* for (int i = 0; i < 4; i++)
        {   
          for(int j=0;j<4;j++)
         {
         System.out.print(color[i][j]+" ");
         }
      System.out.println("");
       }*/
     }
    
    /*for (int i = 0; i < noofCells; i++)
        {   
          for(int j=0;j<noofCells;j++)
         {
         System.out.print(color[i][j]+" ");
         }
      System.out.println("");
       }*/
       //  System.out.println("Printing arraylist\n");
    for (int i = 0; i < noOfColors; i++) { 
          /*  for(int j=0;j<color_select[i].size();j++)
            {
                  System.out.print(color_select[i].get(j)+" ");
        } */
            win=true;
            for(int k=0;k<noofCells*noofCells;k++)
            {
                if(winCond[k]==false)
                    win=false;
            }
            if(win==true)
            {
                JOptionPane.showMessageDialog(null,"Well Played, You win");
                levelNo++;
                String levelLoc="S:\\FlowFreeLevels\\dot"+levelNo+".txt";
                System.out.println(levelLoc+"--------------------------"+levelNo+"--------------------");
                  for(int x_=0;x_<noOfColors;x_++)
                        {
                            
                                for(int j=0;j<color_select[x_].size();j++)
                                 {
                                    //if(color_select[i].get(j)==cellPos+1)
                                      //  {   
                                            for(int k=0;k<color_select[x_].size();k++)
                                             {
                                                  int p=color_select[x_].get(k);
                                                   winCond[p-1]=false;
                                                    if(p%noofCells==0)
                                                     {
                                                          color[p/noofCells-1][3]=0;
                                                     }
                                                    else
                                                     {
                                                        color[p/noofCells][p%noofCells-1]=0;
                                                    }
                                             }
                                               color_select[x_].clear();
                            
                                        //}
                             
                                  }
                        }
                
                System.out.println("----------------YOUWIN-----------");
                Game g=new Game(levelLoc,levelNo);
                //g.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                //frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
                setVisible(false);
                dispose();
                repaint();
                break;
            }
          
            System.out.println();}
   
 }  
     @Override
    public void mouseMoved(MouseEvent e) {  
        
    }  
     @Override
     public void mouseReleased(MouseEvent e) {  
         
         for(int i=0;i<noOfColors;i++)//-------------this clear is for when we release the mouse after the backward is detected-//////////
         {
             if(clearcell[i])
             {
                 for(int k=0;k<color_select[i].size();k++)
                             {  
                                 int p=color_select[i].get(k);
                                 winCond[p-1]=false;
                                 if(p%noofCells==0)
                                 {
                                     color[p/noofCells-1][3]=0;
                                 }
                                 else
                                 {
                                     color[p/noofCells][p%noofCells-1]=0;
                                 }
                                 
                             }
                color_select[i].clear();
                clearcell[i]=false;
             }
           //  System.out.println("dsdaddiodewfejwfwfjwfjewfwjf");
         }
         flag=true;
         y=0;
    }  
     @Override
     public void mouseClicked(MouseEvent e) {  
        
    }  
     @Override
     public void mouseEntered(MouseEvent e) {  
        
    }  
     @Override
     public void mouseExited(MouseEvent e) {  
        
    }  
     @Override
     public void mousePressed(MouseEvent e) {  
        
    }
     public void actionPerformed(ActionEvent e)
     {
         String str=e.getActionCommand();
         if(str.equals("RESET"))
         {
             System.out.println("BUTTon pressed----------------------------------------------------------");
                             //JOptionPane.showMessageDialog(null,"RESET?");
            for(int x_=0;x_<noOfColors;x_++)
                        {
                            
                                for(int j=0;j<color_select[x_].size();j++)
                                 {
                                    //if(color_select[i].get(j)==cellPos+1)
                                      //  {   
                                            for(int k=0;k<color_select[x_].size();k++)
                                             {
                                                  int p=color_select[x_].get(k);
                                                   winCond[p-1]=false;
                                                    if(p%noofCells==0)
                                                     {
                                                          color[p/noofCells-1][3]=0;
                                                     }
                                                    else
                                                     {
                                                        color[p/noofCells][p%noofCells-1]=0;
                                                    }
                                             }
                                               color_select[x_].clear();
                            
                                        //}
                             
                                  }
                        }repaint();

         }
     }
 public static void main( String args[] ) 
 {  
     String levelLoc="S:\\FlowFreeLevels\\dot1.txt";
     Game  application = new Game (levelLoc,1);
 application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
 }  } 
