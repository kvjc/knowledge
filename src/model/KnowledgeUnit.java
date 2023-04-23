package model;

public class KnowledgeUnit {

	private String id;
	private String description;
	private String type;
	private String learnedLessons;
	private String status;
	private TypeKU typeKU;
	private String cName;

	public KnowledgeUnit(String cName, String id, String description, TypeKU typeKU, String learnedLessons, String status) {

		this.id = id;
		this.description = description;
		this.typeKU = typeKU;
		this.learnedLessons = learnedLessons;
		this.cName = cName;
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

	public TypeKU getTypeKU() {
		return typeKU;
	}


	public void setTypeKU(TypeKU typeKU) {
		this.typeKU = typeKU;
	}
	


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public String toStringA(){

		String msg = "";

		msg = "\nid: " + id + "\ndescription: " + description;

		return msg;

	}


	@Override
	public String toString() {
		return "KnowledgeUnit [Collaborator's name = " + cName + "id=" + id + ", description=" + description + ", type=" + typeKU + ", learnedLessons="
				+ learnedLessons + ", status=" + status + "]";
	}

	

}
