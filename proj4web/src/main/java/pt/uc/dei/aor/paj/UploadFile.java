package pt.uc.dei.aor.paj;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

@ManagedBean
@ApplicationScoped
public class UploadFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5537671907313363474L;

	private Part file;

	private String path;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	//Cuidado com as excepções
	public void upload() {
		Properties props = System.getProperties();

		Random r=new Random();

		String name="my_music"+r.nextInt(1000);

		this.path="/music/"+name+".mp3";

		try {
			file.write(props.getProperty("user.dir")+"\\music\\"+name+".mp3");
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.file=null;
	}

	private static String getFilename(Part part) {  
		for (String cd : part.getHeader("content-disposition").split(";")) {  
			if (cd.trim().startsWith("filename")) {  
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");  
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.  
			}
		}
		return null;  
	}

}
