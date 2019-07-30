package ovh.ladon.patterns.structural.proxy.protection;




public class SmallPrison implements PrisonBuilding {

	@Override
	public void enter(Thief thief) {
		System.out.println("The thief " + thief + " entered the small prison");
	}
}
