package com.apiomat.csm.application.entities;

import java.time.Instant;
import java.util.Objects;

public class Booking
{
	private final Long seatId;
	private final Instant start;
	private final Instant end;

	public Booking( final Long seatId, final Instant start, final Instant end )
	{
		this.seatId = seatId;
		this.start = start;
		this.end = end;
	}

	@Override
	public boolean equals( final Object o )
	{
		if ( this == o )
		{
			return true;
		}
		if ( o == null || getClass( ) != o.getClass( ) )
		{
			return false;
		}
		final Booking booking = ( Booking ) o;
		return Objects.equals( this.seatId, booking.seatId ) &&
			Objects.equals( this.start, booking.start ) &&
			Objects.equals( this.end, booking.end );
	}

	@Override
	public int hashCode( )
	{
		return Objects.hash( this.seatId, this.start, this.end );
	}

	public boolean blocks( final Booking other )
	{
		if ( other.seatId.equals( this.seatId ) )
		{
			return other.start.isBefore( this.end ) && other.end.isAfter( this.start );
		}

		return false;
	}

	public Long getSeatId( )
	{
		return this.seatId;
	}

	public Instant getStart( )
	{
		return this.start;
	}

	public Instant getEnd( )
	{
		return this.end;
	}
}
