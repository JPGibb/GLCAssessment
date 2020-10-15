
public class Video extends Stock {
	
	//Declaring attributes
	private String typeOfCase;
	private int runTime;
	private String videoFormat;
	
	//Class constructor
	public Video(String t, String desc, String toc, String f, int r, double c, int nextSid) {
		stockId = nextSid;
		//nextStockId++;
		itemName = t;
		itemDescription = desc;
		typeOfCase = toc;
		videoFormat = f;
		runTime = r;
		cost = c;		
		itemType = "Video";
	}
	
	//Returns the runtime as a float
	public float getRunTime() {
		return runTime;
	}
	
	//Returns the video format as a string
	public String getFormat() {
		return videoFormat;
	}
}
