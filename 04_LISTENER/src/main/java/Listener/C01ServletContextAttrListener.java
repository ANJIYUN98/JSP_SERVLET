package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

//@WebListener의 적용은 web.wml에서 확인
public class C01ServletContextAttrListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("C01ServletContextAttrListener's attributeAdded invoke..");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("C01ServletContextAttrListener's attributeRemoved invoke..");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("C01ServletContextAttrListener's attributeReplaced invoke..");
	}

	
}
