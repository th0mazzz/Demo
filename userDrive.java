public class userDrive{
    public static void main(String[] args){
	System.out.println("------------------------------------");
	User foo = new User("Bob");
	//System.out.println(foo);
        Subject a = new Subject("Precalc");
	foo.addSubject(a);
	System.out.println(foo.displayClasses());
	System.out.println(foo);
    }
}
