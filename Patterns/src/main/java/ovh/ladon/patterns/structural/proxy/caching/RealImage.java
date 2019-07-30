package ovh.ladon.patterns.structural.proxy.caching;

public class RealImage implements Image {
	private String fileName;
	private boolean loadedFromDisk = false;

	RealImage(String fileName){
		this.fileName = fileName;
		loadFromDisk();
	}

	@Override
	public String getImage() {
		return "Displaying " + fileName;
	}

	private void loadFromDisk(){
		loadedFromDisk = true;
	}

	public boolean isLoadedFromDisk() {
		return loadedFromDisk;
	}
}
