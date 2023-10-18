Forgive the bare bones readme!

* application.properties has two settings that can be toggled to "memory" or "database"
  * This can be used to show dependency injection (note @ConditionalOnProperty annotations in DAOs) 
* Database must be created and named HotelReservations (or you must edit application.properties)
* Hotel endpoints are intact and the controller has the @RestController annotation. These endpoints work:
  * http://localhost:8080/hotels
  * http://localhost:8080/hotels/1  (or any ID)