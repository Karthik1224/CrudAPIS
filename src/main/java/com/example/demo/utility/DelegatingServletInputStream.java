package com.example.demo.utility;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

public class DelegatingServletInputStream extends ServletInputStream{
	private final InputStream sourceStream;

    public DelegatingServletInputStream(byte[]sourceBytes) {
        sourceStream = new ByteArrayInputStream(sourceBytes);
    }

    public int read() throws IOException {
        return sourceStream.read();
    }

    public boolean isFinished() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void setReadListener(ReadListener readListener) {
        // Not implemented
    }
}
