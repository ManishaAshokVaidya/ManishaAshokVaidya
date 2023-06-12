package HotelReservation.FinalEduProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guests")
public class Guest 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int GuestId;
	private String guestName;
	private String guestEmail;
	public int getGuestId() {
		return GuestId;
	}
	public void setGuestId(int guestId) {
		GuestId = guestId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	

}
