package com.apiomat.csm.application.dtos.blocks;

public class TextBlockDto extends BookingBlockDto
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
