package com.winxuan.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName:Main.java 
 * @Description: 
 * @author: wangpanyong
 * @date: 2015年12月14日
 */
@SpringBootApplication
@ComponentScan({ "com.winxuan" })
@EnableDiscoveryClient
public class Main {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

}
