package com.apiomat.csm.application.entities;

import java.time.Instant;

public abstract class Entity
{
	private Long id;
	private Instant createdAt;
	private String createdBy;
	private Instant modifiedAt;
	private String modifiedBy;

	public Long getId( )
	{
		return this.id;
	}

	public void setId( final Long id )
	{
		this.id = id;
	}

	public Instant getCreatedAt( )
	{
		return this.createdAt;
	}

	public void setCreatedAt( final Instant createdAt )
	{
		this.createdAt = createdAt;
	}

	public String getCreatedBy( )
	{
		return this.createdBy;
	}

	public void setCreatedBy( final String createdBy )
	{
		this.createdBy = createdBy;
	}

	public Instant getModifiedAt( )
	{
		return this.modifiedAt;
	}

	public void setModifiedAt( final Instant modifiedAt )
	{
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy( )
	{
		return this.modifiedBy;
	}

	public void setModifiedBy( final String modifiedBy )
	{
		this.modifiedBy = modifiedBy;
	}
}
