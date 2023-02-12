public class Champ {
    int energy;
    int brainUsage;
    public Champ(int energy,int brainUsage){
        this.energy = energy;
        this.brainUsage = brainUsage;
    }
    public int getEnergy(){
        return energy;
    }
    public int getBrainUsage(){
        return brainUsage;
    }
    public static int getPropAmt(){
        return 2;
    }
}
