package kr.library.core.aop;
 
import java.io.BufferedReader;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import kr.library.core.util.JsonUtils;
import kr.library.core.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;

import org.json.simple.JSONObject;
 
//ex> api 예시
// Pointcut	JoinPoints 
// execution(public * *(..))	public 메소드 실행
// execution(* set*(..))	이름이 set으로 시작하는 모든 메소드명 실행
// execution(* get*(..))	이름이 get으로 시작하는 모든 메소드명 실행
// execution(* com.xyz.service.AccountService.*(..))	AccountService 인터페이스의 모든 메소드 실행
// execution(* com.xyz.service.*.*(..))	service 패키지의 모든 메소드 실행
// execution(* com.xyz.service..*.*(..))	service 패키지와 하위 패키지의 모든 메소드 실행
// within(com.xyz.service.*)	service 패키지 내의 모든 결합점 (클래스 포함)
// within(com.xyz.service..*)	service 패키지 및 하위 패키지의 모든 결합점 (클래스 포함)
// bean(*Repository)	이름이 “Repository”로 끝나는 모든 빈
// bean(*)	모든 빈 bean(account*) 이름이 'account'로 시작되는 모든 빈
// bean(*dataSource) || bean(*DataSource)	이름이 “dataSource” 나 “DataSource” 으로 끝나는 모든 빈

/**
 * ==========================================================
 * @package_name				:	kr.library.core.aop
 * @file_name					:	LogAspect.java
 * @author						:	hoosfa
 * @date						:	2021.04.116
 * ==========================================================
 * 
 * HISTORY
 * ==========================================================
 * DATE			AUTHOR			MEMO
 * ==========================================================
 * 2021.04.116		hoosfa		init
 *
 *
 */
@Slf4j
@Aspect
@Component
public class AppLogAspect {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Pointcut("@annotation(kr.library.core.annotation.AccessTokenCheck)")
	public void accessTokenCheck() { }
	
	@Before("accessTokenCheck()")
	public void beforeMethod(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String accessToken = request.getHeader("X-Auth-Token");
		
		jwtUtils.isVaildAccessToken(accessToken, getUserId(joinPoint, request));
	}
    
    private String getUserId(JoinPoint joinPoint, HttpServletRequest request) {
    	String username = "";
    	try {
    		
    		BufferedReader br = request.getReader();
    		String content = br.lines().collect(Collectors.joining());
    		br.close();
    		
			JSONObject json = JsonUtils.toJson(content);
			username = json.get("username").toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return username;
	}

	/**
     * ==========================================================
     * @author						:	hoosfa
     * @date						:	2021.04.28
     * @enclosing_method			:	logging
     * @enclosing_type				:	LogAspect
     * @return_type					:	Object
     * @tags						:	@param pjp
     * @tags						:	@return
     * @tags						:	@throws Throwable
     * ==========================================================
     * 
     * HISTORY
     * ==========================================================
     * DATE			AUTHOR			MEMO
     * ==========================================================
     * 2021.04.28		hoosfa		init
     *
     * kr.library.core.app.main.service하위 *Service의 모든 메서드
     * 모든 메소드 시작전, 종료후 log를 write 한다.
     */
    @Around("execution(* kr.library.core.app.main.service.*Service.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
    	// pjp.getSignature().getDeclaringTypeName() : packageName+className
    	// pjp.getSignature().getName() : methodNmae
        log.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        log.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        return result;
    }
    
    /**
     * ==========================================================
     * @author						:	hoosfa
     * @date						:	2021.04.29
     * @enclosing_method			:	logging
     * @enclosing_type				:	LogAspect
     * @return_type					:	Object
     * @tags						:	@param pjp
     * @tags						:	@return
     * @tags						:	@throws Throwable
     * ==========================================================
     * 
     * HISTORY
     * ==========================================================
     * DATE			AUTHOR			MEMO
     * ==========================================================
     * 2021.04.29		hoosfa		init
     *
     * kr.library.core.app.main.controller하위 *Controller의 모든 메서드
     * 모든 메소드 시작전, 종료후 log를 write 한다.
     */
    @Around("execution(* kr.library.app.main.controller.*Controller.*(..))")
    public Object logging2(ProceedingJoinPoint pjp) throws Throwable {
    	// pjp.getSignature().getDeclaringTypeName() : packageName+className
    	// pjp.getSignature().getName() : methodNmae
        log.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        log.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        return result;
    }
    
    
}
