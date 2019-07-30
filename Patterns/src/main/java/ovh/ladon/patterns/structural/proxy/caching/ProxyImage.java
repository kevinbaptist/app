package ovh.ladon.patterns.structural.proxy.caching;

public class ProxyImage implements Image {
	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName){
		this.fileName = fileName;
	}

	@Override
	public String getImage() {
		if(realImage == null){
			realImage = new RealImage(fileName);
		}
		return realImage.getImage();
	}
}
