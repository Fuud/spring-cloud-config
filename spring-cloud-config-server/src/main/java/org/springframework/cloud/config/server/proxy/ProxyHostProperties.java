/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.config.server.proxy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Properties for a proxy host.
 *
 * @author Dylan Roberts
 */
public class ProxyHostProperties {

	private String host;

	private int port;

	private String nonProxyHosts;

	private String username;

	private String password;

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getNonProxyHosts() {
		return this.nonProxyHosts;
	}

	public void setNonProxyHosts(String nonProxyHosts) {
		this.nonProxyHosts = nonProxyHosts;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Proxy for a given scheme.
	 */
	public enum ProxyForScheme {

		/**
		 * HTTP scheme.
		 */
		HTTP,
		/**
		 * HTTPS scheme.
		 */
		HTTPS;

		@JsonCreator
		public static ProxyForScheme forLowerCaseName(String lowerCaseName) {
			return ProxyForScheme.valueOf(lowerCaseName.toUpperCase());
		}

		@JsonValue
		public String lowercaseName() {
			return this.name().toLowerCase();
		}

	}

	@JsonIgnore
	public boolean connectionInformationProvided() {
		return host != null && !host.isEmpty() && port > 0;
	}

	@JsonIgnore
	public boolean authenticationProvided() {
		return username != null && password != null;
	}

}
