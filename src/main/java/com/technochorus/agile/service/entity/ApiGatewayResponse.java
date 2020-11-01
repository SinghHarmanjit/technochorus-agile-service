package com.technochorus.agile.service.entity;

import java.util.Collections;
import java.util.Map;

public class ApiGatewayResponse {

	private final int statusCode;
	private final String body;
	private final Map<String, String> headers;
	private final boolean isBase64Encoded;

	public ApiGatewayResponse(int statusCode, String body, Map<String, String> headers, boolean isBase64Encoded) {
		this.statusCode = statusCode;
		this.body = body;
		this.headers = headers;
		this.isBase64Encoded = isBase64Encoded;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getBody() {
		return body;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	// API Gateway expects the property to be called "isBase64Encoded" => isIs
	public boolean isIsBase64Encoded() {
		return isBase64Encoded;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private int statusCode = 200;
		private Map<String, String> headers = Collections.emptyMap();
		private String body;
		private boolean base64Encoded;

		public Builder setStatusCode(int statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public Builder setHeaders(Map<String, String> headers) {
			this.headers = headers;
			return this;
		}

		/**
		 * Builds the {@link ApiGatewayResponse} using the passed raw body string.
		 */
		public Builder setBody(String body) {
			this.body = body;
			return this;
		}

		/**
		 * A binary or rather a base64encoded responses requires
		 * <ol>
		 * <li>"Binary Media Types" to be configured in API Gateway
		 * <li>a request with an "Accept" header set to one of the "Binary Media
		 * Types"
		 * </ol>
		 */
		public Builder setBase64Encoded(boolean base64Encoded) {
			this.base64Encoded = base64Encoded;
			return this;
		}

		public ApiGatewayResponse build() {
			return new ApiGatewayResponse(statusCode, body, headers, base64Encoded);
		}
	}
}
