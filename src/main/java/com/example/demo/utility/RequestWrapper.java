package com.example.demo.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {
	 private final String body;

	    public RequestWrapper(HttpServletRequest request) throws IOException {
	        super(request);
	        StringBuilder stringBuilder = new StringBuilder();
	        try (BufferedReader reader = request.getReader()) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                stringBuilder.append(line).append('\n');
	            }
	        }
	        body = stringBuilder.toString();
	    }

	    @Override
	    public ServletInputStream getInputStream() throws IOException {
	        return new DelegatingServletInputStream(body.getBytes());
	    }

	    @Override
	    public BufferedReader getReader() throws IOException {
	        return new BufferedReader(new InputStreamReader(this.getInputStream()));
	    }

	    public String getRequestBody() {
	        return body;
	    }
}
