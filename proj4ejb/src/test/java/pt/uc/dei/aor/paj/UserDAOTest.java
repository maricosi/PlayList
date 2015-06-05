package pt.uc.dei.aor.paj;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pt.uc.dei.aor.paj.DAO.UserDAO;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UserDAOTest {
	 @Mock
	 Query q;
	 @Mock
	 EntityManager em;
	 
	 @InjectMocks
	 UserDAO user;
	 
	 @Test
	 public void testfindUsernamePass(){
		 String username="";
		 String password="";
		 
		when(em.createNamedQuery(Utilizador.FIND_BY_USERNAME_PASS)).thenReturn(q);
		user.findUsernamePass(username, password);
		verify(q).setParameter("username", username);
		verify(q).setParameter("password",password);
		verify(q).getResultList();
	 }
	 
	 
	 @Test
	 public void testfindUsername(){
		 String username="";
		 when(em.createNamedQuery(Utilizador.FIND_BY_USERNAME)).thenReturn(q);
		 user.findUsername(username);
		 verify(q).setParameter("username", username);
		 verify(q).getResultList();
		 
	 }

	 @Test
	 public void testfindEmail(){
		 String email="";		 
		 when(em.createNamedQuery(Utilizador.FIND_BY_EMAIL)).thenReturn(q);
		 user.findEmail(email);
		 verify(q).setParameter("email", email);
		 verify(q).getResultList();
	 }
	 

}
