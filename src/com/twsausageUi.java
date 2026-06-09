package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;

import java.net.URL;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class twsausageUi extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sausage;
	private JTextField rice_sausage;
	private JTextField tw_hotdog;
	private JTextField tw_oden;
	private JTextField drink;
	private JTextField name;
	
	private javax.swing.JLabel Lab_win;
	
	
	private String winmsg;	
	public twsausageUi ParentUI = this;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					twsausageUi frame = new twsausageUi();
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
	public twsausageUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 584, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("炭     烤     香     腸");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel.setBounds(50, 10, 197, 33);
		panel.add(lblNewLabel);
		
		JLabel clockLabel = new JLabel("0000-00-00 00:00:00");
		clockLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		clockLabel.setBounds(278, 23, 146, 15);
		panel.add(clockLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 57, 203, 367);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("古早味烤腸 $45:");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 66, 112, 23);
		panel_1.add(lblNewLabel_1);
		
		sausage = new JTextField();
		sausage.setBounds(52, 88, 96, 20);
		panel_1.add(sausage);
		sausage.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("花生糯米腸 $40:");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 109, 112, 23);
		panel_1.add(lblNewLabel_2);
		
		rice_sausage = new JTextField();
		rice_sausage.setBounds(52, 130, 96, 21);
		panel_1.add(rice_sausage);
		rice_sausage.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("大腸包小腸 $75:");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 155, 102, 23);
		panel_1.add(lblNewLabel_3);
		
		tw_hotdog = new JTextField();
		tw_hotdog.setBounds(52, 177, 96, 21);
		panel_1.add(tw_hotdog);
		tw_hotdog.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("綜合甜不辣 $30:");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 202, 112, 23);
		panel_1.add(lblNewLabel_4);
		
		tw_oden = new JTextField();
		tw_oden.setBounds(52, 224, 96, 23);
		panel_1.add(tw_oden);
		tw_oden.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("飲料 $25:");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 253, 96, 21);
		panel_1.add(lblNewLabel_5);
		
		drink = new JTextField();
		drink.setBounds(52, 275, 96, 21);
		panel_1.add(drink);
		drink.setColumns(10);
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(207, 57, 297, 367);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		

		
		JTextArea show = new JTextArea();
		show.setBounds(0, 118, 297, 247);
		panel_2.add(show);
		
		JRadioButton r1 = new JRadioButton("熟客 9折");
		buttonGroup.add(r1);
		r1.setBounds(0, 55, 87, 23);
		panel_2.add(r1);
		
		JRadioButton r2 = new JRadioButton("優惠卷 8折");
		buttonGroup.add(r2);
		r2.setBounds(106, 55, 87, 23);
		panel_2.add(r2);
		
		JRadioButton r3 = new JRadioButton("VIP卡 7折");
		buttonGroup.add(r3);
		r3.setBounds(209, 55, 88, 23);
		panel_2.add(r3);
		
		Lab_win = new JLabel("");
		Lab_win.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		Lab_win.setBounds(10, 306, 183, 23);
		panel_1.add(Lab_win);
		//*****************event*************************
		//菜單欄位增減數目
		JButton btn1_1 = new JButton("-");		
		btn1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				sausage.setText((new twsausage()).decnum(sausage.getText()));				
			}
		});
		btn1_1.setBounds(10, 88, 45, 20);
		panel_1.add(btn1_1);
		
		JButton btn1_2 = new JButton("+");
		btn1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sausage.setText((new twsausage()).addnum(sausage.getText()));
			}
		});
		btn1_2.setBounds(148, 88, 45, 20);
		panel_1.add(btn1_2);
		
		JButton btn2_1 = new JButton("-");
		btn2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rice_sausage.setText((new twsausage()).decnum(rice_sausage.getText()));
			}
		});
		btn2_1.setBounds(10, 130, 45, 20);
		panel_1.add(btn2_1);
		
		JButton btn2_2 = new JButton("+");
		btn2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rice_sausage.setText((new twsausage()).addnum(rice_sausage.getText()));
			}
		});
		btn2_2.setBounds(148, 129, 45, 20);
		panel_1.add(btn2_2);
		
		JButton btn3_1 = new JButton("-");
		btn3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tw_hotdog.setText((new twsausage()).decnum(tw_hotdog.getText()));
			}
		});
		btn3_1.setBounds(10, 176, 45, 23);
		panel_1.add(btn3_1);
		
		JButton btn3_2 = new JButton("+");
		btn3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tw_hotdog.setText((new twsausage()).addnum(tw_hotdog.getText()));
			}
		});
		btn3_2.setBounds(148, 176, 45, 23);
		panel_1.add(btn3_2);
		
		JButton btn_4_1 = new JButton("-");
		btn_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tw_oden.setText((new twsausage()).decnum(tw_oden.getText()));
			}
		});
		btn_4_1.setBounds(10, 224, 45, 23);
		panel_1.add(btn_4_1);
		
		JButton btn4_2 = new JButton("+");
		btn4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tw_oden.setText((new twsausage()).addnum(tw_oden.getText()));
			}
		});
		btn4_2.setBounds(148, 224, 45, 23);
		panel_1.add(btn4_2);
		
		JButton btn5_1 = new JButton("-");
		btn5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drink.setText((new twsausage()).decnum(drink.getText()));
			}
		});
		btn5_1.setBounds(10, 274, 45, 23);
		panel_1.add(btn5_1);
		
		JButton btn5_2 = new JButton("+");
		btn5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drink.setText((new twsausage()).addnum(drink.getText()));
			}
		});
		btn5_2.setBounds(148, 274, 45, 23);
		panel_1.add(btn5_2);

		//計時器
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		clockLabel.setText(sdf.format(new Date()));	
		//建立Time，每1000毫秒(1秒)執行一次
		Timer timer = new Timer(1000,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				clockLabel.setText(sdf.format(new Date()));
			}
		});
		timer.start();
		//清空
		JButton btnNewButton = new JButton("清空");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
				sausage.setText("");
				rice_sausage.setText("");
				tw_hotdog.setText("");
				tw_oden.setText("");
				drink.setText("");
				show.setText("");
				Lab_win.setText("");
				buttonGroup.clearSelection();
				winmsg = "";
			}
		});
		btnNewButton.setBounds(10, 334, 183, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("顧客姓名:");
		lblNewLabel_6.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 10, 96, 20);
		panel_1.add(lblNewLabel_6);
		
		name = new JTextField();
		name.setBounds(10, 35, 183, 21);
		panel_1.add(name);
		name.setColumns(10);
		//玩打飛機
		JButton playShooterButton_5 = new JButton("");
		URL btnUrl =getClass().getResource("img/player.png");
		if(btnUrl != null) {
			ImageIcon btnIcon = new ImageIcon(btnUrl);
			playShooterButton_5.setIcon(btnIcon);
		}else {
			playShooterButton_5.setText("打飛機");
		}
		playShooterButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SpaceShooter Form = new SpaceShooter();
				Form.setVisible(true);
			}
		});
		playShooterButton_5.setBounds(439, 10, 46, 33);
		panel.add(playShooterButton_5);
		

		//玩遊戲
		JButton btnNewButton_1 = new JButton("玩  十  八  辣");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (sausage.getText() == null || !sausage.getText().matches("\\d+")) {
			        // 不是數字的情況
			        JOptionPane.showMessageDialog(null,"有購買香腸才能玩!","錯誤!",JOptionPane.ERROR_MESSAGE);
					//System.out.println("不合法的數字！");			       
			    } else {				
					sippatlahUi subForm = new sippatlahUi(sausage.getText(),ParentUI);
		            subForm.setVisible(true);			    
			    }

			}
		});
		btnNewButton_1.setBackground(new Color(255, 128, 128));
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		btnNewButton_1.setBounds(0, 0, 297, 49);
		panel_2.add(btnNewButton_1);
		//結算
		JButton btnNewButton_2 = new JButton("結算");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name = name.getText();
				String Sausage = sausage.getText();
				String Rice_sausage = rice_sausage.getText();
				String Tw_hotdog= tw_hotdog.getText();
				String Tw_oden= tw_oden.getText();
				String Drink= drink.getText();
				String Winmsg= winmsg;				
				String time="\n現在時間:"+ sdf.format(new Date());
				double discount =1.0;
				if(r1.isSelected()) discount =0.9;
				if(r2.isSelected()) discount =0.8;
				if(r3.isSelected()) discount =0.7;
				if(name.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"請輸入顧客姓名!!","警告!",JOptionPane.WARNING_MESSAGE);
				}
				else
				{					
					twsausage ts =new twsausage(Name,Sausage,Rice_sausage,Tw_hotdog,Tw_oden,Drink,Winmsg,time,discount);
					String txt = ts.menu();	
					show.setText(txt);
				}
				
				
			}
		});
		btnNewButton_2.setBounds(-1, 85, 87, 23);
		panel_2.add(btnNewButton_2);
		//列印
		JButton btnNewButton_3 = new JButton("列印");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					show.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(106, 85, 87, 23);
		panel_2.add(btnNewButton_3);
		//結束
		JButton btnNewButton_4 = new JButton("結束");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(209, 85, 87, 23);
		panel_2.add(btnNewButton_4);
	}
	//用來控制會到子視窗要做的事
	public void updateFormChild(String result) {
		
		winmsg= "贈送炭烤香腸"+ result + "根!!";
		//System.out.println("收到子視窗傳回來的值: " + result);		
		Lab_win.setText("贈送炭烤香腸!");
		Lab_win.revalidate();
		Lab_win.repaint();
	}
}
