package cn.tarena.gm.controller;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import cn.tarena.gm.shiro.AuthCredential;
import cn.tarena.gm.shiro.AuthRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;



@Configuration  
public class ShiroConfiguration {  
	//shiro过滤表
    private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();  
   
    //shiro中的组件需要以bean的形式交给spring管理
    @Bean(name = "lifecycleBeanPostProcessor")  
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {  
    	return new LifecycleBeanPostProcessor();  
    }  
    //spring为组件创建代理对象,并且代理的方式是Cglib
    //要求:使用shiro代理对象的创建方式必须是cglib
    @Bean  
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {  
    	DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();  
    	daap.setProxyTargetClass(true);  
    	return daap;  
    }  
    //开启切面注解
    	//??
    //shiro安全管理器
    @Bean(name = "securityManager")  
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {  
    	DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();  
    	dwsm.setRealm(getAuthRealm());  
    	//dwsm.setCacheManager(ehCacheManager());//这个如果执行多次，也是同样的一个对象;  
    	return dwsm;  
    }  
    @Bean(name="authCredential")
    public AuthCredential getAuthCredential(){
    	return new AuthCredential();
    }
    //自己订义的realm
    @Bean(name = "authRealm") 
    @DependsOn("lifecycleBeanPostProcessor")
    public AuthRealm getAuthRealm() {
    	AuthRealm ar = new AuthRealm();
    	ar.setCredentialsMatcher(getAuthCredential());
        return ar;  
    }
    //thymeleaf 添加 shiro支持
    @Bean
    public ShiroDialect shiroDialect(){
		return new ShiroDialect();
	}
    //权限管理器 使用时 需要将安全管理器引入
    @Bean  
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {  
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();  
        aasa.setSecurityManager(getDefaultWebSecurityManager()); 
        return new AuthorizationAttributeSourceAdvisor();  
    } 
    
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
    	SimpleMappingExceptionResolver se = new SimpleMappingExceptionResolver();
    	Properties p = new Properties();
    	p.setProperty("org.apache.shiro.authz.UnauthorizedException", "/error");
    	se.setExceptionMappings(p);
		return se;
    }
   
    //定义一个shiro过滤器
   @Bean(name = "shiroFilter")  
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {  
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();  
        //进入安全管理器
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        //拦截后访问的页面
        shiroFilterFactoryBean.setLoginUrl("/index.jsp");
       
        //拦截和放行
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);  
        return shiroFilterFactoryBean;  
    }  
}  
