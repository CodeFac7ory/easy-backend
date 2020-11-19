package com.apiomat.csm.application.entities.blocks;

import com.apiomat.csm.application.entities.Image;

public class ImageBlock extends BookingBlock
{
	private Image image;

	public Image getImage( )
	{
		return this.image;
	}

	public void setImage( final Image image )
	{
		this.image = image;
	}
}
