package pt.uc.dei.aor.paj;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pt.uc.dei.aor.paj.DAO.MusicDAO;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MusicDAOTest {
	 @Mock
	 Query q;
	 @Mock
	 EntityManager em;
	 
	 @InjectMocks
	 MusicDAO music;
	 
	

}
