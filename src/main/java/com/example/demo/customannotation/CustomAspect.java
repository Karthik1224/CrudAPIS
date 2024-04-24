package com.example.demo.customannotation;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.AuditService;
import com.example.demo.utility.RequestWrapper;
import java.lang.reflect.Field;
import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CustomAspect {

	private static final Logger log = (Logger) LoggerFactory.getLogger(CustomAspect.class);

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private AuditService auditService;

	@Around("@annotation(RequestLogger)")
	public void loggingMsg(ProceedingJoinPoint joinPoint) throws Throwable {

		Object response = joinPoint.proceed();
		log.info("CustomAnnotation : Request Url :{}", request.getRequestURL());
		RequestWrapper requestWrapper = new RequestWrapper(request);
		String requestBody = requestWrapper.getRequestBody();
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		log.info("Request body :{}", requestBody);
		auditService.createAuditRecords(id, requestBody);
		log.info("AuditRecords created successfully ");
		log.info("Response :{}", response.toString());
		// Class<?> responseClass = response.getClass();
		String responsePayload = response.toString();
		Pattern pattern = Pattern.compile("\\b(\\w+)=(\\w+)\\b");
		Matcher matcher = pattern.matcher(responsePayload);

		// Iterate over matches and print key-value pairs
		while (matcher.find()) {
			String key = matcher.group(1);
			String value = matcher.group(2);
			System.out.println("Parameter: " + key + ", Value: " + value);
		}
//		Field[] responseFields = responseClass.get
//		for(Field field : responseFields)
//		{
//			field.setAccessible(true);
//			String paramName = field.getName();
//			Object value = field.get(response);
//			log.info("ParameterName :{}",paramName);
//			log.info("ParameterValue :{}",value.toString());
//		}

	}

}
