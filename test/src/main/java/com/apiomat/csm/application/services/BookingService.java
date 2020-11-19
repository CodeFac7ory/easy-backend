package com.apiomat.csm.application.services;

import com.apiomat.csm.application.entities.Booking;
import com.apiomat.csm.application.repisitories.BookingRepository;

public class BookingService
{
	private final BookingRepository bookingRepository;

	public BookingService( final BookingRepository bookingRepository )
	{
		this.bookingRepository = bookingRepository;
	}

	public void validate( final Booking booking ) throws IllegalArgumentException
	{
		if ( booking.getSeatId( ) == null )
		{
			throw new IllegalArgumentException( "seatId must not be null" );
		}
		if ( booking.getStart( ) == null )
		{
			throw new IllegalArgumentException( "start must not be null" );
		}
		if ( booking.getEnd( ) == null )
		{
			throw new IllegalArgumentException( "end must not be null" );
		}
		if ( booking.getEnd( ).isBefore( booking.getStart( ) ) )
		{
			throw new IllegalArgumentException( "end must not be after start" );
		}
		if ( this.bookingRepository.existsBlockingBooking( booking ) )
		{
			throw new IllegalArgumentException( "seat is already taken within your booking period" );
		}
	}
}
