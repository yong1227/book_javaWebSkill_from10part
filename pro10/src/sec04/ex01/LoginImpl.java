package sec04.ex01;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener
// 세션에 바인딩 시 이벤트를 처리합니다.
public class LoginImpl implements HttpSessionBindingListener {

	String user_id;
	String user_pw;
	
	// 세션에 바인딩 시 1씩 증가시킵니다.
	static int total_user = 0;
	
    /**
     * Default constructor. 
     */
    public LoginImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    // 세션에 저장 시 접속자수를 증가시킵니다.
    public void valueBound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("사용자 접속");
		++total_user;
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    // 세션에서 소멸 시 접속자 수를 감소시킵니다.
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("사용자 접속 해제");
		total_user--;
    }
	
}
