public class Driver {	
	public static void main(String[] args){
        BuzzCard infor = new BuzzCard(1,12.5, 10.0);
        Student status = new Student(infor, "Thinh Nguyen", 903139168);
        SubwayItem test = SubwayItem.FOOTLONG;
        status.buySubwayBuzzFunds(test);
        System.out.println(status.toString());
	}
}