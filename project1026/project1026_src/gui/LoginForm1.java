package gui;
import java.awt.*;//��ȣ���� ������ ���� ���

class LoginForm1 extends Frame{//LoginForm�� �������
	//has a����� ��������� ��ü���϶��� �ǹ��Ѵ�
	Label la_id ;
	Label la_pass ;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_regist;
	Panel p_center;//���Ϳ� �׸��带 ������ �г�
	Panel p_south;//���ʿ� ���� �г� (���⿡ ��ư �ΰ�)

	public LoginForm1(){//������ LoginForm Ȱ��
		
		//�޸� �ʱ�ȭ
		//Ư�� ��ǰ�� �� ��ü�� �¾�� �Բ� �¾�� �ϹǷ�,
		//�������� Ÿ�̹��� ��ġ�� ����
		la_id = new Label("ID");
		la_pass = new Label("Password");
		t_id = new TextField(15);
		t_pass = new TextField(15);
		bt_login = new Button("Login");
		bt_regist = new Button("Regist");
		p_center = new Panel();
		p_south = new Panel();

		//������ �� �����̰�, ���� �����̳� ��Ÿ���� �ο����� ����
		//����
		/*Frame�� �����ڰ� ���̾ƿ��� �������� ������ ����Ʈ�� BorderLayout�̴�
		this.setLayout(new BorderLayout());//==frame.setLayout ������ �ڽ��� frame�̹Ƿ� XX, 
		�׸��� ����Ʈ�� BorderLayout�̹Ƿ� new���� �ʿ䰡 ����*/
		
		p_center.setBackground(new Color(153,255,0));//Color�� c�� ���� 
		//���� �г��� �������� BorderLayout���Ϳ� ����
		this.add(p_center,BorderLayout.CENTER);//BorderLayout.CENTER ���� ����

		//����� �������� �ο��� �������̴�. final�� ���̻� ������ �� ������,
		//static���� �ν��Ͻ��� ������ �����ϸ�, public���� �����Ͽ�, 
		//��簴ü�� ������ �� �ֵ��� ������ Ǯ����
		p_south.setBackground(Color.YELLOW);//rgb���� �ΰ��� �˱� ���� ������ ����غ���
		this.add(p_south, BorderLayout.SOUTH);

		//p_center�׸��� ����
		p_center.setLayout(new GridLayout(2,2));//2�� 2��
		p_center.add(la_id);//�󺧺���
		p_center.add(t_id);//id�ؽ�Ʈ�ڽ� ����
		p_center.add(la_pass);//�� ����
		p_center.add(t_pass);//pass�ؽ�Ʈ�ڽ� ����

		//panel�� �ƹ��� ��ġ�����ڸ� �������� ������ ����Ʈ�� FlowLayout�̴�
		p_south.add(bt_login);
		p_south.add(bt_regist);


		//this�� ��Ȯ�� �ǹ� : ���۷��� ����
		//�� �� �ڽ��� �ּҰ��� ����
		//�ش� �ν��Ͻ��� �ڱ� �ڱ� �ڽ��� ����ų��
		setSize(400,150);//������.setSize = frame.setSeize = this.setSize = setSize
		setVisible(true);
	}
	
	public static void main(String[] args){
		new LoginForm1();
	}
}
