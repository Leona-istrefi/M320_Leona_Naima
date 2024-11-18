
public class DVD extends Media {
    private int runtime; // runtime in minutes

    public DVD(String title, String creator, int runtime) {
        super(title, creator);
        this.runtime = runtime;
    }

    public int getRuntime() {
        return runtime;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Runtime: " + runtime + " minutes");
    }
}
