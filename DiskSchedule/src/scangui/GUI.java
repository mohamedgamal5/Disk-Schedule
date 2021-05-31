/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scangui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class GUI extends JPanel{
    private Algo A = new Algo();
    private Panel APanel = new Panel(A);
    
	public GUI() {
		APanel.setBackground(new Color(210, 180, 222));
		super.setLayout(new BorderLayout());
		setScrollPane();
		setBottomPanel();
	}

	private void setBottomPanel() {
		final JTextField insertText = new JTextField(10);
                final JTextField headText = new JTextField(10);
                final JTextField AlgorithmText = new JTextField(10);
		final JButton insert = new JButton();
		try {
			Image icon = ImageIO.read(getClass().getResource("insert" + ".png"));
			insert.setIcon(new ImageIcon(icon));
			insert.setBorderPainted(false);
                        insert.setSize(10,10);
			insert.setFocusPainted(false);
			insert.setContentAreaFilled(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		final JButton Algorithm = new JButton();
		try {
			Image icon = ImageIO.read(getClass().getResource("Algorithm" + ".png"));
			Algorithm.setIcon(new ImageIcon(icon));
			Algorithm.setBorderPainted(false);
                        Algorithm.setSize(10,10);
			Algorithm.setFocusPainted(false);
			Algorithm.setContentAreaFilled(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		final JButton clear = new JButton();
		try {
			Image icon = ImageIO.read(getClass().getResource("clear" + ".png"));
			clear.setIcon(new ImageIcon(icon));
			clear.setBorderPainted(false);
                        clear.setSize(10,10);
			clear.setFocusPainted(false);
			clear.setContentAreaFilled(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		final JButton head = new JButton();
		try {
			Image icon = ImageIO.read(getClass().getResource("head" + ".png"));
			head.setIcon(new ImageIcon(icon));
			head.setBorderPainted(false);
                        head.setSize(10,10);
			head.setFocusPainted(false);
			head.setContentAreaFilled(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JPanel panel = new JPanel();
                panel.add(insert);
		panel.add(insertText);
		panel.add(Algorithm);
                panel.add(AlgorithmText);
		panel.add(head);
                panel.add(headText);
		panel.add(clear);
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.SOUTH);

		insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				
                                
                                if (insertText.getText().equals(""))
					return;

				int key = Integer.parseInt(insertText.getText());
                                A.inseart(key);
                                APanel.repaint();
                                insertText.requestFocus();
                                insertText.selectAll();

			}
                        

		});
                Algorithm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if (AlgorithmText.getText().equals(""))
                                {
                                    return;
                                }
				int key = Integer.parseInt(AlgorithmText.getText());
                                if(key == 1)
                                {
                                    A.FCFS();
                                }
                                if(key == 3)
                                {
                                    A.AScan();
                                }
                                if(key == 4)
                                {
                                    A.ACScan();
                                }
								else if(key == 5)
								{
									A.Look();
								}
								else if(key == 6)
								{
									A.Clook();
								}
                                APanel.repaint();
                                AlgorithmText.requestFocus();
                                AlgorithmText.selectAll();
				
			}

		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
                            A.clear();
                        }
		});

		head.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				if (headText.getText().equals(""))
					return;

				int key = Integer.parseInt(headText.getText());
                                A.setHead(key);
                                APanel.setVariable(key);
                                APanel.repaint();
                                headText.requestFocus();
                                headText.selectAll();
			}

		});

		headText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				insert.doClick();
			}

		});

	}

	private void setScrollPane() {
		APanel.setPreferredSize(new Dimension(200, 5000));

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(APanel);
		scroll.setPreferredSize(new Dimension(750, 500));
                scroll.getViewport().setViewPosition(new Point(4500, 0));
		add(scroll, BorderLayout.CENTER);
	}

}
