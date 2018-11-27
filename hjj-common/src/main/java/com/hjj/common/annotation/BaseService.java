package com.hjj.common.annotation;

import java.lang.annotation.*;
/**
 * BaseService
 * @author hujunjie
 * @time 2018年11月27日
 */
@Target({ElementType.TYPE}) // �ӿڣ��࣬ö�٣�ע��
@Retention(RetentionPolicy.RUNTIME) // �������͵�Annotations����JVM����
@Documented
public @interface BaseService {

}
