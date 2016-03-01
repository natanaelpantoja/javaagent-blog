package br.com.natanaelpantoja.instrumentation;

import org.avaje.agentloader.AgentLoader;
import org.junit.Test;

public class AgentTest {
	 
//	@Before
	public void before(){
		AgentLoader.loadAgent("/home/natanaelpantoja/dev/eclipse/workspace/javaagent-blog/target/javaagent-blog-0.0.1-SNAPSHOT.jar");
	}
	
    @Test
    public void deveriaInicializarOMetodoMain() throws InterruptedException {
    	String[] a = null;
    	new MainClass();
    		
    }
}
