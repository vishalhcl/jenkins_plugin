/**
 * © Copyright HCL Technologies Ltd. 2017, 2019.
 * LICENSE: Apache License, Version 2.0 https://www.apache.org/licenses/LICENSE-2.0
 */

package com.hcl.appscan.jenkins.plugin.util;

import hudson.model.TaskListener;

import java.io.Serializable;

import com.hcl.appscan.sdk.logging.IProgress;
import com.hcl.appscan.sdk.logging.Message;

public class ScanProgress implements IProgress, Serializable {

	private static final long serialVersionUID = 1L;

	private TaskListener m_listener;
	
	public ScanProgress(TaskListener listener) {
		m_listener = listener;
	}

	@Override
	public void setStatus(Message status) {
		m_listener.getLogger().println(status.getSeverityString() + status.getText());
	}

	@Override
	public void setStatus(Throwable e) {
		m_listener.getLogger().println(Message.ERROR_SEVERITY + e.getLocalizedMessage());
	}

	@Override
	public void setStatus(Message status, Throwable e) {
		m_listener.getLogger().println(status.getSeverityString() + status.getText() + "\n" + e.getLocalizedMessage());
	}
}
