package com.hjj.common.aspect;
/**
 * rpc提供者和消费者日志
 * @author hujunjie
 * @time 2018年11月27日
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.RpcContext;

public class RpcLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(RpcLogAspect.class);
	private long startTime = 0L;
	private long endTime = 0L;
	
	@Before("execution(* *..rpc..*.*(..))")
	public void doBeforeInServiceLayer(JoinPoint joinPoint) {
		logger.debug("deBeforeInServiceLayer");
		startTime = System.currentTimeMillis();
	}
	
	@After("execution(* *..rpc..*.*(..))")
	public void doAfterInServiceLayer(JoinPoint joinPoint) {
		logger.debug("doAfterInServiceLayer");
	}
	
	@Around("execution(* *..rpc..*.*(..))")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Object result = pjp.proceed();
		// 是否是消费端
		boolean consumerSide = RpcContext.getContext().isConsumerSide();
		// 获取最后一次提供方或者调用方的ip
		String ip = RpcContext.getContext().getRemoteHost();
		String url = RpcContext.getContext().getUrl().getParameter("application	");
		logger.info("consumerSide={}, ip={}, url={} ", consumerSide, ip, url);
		return result;
	}
	
}
