package kr.library.core.listener;

import java.io.File;

import org.apache.catalina.Host;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import kr.library.core.util.GetPropertyUtils;

/**
 * ==========================================================
 * @package_name				:	kr.library.core.listener
 * @file_name					:	AppListener.java
 * @author						:	haneul
 * @date						:	2021.05.20
 * ==========================================================
 * 
 * HISTORY
 * ==========================================================
 * DATE			AUTHOR			MEMO
 * ==========================================================
 * 2021.05.20		haneul		init
 *
 *
 */
@Component
public class AppListener implements ApplicationListener<ServletWebServerInitializedEvent> {
	
    /**
     * docbase 설정 
     */
    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
    	
    	String docbase = GetPropertyUtils.getProperty("tomcat.docbase.dir");
    	String hostName = GetPropertyUtils.getProperty("tomcat.host.name");
    	
    	// upload 경로 생성
    	File directory = new File(docbase);
    	if( !directory.exists()) {
    		directory.mkdirs();
    	}
    	
        ServletWebServerApplicationContext applicationContext = event.getApplicationContext();
        
        TomcatWebServer tomcatWebServer = (TomcatWebServer) applicationContext.getWebServer();
        Tomcat tomcat = tomcatWebServer.getTomcat();
        Host host = tomcat.getHost(); 
        host.setName(hostName);
        
        tomcat.addWebapp(host, "/upload", docbase);
    }
}