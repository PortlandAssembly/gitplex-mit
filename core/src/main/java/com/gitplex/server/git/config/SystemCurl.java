package com.gitplex.server.git.config;

import com.gitplex.server.util.editable.annotation.Editable;

@Editable(name="Use curl in System Path", order=100)
public class SystemCurl extends CurlConfig {

	private static final long serialVersionUID = 1L;

	@Override
	public String getExecutable() {
		return "curl";
	}

}
