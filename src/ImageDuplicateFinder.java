import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageDuplicateFinder {

	public static void main(String[] args) {
		
		int dups = 0, files = 0;
		
		File folder = new File("C:/Users/crate/Documents/");
		File[] listOfFiles = folder.listFiles();
		
		List<FileWithHash> listWithHash = new ArrayList<FileWithHash>();
		
		
		for(File file: listOfFiles){
			try {
				files++;
				//System.out.println("Creating new file with hash");
				listWithHash.add(new FileWithHash(file));
			} catch (Exception e) {
				System.err.println("File not found");
			}
		}
		
		for(int outer = 0; outer < listWithHash.size(); outer++){
			System.out.println("Testing " + listWithHash.get(outer).getFileName() + ":");
			
			FileWithHash outerImage = listWithHash.get(outer);
			
			for(int inner = outer+1; inner < listWithHash.size(); inner++){
				
				FileWithHash innerImage = listWithHash.get(inner);
				
				if(outerImage.isSimilar(innerImage) && !listWithHash.get(inner).isDup()){
					dups++;
					System.err.println("\t" + listWithHash.get(inner).getFileName());
					listWithHash.get(inner).setDup();
				}
				try {
					listWithHash.get(outer).close();
				} catch (IOException e) {
					System.err.println("File not found");
				}
			}
		}
		
		System.out.println(files + " scanned. " + dups + " duplicate(s) found.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		String[] test1 = {"Hello", "World", "test", "marx", "next", "table", "test", "My", "Name", "is", "Hello", "Joe", "Hello", "World"};
//		
//		for(int x = 0; x<test1.length; x++){
//			System.out.println("Testing " + test1[x] + ":");
//			for(int y = x+1; y<test1.length; y++){
//				if(x!=y && test1[x].equals(test1[y])){
//					System.out.println("\t" + test1[y]);
//				}
//			}
//		}
		
		
	}
}
