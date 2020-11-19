package com.apiomat.csm.application.dtos;

import com.apiomat.csm.application.dtos.blocks.BookingBlockDto;

import java.util.List;

public class BookingDto
{
	private Long id;
	private List<BookingBlockDto> blocks;

	public Long getId( )
	{
		return this.id;
	}

	public void setId( final Long id )
	{
		this.id = id;
	}

	public List<BookingBlockDto> getBlocks( )
	{
		return this.blocks;
	}

	public void setBlocks( final List<BookingBlockDto> blocks )
	{
		this.blocks = blocks;
	}
}
