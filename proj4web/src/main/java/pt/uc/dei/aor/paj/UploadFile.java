package pt.uc.dei.aor.paj;

import java.io.IOException;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@MultipartConfig (location="/music/", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*100, maxRequestSize=1024*1024*5*5*50)
@ManagedBean
@ApplicationScoped
public class UploadFile {

	private Part file;
	private static final Logger logger = LoggerFactory.getLogger(UploadFile.class);

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
		String name=getFilename(this.file);
		

		this.path="/music/"+name;

		try {
			file.write(props.getProperty("user.dir")+"\\music\\"+name);
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}

		this.file=null;

		//		return this.path;
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
