import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KMeans {

	List<Record> data = new ArrayList<Record>();
	List<Cluster> clusters = new ArrayList<Cluster>();
	Map<Cluster, List<Record>> clusterRecords = new HashMap<Cluster, List<Record>>();
	
	public static void main(String[] args) {
		
		int clusterNumber = 2;
		KMeans demo = new KMeans();
		demo.genereateRecord();
		demo.initiateClusterAndCentroid(clusterNumber);
		demo.printRecordInformation();
		demo.printClusterInformation();
	}
	
	private void genereateRecord() {
		Record record = new Record(1, 19, 15, 39);
		data.add(record);
		record = new Record(2, 21, 15, 81);
		data.add(record);
		record = new Record(3, 20, 16, 6);
		data.add(record);
		record = new Record(4, 23, 16, 77);
		data.add(record);
		record = new Record(5, 31, 17, 40);
		data.add(record);
		record = new Record(6, 22, 17, 76);
		data.add(record);
		
	}

	private void initiateClusterAndCentroid(int clusterNumber) {
		int counter = 1;
		Iterator<Record> iterator = data.iterator();
		Record record = null;
		
		while(iterator.hasNext()) {
			record = iterator.next();
			if(counter <= clusterNumber) {
				record.setClusterNumber(counter);
				initializeCluster(counter, record);
				counter++;
			}else {
				System.out.println(record);
				System.out.println("** Cluster Information **");
				for(Cluster cluster : clusters) {
					System.out.println(cluster);
				}
				System.out.println("*********************");
                double minDistance = Integer.MAX_VALUE;
                Cluster whichCluster = null;
                
                for(Cluster cluster : clusters) {
                	double distance = cluster.calculateDistance(record);
                	System.out.println(distance);
                	if(minDistance > distance) {
                		minDistance = distance;
                		whichCluster = cluster;
                	}
                }
                
                record.setClusterNumber(whichCluster.getClusterNumber());
				whichCluster.updateCentroid(record);
				clusterRecords.get(whichCluster).add(record);

			}
			
			System.out.println("** Cluster Information **");
			for(Cluster cluster : clusters) {
				System.out.println(cluster);
			}
			System.out.println("*********************");

			
		}

	}

	private void initializeCluster(int clusterNumber, Record record) {
		
		Cluster cluster = new Cluster(clusterNumber,record.getAge(),record.getIncome(),record.getScore());
		clusters.add(cluster);
		List<Record> clusterRecord = new ArrayList<Record>();
		clusterRecord.add(record);
		clusterRecords.put(cluster, clusterRecord);

	}

	private void printRecordInformation() {
		   System.out.println("****** Each Record INFORMATIN *********");
		   for(Record record : data) {
			   System.out.println(record);
		   }
	   }

	private void printClusterInformation() {
	   System.out.println("****** FINAL CLUSTER INFORMATIN *********");
	   for (Map.Entry<Cluster, List<Record>> entry : clusterRecords.entrySet())  {
        System.out.println("Key = " + entry.getKey() + 
                         ", Value = " + entry.getValue()); 
    }
}


}
