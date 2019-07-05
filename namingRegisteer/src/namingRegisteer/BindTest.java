package namingRegisteer;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BindTest {
	
	public static void main(String[] args) {
		try {
			//������ ������ ������ Properties��ü�� ����
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			prop.put(Context.PROVIDER_URL, "t3://localhost:7001"); //��������  t3���������� ����Ѵ�.
			
			
			Context ctx = new InitialContext(prop);
			// JNDI API�� �̿��ϸ� �׹̹� ������ ����ϰ� �ȴ�.
			ctx.bind("test", "�׽�Ʈ");
			System.out.println("���̹� ������ ���!!!");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
