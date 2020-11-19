package com.apiomat.csm.application.booking;

import java.time.Instant;
import java.util.Objects;

public class Booking
{
	private String username;
	private String seatId;
	private Instant start;
	private Instant end;

	public String getUsername( )
	{
		return this.username;
	}

	public void setUsername( final String username )
	{
		this.username = username;
	}

	public String getSeatId( )
	{
		return this.seatId;
	}

	public void setSeatId( final String seatId )
	{
		this.seatId = seatId;
	}

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
		return Objects.equals( this.username, booking.username ) &&
			Objects.equals( this.seatId, booking.seatId ) &&
			Objects.equals( this.start, booking.start ) &&
			Objects.equals( this.end, booking.end );
	}

	@Override
	public int hashCode( )
	{
		return Objects.hash( this.username, this.seatId, this.start, this.end );
	}

	@Override
	public String toString( )
	{
		return "Booking{" +
			"username='" + this.username + '\'' +
			", seatId='" + this.seatId + '\'' +
			", start=" + this.start +
			", end=" + this.end +
			'}';
	}
}
