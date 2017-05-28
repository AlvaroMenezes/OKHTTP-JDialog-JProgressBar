package com.alvaromenezes.example.connection;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 
 * @author alvaromenezes 27/05/2017 based on based on
 *         https://github.com/square/okhttp/blob/master/samples/guide/src/main/java/okhttp3/recipes/Progress.java
 *
 */
public class Connection {

	private String url;
	private ProgressListener progressListener;

	public Connection(String url, ProgressListener progressListener) {
		this.url = url;
		this.progressListener = progressListener;
	}

	public String run() throws Exception {
		Request request = new Request.Builder().url(url).build();

		OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Response originalResponse = chain.proceed(chain.request());
				return originalResponse.newBuilder().body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
			}
		}).build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			return response.body().string();
		}
	}

}
