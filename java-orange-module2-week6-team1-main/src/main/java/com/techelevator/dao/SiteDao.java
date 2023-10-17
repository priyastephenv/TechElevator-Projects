package com.techelevator.dao;

import com.techelevator.model.Site;

import java.util.List;

public interface SiteDao {

	/**
	 * Get all sites that allow RVs in a park with the given id.
	 * A site allows RVs if its max RV length is greater than 0.
	 * If no sites are found, return an empty List.
	 * 
	 * @param parkId the id of the park to retrieve sites from
	 * @return a List of Site objects
	 */
    List<Site> getSitesWithRVAccessByParkId(int parkId);

    /**
	 * Get all sites that DO NOT have a reservation (from_date, to_date)
	 * across and including the current day. Examples:
	 *   reservation = from August 11, 2023 to August 13, 2023
	 *   if the current day is: August 11, 2023, August 12, or August 13
	 *   -> DO NOT include this site in the returned list
	 * If no sites are found, return an empty List.
	 *
	 * @param parkId the id of the park to retrieve sites from
	 * @return a List of Site objects
	 */

    List<Site> getSitesWithoutReservationByParkId(int parkId);
}
