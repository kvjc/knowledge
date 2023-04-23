package model;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;

public class Stage {

    private String name;
    private Calendar initialDateP;
	private Calendar finalDateP;
	private Calendar initialDateR;
	private Calendar finalDateR;
    private DateFormat formatter;
    private String status;
	private String cName;
    private KnowledgeUnit[] units;

    

    public Stage(String name, Calendar initialDateR, Calendar finalDateR, Calendar finalDateP, String status){

		//addKU("A001", "Gestion de repositorios", 1, "GitHub es una herramienta util", "aprobada");
		//addKU("A002", "Gestion de equipos", 2, "Es importante definir responsabilidades claras","aprobada");

        this.name = name;
        this.formatter = new SimpleDateFormat("dd/MM/yy");
        this.initialDateP = initialDateP;
		this.finalDateP = finalDateP;
		this.initialDateR = initialDateR;
		this.finalDateR = initialDateR;
        this.status = status;
        this.units = new KnowledgeUnit[50];
    } 

	public void testCases(){


		units[0] = new KnowledgeUnit("Juan","A001", "Gestion de repositorios", TypeKU.DOMAIN, "GitHub es una herramienta util", "aprobada");
		units[1] = new KnowledgeUnit("Jose", "A002", "Gestion de equipos", TypeKU.EXPERIENCES, "Es importante definir responsabilidades claras","aprobada");
		
	}

    public boolean addKU(String cName, String id, String description, int typeKU, String learnedLessons, String status){

        TypeKU typeK= TypeKU.TECHNICAL;
        if (typeKU ==1){
            typeK = TypeKU.TECHNICAL;
        }
        else if (typeKU ==2){
            typeK = TypeKU.MANAGEMENT;
        }else if (typeKU == 3 ){
			typeK = TypeKU.EXPERIENCES;
		}else{
			typeK = TypeKU.DOMAIN;
		}
		
		KnowledgeUnit newKnowledge = new KnowledgeUnit(cName,id, description, typeK, learnedLessons, status);

		for(int i = 0; i<units.length; i++){

            if(units[i]==null){

                units[i] = newKnowledge;
                
                return true;
            }
            
        }

        return false;
    }

    public void approveKnowledgeUnit(int posicion, String status) {

		units[posicion].setStatus(status);

	}

	/**
	*Description: This method allows to modify knowledge capsules. 
	*@param: mod String second string contains the new information, atributo int firs integer contains the type of change, posicion int first integer contains the position of the capsule
	*@return: 
	*/

	public void modifcarCapsula(int posicion, int atributo, String mod){
		int modT = 0;
		if(mod.equals("1")){
			modT = 1;
		}else if(mod.equals("2")){
			modT = 2;
		}else if(mod.equals("3")){
			modT = 3;
		}else if(mod.equals("4")){
			modT = 4;
		}

		

		switch(atributo){
			case 1: 

				units[posicion-1].setDescription(mod);
				
				break;
			
			case 2: 

				switch(modT){

					case 1:
						units[posicion-1].setTypeKU(TypeKU.TECHNICAL);
						break;
					case 2: 
						units[posicion-1].setTypeKU(TypeKU.MANAGEMENT);
						break;
					case 3: 
						units[posicion-1].setTypeKU(TypeKU.EXPERIENCES);
						break;
					case 4: 
						units[posicion-1].setTypeKU(TypeKU.DOMAIN);
						break;

				}
			
			case 3:

				units[posicion].setLearnedLessons(mod);
				break;
		}

	}

	
	
			/**
	*Description: This method allows to show all knowledge capsules. 
	*@param: msg String firs string contains all capsule information
	*@return: msg String contains all capsule information
	*/
	public String getAllKnowledgeUnits() {

		String msg = "";

	 	for(int i=0; i<units.length; i++){

            if(units[i]!=null){
            	msg += "\n" +units[i].toString(); 
            }

        } 

		return msg;

	}

	/**
	*Description: This method allows to show all knowledge capsules. 
	*@param: msg String contains the capsule ID and description
	*@return: msg String contains the capsule ID and description
	*/

	public String getKnowledgeUnits(){

		String msg = "";

	 	for(int i=0; i<units.length; i++){

            if(units[i]!=null){
            	msg += "\n" +units[i].toString(); 
            }

        } 

		return msg;
	}

	/**
	*Description: This method allows to show a specific knowledge capsules. 
	*@param: msg String firs string contains all capsule information
	*@return: msg String contains all capsule information
	*/
	public String getSpecificKnowledgeUnits(int posicion){
		String msg = "";

		if(units[posicion]!=null){
			msg += "\n" +units[posicion].toString(); 
		}else{
			msg += "This capsule is not registered";
		}


		return msg;
	}


	
	public String getInitialDateRFormated() throws ParseException{
		return formatter.format(this.initialDateR.getTime());
	}


	public String getFinalDateRFormated() throws ParseException{
		return formatter.format(this.finalDateR.getTime());
	}

	public String getInitialDatePFormated() throws ParseException{
		return formatter.format(this.initialDateP.getTime());
	}


	public String getFinalDatePFormated() throws ParseException{
		return formatter.format(this.finalDateP.getTime());
	}

	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}

	public String getStageInfo() throws ParseException{
		return "\nName: " +name +  "\nInitial Date: " + getInitialDateRFormated()+ "\nFinal Date: " + getFinalDateRFormated() + "\nStatus: " +status+ ".\n";
	}

	public String getName() {
		return name;
	}   

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getInitialDateP() {
		return initialDateP;
	}

	public void setInitialDateP(Calendar initialDateP) {
		this.initialDateP = initialDateP;
	}

	public Calendar getFinalDateP() {
		return finalDateP;
	}

	public void setFinalDateP(Calendar finalDateP) {
		this.finalDateP = finalDateP;
	}

	public Calendar getInitialDateR() {
		return initialDateR;
	}

	public void setInitialDateR(Calendar initialDateR) {
		this.initialDateR = initialDateR;
	}

	public Calendar getFinalDateR() {
		return finalDateR;
	}

	public void setFinalDateR(Calendar finalDateR) {
		this.finalDateR = finalDateR;
	}

	public KnowledgeUnit[] getUnits() {
		return units;
	}

	public void setUnits(KnowledgeUnit[] units) {
		this.units = units;
	}

	

}
