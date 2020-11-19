package com.apiomat.csm.application.notifications;

import com.apiomat.csm.application.booking.Booking;
import com.apiomat.csm.application.booking.Sender;

public class PushSender implements Sender
{
	public void send( final Booking booking )
	{
		System.out.println( "sending push message for: " + booking );
	}
}
