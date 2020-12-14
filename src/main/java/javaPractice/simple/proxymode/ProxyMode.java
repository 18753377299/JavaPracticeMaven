package javaPractice.simple.proxymode;

import com.common.po.Gps;

/**
 * @功能：代理设计模式，使用了多态
 * @author liqiankun	
 * @param            
 * @throws
 * @日期 2019年7月3日
 * @时间 下午3:57:49
 */
public class ProxyMode {
	public static void main(String[] args) {
		Gps gps = new Gps(36,118);
		System.out.println(gps);
		
		int aa =  Math.floorDiv(4, 2);

		Integer a = 1;
		int b= (int)a;
		Integer c = (Integer)b;
		
		NetWork netWork = null;
		netWork = new Proxy(new Real());
		netWork.browse();
	}
}

interface NetWork{
	void browse();
}

class Real implements NetWork{
	@Override
	public void browse() {
		System.out.println("上网浏览信息");
	}
}

class Proxy implements NetWork{
	private NetWork netWork;
	
	public Proxy(NetWork netWork) {
		super();
		this.netWork = netWork;
	}
	public void check() {
		System.out.println("检验用户是否合法上网");
	}
	@Override
	public void browse() {
		this.check();
		this.netWork.browse();
	}
	
}
