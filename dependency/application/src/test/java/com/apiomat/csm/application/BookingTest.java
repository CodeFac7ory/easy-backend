package com.apiomat.csm.application;

import com.apiomat.csm.application.booking.Booking;
import com.apiomat.csm.application.booking.BookingService;
import com.apiomat.csm.application.notifications.MailSender;
import com.apiomat.csm.application.notifications.PushSender;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookingTest
{
	@Spy
	private final MailSender mailSender = spy( MailSender.class );

	@Spy
	private final PushSender pushSender = spy( PushSender.class );

	private final BookingService bookingService = new BookingService(mailSender, pushSender);

	@Test
	public void itCreatesBooking( )
	{
		// given
		final Booking booking = new Booking( );
		booking.setUsername( "testuser" );
		booking.setSeatId( "123" );
		booking.setStart( Instant.now( ) );
		booking.setEnd( Instant.now( ).plus( 2, ChronoUnit.DAYS ) );

		// when
		this.bookingService.create( booking );

		// then
		verify( this.mailSender, times( 1 ) ).send( eq( booking ) );
		verify( this.pushSender, times( 1 ) ).send( eq( booking ) );
	}
}
