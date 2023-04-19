package model;

public class KnowledgeUnit {

	private String id;
	private String description;
	private String type;
	private String learnedLessons;
	private String status;

	public KnowledgeUnit(String id, String description, String type, String learnedLessons, String status) {

		this.id = id;
		this.description = description;
		this.type = type;
		this.learnedLessons = learnedLessons;
		this.status = "Por definir";
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}

	public String getStatus(String status){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}
	
	public String toString(){

		String msg = "";

		msg = "\nid: " + id + "\ndescription: " + description + "\nType: " +type +"LearnedLesson: "+learnedLessons +"\nStatus: " +status +"\n";

		return msg;
	}

	public String toStringA(){

		String msg = "";

		msg = "\nid: " + id + "\ndescription: " + description;

		return msg;

	}

}
