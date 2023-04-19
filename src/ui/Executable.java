package ui;

import java.text.ParseException;
import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) throws ParseException {

		Executable exe = new Executable();
		exe.menu();

	}

	// Incomplete
	public void menu() throws ParseException {

		System.out.println("Welcome to GreenSQA");
		boolean cond = false;

		while(!cond){

            System.out.println("1. Register project");
            System.out.println("2. Search projects after Date ");
            System.out.println("3. Search projects before date");
			System.out.println("4. Consult projects");
            System.out.println("5. Register knowledge unit");
            System.out.println("6. Modify knowledge unit");
            System.out.println("7. Consult knowledge units");
			System.out.println("8. Approve knowledge unit");			
            System.out.println("9. Exit"); 
            int opcion = reader.nextInt();

            switch(opcion){
                case 1: 
                    registerProject();

                    break;

                case 2: 
                    
					searchProjectsAfterDate();
                    
                    break;

                case 3:

					searchProjectsBeforeDate();
			

					break;
				
				case 4:

					showAllProjects();

					break;
				
				case 5: 
                    registerKnowledgeUnit();

                    break;

                case 6: 
                    
					modifcarCapsula();
                    
                    break;

                case 7:

					showAllKnowledgeUnits();
			

					break;

				case 8:

					approveKnowledgeUnit();

					break;
                    
                
                case 9:
                    cond = true;
                
            }
        }

	}

	//Projects
	public void registerProject() {

		System.out.println("Enter the information of the project");

		System.out.println("Enter the project's name");
		String projectName = reader.nextLine();

		reader.nextLine();
		
		System.out.println("Enter the client name");
		String projectClient = reader.nextLine();
		
		System.out.println("Enter the manager name");
		String managerName = reader.nextLine();

		System.out.println("Enter the manager phone");
		String managerPhone = reader.nextLine();

		System.out.println("Enter the budget");
		double budget = reader.nextDouble();

		System.out.println("Enter the type \n1.DEPLOYMENT, \n2.MAINTENANCE \n3.DEPLOYMENT");
		int type = reader.nextInt();
		

		System.out.println("Enter the initial date");

		System.out.println("Enter the day");
		int iDay = reader.nextInt();

		System.out.println("Enter the month");
		int iMonth = reader.nextInt();

		System.out.println("Enter the year");
		int iYear = reader.nextInt();


		System.out.println("Enter the final date");
		
		System.out.println("Enter the day");
		int fDay = reader.nextInt();

		System.out.println("Enter the month");
		int fMonth = reader.nextInt();

		System.out.println("Enter the year");
		int fYear = reader.nextInt();


		if (controller.registerProject(projectName, projectClient, managerName, managerPhone, budget, iDay, fDay, iMonth, fMonth, iYear, fYear, type)) {
			System.out.println("project registered successfully!");
		} else {
			System.out.println("Could not register the project :(");
		}

	}


	public void searchProjectsAfterDate() throws ParseException {

		System.out.println("Enter the date");

		reader.nextLine();
		
		System.out.println("Enter the day");
		int cDay = reader.nextInt();

		System.out.println("Enter the month");
		int cMonth = reader.nextInt();

		System.out.println("Enter the year");
		int cYear = reader.nextInt();

		String consult = controller.searchProjectsAfterDate(cYear, cMonth, cDay);

		if(consult.equals("")){

            System.out.println("There are no registeredprojects :(");
        }else{
            System.out.println(consult);
        }


	}
	

	public void searchProjectsBeforeDate() throws ParseException {

		System.out.println("Enter the date");

		System.out.println("Enter the day");
		int cDay = reader.nextInt();

		System.out.println("Enter the month");
		int cMonth = reader.nextInt();

		System.out.println("Enter the year");
		int cYear = reader.nextInt();
		

		String consult = controller.searchProjectsBeforeDate(cYear, cMonth, cDay);

		if(consult.equals("")){

            System.out.println("There are no registered projects :(");
        }else{
            System.out.println(consult);
        }

	}

	public void showAllProjects() throws ParseException {

		System.out.println("This is the information registered in the system");
        
        String consulta = controller.getAllProjects();

		if(consulta.equals("")){

            System.out.println("There are no registered projects :(");
        }else{
            System.out.println(consulta);
        }

	}


		/**
	*Description: This method allows to approve of knowledge capsules. 
	*@param: posicion int first integer, status String first string containing the capsule status
	*@return: 
		 * @throws ParseException
	*/
	


	//KnowledgeUnit
	private void approveKnowledgeUnit() throws ParseException {

		System.out.println("These are the available projects");
		String consultap = controller.getAllProjects();
		if(consultap.equals("")){

            System.out.println("There are no registered projects :(");
        }else{
            System.out.println(consultap);
        }
		System.out.println("Choose a project");
		int project = reader.nextInt();



		System.out.println("These are the stages");
		String consultas = controller.getAllStages(project);
        System.out.println(consultas);
		System.out.println("Choose a atage");
		int stage = reader.nextInt();

    
		System.out.println("These are the knowledge units registered in the system");
		String consultau = controller.getAllKnowledgeUnits(project, stage);
		if(consultau.equals("")){

            System.out.println("There are no registered knowledge units :(");
        }else{
            System.out.println(consultau);
        }


		System.out.println("Select the unit to approve its status");
		int posicionu = reader.nextInt();
		
		reader.nextLine();

		System.out.println("Write the status of the unit");
		String status = reader.nextLine();

		controller.approveKnowledgeUnit(project, stage, posicionu, status);
		System.out.println("The unit status has been modified.");

	}


			/**
	*Description: This method allows to register knowledge capsules. 
	*@param: id String firs string containing the capsule identficator, description String second string containing the capsule description
			 type String third string containing the capsule type, learnedLessons String fourth string containing the capsule learnedLessons
	*@return: 
			 * @throws ParseException
	*/
	public void registerKnowledgeUnit() throws ParseException {

		//Mostrar al usuario que proyectos existen
		//Pregutar al usuario el proyecto
		System.out.println("These are the available projects");
		String consultap = controller.getAllProjects();
		if(consultap.equals("")){

            System.out.println("There are no registered projects :(");
        }else{
            System.out.println(consultap);
        }
		System.out.println("Choose a project");
		int project = reader.nextInt();



		System.out.println("These are the stages");
		String consultas = controller.getAllStages(project);
        System.out.println(consultas);
		System.out.println("Choose a atage");
		int stage = reader.nextInt();

		System.out.println("Enter the information of the knowledge unit");

		reader.nextLine();

		System.out.println("Enter the identifier of the unit");
		String id = reader.nextLine();

		System.out.println("Enter the description of the unit");
		String description = reader.nextLine();

		System.out.println("Enter the type of the unit");
		String type = reader.nextLine();

		System.out.println("Enter the learned lesson");
		String learnedLessons = reader.nextLine();

		
		String status = "To define";

		if (controller.registerKnowledgeUnit(project, stage, id, description, type, learnedLessons, status)) {
			System.out.println("Knowledge unit registered successfully!");
		} else {
			System.out.println("Could not register the knowledge unit :(");
		}

	}



			/**
	*Description: This method allows to show all knowledge capsules. 
	*@param: consulta String first string contains the information of the capsules
	*@return: 
			 * @throws ParseException
	*/
	public void showAllKnowledgeUnits() throws ParseException {

		System.out.println("These are the available projects");
		String consultap = controller.getAllProjects();
		if(consultap.equals("")){

            System.out.println("There are no registered projects :(");
        }else{
            System.out.println(consultap);
        }
		System.out.println("Choose a project");
		int project = reader.nextInt();



		System.out.println("These are the stages");
		String consultas = controller.getAllStages(project);
        System.out.println(consultas);
		System.out.println("Choose a atage");
		int stage = reader.nextInt();

		System.out.println("This is the information registered in the system");
        
        String consulta = controller.getAllKnowledgeUnits(project, stage);

		if(consulta.equals("")){

            System.out.println("There are no registered knowledge units :(");
        }else{
            System.out.println(consulta);
        }

	}

			/**
	*Description: This method allows to modify knowledge capsules. 
	*@param: consulta String first string contains the information of the capsules, mod String second string contains the new information, 
			atributo int firs integer contains the type of change, posicion int first integer contains the position of the capsule
	*@return: 
			 * @throws ParseException
	*/
	
	public void modifcarCapsula() throws ParseException{


		System.out.println("These are the available projects");
		String consultap = controller.getAllProjects();
		if(consultap.equals("")){

            System.out.println("There are no registered projects :(");
        }else{
            System.out.println(consultap);
        }
		System.out.println("Choose a project");
		int project = reader.nextInt();



		System.out.println("These are the stages");
		String consultas = controller.getAllStages(project);
        System.out.println(consultas);
		System.out.println("Choose a atage");
		int stage = reader.nextInt();


		System.out.println("These are the knowledge units registered in the system");
		String consulta = controller.getAllKnowledgeUnits(project, stage);System.out.println("Enter the number of the knowledge unit");
		int posicionN = reader.nextInt();
		



		if(consulta.equals("")){

            System.out.println("There are no registered knowledge units :(");
        }else{
            System.out.println(consulta);
        }

		System.out.println("Select the unit to modify");
		int posicion = reader.nextInt();

		controller.getSpecificKnowledgeUnits(posicion, project, stage); 

		System.out.println("Select which attribute to modify \n1. Description \n2. Type \n3. LearnedLesson");
		int atributo = reader.nextInt();

		reader.nextLine();

		System.out.println("Write the modification");
		String mod = reader.nextLine();

		controller.modifcarCapsula(project, stage, posicion, atributo, mod);
		System.out.println("The unit has been modified ");

	}

	public void activateStage(){

		System.out.println("Escriba a continuacion la fecha");

		System.out.println("Enter the day");
		int sDay = reader.nextInt();

		System.out.println("Enter the month");
		int sMonth = reader.nextInt();

		System.out.println("Enter the year");
		int sYear = reader.nextInt();

	}

	public void culminateStage() throws ParseException{
		
		System.out.println("These are the available projects");
		String consultap = controller.getAllProjects();
		if(consultap.equals("")){

            System.out.println("There are no registered projects :(");
        }else{
            System.out.println(consultap);
        }
		System.out.println("Choose a project");
		int project = reader.nextInt();



		System.out.println("This is the current stage");
		String consultas = controller.getAllStages(project);
        System.out.println(consultas);
		System.out.println("Choose a atage");
		int stage = reader.nextInt();

		System.out.println("Enter the final date");
		
		System.out.println("Enter the day");
		int fDayR = reader.nextInt();

		System.out.println("Enter the month");
		int fMonthR = reader.nextInt();

		System.out.println("Enter the year");
		int fYearR = reader.nextInt();



	}



}