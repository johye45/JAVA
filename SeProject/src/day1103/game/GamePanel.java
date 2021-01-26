package day1103.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.BranchElement;

import common.image.ImageUtil;

//��ǻ� ��� ������ �׷��� ó���� �г��� ����ϰ� ��
public class GamePanel extends JPanel{
	Thread loopThread;//���� ������ ���� ������ ������ ������
	public static final int WIDTH=1600;
	public static final int HEIGHT=900;
	Hero hero;
	//Bullet bullet;
	
	//�ٷ��� �ټ��� �Ѿ��� ������� �÷��� �����ӿ� �� List�� �̿��غ���
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	ArrayList<Block> blockList = new ArrayList<Block>();

	GameBg[] gameBg = new GameBg[2];
	boolean flag = false;//���ʿ��� �����־�� �ϹǷ�
	boolean over = false;
	int score=0;//���� 
	ArrayList<Hp> hpList = new ArrayList<Hp>();
	

	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH ,HEIGHT));
		createBg();//������
		createHero();//���ΰ� ����
		createEnemy();
		createBlock();
		createHP();
		loopThread = new Thread() {
			public void run() {
				while(true) {
					if(flag)gameLoop();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
			}
		};
		loopThread.start();
	}
	
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;//2D�� �� ������ �׷��Ƚ� ��ü�� ����ȯ!!
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH, HEIGHT);//�г��� ũ�⸸ŭ �簢���� ä������(ȭ���� ������ �۴� ȿ��)
		
		render(g2);
	}
	
	//�̹����� ������ ��� 1 ) Toolkit
	//2)Ŭ���� �н�,Ŭ�����δ�.getResources()
	public void createHero() {
		Image img =ImageUtil.getIcon(this.getClass(),"res/game/plane.png", 100,100).getImage();
		hero = new Hero(this,img,200,200,50,50,0,0);
	}
	
	public void createBlock() {
		for(int i=0;i<20;i++) {
			Image img=ImageUtil.getIcon(this.getClass(), "res/game/brick.png", 60, 60).getImage();
			Block block = new Block(img, 300+(i*60), 600, 60, 60, 0, 0);
			blockList.add(block); //�� ��Ͽ� �߰�!!
		}
	}
	
	//���� ������κ��� � ����Ű�� ���ȴ����� ���޹���!
	public void movekey(int key) {
		switch(key) {
		case KeyEvent.VK_LEFT:hero.velX=-5;break;//Ű���� 37���� ȭ��ǥ
		case KeyEvent.VK_RIGHT:hero.velX=5;break;//Ű���� ���� ȭ��ǥ
		case KeyEvent.VK_UP:hero.velY=-5;break;//Ű���� ���� ȭ��ǥ
		case KeyEvent.VK_DOWN:hero.velY=5;break;//Ű���� �Ʒ��� ȭ��ǥ
		case KeyEvent.VK_SPACE:fire();break;
		}
		
	}
		
	//���� ������κ��� � ����Ű�� ���ȴ����� ���޹���!
	public void stopkey(int key) {
		switch(key) {
		case KeyEvent.VK_LEFT:hero.velX=0;break;//Ű���� 37���� ȭ��ǥ
		case KeyEvent.VK_RIGHT:hero.velX=0;break;//Ű���� ���� ȭ��ǥ
		case KeyEvent.VK_UP:hero.velY=0;break;//Ű���� ���� ȭ��ǥ
		case KeyEvent.VK_DOWN:hero.velY=0;break;//Ű���� �Ʒ��� ȭ��ǥ
		
		}
		
	}
			
	
	//�Ѿ� �߻�
	public void fire() {
		Image img = ImageUtil.getIcon(this.getClass(), "res/game/ball.png", 40, 40).getImage();
		Bullet bullet = new Bullet(this,img,(hero.x+hero.width),(hero.y+(hero.height/2)), 20,20,10,0);
		
		//������ �Ѿ��� bulletList�� ����
		bulletList.add(bullet);
	}
		
	
	//����̹��� ����
	public void createBg() {
		Image img = ImageUtil.getIcon(this.getClass(),"res/game/bg.png", WIDTH, HEIGHT).getImage();
		//������ �̹����� ��水ü 2���� ��������
		gameBg[0] = new GameBg(img,0,0,WIDTH,HEIGHT,-1,0);
		gameBg[1] = new GameBg(img,WIDTH,0,WIDTH,HEIGHT,-1,0);
	}
	
	public void createEnemy() {
		String[] path= {"e1.png","e2.png","e3.png","e4.png","e5.png"};
		
		for(int i=0;i<20;i++) {
			double r = Math.random();
			int n =(int)(r*path.length);
//		System.out.println(n);
			Image img=ImageUtil.getIcon(this.getClass(), "res/game/"+path[n], 80, 60).getImage();
			Enemy enemy = new Enemy(img, WIDTH-50, 50+(80*i), 80, 60, -2, 0);
			enemyList.add(enemy); //���� ��Ͽ� �߰�!!
		}
		
	}
	
	//hp����
	public void createHP() {
		Image img=ImageUtil.getIcon(this.getClass(), "res/game/heart.png", 50, 50).getImage();
		for(int i=0;i<4;i++) {
			Hp hp = new Hp(img, 50+(51*i),100,50,50,0,0);
			hpList.add(hp);
		}
	}
	
	//������ ��Ȳ ���� ���, �Ѿ� �� ����
	public void printData(Graphics2D g2) {
		
		g2.setFont(new Font("Verdana",Font.BOLD,20));
		g2.setColor(Color.white);

		StringBuffer sb = new StringBuffer();
		sb.append("Bullet Cont : "+ bulletList.size());
		sb.append("EnemyCount : "+enemyList.size());
		sb.append("Score:"+score);
		
		
		g2.drawString(sb.toString(), 100, 50);
		
	
		if(over)showGameOver(g2);
	
	}
	
	public void showGameOver(Graphics2D g2) {
		g2.setFont(new Font("Verdana",Font.BOLD,200));
		g2.setColor(Color.white);


		StringBuffer sb = new StringBuffer();
		sb.append("Game Over");
		g2.drawString(sb.toString() , 50, 400);	
	
	}
	
	
	//������ ��ȭ
	public void tick() {
		hero.tick();
		for(int i=0; i<bulletList.size();i++) {
			Bullet bullet = bulletList.get(i);
			bullet.tick();						
		}
		
		//������ ���� 
		for(int i = 0; i<enemyList.size();i++) {
			Enemy enemy = enemyList.get(i);
			enemy.tick();
		}
		//���� ���� 
		for(int i = 0; i<blockList.size();i++) {
			Block block = blockList.get(i);
			block.tick();
		}
		
		//��濡 ���� 
		for(int i=0;i<gameBg.length;i++) {
			gameBg[i].tick();
		}
		
		//hp�� ����
		for(int i=0;i<hpList.size();i++) {
			Hp hp = hpList.get(i);
				hp.tick();
		}
		
	}
	public void render(Graphics2D g2) {
		//��浵 �׸���
//		g2.drawImage(bgimg, 0, 0, this);
		
		//��濡 ���� 
		for(int i=0;i<gameBg.length;i++) {
			gameBg[i].render(g2);
		}

		hero.render(g2);
		
		//�Ѿ˿� ����
		for(int i=0; i<bulletList.size();i++) {
			Bullet bullet = bulletList.get(i);
			bullet.render(g2);			
		}
		
		//������ ���� 
		for(int i = 0; i<enemyList.size();i++) {
			Enemy enemy = enemyList.get(i);
			enemy.render(g2);
		}
		//���� ���� 
			for(int i = 0; i<blockList.size();i++) {
				Block block = blockList.get(i);
				block.render(g2);
			}
			
		//hp�� ����
		for(int i=0;i<hpList.size();i++) {
			Hp hp = hpList.get(i);
				hp.render(g2);
		}
		printData(g2);
	}
	
	
	//��� ������ tick() render()ȣ�� �� ���� ����
	public void gameLoop() {
		tick();
		this.repaint();
		
//		System.out.println("gameLoop....");
	}
}
