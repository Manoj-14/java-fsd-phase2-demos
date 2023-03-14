package com.project.listiners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListiner implements ServletRequestListener {

	public RequestListiner() {

	}

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("Request destroyed");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request initialised");
	}

}
