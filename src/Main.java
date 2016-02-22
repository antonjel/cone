import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	
	public static void main(String[] args) {
		List<String> inputData = new ArrayList<>();
		List<Square> listOfSquares = new ArrayList<>();
		inputData = readFile();
		listOfSquares = buildSquares(inputData);
		
		Board board = new Board(listOfSquares);
		board.analyse(); 
		
		permute(listOfSquares);
		
	}

	public static void permute(List<Square> listOfSquares){
	    permuteHelper(listOfSquares, 0);
	}

	private static void permuteHelper(List<Square> listOfSquares, int index){
	    if(index >= listOfSquares.size() - 1){
	        List<Square> updatedList = new ArrayList<>();

	        for(int i = 0; i < listOfSquares.size() - 1; i++){
	        	updatedList.add(listOfSquares.get(i));
	        }
	        if(listOfSquares.size() > 0) 
	        	updatedList.add(listOfSquares.get(listOfSquares.size()-1));
	        
			Board board = new Board(updatedList);
			board.analyse(); 
	        
	        return;
	    }

	    for(int i = index; i < listOfSquares.size(); i++){

	        Square t = listOfSquares.get(index);
	        listOfSquares.set(index, listOfSquares.get(i));
	        listOfSquares.set(i, t);

	        permuteHelper(listOfSquares, index+1);

	        t = listOfSquares.get(index);
	        listOfSquares.set(index, listOfSquares.get(i));
	        listOfSquares.set(i, t);
	    }
	}
	
	private static List<String> readFile(){
		List<String> list = new ArrayList<>();
		String file = "input.txt";
		
		try(BufferedReader br = Files.newBufferedReader(Paths.get(file))){
			list = br.lines().collect(Collectors.toList());
		} catch (IOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	private static List<Square> buildSquares(List<String> inputData){
		List<Square> listOfSquares = new ArrayList<>();
		for(String line : inputData){	
			if(line.length() == 7){
				int topLeft, topRight, bottomLeft, bottomRight;
				topLeft = Character.getNumericValue(line.charAt(0));
				topRight = Character.getNumericValue(line.charAt(2));
				bottomLeft = Character.getNumericValue(line.charAt(4));
				bottomRight = Character.getNumericValue(line.charAt(6));
				listOfSquares.add(new Square(topLeft, topRight, bottomLeft, bottomRight));
			}
		}
		return listOfSquares;
	}


}
