/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scangui;

import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import static java.awt.Color.white;
import java.util.ArrayList;


public class Panel extends JPanel{
   

	private Algo s;
	private int radius = 15;//nsf alqtr
	private int zwaya = 50;//alzawya
        int search;
        static int i =0;
        ArrayList<Integer>arr;
        
        
        public Panel (Algo tree)
        {
            this.s = tree;
            arr = s.arr4;
        }
        
        public void setVariable(int variable) {
		search = variable;
	}
        @Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		if (arr.size() == 0)
                {
                    return;
                }

		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                //mkan al zhor el node
		paint(graphics2d, arr.get(0), arr.get(0) *5 , 120,getSpace());

	}
        // graphics   root of tree    width     
        private void paint(Graphics2D graph, int root, int x, int y, int space) {
		if (x < 0)
                {
                    setPreferredSize(new Dimension(2 * getWidth(), getHeight()));
                }
                if (i+2 > arr.size())
                {
                    Color c;    
                    c = black;

                    graph.setColor(c);
                    graph.fillOval(x  , y -100, 2 * radius, 2 * radius);
                    //color of of key
                    graph.setColor(new Color(255,255,255));
                    String key = "" + root;
                    FontMetrics fm = graph.getFontMetrics();
                    double t_width = fm.getStringBounds(key, graph).getWidth();
                    graph.drawString(key, (int) (x - t_width + 15), (int) (y + (fm.getMaxAscent() / 2)-90));
                    //color of line and search
                    graph.setColor(Color.BLUE);    
                    c = blue;

                    graph.setColor(c);
                    graph.fillOval(0 , 0, 2 * radius+10, 2 * radius+10);
                    //color of of key
                    graph.setColor(new Color(255,255,255));
                    key = "" + s.t;
                    fm = graph.getFontMetrics();
                    t_width = fm.getStringBounds(key, graph).getWidth();
                    graph.drawString(key, (int) (10 - t_width + 15), (int) (100 + (fm.getMaxAscent() / 2)-90));
                    //color of line and search
                    graph.setColor(Color.BLUE);
                    //System.out.println("LLLLLLLLLLLL");
                    i = 0;
                    return;
                }
                else
                {
                
                    //System.out.println("arr  "+ arr.size());
                    //create node
                    Color c;    
                        c = black;

                    graph.setColor(c);
                    graph.fillOval(x  , y -100, 2 * radius, 2 * radius);
                    //color of of key
                    graph.setColor(new Color(255,255,255));
                    String key = "" + root;
                    FontMetrics fm = graph.getFontMetrics();
                    double t_width = fm.getStringBounds(key, graph).getWidth();
                    graph.drawString(key, (int) (x - t_width + 15) + 5, (int) (y + (fm.getMaxAscent() / 2)-90) + 2);
                    //color of line and search
                    graph.setColor(Color.BLUE);
                    // end creat
                    
                        
                        //System.out.println("<<"+i+"<<"+x+"<<"+y+"<<"+arr.get(i));
                        int x1 = arr.get(i)*5;
                        int y1 = 35*(i+1);
                        int x2 = arr.get(i+1)*5;
                        int y2 = 35 * (i+2);
                        y += 35;
                        equation(graph, x1+10, y1, x2+10, y2);
                        i++;
                        paint(graph, arr.get(i), x2, y2 + 100, space / 2);
//                  
                }
	}
        
        //equation to get x and y of line start and end
	private void equation(Graphics2D g, int x1, int y1, int x2, int y2) {
		g.drawLine(x1, y1, x2, y2);
	}
        private int getSpace() {
            int depth = arr.size();
            float exponent = (float) 1.5;
            return (int) Math.pow(depth, exponent) * 50;
	}
}
