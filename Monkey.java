                                                                                                      public class Monkey extends RescueAnimal{
    private String species;
    private double bodyLength;
    private double height;
    private double tailLength;

    // Constructor
    public Monkey(String name, String gender, int age,
                  double weight, String acquisitionDate, String acquisitionCountry,
                  String species, String trainingStatus, boolean reserved,
                  String inServiceCountry, double bodyLength, double height, double tailLength ){
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionLocation(acquisitionCountry);
        setAcquisitionDate(acquisitionDate);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        this.species = species;
        this.bodyLength = bodyLength;
        this.height = height;
        this.tailLength = tailLength;
    };


    // Set / Get Species
    public void setSpecies(String species){
        this.species = species;
    };
    public String getSpecies(){
        return this.species;
    };

    // Set / Get bodyLength
    public void setBodyLength(double bodyLength){
        this.bodyLength = bodyLength;
    };
    public double getBodyLength(){
        return this.bodyLength;
    };

    // Set / Get height
    public void setHeight(double height){
        this.height = height;
    };
    public double getHeight(){
        return this.height;
    };

    // Set / Get tailLength
    public void setTailLength(double tailLength){
        this.tailLength = tailLength;
    };
    public double getTailLength(){
        return this.tailLength;
    };
}