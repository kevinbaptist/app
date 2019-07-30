package ovh.ladon.patterns.structural.proxy.protection;

public class PrisonBuildingProxy implements PrisonBuilding {
	private final PrisonBuilding prisonBuilding;
	private static final int MAX_PRISIONERS_ALLOWED = 3;
	private int numPrisioners;

	public PrisonBuildingProxy(PrisonBuilding prisonBuilding) {
		this.prisonBuilding = prisonBuilding;
	}

	@Override
	public void enter(Thief thief) {
		if (numPrisioners < MAX_PRISIONERS_ALLOWED) {
			prisonBuilding.enter(thief);
			numPrisioners++;
		} else {
			System.out.println(thief + " is not allowed to enter!");
			throw new IllegalArgumentException(thief + "is not allowed to enter!");
		}
	}
}
