package com.apiomat.csm.application.entities.blocks;

public class TextBlock extends BookingBlock
{
	private String text;

	public String getText( )
	{
		return this.text;
	}

	public void setText( final String text )
	{
		this.text = text;
	}
}
