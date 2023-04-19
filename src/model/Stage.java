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
    private KnowledgeUnit[] units;

    

    public Stage(String name, Calendar initialDate, Calendar finalDate, String status){

        this.name = name;
        this.formatter = new SimpleDateFormat("dd/MM/yy");
        this.initialDateP = initialDate;
		this.finalDateP = finalDate;
		this.initialDateR = null;
		this.finalDateR = null;
        this.status = status;

        this.units = new KnowledgeUnit[50];
    } 

    public boolean addKU(String id, String description, String type, String learnedLessons, String status){

        KnowledgeUnit newKnowledge = new KnowledgeUnit(id, description, type, learnedLessons, status);

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

		switch(atributo){
			case 1: 

				units[posicion-1].setDescription(mod);
				
				break;
			
			case 2: 

				units[posicion-1].setType(mod);
				break;
			
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
            	msg += "\n" +units[i].toStringA(); 
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

	public String getProjectInfo() throws ParseException{
		return "\nFinal Date" + getFinalDatePFormated() +"\nInitial Date" + getInitialDatePFormated() +"Status: " +status+ ".\n";
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
