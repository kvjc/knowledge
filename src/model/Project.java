package model;

import java.util.Arrays;
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
    private int numKU;

	private DateFormat formatter;

    

	public Project(String projectName, String projectClient, String managerName, String managerPhone,  double budget, Calendar initialDate, Calendar finalDate, TypeProject typeProject, int numKU){
		
        this.stages = new Stage[6]; //[null,null,...,null]

        

        String[] sName = {"Initiation", "Planning", "Design", "Execution", "Closure", "Monitoring and Control"};
        

        addStage(sName[0], initialDate, null,  null,  "Activa");
        addStage(sName[1], initialDate, finalDate, null,"Inactiva");
        addStage(sName[2], initialDate, finalDate, null,"Inactiva");
        addStage(sName[3], initialDate, finalDate, null,"Inactiva");
        addStage(sName[4], initialDate, finalDate, null,"Inactiva");
        addStage(sName[5], initialDate, finalDate,null, "Inactiva");

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


    public boolean addStage(String name, Calendar initialDateR, Calendar finalDateR, Calendar finalDateP, String status){
        
        Stage newStage = new Stage(name, initialDateR, finalDateR, finalDateP, status);

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

    public boolean addKnowledgeUnitToStage(String cName, String id, String description, int typeKU, String learnedLessons, String status) {

		if(stage.addKU(cName, id, description, typeKU, learnedLessons, status)){
			return true;
		}

        setNumKU(+1);
    

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

    

    public int getNumKU() {
        return numKU;
    }


    public void setNumKU(int numKU) {
        this.numKU = numKU;
    }


    public String getProjectInfo() throws ParseException{
		return "\nProject's name: " + projectName + "\nProject's client: " + projectClient + "\nBudget: " +budget +"Manager name: "+managerName +"\nManager's phone: " +managerPhone +"\nFinal Date: " + getFinalDateFormated() +"\nInitial Date: " + getInitialDateFormated() +"\nType: " +typeProject + ".\n";
	}

    public String getAllStages() throws ParseException {

		String msg = "";

	 	for(int i=0; i<stages.length; i++){

            if(stages[i]!=null){
            	msg += "\n" +stages[i].getStageInfo();    
            }

        } 

		return msg;

	}

    @Override
    public String toString() {
        return "Project \nstage=" + stage + " \nprojectName=" + projectName + "\nprojectClient=" + projectClient
                + "\nmanagerName=" + managerName + "\nmanagerPhone=" + managerPhone + "\nbudget=" + budget
                + "\ninitialDate=" + initialDate + "\nfinalDate=" + finalDate + "\ntypeProject=" + typeProject
                + "\nstages=" + Arrays.toString(stages) + "\nformatter=" + formatter + "\n";
    }



    
}


