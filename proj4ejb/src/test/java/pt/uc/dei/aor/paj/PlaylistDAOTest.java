package pt.uc.dei.aor.paj;


import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pt.uc.dei.aor.paj.DAO.PlaylistDAO;



@RunWith(MockitoJUnitRunner.class)
public class PlaylistDAOTest {
	 @Mock
	 Query qMocked;
	 @Mock
	 EntityManager em;
	 
	 @Mock
	 NamedQuery namedQueryMocked;
	 
	 @Mock
	 Playlist playlist;
	 @Mock 
	 Utilizador utilizador;
	 @Mock 
	 Music music;
	 
	 
	 @InjectMocks
	 PlaylistDAO playlistTest;
	
	 @Test
	 public void testDevolvePlaylistporNomeUtilizador(){
		 this.utilizador=new Utilizador();
		 String name="";
		 final String namedQueryMocked= Playlist.FIND_BY_NAME_UTILIZADOR;	 
		 when(em.createNamedQuery(namedQueryMocked)).thenReturn(qMocked);		 	
		 playlistTest.findNameUtilizador(name, utilizador);		 
		 verify(qMocked).setParameter("name", name);
		 verify(qMocked).setParameter("utilizador", utilizador);	 
		 verify(qMocked).getResultList();		 
	 }
	 
	 @Test
	 public void testDevolveTodasPlaylists(){
		 final String namedQueryMocked= Playlist.FIND_ALL;	 
		 when(em.createNamedQuery(namedQueryMocked)).thenReturn(qMocked);
		 playlistTest.all();	
		 verify(qMocked).getResultList();	
		 verify(em).createNamedQuery(namedQueryMocked);
	 }
	 
	 @Test
	 public void testOrdenaByNameASC(){
		 final String namedQueryMocked= Playlist.ORDER_BY_NAME_ASC;	 
		 when(em.createNamedQuery(namedQueryMocked)).thenReturn(qMocked);
		 playlistTest.orderByNameASC(utilizador);	
		 verify(qMocked).getResultList();	
		 verify(em).createNamedQuery(namedQueryMocked);
	 }
	 
	 
	 
//	
//		public List <Playlist> orderByNameASC(Utilizador utilizador){
//			Query q = em.createNamedQuery(Playlist.ORDER_BY_NAME_ASC);
//			q.setParameter("utilizador",utilizador);
//			return q.getResultList();
//		}
//		
//		@SuppressWarnings("unchecked")
//		public List <Playlist> orderByNameDESC(Utilizador utilizador){
//			Query q = em.createNamedQuery(Playlist.ORDER_BY_NAME_DESC);
//			q.setParameter("utilizador",utilizador);
//			return q.getResultList();
//		}
//		
//		@SuppressWarnings("unchecked")
//		public List <Playlist> orderByDateASC(Utilizador utilizador){
//			Query q = em.createNamedQuery(Playlist.ORDER_BY_DATE_ASC);
//			q.setParameter("utilizador",utilizador);
//			return q.getResultList();
//		}
//		
//		@SuppressWarnings("unchecked")
//		public List <Playlist> orderByDateDESC(Utilizador utilizador){
//			Query q = em.createNamedQuery(Playlist.ORDER_BY_DATE_DESC);
//			q.setParameter("utilizador",utilizador);
//			return q.getResultList();
//		}
//		
//		@SuppressWarnings("unchecked")
//		public List <Playlist> orderBySizeASC(Utilizador utilizador){
//			Query q = em.createNamedQuery(Playlist.ORDER_BY_SIZE_ASC );
//			q.setParameter("utilizador",utilizador);
//			return q.getResultList();
//		}
//		
//		@SuppressWarnings("unchecked")
//		public List <Playlist> orderBySizeDESC(Utilizador utilizador){
//			Query q = em.createNamedQuery(Playlist.ORDER_BY_SIZE_DESC );
//			q.setParameter("utilizador",utilizador);
//			return q.getResultList();	
//		}
//		
//
//		
//		@SuppressWarnings("unchecked")
//		public List<Playlist> findNameUtilizador(String name, Utilizador utilizador) {
//			Query q = em.createNamedQuery(Playlist.FIND_BY_NAME_UTILIZADOR);
//			   q.setParameter("name", name);
//		       q.setParameter("utilizador",utilizador);
//			return q.getResultList();
//		}
//
//
//		@SuppressWarnings("unchecked")
//		public List<Playlist> findByUtilizador(Utilizador utilizador) {
//			Query q = em.createNamedQuery(Playlist.FIND_BY_UTILIZADOR);
//		       q.setParameter("utilizador",utilizador);
//			return q.getResultList();
//		}

	 
	 
	 

	 

}
	 


