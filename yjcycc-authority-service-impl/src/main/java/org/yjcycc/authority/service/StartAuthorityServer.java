package org.yjcycc.authority.service;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yjcycc.authority.service.zk.server.AuthorityServer;
import org.yjcycc.tools.zk.prop.SystemProperties;
import org.yjcycc.tools.zk.prop.ZkProperties;

public class StartAuthorityServer {

	private static Logger logger = Logger.getLogger(StartAuthorityServer.class);
	
	public static void main(String[] args) {
		if(args != null && args.length>0){
			String env = args[0];
			logger.info("Using enviroment:" + env);
			SystemProperties.setEnviroment(env);
		}else {
			logger.warn("no start up args. Using default enviroment: devp" );
			SystemProperties.setEnviroment("test");
		}

		ClassPathXmlApplicationContext ctx = null;
		try {
			logger.info("Lanch StartAuthorityServer...  classpath:/spring/spring-context.xml");
			ctx = new ClassPathXmlApplicationContext("classpath:/spring/spring-context.xml");
			ctx.start();

			AuthorityServer authorityServer = ctx.getBean(AuthorityServer.class);
			
			if(authorityServer.isRunning()){
				//不管是不是主节点  都需要往zookeeper 节点树声明一下自身：创建一个节点！
				boolean flag = authorityServer.createTreeNode();
				
				logger.info("创建节点, 结果：" + flag);
				if(flag == false){
					logger.error("StartAuthorityServer 创建ZK节点失败，请检查配置。导致此失败的原因是 1.ZK无法连接 ;2.ZK上已存在相关节点 ;3.ZK操作权限受限");
					logger.error("\n\n############################## StartAuthorityServer Failed launch:##############################");
					ctx.close();
					return ;
				}
			} else {
				logger.error("StartAuthorityServer not started well, please check StartAuthorityServer config");
				logger.error("\n\n############################## StartAuthorityServer Failed launch:##############################" );
				ctx.close();
				return ;
			} 
			
			logger.info("\n\n############################## StartAuthorityServer started:##############################");
			logger.info("\n\n############################## " + authorityServer.getUsingIpPort());
		} catch (Exception e) {
			logger.error("\n\n############################## StartAuthorityServer Failed launch:##############################", e);
			return;
		}
		
		logger.info("@@@@ Using ZooKeeper url : " + ZkProperties.getInstance().getZookeeperConnUrl());
		logger.info("@@@@ Current Enviroment  : " + SystemProperties.getEnviroment());
		
		synchronized (StartAuthorityServer.class) {
			while (true) {
				try {
					StartAuthorityServer.class.wait();
				} catch (InterruptedException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}
	
}
