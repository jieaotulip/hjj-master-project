package com.hjj.db;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDao extends SqlSessionDaoSupport {
	private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		logger.info("set sqlSessionFactory success");
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
