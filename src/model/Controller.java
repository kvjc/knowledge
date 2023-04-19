package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.event.SwingPropertyChangeSupport;
import model.Stage;
import model.Project;

public class Controller {

	private Project[] projects;
//	private KnowledgeUnit[] units;
	
	private Stage stage;
	private Project project;
	
	
	

	public Controller() {

	//	units = new KnowledgeUnit[25];
		projects = new Project[10];
		testCases();
	
	}
	
	public void testCases(){
		//units[0] = new KnowledgeUnit("A001", "Gestion de repositorios", "Tecnico", "GitHub es una herramienta util", "aprobada");
		//units[1] = new KnowledgeUnit("A002", "Gestion de equipos", "Experiencias", "Es importante definir responsabilidades claras","aprobada");
		//projects[0] = new Project("h", "h", "s", "100", 10, null, null, null);
	}


	public boolean registerProject(String projectName, String projectClient, String managerName, String managerPhone, double budget , int iDay, int fDay, int iMonth, int fMonth, int iYear, int fYear, int type) {

		Calendar initialDate = new GregorianCalendar(iYear, iMonth-1, iDay);
		Calendar finalDate = new GregorianCalendar(fYear, fMonth-1, fDay);
		
		TypeProject typeP= TypeProject.DEVELOPMENT;
        if (type==1){
            typeP= TypeProject.DEVELOPMENT;
        }
        else if (type==2){
            typeP=TypeProject.MAINTENANCE;
        }
		else{
			typeP=TypeProject.DEPLOYMENT;
		}

		Project newProject = new Project(projectName, projectClient, managerName, managerPhone, budget, initialDate, finalDate, typeP);

		for(int i = 0; i<projects.length; i++){

            if(projects[i]==null){

                projects[i] = newProject;

                return true;
            }
            
        }

		return false;
	}


	public String searchProjectsAfterDate(int cYear, int cMonth, int cDay) throws ParseException {

		Calendar consultDate = new GregorianCalendar(cYear, cMonth-1, cDay);

		String msg = "";

		for(int i = 0; i<projects.length; i++){
			
			int val = 0;
	
			if (projects[i]!=null){
				val = projects[i].getInitialDate().compareTo(consultDate);
	
				if(val == 1){
					msg = "\n" +projects[i].getProjectInfo(); 
				}
			}
        }

		return msg;

	}
	
	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsBeforeDate(int cYear, int cMonth, int cDay) throws ParseException {

		Calendar consultDate = new GregorianCalendar(cYear, cMonth-1, cDay);

		String msg = "";

		for(int i = 0; i<projects.length; i++){
			
			int val = 0;

			val = projects[i].getFinalDate().compareTo(consultDate);

			if (projects[i]!=null){
				val = projects[i].getInitialDate().compareTo(consultDate);
	
				if(val == 1){
					msg = "\n" +projects[i].getProjectInfo(); 
				}
			}
            
        }

		return msg;

	}

	
	/**
	*Description: This method allows to register knowledge capsules. 
	*@param: id String firs string containing the capsule identficator, description String second string containing the capsule description
			 type String third string containing the capsule type, learnedLessons String fourth string containing the capsule learnedLessons
	*@return: boolean condition
	*/
	
	public boolean registerKnowledgeUnit(int project, int stage, String id, String description, String type, String learnedLessons, String status) {

		return projects[project].getStages()[stage].addKU(id, description, type, learnedLessons, status);

	}

		/**
	*Description: This method allows to approve of knowledge capsules. 
	*@param: posicion int first integer, status String first string containing the capsule status
	*@return: 
	*/
	
	public void approveKnowledgeUnit(int posicionProyecto, int posicionEtapa, int posicionKU, String status) {

		projects[posicionProyecto].getStages()[posicionEtapa].approveKnowledgeUnit(posicionKU, status);

	}

	/**
	*Description: This method allows to modify knowledge capsules. 
	*@param: mod String second string contains the new information, atributo int firs integer contains the type of change, posicion int first integer contains the position of the capsule
	*@return: 
	*/

	public void modifcarCapsula(int posicionProyecto, int posicionEtapa, int posicion, int atributo, String mod){

		projects[posicionProyecto].getStages()[posicionEtapa].modifcarCapsula(posicion, atributo, mod);
		

	}

	
	
			/**
	*Description: This method allows to show all knowledge capsules. 
	*@param: msg String firs string contains all capsule information
	*@return: msg String contains all capsule information
	*/
	public String getAllKnowledgeUnits(int posicionProyecto, int posicionEtapa) {
		
		return projects[posicionProyecto].getStages()[posicionEtapa].getAllKnowledgeUnits();

	}

	/**
	*Description: This method allows to show all knowledge capsules. 
	*@param: msg String contains the capsule ID and description
	*@return: msg String contains the capsule ID and description
	*/

	public String getKnowledgeUnits(int posicionProyecto, int posicionEtapa){

		return projects[posicionProyecto].getStages()[posicionEtapa].getKnowledgeUnits();
	}

	/**
	*Description: This method allows to show a specific knowledge capsules. 
	*@param: msg String firs string contains all capsule information
	*@return: msg String contains all capsule information
	*/


	public String getSpecificKnowledgeUnits(int posicion, int posicionProyecto, int posicionEtapa){

		return projects[posicionProyecto].getStages()[posicionEtapa].getSpecificKnowledgeUnits(posicion);
	}



	public String getAllProjects() throws ParseException {

		String msg = "";

	 	for(int i=0; i<projects.length; i++){

            if(projects[i]!=null){
            	msg += "\n" +projects[i].getProjectInfo();    
            }

        } 

		return msg;

	}

	public String getAllStages(int posicionProyecto) throws ParseException{
		
		return projects[posicionProyecto-1].getAllStages();
	}

	public void culminateStage(int sDay, int sMonth, int sYear){
		Calendar initialDate = new GregorianCalendar(sYear, sMonth-1, sDay);
		Calendar finalDate = new GregorianCalendar(sYear, sMonth-1, sDay);

	}

	public void  addStage(int fYearR, int fMonthR, int fDayR){
		Calendar initialDateR = new GregorianCalendar(fMonthR, fMonthR-1, fDayR);
		Calendar finalDateR = new GregorianCalendar(fMonthR, fMonthR-1, fDayR);
	}
}
