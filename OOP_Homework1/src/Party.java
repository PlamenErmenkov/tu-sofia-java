public class Party {
    public Party(Performance[] performances) {
        this.performances = performances;
    }

    public Performance[] getPerformances() {
        return performances;
    }

    public void setPerformances(Performance[] performances) {
        this.performances = performances;
    }

    private Performance[] performances;

    public void startParty(){
        for (int i = 0; i < performances.length; i++){
            performances[i].start();
            if(i == performances.length - 1){
                System.out.println("Party started!");
            }
        }
    }
}
