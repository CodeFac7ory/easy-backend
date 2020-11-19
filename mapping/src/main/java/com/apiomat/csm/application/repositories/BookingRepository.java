package com.apiomat.csm.application.repositories;

import com.apiomat.csm.application.entities.Booking;
import com.apiomat.csm.application.entities.Image;
import com.apiomat.csm.application.entities.blocks.BookingBlock;
import com.apiomat.csm.application.entities.blocks.ImageBlock;
import com.apiomat.csm.application.entities.blocks.TextBlock;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookingRepository
{

	public List<Booking> all( )
	{
		final List<Booking> result = new ArrayList<>( );
		result.add( createBooking( 1001L ) );
		result.add( createBooking( 2002L ) );
		result.add( createBooking( 3003L ) );
		result.add( createBooking( 4004L ) );
		result.add( createBooking( 5005L ) );
		return result;
	}

	public Booking findBy( final Long id ) throws IllegalStateException
	{
		final List<Booking> existingBookings = new ArrayList<>( );
		existingBookings.add( createBooking( 1001L ) );
		existingBookings.add( createBooking( 2002L ) );
		existingBookings.add( createBooking( 3003L ) );
		existingBookings.add( createBooking( 4004L ) );
		existingBookings.add( createBooking( 5005L ) );

    for ( Booking item : existingBookings ) {
	    if ( id.equals( item.getId() ) ) {
				return item;
	    }
		}
		throw new IllegalStateException ("not found");
	}

	public void create( final Booking create )
	{
		// Nicht Teil dieser Aufgabe
	}

	private Booking createBooking( final Long id )
	{
		final Booking result = new Booking( );
		result.setId( id );
		result.setCreatedAt( Instant.ofEpochMilli( 1600846038737L ) );
		result.setCreatedBy( "Max Mustermann" );
		result.setModifiedAt( Instant.ofEpochMilli( 1600846048737L ) );
		result.setModifiedBy( "Hans Müller" );
		result.setStart( Instant.now( ) );
		result.setEnd( Instant.now( ).plus( 2, ChronoUnit.DAYS ) );
		result.setBlocks( createBookingBlocks( id ) );
		return result;
	}

	private Set<BookingBlock> createBookingBlocks( final Long bookingId )
	{
		final Set<BookingBlock> result = new HashSet<>( );

		final TextBlock textBlock = new TextBlock( );
		textBlock.setText( "Some Text for " + bookingId );
		textBlock.setSortIndex( 0 );
		result.add( textBlock );

		final ImageBlock imageBlock = new ImageBlock( );
		imageBlock.setImage( createImage( 1L ) );
		imageBlock.setSortIndex( 1 );
		result.add( imageBlock );

		final TextBlock secondTextBlock = new TextBlock( );
		secondTextBlock.setText( "Second Text for " + bookingId );
		secondTextBlock.setSortIndex( 2 );
		result.add( secondTextBlock );

		final TextBlock thirdTextBlock = new TextBlock( );
		thirdTextBlock.setText( "Third Text for " + bookingId );
		thirdTextBlock.setSortIndex( 3 );
		result.add( thirdTextBlock );

		return result;
	}

	private Image createImage( final Long imageId )
	{
		final Image result = new Image( );
		result.setId( imageId );
		result.setCreatedAt( Instant.ofEpochMilli( 1600846038737L ) );
		result.setCreatedBy( "Max Mustermann" );
		result.setModifiedAt( Instant.ofEpochMilli( 1600846048737L ) );
		result.setModifiedBy( "Hans Müller" );
		result.setUrl( "https://apiomat.com/image/" + imageId );
		return result;
	}
}
