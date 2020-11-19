package com.apiomat.csm.application.dtos;

public class ImageDto
{
	private Long id;
	private String url;

	public Long getId( )
	{
		return this.id;
	}

	public void setId( final Long id )
	{
		this.id = id;
	}

	public String getUrl( )
	{
		return this.url;
	}

	public void setUrl( final String url )
	{
		this.url = url;
	}
}
