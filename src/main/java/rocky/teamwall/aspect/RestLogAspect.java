package rocky.teamwall.aspect;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import rocky.teamwall.dto.JsonResult;
import rocky.teamwall.entity.Tag;

@Aspect
@Component
public class RestLogAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * rocky.teamwall.web..*.*(..))")
    public void restLog(){}

    @Before("restLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    	logger.info("------------------------------->RestLogAspect.doBefore");
    	
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "restLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
    	JsonResult<List<Tag>> json = (JsonResult<List<Tag>>)ret;
        logger.info("RESPONSE : " + json);
    }

}