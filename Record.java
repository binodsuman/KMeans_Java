
public class Record {
	
	private int id;
	private int age;
	private int income;
	private int score;
	private int clusterNumber;
	
	
	
	
	public Record(int id, int age, int income, int score) {
		super();
		this.id = id;
		this.age = age;
		this.income = income;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", age=" + age + ", income=" + income + ", score=" + score + ", clusterNumber="
				+ clusterNumber + "]";
	}

	

}
