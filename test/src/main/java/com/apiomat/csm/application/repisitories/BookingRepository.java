package com.apiomat.csm.application.repisitories;

import com.apiomat.csm.application.entities.Booking;

public interface BookingRepository
{
	boolean existsBlockingBooking( final Booking booking );
}
