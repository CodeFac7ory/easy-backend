package com.apiomat.csm.application.booking;

public class BookingService
{
	private Sender mailSender;
	private Sender pushSender;

	public BookingService(Sender mailSender, Sender pushSender) {
		this.mailSender = mailSender;
		this.pushSender = pushSender;
	}

	public void create( final Booking booking )
	{
		mailSender.send( booking );
		pushSender.send( booking );
	}
}
