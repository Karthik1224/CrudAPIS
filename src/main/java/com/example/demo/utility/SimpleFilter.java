package com.example.demo.utility;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.eroute.AuthServer.util.ResponseWrapper;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




//@Order(1)
@Component
public class SimpleFilter extends OncePerRequestFilter {
	private static final Logger log = (Logger) LoggerFactory.getLogger(SimpleFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			
			String token = "AB12345";
			MDC.put("mdcKey", token);
			 RequestWrapper requestWrapper = new RequestWrapper(request);
			 ResponseWrapper responseWrapper = new ResponseWrapper(response);
		     String requestBody = requestWrapper.getRequestBody();
            log.info("request body :{}",requestBody);
			filterChain.doFilter(requestWrapper, response);
			byte[] responseData = responseWrapper.getCachedResponseBody();
			String responsePayload = new String(responseData, response.getCharacterEncoding());
			log.info("AuditFilter : ResponsePayload :{}", responsePayload);
		} catch (Exception e) {
			
		}
		finally {
			MDC.remove("mdcKey");
		}
		
	}
	@Override
    protected boolean isAsyncDispatch(final HttpServletRequest request) {
        return false;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return false;
    }

   
}

