package com.apiomat.csm.application.entities;

import com.apiomat.csm.application.entities.Booking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

class BookingTest
{
	@Test
	public void itCreates2BookingsSameSeatBlockingTimes( )
	{
		// given
		final Booking booking1 = new Booking( 123L, Instant.now( ), Instant.now( ).plus( 2, ChronoUnit.DAYS ) );
		final Booking booking2 = new Booking( 123L,
			Instant.now( ).plus( 1, ChronoUnit.DAYS ),
			Instant.now( ).plus( 2, ChronoUnit.DAYS )
		);

		assertTrue( booking1.blocks( booking2 ) );
		assertTrue( booking2.blocks( booking1 ) );
	}

	@Test
	public void itCreates2BookingsSameSeatNonBlockingTimes( )
	{
		// given
		final Booking booking1 = new Booking( 123L, Instant.now( ), Instant.now( ).plus( 2, ChronoUnit.DAYS ) );
		final Booking booking2 = new Booking( 123L,
			Instant.now( ).plus( 3, ChronoUnit.DAYS ),
			Instant.now( ).plus( 4, ChronoUnit.DAYS )
		);

		assertFalse( booking1.blocks( booking2 ) );
		assertFalse( booking2.blocks( booking1 ) );
	}

	@Test
	public void itCreates2BookingsDifferentSeatOverlappingTime( )
	{
		// given
		final Booking booking1 = new Booking( 123L, Instant.now( ), Instant.now( ).plus( 2, ChronoUnit.DAYS ) );
		final Booking booking2 = new Booking( 124L,
			Instant.now( ).plus( 1, ChronoUnit.DAYS ),
			Instant.now( ).plus( 2, ChronoUnit.DAYS )
		);

		assertFalse( booking1.blocks( booking2 ) );
		assertFalse( booking2.blocks( booking1 ) );
	}

	@Test
	public void itCreates2BookingsDifferentSeatSameTime( )
	{
		// given
		final Booking booking1 = new Booking( 123L, Instant.now( ), Instant.now( ).plus( 2, ChronoUnit.DAYS ) );
		final Booking booking2 = new Booking( 124L,
			Instant.now( ),
			Instant.now( ).plus( 2, ChronoUnit.DAYS )
		);

		assertFalse( booking1.blocks( booking2 ) );
		assertFalse( booking2.blocks( booking1 ) );
	}
}
