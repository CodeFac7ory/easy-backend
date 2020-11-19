package com.apiomat.csm.application.mappers;

import com.apiomat.csm.application.dtos.BookingDto;
import com.apiomat.csm.application.dtos.ImageDto;

import com.apiomat.csm.application.dtos.blocks.BookingBlockDto;
import com.apiomat.csm.application.dtos.blocks.ImageBlockDto;
import com.apiomat.csm.application.dtos.blocks.TextBlockDto;

import com.apiomat.csm.application.entities.Booking;
import com.apiomat.csm.application.entities.Image;

import com.apiomat.csm.application.entities.blocks.BookingBlock;
import com.apiomat.csm.application.entities.blocks.ImageBlock;
import com.apiomat.csm.application.entities.blocks.TextBlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BookingMapper
{
	public BookingDto map( final Booking booking )
	{
		BookingDto bookingDto = new BookingDto();
		bookingDto.setId( booking.getId() );

		List<BookingBlockDto> bookingBlockDtos = new ArrayList<>();

		Iterator<BookingBlock> bookingBlocks = booking.getBlocks().iterator();
		BookingBlockDto bookingBlockDtoTemp;
    while ( bookingBlocks.hasNext() ){
    	BookingBlock bookingBlock = bookingBlocks.next();

    	if( bookingBlock instanceof ImageBlock ) {
    		bookingBlockDtoTemp = new ImageBlockDto();
    		ImageDto imageDto = new ImageDto();
    		Image image = bookingBlock.getImage();
    		imageDto.setId( image.getId() );
    		imageDto.setUrl( image.getUrl() );
    		bookingBlockDtoTemp.setImage( imageDto );
    	}
    	else if ( bookingBlock instanceof TextBlock ) {
    		bookingBlockDtoTemp = new TextBlockDto();
    		bookingBlockDtoTemp.setText( bookingBlock.getText() );
    	}
    	else {
    		bookingBlockDtoTemp = new BookingBlockDto();
    	}

    	bookingBlockDtoTemp.setSortIndex( bookingBlock.getSortIndex() );
    	bookingBlockDtos.add( bookingBlockDtoTemp );
    }

    Collections.sort( bookingBlockDtos );

		bookingDto.setBlocks( bookingBlockDtos );
		return bookingDto;
	}

	public Booking map( final BookingDto bookingDto )
	{
		// Nicht Teil dieser Aufgabe
		return new Booking( );
	}
}
