package com.apiomat.csm.application.dtos.blocks;

import com.apiomat.csm.application.dtos.ImageDto;

public class ImageBlockDto extends BookingBlockDto
{
	private ImageDto image;

	public ImageDto getImage( )
	{
		return this.image;
	}

	public void setImage( final ImageDto image )
	{
		this.image = image;
	}
}
