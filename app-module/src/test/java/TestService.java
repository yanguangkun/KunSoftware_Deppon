import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.deppon.app.module.user.shared.domain.SynUserRequest;
import com.deppon.app.module.user.shared.ws.ISynUserService;


public class TestService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JaxWsProxyFactoryBean factory1 = new JaxWsProxyFactoryBean(); 
		factory1.setServiceClass(ISynUserService.class);  
		factory1.setAddress("http://127.0.0.1:8080/app/ws/synUserService");  
		ISynUserService u = (ISynUserService) factory1.create();  
		
		SynUserRequest name = new SynUserRequest();
		name.setName("hello");
		String str = u.getName(name);  

		System.out.println(str);
	}

}
