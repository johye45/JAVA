package event;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

/*윈도우 창을 대상으로 발생할 수 있는 이벤트를
감지하는 리스너 구현하기*/
public class MyWindowListener implements WindowListener{

	public void windowActivated(WindowEvent e){
		System.out.println("windowActivated...");
		//현재 창을 활성화 시킬때 (즉, 커서가 현재 창에 올라와 사용중일때)
	}
	public void windowClosed(WindowEvent e){
		System.out.println("windowClosed...");
		//창이 닫히면
	}
	public void windowClosing(WindowEvent e){
		System.out.println("windowClosing...");
		//닫기 버튼 누를때(창이 닫히지는 않음)
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("windowDeactivated...");
		//아이콘화에 반대 
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println("windowDeiconified...");
		
	}
	public void windowIconified(WindowEvent e){
		System.out.println("windowIconified...");
		//최소화 버튼을 눌러 아이콘화 시킬때
	}
	public void windowOpened(WindowEvent e){
		System.out.println("windowOpened...");
		//창이 뜰때
	}
}
