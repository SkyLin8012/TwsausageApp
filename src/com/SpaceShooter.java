package com;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.border.EmptyBorder;

public class SpaceShooter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceShooter frame = new SpaceShooter();
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
	public SpaceShooter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("太空打飛機簡易版");
		setResizable(false); //不予許玩家拖拉縮放視窗
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//將遊戲畫布做出來
		GamePanel gamePanel = new GamePanel();
		
		//將之裝入contentPane 裡面
		contentPane.add(gamePanel);
		
		//外框自適應gamePanel大小
		pack();
		//遊戲居中
		setLocationRelativeTo(null); 
		
		// 設定關閉時僅隱藏/銷毀此視窗，避免整個應用程式結束
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}

class GamePanel extends JPanel implements ActionListener,KeyListener{
	private static final long serialVersionUID = 1L;
	/*
		extends JPanel 將類別變成面板
		implements ActionListener 使其繼承 接收時間觸發的能力
		implements KeyListener 使其具備監聽鍵盤的能力
	*/
	//定義遊戲畫面的長寬 需宣告為常數
	private static final int WIDTH=400;
	private static final int HEIGHT =800;

	private Timer time; //遊戲的心臟，用以更新畫面
	private boolean running = true; //true 代表遊玩中，false 代表結束
	private int score=0; //玩家目前的分數

	private Player player; //代表玩家的飛機
	private ArrayList<Bullet> bullets; //因為畫面有很多敵人與子彈
	private ArrayList<Enemy> enemies; //用ArrayList將之都裝起來

	private Image playerImg;
	private Image bulletImg;
	private Image enemyImg;
	
	private int shootCooldown = 0; //射擊冷卻時間，防止按住空白鍵子彈連城直縣
	private boolean leftPressed = false; //紀錄鍵盤狀態
	private boolean rightPressed = false; //如玩家按右鍵，rightPressed=true
	private boolean spacePressed = false;

