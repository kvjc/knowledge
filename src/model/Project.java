package model;

import java.util.Calendar;

import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.Stage;

import java.text.ParseException;


public class Project{

    private Stage stage; 
	
	private String projectName;
    private String projectClient;
    private String managerName;
    private String managerPhone;
    private double budget;
	private Calendar initialDate;
	private Calendar finalDate;
    private TypeProject typeProject;
    private Stage[] stages;

	private DateFormat formatter;

	public Project(String projectName, String projectClient, String managerName, String managerPhone,  double budget, Calendar initialDate, Calendar finalDate, TypeProject typeProject){
		
        this.stages = new Stage[6]; //[null,null,...,null]


        String[] sName = {"initiation", "planning", "design", "execution", "closure", "monitoring and control"};

        addStage(sName[0], initialDate, null, "Activa");
        addStage(sName[1], initialDate, finalDate, "Inactiva");
        addStage(sName[2], initialDate, finalDate, "Inactiva");
        addStage(sName[3], initialDate, finalDate, "Inactiva");
        addStage(sName[4], initialDate, finalDate, "Inactiva");
        addStage(sName[5], initialDate, finalDate, "Inactiva");

		this.formatter = new SimpleDateFormat("dd/MM/yy");
		this.projectName = projectName;
        this.projectClient = projectClient;
        this.managerName = managerName;
        this.managerPhone = managerPhone;
        this.budget = budget;
		this.initialDate = initialDate;
        this.typeProject=typeProject;
		this.finalDate = finalDate;
        
	}

    public boolean addStage(String name, Calendar initialDate, Calendar finalDate, String status){
        
        Stage newStage = new Stage(name, initialDate, finalDate, status);

        for(int i = 0; i<stages.length; i++){

            if(stages[i]==null){

                stages[i] = newStage;
                
                return true;
            }
            
        }

        return false; 
    }

    public void culminateStage(Calendar initialDate, Calendar finalDate, int stage){

    
        stages[stage-1].setFinalDateR(finalDate);
        stages[stage-1].setStatus("Inactiva");
        stages[stage].setInitialDateR(initialDate);
        stages[stage].setStatus("Activa");


    }

    public boolean addKnowledgeUnitToStage(String id, String description, String type, String learnedLessons, String status) {

		if(stage.addKU(id, description, type, learnedLessons, status)){
			return true;
		}

		return false;
	}

    

	public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    

    public String getProjectClient(){
        return projectClient;
    }
    public void setProjectClient(String projectClient){
        this.projectClient = projectClient;
    }


    public double getBudget(){
        return budget;
    }
    public void setBudget(double budget){
        this.budget = budget;
    }

    public String getManagerName(){
        return managerName;
    }
    public void setManagerName(String managerName){
        this.managerName = managerName;
    }

    
    public String ManagerPhone(){
        return managerPhone;
    }
    public void ManagerPhone(String managerPhone){
        this.managerPhone = managerPhone;
    }
	

	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated() throws ParseException{
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated() throws ParseException{
		return formatter.format(this.finalDate.getTime());
	}	
    
    public TypeProject getTypeProject(){
		return typeProject;
	}

	public Stage[] getStages() {
        return stages;
    }

    public void setStages(Stage[] stages) {
        this.stages = stages;
    }

    public String getProjectInfo() throws ParseException{
		return "\nProject's name: " + projectName + "\nProject's client: " + projectClient + "\nBudget: " +budget +"Manager name: "+managerName +"\nManager's phone: " +managerPhone +"\nFinal Date" + getFinalDateFormated() +"\nInitial Date" + getInitialDateFormated() +"Type: " +typeProject + ".\n";
	}

    public String getAllStages() throws ParseException {

		String msg = "";

	 	for(int i=0; i<stages.length; i++){

            if(stages[i]!=null){
            	msg += "\n" +stages[i].getProjectInfo();    
            }

        } 

		return msg;

	}
}


