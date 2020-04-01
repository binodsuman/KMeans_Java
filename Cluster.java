
public class Cluster {

	private int ageCentroid;
	private int incomeCentroid;
	private int scoreCentroid;
	private int clusterNumber;
	
	
	
	public Cluster(int clusterNumber, int ageCentroid, int incomeCentroid, int scoreCentroid) {
		super();
		this.clusterNumber = clusterNumber;
		this.ageCentroid = ageCentroid;
		this.incomeCentroid = incomeCentroid;
		this.scoreCentroid = scoreCentroid;
	}
	
	public int getAgeCentroid() {
		return ageCentroid;
	}
	public void setAgeCentroid(int ageCentroid) {
		this.ageCentroid = ageCentroid;
	}
	public int getIncomeCentroid() {
		return incomeCentroid;
	}
	public void setIncomeCentroid(int incomeCentroid) {
		this.incomeCentroid = incomeCentroid;
	}
	public int getScoreCentroid() {
		return scoreCentroid;
	}
	public void setScoreCentroid(int scoreCentroid) {
		this.scoreCentroid = scoreCentroid;
	}
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}

	@Override
	public String toString() {
		return "Cluster [ageCentroid=" + ageCentroid + ", incomeCentroid=" + incomeCentroid + ", scoreCentroid="
				+ scoreCentroid + ", clusterNumber=" + clusterNumber + "]";
	}
	
	// Euclidean distance calculation
	public double calculateDistance(Record record) {
		return Math.sqrt(Math.pow((getAgeCentroid() - record.getAge()), 2) + Math.pow((getIncomeCentroid() - record.getIncome()),2) + Math.pow((getScoreCentroid() - record.getScore()), 2));
    }

	// Binod Suman Academy YouTube Video on K-Mean Algorithm
	public void updateCentroid(Record record) {
		setAgeCentroid((getAgeCentroid()+record.getAge())/2);
		setIncomeCentroid((getIncomeCentroid()+record.getIncome())/2);
		setScoreCentroid((getScoreCentroid()+record.getScore())/2); 
	}

}
