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

		Calendar initialDate = new GregorianCalendar(2023, 03, 12);
		Calendar finalDate = new GregorianCalendar(2024, 03, 12);
		
		projects[0] = new Project("1", "h", "s", "100", 10, initialDate, finalDate, TypeProject.DEPLOYMENT,10);
		projects[1] = new Project("2", "h", "s", "100", 10, initialDate, finalDate, TypeProject.DEPLOYMENT,10);
	}


	public boolean registerProject(String projectName, String projectClient, String managerName, String managerPhone, double budget , int iDay, int fDay, int iMonth, int fMonth, int iYear, int fYear, int type, int numKU) {

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

		Project newProject = new Project(projectName, projectClient, managerName, managerPhone, budget, initialDate, finalDate, typeP, numKU);

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
	
	public boolean registerKnowledgeUnit(int project, int stage, String cName, String id, String description, int typeKU, String learnedLessons, String status) {

		return projects[project-1].getStages()[stage-1].addKU(cName, id, description, typeKU, learnedLessons, status);

	}

		/**
	*Description: This method allows to approve of knowledge capsules. 
	*@param: posicion int first integer, status String first string containing the capsule status
	*@return: 
	*/
	
	public void approveKnowledgeUnit(int posicionProyecto, int posicionEtapa, int posicionKU, String status) {

		projects[posicionProyecto-1].getStages()[posicionEtapa-1].approveKnowledgeUnit(posicionKU-1, status);

	}

	/**
	*Description: This method allows to modify knowledge capsules. 
	*@param: mod String second string contains the new information, atributo int firs integer contains the type of change, posicion int first integer contains the position of the capsule
	*@return: 
	*/

	public void modifcarCapsula(int posicionProyecto, int posicionEtapa, int posicion, int atributo, String mod){


		projects[posicionProyecto-1].getStages()[posicionEtapa-1].modifcarCapsula(posicion, atributo, mod);
		

	}

	
	
			/**
	*Description: This method allows to show all knowledge capsules. 
	*@param: msg String firs string contains all capsule information
	*@return: msg String contains all capsule information
	*/
	public String getAllKnowledgeUnits(int posicionProyecto, int posicionEtapa) {
		
		return projects[posicionProyecto-1].getStages()[posicionEtapa-1].getAllKnowledgeUnits();

	}

	/**
	*Description: This method allows to show all knowledge capsules. 
	*@param: msg String contains the capsule ID and description
	*@return: msg String contains the capsule ID and description
	*/

	public String getKnowledgeUnits(int posicionProyecto, int posicionEtapa){

		return projects[posicionProyecto-1].getStages()[posicionEtapa-1].getKnowledgeUnits();
	}

	/**
	*Description: This method allows to show a specific knowledge capsules. 
	*@param: msg String firs string contains all capsule information
	*@return: msg String contains all capsule information
	*/


	public String getSpecificKnowledgeUnits(int posicion, int posicionProyecto, int posicionEtapa){

		return projects[posicionProyecto-1].getStages()[posicionEtapa-1].getSpecificKnowledgeUnits(posicion-1);
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

	public void culminateStage(int posicionProyecto, int posicionEtapa, int sDay, int sMonth, int sYear){

		Calendar initialDateR = new GregorianCalendar(sYear, sMonth-1, sDay);
		Calendar finalDateR = new GregorianCalendar(sYear, sMonth-1, sDay);

		projects[posicionProyecto-1].culminateStage(initialDateR, finalDateR, posicionEtapa);
		

	}

	public void  addStage(int fYearR, int fMonthR, int fDayR, int month, int inMonth, int plMonth, int deMonth, int exMonth, int clMonth, int macMonth){
		Calendar initialDateR = new GregorianCalendar(fMonthR, fMonthR-1, fDayR);
		Calendar finalDateR = new GregorianCalendar(fMonthR, fMonthR-1, fDayR);
		Calendar finalDatePIn = (Calendar)finalDateR.clone();
	
		finalDateR.add(Calendar.MONTH, month);
		finalDatePIn.add(Calendar.MONTH, inMonth);

		Calendar finalDatePPl = (Calendar)finalDatePIn.clone();
		finalDatePPl.add(Calendar.MONTH, plMonth);
		Calendar finalDatePDe = (Calendar)finalDatePPl.clone();
		finalDatePDe.add(Calendar.MONTH, deMonth);
		Calendar finalDatePEx = (Calendar)finalDatePDe.clone();
		finalDatePEx.add(Calendar.MONTH, exMonth);
		Calendar finalDatePCl = (Calendar)finalDatePEx.clone();
		finalDatePCl.add(Calendar.MONTH, clMonth);
		Calendar finalDatePMac = (Calendar)finalDatePCl.clone();
		finalDatePMac.add(Calendar.MONTH, macMonth);
	
	}

	public String typeKu(){

		String msg = "";

		int tCounter = 0;
		int mCounter = 0;
		int dCounter = 0;
		int eCounter = 0;

		for(int i=0; i < projects.length; i++){

			if(projects[i]!= null){

				for(int x=0; x < projects[i].getStages().length; x++){

					if(projects[i].getStages()[x]!= null){

		

						for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++ ){

							if(projects[i].getStages()[x].getUnits()[y] != null){

								if(projects[i].getStages()[x].getUnits()[y].getTypeKU().equals(TypeKU.TECHNICAL)){
									tCounter+=1;

								}else if(projects[i].getStages()[x].getUnits()[y].getTypeKU().equals(TypeKU.MANAGEMENT)){
									mCounter+=1;

								}else if(projects[i].getStages()[x].getUnits()[y].getTypeKU().equals(TypeKU.EXPERIENCES)){
									eCounter+=1;

								}else{
									dCounter+=1;
								}

							}
						}

					}
				}
			}
		}

		msg = "\n" + "\nTECHNICAL: " +tCounter +"\nMANAGEMENT: "+mCounter +"\nEXPERIENCES: "+eCounter +"\nEXPERIENCES: " +"\nDOMAIN: " +dCounter;

		return msg;
	}

	public String  lessonKU(int posicionP, int posicionS){

		String msg = "";

			if(projects[posicionP].getStages()[posicionS]!= null){

				for(int y = 0; y < projects[posicionP].getStages()[posicionS].getUnits().length; y++ ){

					if(projects[posicionP].getStages()[posicionS].getUnits()[y] != null){

						msg += "\n" +"Id: " + projects[posicionP].getStages()[posicionS].getUnits()[y].getId() + "\nLeaned lesson: " +projects[posicionP].getStages()[posicionS].getUnits()[y].getLearnedLessons();
									
					}
				}

			}

			return msg; 
			
		}

		public String numKU(){

			int[] numPKU = new int[projects.length];
			int maxIndex = 0;
			for (int i = 0; i < projects.length; i++) {
				if (projects[i] != null) {
					numPKU[i] = projects[i].getNumKU();
					if (numPKU[i] > numPKU[maxIndex]) {
						maxIndex = i;
					}
				}
			}

			return projects[maxIndex].getProjectName();
		}

		public boolean findName(String cName) {

			for (int i = 0; i < projects.length; i++) {

				if (projects[i] != null) {

					for (int x = 0; x < projects[i].getStages().length; x++) {

						if (projects[i].getStages()[x] != null) {

							for (int y = 0; y < projects[i].getStages()[x].getUnits().length; y++) {

								if (projects[i].getStages()[x].getUnits()[y] != null) {

									String unitName = projects[i].getStages()[x].getUnits()[y].getcName();

									if (unitName != null && unitName.equalsIgnoreCase(cName)) {

										return true;
									}
								}
							}
						}
					}
				}
			}
			return false;
		}

		public String findDesLess(String information) {

			String msg = "";

			for (int i = 0; i < projects.length; i++) {

				if (projects[i] != null) {

					for (int x = 0; x < projects[i].getStages().length; x++) {

						if (projects[i].getStages()[x] != null) {

							for (int y = 0; y < projects[i].getStages()[x].getUnits().length; y++) {

								if (projects[i].getStages()[x].getUnits()[y] != null) {

									String informationdes = projects[i].getStages()[x].getUnits()[y].getDescription();
									String informationles = projects[i].getStages()[x].getUnits()[y].getLearnedLessons();

									if (informationdes != null && informationdes.contains(information) || informationles != null && informationles.contains(information) ) {
										msg += "\n" +"Id: " + projects[i].getStages()[x].getUnits()[y].getId() + "\nLeaned lesson: " +projects[i].getStages()[x].getUnits()[y].getLearnedLessons() +"\nDescription: " +projects[i].getStages()[x].getUnits()[y].getDescription();

										
									}
								}
							}
						}
					}
				}
			}
			return msg;
		}
}
		

			
	
		
	