	//建構子(遊戲世界誕生)
	public GamePanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT)); //把畫布設定為400X600
		setBackground(Color.BLACK); //背景塗黑
		setFocusable(true); //這兩行告訴電腦，請讓視窗專注接收鍵盤訊號
		addKeyListener(this);
		
		//載入圖片
		loadImages();

		player = new Player(WIDTH/2 -20, HEIGHT-70); 
		//飛機產生於於畫面底部中央附近
		bullets = new ArrayList<>(); //挖出兩個箱子用來裝產生的子彈與敵人
		enemies = new ArrayList<>();

		time = new Timer(16,this); //設定每16毫秒(60FPS)按鈕會發一次訊號由GamePanel接收
		time.start();//心臟開始跳動，遊戲運作
	}
	//匯入圖片
	private void loadImages() {
		try {
			URL playerUrl = getClass().getResource("img/player.png");
			URL bulletUrl = getClass().getResource("img/bullet.png");
			URL enemyUrl = getClass().getResource("img/enemy.png");
			//如果找不到圖片，會跳到catch防止遊戲崩潰
			if(playerUrl !=null) playerImg = new ImageIcon(playerUrl).getImage();
			if(bulletUrl !=null) bulletImg = new ImageIcon(bulletUrl).getImage();
			if(enemyUrl !=null) enemyImg = new ImageIcon(enemyUrl).getImage();
						
		}catch(Exception e) {
			System.out.println("圖片載入失敗");
		}
	}

	@Override
	protected void paintComponent(Graphics g){ //java內建的畫畫工具g就像一支筆
		super.paintComponent(g); //把舊畫面擦乾淨，不然飛機會留下殘影
		if(running){ //如果遊戲正進行中 running==true
			//劃一個實心舉行，位置在玩家的(x,y)大小事玩家的寬高，這就是飛機
			if(playerImg !=null) {
				g.drawImage(playerImg, (int)player.x, (int)player.y, player.width, player.height, this);
			}else {
				g.setColor(Color.GREEN); //把畫筆換成綠色
				g.fillRect((int)player.x, (int)player.y,player.width,player.height);
			}

			//畫飛彈	
			for(Bullet b: bullets){ 
			    //用一個for迴圈，打前箱子(bullets)裡面的每一顆子彈都各自於座標上畫出來
				if(bulletImg !=null)
				{
					g.drawImage(bulletImg, (int)b.x, (int)b.y, b.width, b.height, this);
				}else {
					g.setColor(Color.YELLOW); //把畫筆換成黃色
					g.fillRect((int)b.x,(int)b.y,b.width,b.height);
				}
			}
			//畫敵機
			
			for(Enemy e: enemies){
				if(enemyImg !=null)
				{
					g.drawImage(enemyImg, (int)e.x, (int)e.y, e.width, e.height, this);
				}else {
					g.setColor(Color.RED);
					g.fillRect((int)e.x, (int)e.y,e.width,e.height);	
				}

			}
			//計分UI
			//同理畫出紅色的敵機並用迴圈將箱子(enemies)內的每架都畫出來
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD,18));
			g.drawString("Score:"+score,10,25);
			//把畫筆換成白色，設定Arial粗體18級
			//drawString 在畫面左上角(10,25)位置劃出目前分數

		}else{
			//遊戲結束UI			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD,36));
			g.drawString("GAME OVER", WIDTH/2-100,HEIGHT/2-20);
			g.setFont(new Font("Arial", Font.BOLD,18));
			g.drawString("Final Score: "+ score, WIDTH/2-55,HEIGHT/2+20);
		   //else 如果遊戲結束，在畫面正中樣顯示白色GAME OVER 與最終分數
		}
	}

	//遊戲主迴圈(每16毫秒執行的邏輯)
	@Override
	public void actionPerformed(ActionEvent e){
		if(!running) return; //遊戲是否結束
		//玩家移動
		if(leftPressed && player.x >0)
		{
			player.x -= player.speed;
		}
		if(rightPressed && player.x < WIDTH-player.width){
			player.x += player.speed;
		}
		/* 若玩家按左鍵(leftPressed == true) 且飛機沒移出左邊界
		(player.x > 0),就把飛機的x座標減去移速(往左移)。右移同理
		 */
		//發射子彈
		if(shootCooldown > 0) shootCooldown--;
		if(spacePressed && shootCooldown==0){
			bullets.add(new Bullet(player.x+player.width/2-2,player.y));
			shootCooldown=12;
		}
		/*
		 每次回圈冷卻時間都換減1
		 當玩家按著空白鑑且冷卻時間規0，飛機在正中間上方(player.x+player.width/2-2)
		 新增一顆子彈放入箱中，把冷卻時間重設為12(約0.2秒射一發)
		 */
		//讓子彈往前飛
		for(int i=0; i<bullets.size();i++)
		{
			Bullet b = bullets.get(i);
			b.y-= b.speed;
			//用迴圈檢查每顆子彈，把子彈Y座標減少(螢幕中，向上移動減Y)
			if(b.y<0){
			//子彈飛出螢幕(b.y<0)，將子彈從箱子移除(bullets.remove(i))			
				bullets.remove(i);//釋放記憶體
				i--;
			}
		}
		//隨機產生敵人
		Random rand = new Random();
	    int minenemy =3;
		if(score!=0) {
			minenemy +=(score/100);
	    }
		if(rand.nextInt(100)<minenemy){
			int enemyX = rand.nextInt(WIDTH-30);
			enemies.add(new Enemy(enemyX,0));
		}
		//每次計時器響應，約有3%的機率(rand.nextInt(100)<3)在螢幕最上方(Y=0)
		//、X軸隨機的位置產生一個新敵人

		//敵人往下掉
		for(int i=0; i<enemies.size();i++)
		{
			Enemy enemy = enemies.get(i);
			enemy.y += enemy.speed;
			//讓所有的敵人Y座標增加(往下掉)。

			if(enemy.y> HEIGHT){
				running = false;
			}
			//當敵人跳出螢幕(enemy.y>HEIGHT)，running
			//變成false，遊戲結束
		}

		//碰撞偵測(子彈打中敵人)
		for(int i=0;i<bullets.size();i++)
		{
			Bullet b = bullets.get(i);
			Rectangle rBullet = new Rectangle((int)b.x,(int)b.y,b.width,b.height);

			for(int j=0;j<enemies.size(); j++)
			{
				Enemy enemy = enemies.get(j); //拿每一顆子彈去對比每一個敵人
				Rectangle rEnemy = new Rectangle((int)enemy.x, (int)enemy.y, enemy.width, enemy.height);
				//將子彈與敵人都虛擬包裝成一個四方型
				if(rBullet.intersects(rEnemy)){
					//java內建功能，幫你算這兩個四方形有沒有重疊
					bullets.remove(i);
					enemies.remove(j);
					//如果撞到，將子彈與敵人都從各自的箱子
					score+=10;
					//玩家分數加十分
					i--;
					break;
				}
			}
		}

		//碰撞偵測(敵人撞到玩家)
		Rectangle rPlayer = new Rectangle((int)player.x,(int)player.y,player.width,player.height);
		//把玩家包裝成四方形
		for(Enemy enemy: enemies){
			Rectangle rEnemy = new Rectangle((int)enemy.x, (int)enemy.y,enemy.width,enemy.height);
			if(rPlayer.intersects(rEnemy)){ //跟箱子內的每個敵人對比
				running=false;
				//敵人撞到玩家，遊戲結束
			}
		}
		repaint();
		//當上面的移動、碰撞、分數都算好後，呼叫repaint()，系統會強制執行
		//剛剛寫的paintComponent，把更新遊戲畫面
	}

	//鍵盤監聽(接收玩家輸入)
	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)leftPressed=true;
		if (key == KeyEvent.VK_RIGHT || key== KeyEvent.VK_D)rightPressed=true;
		if (key == KeyEvent.VK_SPACE) spacePressed = true;
		/*
		當按鍵被按下時；檢查按下去的是否為方向鑑或A鑑，是即leftPressed=true
		右方向鑑、D鑑、空白鑑依此類推
		*/
	}
	@Override
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)leftPressed= false;
		if (key == KeyEvent.VK_RIGHT || key== KeyEvent.VK_D)rightPressed=false;
		if (key == KeyEvent.VK_SPACE) spacePressed = false;
	}
	//當按鍵被放開時，把對應的標記變回false，飛機會立即停下來

	@Override
	public void keyTyped(KeyEvent e){} //必須補上實作KeyListener要求的方法
}

//==================================================
// 遊戲角色類別
//==================================================
class GameObject{
	double x, y;
	int width, height;
	double speed;
	public GameObject(double x, double y, int width, int height,double speed){
		this.x=x;
		this.y=y;
		this.width =width;
		this.height = height;
		Random rand = new Random();
		int num = rand.nextInt(4)+1;
		this.speed = speed+num;
	}
}

class Player extends GameObject{
	public Player(double x, double y){
		super(x,y,40,40,6.0);
		//飛機寬40、高30，移速6
	}
}

class Bullet extends GameObject{
	public Bullet(double x, double y){
		super(x,y,10,20,8.0);
		//子彈寬5、高10，移速8
	}
}

class Enemy extends GameObject{

	public Enemy(double x, double y){
		super(x,y,35,35,1);
		//敵人寬30、高30，下墜速3
	}
}


