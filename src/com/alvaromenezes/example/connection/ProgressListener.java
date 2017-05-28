package com.alvaromenezes.example.connection;

public interface ProgressListener {
	void update(long bytesRead, long contentLength);
}