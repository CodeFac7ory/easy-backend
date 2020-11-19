package com.apiomat.csm.application.controllers;

import com.apiomat.csm.application.dtos.BookingDto;
import com.apiomat.csm.application.services.BookingService;

import java.util.List;

public class BookingController
{
	private final BookingService bookingService;

	public BookingController( final BookingService bookingService )
	{
		this.bookingService = bookingService;
	}

	public List<BookingDto> list( )
	{
		return this.bookingService.list( );
	}

	public BookingDto details( final Long id ) throws IllegalStateException
	{
		try {
			return this.bookingService.findById( id );
		}
		catch (IllegalStateException e) {
			throw e;
		}
	}

	public BookingDto create( final BookingDto bookingDto )
	{
		return this.bookingService.create( bookingDto );
	}
}
