public class Bank_Account {
    // Initial
    protected final String Name;
    protected  final String Card_Number;
    protected  final int CVC;
    protected double Balance;

    // Constructor
    public Bank_Account (String AccountName, String Identification_Number, int CVC, double Initial_Balance) {
        this.Name = AccountName;
        this.Card_Number = Identification_Number;
        this.CVC = CVC;
        this.Balance = Initial_Balance;
    }

    // Deposit
    public void deposit_Money (double Amount) {
        if (Amount > 0) {
            Balance += Amount;
            System.out.println("\n$" + Amount + " Has been deposited. \nNew Balance = $" + Balance);
        } else {
            System.out.println("Invalid Amount\n");
        }
    }

    // Withdraw
    public void Withdraw_Money (double Amount) {
        if (Amount > 0 && Amount <= Balance) {
            Balance -= Amount;
            System.out.println("\n$" + Amount + " Has been withdrawn. \nNew Balance = $" + Balance);
        } else {
            System.out.println("Invalid Amount or Insufficent Balance\n");
        }
    }

    // Check Info
    public void CheckInfo() {
        System.out.println("\nCardholder Name: " + Name + "\nCard Number: " + Card_Number + "\nCVC: " + CVC + "\nCurrent Balance: $" + Balance);
    }

    // Test Run
    public static void main(String[] args) {
        Bank_Account user = new Bank_Account("Jane Doe", "5550 1309 6672 6224", 324, 12000);
        user.CheckInfo();
        user.deposit_Money(2500);
        user.Withdraw_Money(5000);
        user.CheckInfo();
    }
}

class Savings_Account extends Bank_Account{
    //Initials
    private final double Interest;

    // Constructor
    public Savings_Account (String AccountName, String Identification_Number, int CVC, double Initial_Balance, double Interest_Rate){
        super(AccountName, Identification_Number, CVC, Initial_Balance);
        this.Interest = Interest_Rate;
    }

    // Applying Interest
    public void Apply_Interest (){
        Balance += Balance * (Interest / 100);
        System.out.println("\nInterest Applied.\nNew Balance: $" + Balance);
    }

    // Check Info
    @Override public void CheckInfo() {
        System.out.println("\nCardholder Name: " + Name + "\nCard Number: " + Card_Number + "\nCVC: " + CVC + "\nCurrent Balance: $" + Balance + "\nInterest: " + Interest + "%");
    }

    // Test Run
    public static void main(String[] args) {
        Savings_Account user = new Savings_Account("Jane Doe", "5550 1309 6672 6224", 324, 12000, 5);
        user.CheckInfo();
        user.Apply_Interest();
        user.CheckInfo();
    }
}