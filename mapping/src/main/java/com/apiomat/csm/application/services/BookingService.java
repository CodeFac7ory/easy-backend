package com.apiomat.csm.application.services;

import com.apiomat.csm.application.dtos.BookingDto;
import com.apiomat.csm.application.entities.Booking;
import com.apiomat.csm.application.mappers.BookingMapper;
import com.apiomat.csm.application.repositories.BookingRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingService
{
	private final BookingRepository repository;
	private final BookingMapper mapper;

	public BookingService( final BookingRepository repository, final BookingMapper mapper )
	{
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<BookingDto> list( )
	{
		final List<Booking> bookings = this.repository.all( );
		// TODO
		List<BookingDto> bookingDtos = new ArrayList<BookingDto>();
    for (Booking temp : bookings) {
      bookingDtos.add( this.mapper.map( temp ) );
    }
		return bookingDtos;
		// return new ArrayList<>( );
	}

	public BookingDto findById( final Long id ) throws IllegalStateException
	{
		try {

			final Booking booking = this.repository.findBy( id );
			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[booking]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			System.out.println(booking);
			// System.out.println(booking.getId());
			// System.out.println(booking.getCreatedAt());
			// if (booking != null) {
			return this.mapper.map( booking );
			// }
			// else {
			// 	throw new IllegalStateException("not found");
			// }
		}
		catch (IllegalStateException e) {
			throw e;
		}
		// TODO
		// return new BookingDto( );
	}

	public BookingDto create( final BookingDto bookingDto )
	{
		final Booking create = this.mapper.map( bookingDto );
		this.repository.create( create );
		return this.mapper.map( create );
	}
}
