package com.nisum.controller.factory;

import com.nisum.controller.dto.Notification;

public class NotificationFactory {

	public static final Notification buildNotification(String message) {
		return new Notification(message);
	}
}
