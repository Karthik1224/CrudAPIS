package com.example.demo.Configurations;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.util.IntMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.Constants.Constant;
import com.example.demo.modals.RequestAudit;
import com.example.demo.services.RequestAuditService;
import com.example.demo.services.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SimpleFilter implements Filter {

	private static final Logger log = (Logger) LoggerFactory.getLogger(SimpleFilter.class);

	private final ObjectMapper mapper = new ObjectMapper();

	@Value("${apiKey}")
	private String apiKeyValue;

	@Autowired
	private RequestAuditService reqAuditService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		RequestAudit reqAudit = new RequestAudit();
		reqAudit.setMobileNumber("1234567890");
		reqAudit.setRequestUrl(req.getRequestURI());
		reqAudit.setRequestIp(req.getProtocol());

		log.info("converted the object to this URL is ::" + req.getRequestURI());
//		if(req.getHeader("x-api-key").equals(apiKeyValue))
//		{
//		
		reqAudit.setResponseCode(Constant.SUCCESS_API_CODE);
		reqAuditService.addRequestAudit(reqAudit);
		chain.doFilter(request, response);
		log.info("done with request sending response URL is  ::" + req.getRequestURI());
		// }
//		else
//		{
//			 reqAudit.setResponseCode(Constant.FAILURE_API_CODE);
//			 reqAuditService.addRequestAudit(reqAudit);
//			 Map<String, Object> errorDetails = new HashMap<>();
//		        errorDetails.put("message", "Provide valid credentials");
//		       mapper.writeValue(res.getWriter(), errorDetails);
//			log.info("Unable to process the request");
		// }
	}
}
