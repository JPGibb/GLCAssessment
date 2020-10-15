
public class CD extends Stock {
	
	//Declaring attributes
	private int runTime;
	private int noTracks;
	private String caseType;
	private String artist;
	private String cdType;
	
	//Class constructor
	public CD(String name, String desc,String toc, String a, String type, int tracks, float r, double c, int nextSId) {
		stockId = nextSId;
		//nextStockId++;
		itemName = name;
		itemDescription  = desc;
		cost = c;
		itemType = "CD";
		
	}
	
	//Returns the runtime as a float
	public float getRunTime() {
		return runTime;
	}
	
	//Returns the number of tracks as an int
	public int getNoTracks() {
		return noTracks;
	}
}
