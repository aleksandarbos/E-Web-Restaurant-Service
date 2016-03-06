package server.session;

import server.entity.KorisnikGost;
import server.entity.Prijatelji;

public interface FriendsDaoLocal {

	public void removeFriend(int userId, int friendId);
	
	public Prijatelji findPrijatelji(int userId, int friendId);

	public KorisnikGost addFriend(int personId, int userId);
}
