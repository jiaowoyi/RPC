package socketrpc.server;

import socketrpc.IHello;
import socketrpc.server.XPathDemo;

public class HelloServiceImpl implements IHello {

    @Override
    public String sayHello(String string) {
        return "你好:".concat ( string );
        
    }

	@Override
	public String FindFlight(String string) {
		// TODO Auto-generated method stub
		String st = new String() ;
		try {
			XPathDemo.init();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			st = XPathDemo.getAttrEles(string);
		}catch(Exception e){
			e.printStackTrace();
		}
		return st;
	}
}
