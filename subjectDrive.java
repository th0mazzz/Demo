public class subjectDrive{
        public static void main(String[] args){
	Subject n = new Subject("foo");
	System.out.println(n);
	n.setName("APCS");
	System.out.println(n.getName());
	Subcategory abcd = new Subcategory("Participation", 20.0);
	Subcategory tests = new Subcategory("Tests", 60.0);
	Subcategory quizzes = new Subcategory("Quizzes", 0.0);
	Subcategory projects = new Subcategory("Projects", 0.0);
	n.addSubCat(abcd);
	n.addSubCat(tests);
	n.addSubCat(quizzes);
	n.addSubCat(projects);
	//System.out.println(n.collection.size());
	System.out.println(n.checkSubcategorySum());
    }
}
