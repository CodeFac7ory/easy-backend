package com.apiomat.csm.application.entities;

import com.apiomat.csm.application.entities.blocks.BookingBlock;

import java.time.Instant;
import java.util.Set;

public class Booking extends Entity
{
	private Instant start;
	private Instant end;
	private Set<BookingBlock> blocks;

	public Instant getStart( )
	{
		return this.start;
	}

	public void setStart( final Instant start )
	{
		this.start = start;
	}

	public Instant getEnd( )
	{
		return this.end;
	}

	public void setEnd( final Instant end )
	{
		this.end = end;
	}

	public Set<BookingBlock> getBlocks( )
	{
		return this.blocks;
	}

	public void setBlocks( final Set<BookingBlock> blocks )
	{
		this.blocks = blocks;
	}
}
