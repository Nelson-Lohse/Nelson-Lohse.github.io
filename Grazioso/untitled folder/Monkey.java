public class Monkey extends RescueAnimal {
    private String species;
    private int height;
    private int tailLength;
    private int bodyLength;
    
    public static final String[] VALID_BREEDS = {
            "Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel Monkey", "Tamarin"
        };
    
    public Monkey (){
        species = "None";
        height = -1;
        tailLength = -1;
        bodyLength = -1;
    }
    
    public Monkey(String name, String species, String gender, String age, String weight,
            String acquisitionDate, String acquisitionCountry,
            String trainingStatus, boolean reserved, String inServiceCountry) {
  setName(name);
  setSpecies(species);
  setGender(gender);
  setAge(age);
  setWeight(weight);
  setAcquisitionDate(acquisitionDate);
  setAcquisitionLocation(acquisitionCountry);
  setTrainingStatus(trainingStatus);
  setReserved(reserved);
  setInServiceCountry(inServiceCountry);
}
    
    public void setSpecies (String monkeySpecies){
        species = monkeySpecies;
    }
    public void setHeight (int monkeyHeight){
        height = monkeyHeight;
    }
    public void setTailLength (int monkeyTailLength){
        tailLength = monkeyTailLength;
    }
    public void setBodyLength (int monkeyBodyLength){
        bodyLength = monkeyBodyLength;
    }
    public String getSpecies (){
        return species;
    }
    public int getHeight (){
        return height;
    }
    public int getTailLength (){
        return tailLength;
    }
    public int getBodyLength (){
        return bodyLength;
    }
}