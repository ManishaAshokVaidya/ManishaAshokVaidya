package HotelReservation.FinalEduProject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class HotelReservationMain 
{
	public static void main( String[] args )
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory=metadata.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		
		//System.out.println( "Hello World!" );
		
		//Create hotel object
		Hotel hotelReservation = new Hotel();
		hotelReservation.setHotelName("RamaInternational Hotel");
		hotelReservation.setRoomType("Deluxe");
		hotelReservation.setCheckInDate("2023-06-10");
		hotelReservation.setCheckOutDate("2023-06-15");
		hotelReservation.setReservationStatus("Confirmed");
		hotelReservation.setPaymentStatus("Paid");
		hotelReservation.setTotalCost(10000);
		
		//Create guest object
		Guest guest = new Guest();
		guest.setGuestName("Narendra Modi");
		guest.setGuestEmail("Narendramodi@gmail.com");
		Transaction transaction = null;
		try {
			// Start a new transaction
			transaction = session.beginTransaction();
			// Save the hotel reservation object
			session.save(hotelReservation);
			// save the guest object
			session.save(guest);
			// Commit the transaction
			transaction.commit();
			System.out.println("Hotel reservation saved successfully.");
			} catch (Exception e) {
				// Roll back the transaction if an error occurs
				if (transaction != null) 
				{
					transaction.rollback();
					}
				e.printStackTrace();
				} finally 
		{
					// Close the session
					session.close();
					}
		}
	}
