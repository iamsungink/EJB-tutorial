package namingRegisteer;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BindTest {
	
	public static void main(String[] args) {
		try {
			//웹로직 서버의 정보를 Properties객체에 포함
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			prop.put(Context.PROVIDER_URL, "t3://localhost:7001"); //웹로직은  t3프로토콜을 사용한다.
			
			
			Context ctx = new InitialContext(prop);
			// JNDI API를 이용하면 네미밍 서버에 등록하게 된다.
			ctx.bind("test", "테스트");
			System.out.println("네이밍 서버에 등록!!!");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
