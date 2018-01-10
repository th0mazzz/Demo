public class userDrive{
    public static void main(String[] args){
	System.out.println("------------------------------------");
	User foo = new User("Bob");
	//System.out.println(foo);
        Subject a = new Subject("Precalc");
	foo.addSubject(a);
	System.out.println(foo.displayClasses());
	
	/*	
	try{
	    System.out.println("Inputted keyword: " + args[0]);
	    int levelCounter = 0;
	    System.out.println("levelCounter :" + levelCounter);
	    String keyword = args[0];
	    
	    if(levelCounter == 0 && keyword.equals("back")){
		System.out.println("You cannot go back anymore!");
		levelCounter++;
		System.out.println(levelCounter);
	    }
	    // Should also be an upperbounds on levelCounter
	
	    if(keyword.equals("back")){
		levelCounter--;
		System.out.println(levelCounter);
	    }
	    else{
		levelCounter++;
	    }
	    if(levelCounter == 0){
		System.out.println("Please type in a class from the following list");
		System.out.println(foo);
	    }
	    if(levelCounter == 1){
		for(int index = 0; index < foo.size(); index++){
		    if(keyword == foo.get(index).getName()){
			System.out.println(foo.get(index));
		    }
		}
		System.out.println("Please type a subcategory from the following list");
		    
	    }
	}catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("You must include a key word after 'java User'");
	}
	*/
    }
}
