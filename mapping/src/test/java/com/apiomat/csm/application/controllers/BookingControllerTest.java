package com.apiomat.csm.application.controllers;

import com.apiomat.csm.application.dtos.BookingDto;
import com.apiomat.csm.application.dtos.blocks.BookingBlockDto;
import com.apiomat.csm.application.dtos.blocks.ImageBlockDto;
import com.apiomat.csm.application.dtos.blocks.TextBlockDto;
import com.apiomat.csm.application.mappers.BookingMapper;
import com.apiomat.csm.application.repositories.BookingRepository;
import com.apiomat.csm.application.services.BookingService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookingControllerTest
{
	private final BookingRepository repository = new BookingRepository( );
	private final BookingMapper mapper = new BookingMapper( );
	private final BookingService bookingService = new BookingService( this.repository, this.mapper );

	private final BookingController bookingController = new BookingController( this.bookingService );

	/* list */

	@Test
	public void listReturnsDtos( )
	{
		// when
		final List<BookingDto> list = this.bookingController.list( );

		// then
		assertThat( list, hasSize( 5 ) );
		checkBookingDto( 1001L, list.get( 0 ) );
		checkBookingDto( 2002L, list.get( 1 ) );
		checkBookingDto( 3003L, list.get( 2 ) );
		checkBookingDto( 4004L, list.get( 3 ) );
		checkBookingDto( 5005L, list.get( 4 ) );
	}

	/* details */

	@Test
	public void detailsReturnsDtoForExistingId( )
	{
		// when
		final BookingDto booking = this.bookingController.details( 2002L );

		// then
		checkBookingDto( 2002L, booking );
	}

	@Test
	public void detailsThrowsForNonExistingId( )
	{
		// when
		final IllegalStateException exception = assertThrows( IllegalStateException.class, ( ) -> {
			this.bookingController.details( 6006L );
		} );

		// then
		assertThat( exception.getMessage( ), equalTo( "not found" ) );
	}

	private void checkBookingDto( final Long bookingId, final BookingDto bookingDto )
	{
		assertThat( bookingDto.getId( ), equalTo( bookingId ) );

		final List<BookingBlockDto> blocks = bookingDto.getBlocks( );
		assertThat( blocks.get( 0 ), instanceOf( TextBlockDto.class ) );
		final TextBlockDto textBlockDto = ( TextBlockDto ) blocks.get( 0 );
		assertThat( textBlockDto.getSortIndex( ), equalTo( 0 ) );
		assertThat( textBlockDto.getText( ), equalTo( "Some Text for " + bookingId ) );

		assertThat( blocks.get( 1 ), instanceOf( ImageBlockDto.class ) );
		final ImageBlockDto imageBlockDto = ( ImageBlockDto ) blocks.get( 1 );
		assertThat( imageBlockDto.getSortIndex( ), equalTo( 1 ) );
		assertThat( imageBlockDto.getImage( ).getId( ), equalTo( 1L ) );
		assertThat( imageBlockDto.getImage( ).getUrl( ), equalTo( "https://apiomat.com/image/1" ) );

		assertThat( blocks.get( 2 ), instanceOf( TextBlockDto.class ) );
		final TextBlockDto secondTextBlockDto = ( TextBlockDto ) blocks.get( 2 );
		assertThat( secondTextBlockDto.getSortIndex( ), equalTo( 2 ) );
		assertThat( secondTextBlockDto.getText( ), equalTo( "Second Text for " + bookingId ) );

		assertThat( blocks.get( 3 ), instanceOf( TextBlockDto.class ) );
		final TextBlockDto thirdTextBlockDto = ( TextBlockDto ) blocks.get( 3 );
		assertThat( thirdTextBlockDto.getSortIndex( ), equalTo( 3 ) );
		assertThat( thirdTextBlockDto.getText( ), equalTo( "Third Text for " + bookingId ) );
	}
}
