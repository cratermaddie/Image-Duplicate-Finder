import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileWithHash {
	
	private String fileName, hash;
	private boolean dup = false;
	private FileInputStream fis;
	private ImagePHash pHash = new ImagePHash();
	
	public FileWithHash(File inFile) throws Exception{
		
		fis = new FileInputStream(inFile);
		
		fileName = inFile.getName();
		hash = pHash.getHash(fis);
	}
	
	public boolean isSimilar(FileWithHash innerImage){
		if(fileName.contains(".webm") && pHash.distance(hash, innerImage.getHash()) == 0){
			return true;
		}
		else if(pHash.distance(hash, innerImage.getHash()) < 5)
			return true;
		return false;
	}
	
	public String getFileName(){
		return fileName;
	}
	public String getHash(){
		return hash;
	}
	public boolean isDup(){
		return dup;
	}
	public void setDup(){
		dup = true;
	}
	public void close() throws IOException{
		fis.close();
	}

}
