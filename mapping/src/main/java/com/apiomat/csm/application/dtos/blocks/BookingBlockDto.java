package com.apiomat.csm.application.dtos.blocks;

import com.apiomat.csm.application.dtos.ImageDto;

public class BookingBlockDto implements Comparable<BookingBlockDto>
{
	private int sortIndex;
	private ImageDto image;
	private String text;

	public void setImage(ImageDto imageDto)
	{
		this.image = image;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public int getSortIndex( )
	{
		return this.sortIndex;
	}

	public void setSortIndex( final int sortIndex )
	{
		this.sortIndex = sortIndex;
	}

	@Override
	public int compareTo(BookingBlockDto o) {
		return this.getSortIndex() - o.getSortIndex();
	}
}
