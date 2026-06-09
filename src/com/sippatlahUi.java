package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;


public class sippatlahUi extends JFrame {
	private int receivedData; // 用來儲存傳過來的資料
	private static final long serialVersionUID = 1L;
	private JPanel sippbox;
	private String result ="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sippatlahUi frame = new sippatlahUi("0",new twsausageUi() );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sippatlahUi(String data,twsausageUi parent) {
		this.receivedData =Integer.parseInt(data);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 300);
		sippbox = new JPanel();
		sippbox.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(sippbox);
		sippbox.setLayout(null);
		
		ImageIcon img1 = new ImageIcon(getClass().getResource("img/01.png"));
		java.awt.Image t1 = img1.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
		ImageIcon i1 = new ImageIcon(t1);
		
		ImageIcon img2 = new ImageIcon(getClass().getResource("img/02.png"));
		java.awt.Image t2 = img2.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
		ImageIcon i2 = new ImageIcon(t2);
		
		ImageIcon img3 = new ImageIcon(getClass().getResource("img/03.png"));
		java.awt.Image t3 = img3.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(t3);
		
		ImageIcon img4 = new ImageIcon(getClass().getResource("img/04.png"));
		java.awt.Image t4 = img4.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
		ImageIcon i4 = new ImageIcon(t4);
		
		ImageIcon img5 = new ImageIcon(getClass().getResource("img/05.png"));
		java.awt.Image t5 = img5.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
		ImageIcon i5 = new ImageIcon(t5);
		
		ImageIcon img6 = new ImageIcon(getClass().getResource("img/06.png"));
		java.awt.Image t6 = img6.getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH);
		ImageIcon i6 = new ImageIcon(t6);
		
		JLabel c1 = new JLabel(i6);
		c1.setOpaque(true); 
		c1.setForeground(new Color(0, 0, 0));
		c1.setBackground(new Color(255, 255, 255));
		c1.setHorizontalAlignment(SwingConstants.CENTER);
		//c1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		c1.setBounds(10, 31, 40, 40);
		sippbox.add(c1);
		
		JLabel lblNewLabel_1 = new JLabel("顧客骰子數:");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 10, 87, 23);
		sippbox.add(lblNewLabel_1);
		
		JLabel c2 = new JLabel(i6);
		c2.setOpaque(true);
		c2.setBackground(new Color(255, 255, 255));
		c2.setFont(new Font("微軟正黑體", Font.BOLD, 20));		
		c2.setHorizontalAlignment(SwingConstants.CENTER);
		c2.setBounds(96, 31, 40, 40);
		sippbox.add(c2);
		
		JLabel c3 = new JLabel(i6);
		c3.setOpaque(true);
		c3.setBackground(new Color(255, 255, 255));
		c3.setHorizontalAlignment(SwingConstants.CENTER);
		c3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		c3.setBounds(184, 31, 40, 40);
		sippbox.add(c3);
		
		JLabel c4 = new JLabel(i6);
		c4.setOpaque(true);
		c4.setBackground(new Color(255, 255, 255));
		c4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		c4.setHorizontalAlignment(SwingConstants.CENTER);
		c4.setBounds(275, 31, 40, 40);
		sippbox.add(c4);
		
		JLabel lblNewLabel = new JLabel("老闆骰子數:");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 112, 104, 23);
		sippbox.add(lblNewLabel);
		
		JLabel b1 = new JLabel(i6);
		b1.setOpaque(true);
		b1.setBackground(new Color(255, 255, 255));
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		b1.setBounds(10, 136, 40, 40);
		sippbox.add(b1);
		
		JLabel b2 = new JLabel(i6);
		b2.setOpaque(true);
		b2.setBackground(new Color(255, 255, 255));
		b2.setHorizontalAlignment(SwingConstants.CENTER);
		b2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		b2.setBounds(96, 136, 40, 40);
		sippbox.add(b2);
		
		JLabel b3 = new JLabel(i6);
		b3.setOpaque(true);
		b3.setBackground(new Color(255, 255, 255));
		b3.setHorizontalAlignment(SwingConstants.CENTER);
		b3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		b3.setBounds(184, 136, 40, 40);
		sippbox.add(b3);
		
		JLabel b4 = new JLabel(i6);
		b4.setOpaque(true);
		b4.setBackground(new Color(255, 255, 255));
		b4.setHorizontalAlignment(SwingConstants.CENTER);
		b4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		b4.setBounds(269, 136, 40, 40);
		sippbox.add(b4);
		
		JLabel CusMsg = new JLabel("");
		CusMsg.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		CusMsg.setBounds(10, 81, 126, 27);
		sippbox.add(CusMsg);
		
		JLabel BoosMsg = new JLabel("");
		BoosMsg.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		BoosMsg.setBounds(10, 186, 127, 28);
		sippbox.add(BoosMsg);
		//**********************event******************
		//賭博		
		
		JButton btnNewButton = new JButton("十八辣");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
					si̍ppatlah sip = new si̍ppatlah(receivedData);
					//c1.setText(String.valueOf(sip.Cnumbers()[0]));
					c1.setIcon(icom(String.valueOf(sip.Cnumbers()[0])));					
					//c1.repaint();
					//c2.setText(String.valueOf(sip.Cnumbers()[1]));
					c2.setIcon(icom(String.valueOf(sip.Cnumbers()[1])));
					c2.repaint();
					//c3.setText(String.valueOf(sip.Cnumbers()[2]));
					c3.setIcon(icom(String.valueOf(sip.Cnumbers()[2])));
					c3.repaint();
					//c4.setText(String.valueOf(sip.Cnumbers()[3]));
					c4.setIcon(icom(String.valueOf(sip.Cnumbers()[3])));
					c4.repaint();
					//b1.setText(String.valueOf(sip.Bnumbers()[0]));
					b1.setIcon(icom(String.valueOf(sip.Bnumbers()[0])));
					b1.repaint();
					//b2.setText(String.valueOf(sip.Bnumbers()[1]));
					b2.setIcon(icom(String.valueOf(sip.Bnumbers()[1])));
					b2.repaint();
					//b3.setText(String.valueOf(sip.Bnumbers()[2]));
					b3.setIcon(icom(String.valueOf(sip.Bnumbers()[2])));
					b3.repaint();
					//b4.setText(String.valueOf(sip.Bnumbers()[3]));
					b4.setIcon(icom(String.valueOf(sip.Bnumbers()[3])));
					b4.repaint();
					CusMsg.setText(sip.CnumMsg);
					BoosMsg.setText(sip.BnumMsg);
					if(sip.Cnum> sip.Bnum)
					{
						JOptionPane.showMessageDialog(null,sip.result(),"恭喜!",JOptionPane.INFORMATION_MESSAGE);
						parent.updateFormChild(String.valueOf(receivedData));//回傳贈送的香腸						
						sippatlahUi.this.dispose();
					}
					else if(sip.Cnum== sip.Bnum)
					{
						JOptionPane.showMessageDialog(null,sip.result(),"平手!",JOptionPane.INFORMATION_MESSAGE);
						parent.updateFormChild(String.valueOf(1));//回傳贈送的香腸						
						sippatlahUi.this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,sip.result(),"抱歉!",JOptionPane.ERROR_MESSAGE);	
					}
					
					//show.setText(sip.show());
					result = sip.result();
			}
			
			javax.swing.ImageIcon icom(String num)
			{				
				//ImageIcon re= new ImageIcon();
				//System.out.println(num);
				if("1".equals(num))
				{
					return i1;
				}
				else if("2".equals(num))
				{
					return i2;
				}
				else if("3".equals(num))
				{
					return i3;
				}
				else if("4".equals(num))
				{
					return i4;
				}
				else if("5".equals(num))
				{
					return i5;
				}
				else if("6".equals(num))
				{
					return i6;
				}
				return null;
			}
			
			
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 16));
		btnNewButton.setBounds(10, 228, 317, 23);
		sippbox.add(btnNewButton);
		

		// 設定關閉時僅隱藏/銷毀此視窗，避免整個應用程式結束
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //===================新增:視窗關閉事件監聽===============
        
        this.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		//當使用者點擊右上角的[x]時，會觸發
        		if(parent != null)
        		{
					if(result.contains("勝利"))
					{
					  parent.updateFormChild(String.valueOf(receivedData));
					} 
        		}
        	}
        	@Override
        	public void windowClosed(WindowEvent e)
        	{
        		//當視窗成功被 DISPOSE 後，會觸發這個方法
        	}
        });	
        
        //==================================================
        
	}
}
