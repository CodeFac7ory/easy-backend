package com.apiomat.csm.application.services;

import com.apiomat.csm.application.services.BookingService;
import com.apiomat.csm.application.entities.Booking;
import org.junit.jupiter.api.Test;
import com.apiomat.csm.application.repisitories.BookingRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BookingServiceTest
{

	BookingRepository bookingRepository;
	private final BookingService bookingService = new BookingService( bookingRepository );

	@Test
	public void itCreatesNullSeatIdBooking( )
	{
		// given
		final Booking booking = new Booking( null, Instant.now( ), Instant.now( ).plus( 2, ChronoUnit.DAYS ) );

		// when
		final IllegalArgumentException exception = assertThrows( IllegalArgumentException.class, ( ) -> {
			this.bookingService.validate( booking );
		} );

		// then
		assertThat( exception.getMessage( ), equalTo( "seatId must not be null" ) );
	}

	@Test
	public void itCreatesNullStartBooking( )
	{
		// given
		final Booking booking = new Booking( 123L, null, Instant.now( ).plus( 2, ChronoUnit.DAYS ) );

		// when
		final IllegalArgumentException exception = assertThrows( IllegalArgumentException.class, ( ) -> {
			this.bookingService.validate( booking );
		} );

		// then
		assertThat( exception.getMessage( ), equalTo( "start must not be null" ) );
	}

	@Test
	public void itCreatesNullEndBooking( )
	{
		// given
		final Booking booking = new Booking( 123L, Instant.now( ), null );

		// when
		final IllegalArgumentException exception = assertThrows( IllegalArgumentException.class, ( ) -> {
			this.bookingService.validate( booking );
		} );

		// then
		assertThat( exception.getMessage( ), equalTo( "end must not be null" ) );
	}

	@Test
	public void itCreatesEndBeforeStartBooking( )
	{
		// given
		final Booking booking = new Booking( 123L, Instant.now( ).plus( 2, ChronoUnit.DAYS ), Instant.now( ));

		// when
		final IllegalArgumentException exception = assertThrows( IllegalArgumentException.class, ( ) -> {
			this.bookingService.validate( booking );
		} );

		// then
		assertThat( exception.getMessage( ), equalTo( "end must not be after start" ) );
		//THIS IS WRONG ERROR MESSAGE BY THE WAY:)
	}
}
