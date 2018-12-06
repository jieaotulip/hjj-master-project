package com.hjj.db;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Collection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.defaults.DefaultSqlSession.StrictMap;

/**
 * Sql执行时间记录拦截器
 * 
 * @author hujunjie
 *
 */
@Intercepts({
		@Signature(type = StatementHandler.class, method = "query", args = { Statement.class, ResultHandler.class }),
		@Signature(type = StatementHandler.class, method = "update", args = { Statement.class }),
		@Signature(type = StatementHandler.class, method = "batch", args = { Statement.class }) })
public class SqlCostInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object target = invocation.getTarget();
		long startTime = System.currentTimeMillis();
		StatementHandler sh = (StatementHandler) target;
		try {
			return invocation.proceed();
		} finally {
			long endTime = System.currentTimeMillis();
			long sqlCost = endTime - startTime;
			BoundSql boundSql = sh.getBoundSql();
			String sql = boundSql.getSql();
			Object parameterObject = boundSql.getParameterObject();
			List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
			return null;
		}
	}

	@Override
	public Object plugin(Object target) {
		return null;
	}

	@Override
	public void setProperties(Properties properties) {

	}

	private String formatSql(String sql, Object parameterObject, List<ParameterMapping> parameterMappingList) {
		if (sql == null || sql.length() == 0) {
			return "";
		}
		sql = beautifySql(sql);
		if (parameterObject == null || parameterMappingList == null || parameterMappingList.size() == 0) {
			return sql;
		}
		String sqlWithoutReplacePlaceholder = sql;
		if (parameterMappingList != null) {
			Class<?> parameterObjectClass  = parameterObject.getClass();
			if (isStrictMap(parameterObjectClass)) {
				StrictMap<Collection<?>> strictMap = (StrictMap<Collection<?>>)parameterObject;
				if (isList(strictMap.get("list").getClass())) {
				}
			}
		}
		return null;
	}
	
	/**
	 * 美化sql
	 * @return
	 */
	private String beautifySql(String sql) {
		sql = sql.replaceAll("[\\s\n ]+"," ");
		return sql;
	}
	
	/**
	 * 是否DafaultSqlSession的内部类StrictMap
	 * @return
	 */
	private boolean isStrictMap(Class<?> parameterObjectClass) {
		return parameterObjectClass.isAssignableFrom(StrictMath.class);
	}
	
	/**
	 * 是否List的实现类
	 * @param clazz
	 * @return
	 */
	private boolean isList(Class<?> clazz) {
		Class<?>[] interfaceClasses = clazz.getInterfaces();
		for (Class<?> interfaceClass : interfaceClasses) {
			if (interfaceClass.isAssignableFrom(List.class)) return true;
		}
		return false;
	}
	
	/**
	 * 是否Map的实现类
	 * @param clazz
	 * @return
	 */
	private boolean isMap(Class<?> clazz) {
		Class<?>[] interfaceClasses = clazz.getInterfaces();
		for (Class<?> interfaceClass : interfaceClasses) {
			if (interfaceClass.isAssignableFrom(Map.class)) return true;
		}
		return false;
	}
	/**
	 * 是否基本数据类型或者基本数据类型的包装类
	 * @return
	 */
	private boolean isPrimitiveOrPrimitiveWrapper(Class<?> parameterObjectClass) {
		return parameterObjectClass.isPrimitive() ||  (parameterObjectClass.isAssignableFrom(Byte.class) 
				|| parameterObjectClass.isAssignableFrom(Short.class) || parameterObjectClass.isAssignableFrom(Integer.class)
				|| parameterObjectClass.isAssignableFrom(Long.class) || parameterObjectClass.isAssignableFrom(Double.class)
				|| parameterObjectClass.isAssignableFrom(Float.class) || parameterObjectClass.isAssignableFrom(Character.class)
				|| parameterObjectClass.isAssignableFrom(Boolean.class));
	}
	
	

}
