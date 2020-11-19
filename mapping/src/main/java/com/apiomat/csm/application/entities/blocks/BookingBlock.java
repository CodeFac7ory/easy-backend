package com.apiomat.csm.application.entities.blocks;

import com.apiomat.csm.application.entities.Image;

public class BookingBlock
{
	private int sortIndex;
	private Image image;
	private String text;

	public Image getImage( )
	{
		return this.image;
	}
	public String getText( )
	{
		return this.text;
	}

	public int getSortIndex( )
	{
		return this.sortIndex;
	}

	public void setSortIndex( final int sortIndex )
	{
		this.sortIndex = sortIndex;
	}
}
