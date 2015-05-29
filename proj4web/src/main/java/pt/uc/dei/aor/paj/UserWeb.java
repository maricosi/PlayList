package pt.uc.dei.aor.paj;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pt.uc.dei.aor.paj.fachada.IntUserFachada;

@Named
@RequestScoped
public class UserWeb {
		@EJB
		private IntUserFachada user;
	
		private String name;
		private String username;
		private String email;
		private String password;
		private String menssagem="";

		public UserWeb() {
			super();
		}
		
		
}

