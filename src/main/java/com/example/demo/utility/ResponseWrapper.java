package com.example.demo.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper {

	private ByteArrayOutputStream cachedResponseBody;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        cachedResponseBody = new ByteArrayOutputStream();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStreamWrapper(cachedResponseBody);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(getOutputStream(), true);
    }

    public byte[] getCachedResponseBody() {
        return cachedResponseBody.toByteArray();
    }

    private static class ServletOutputStreamWrapper extends ServletOutputStream {

        private final ByteArrayOutputStream outputStream;

        public ServletOutputStreamWrapper(ByteArrayOutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public void write(int b) throws IOException {
            outputStream.write(b);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            outputStream.write(b, off, len);
        }

        @Override
        public void flush() throws IOException {
            outputStream.flush();
        }

        @Override
        public void close() throws IOException {
            outputStream.close();
            super.close();
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener listener) {

        }
    }
}
