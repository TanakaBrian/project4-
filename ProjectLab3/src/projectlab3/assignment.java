/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectlab3;
import java.util.ArrayList;
import java.util.List;

// ================================================================
// Account Hierarchy
// ================================================================

/**
 * Abstract Account class.
 */
abstract class Account {
    protected String accountNumber;
    protected String nickname; // Allowed except for LoanAccount

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Default: allow nickname setting.
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [accountNumber=" + accountNumber 
                + ", nickname=" + nickname + "]";
    }
}

/**
 * SavingsAccount: adds interest rate and a minimum balance attribute.
 */
class SavingsAccount extends Account {
    private double interestRate;
    private double minimumBalance; // Additional attribute

    public SavingsAccount(String accountNumber, double interestRate, double minimumBalance) {
        super(accountNumber);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public String toString() {
        return "SavingsAccount [accountNumber=" + accountNumber 
                + ", nickname=" + nickname 
                + ", interestRate=" + interestRate 
                + ", minimumBalance=" + minimumBalance + "]";
    }
}

/**
 * CheckingAccount: adds an overdraft limit attribute.
 */
class CheckingAccount extends Account {
    private double overdraftLimit; // Additional attribute

    public CheckingAccount(String accountNumber, double overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String toString() {
        return "CheckingAccount [accountNumber=" + accountNumber 
                + ", nickname=" + nickname 
                + ", overdraftLimit=" + overdraftLimit + "]";
    }
}

/**
 * InvestmentAccount: adds an investment type attribute.
 */
class InvestmentAccount extends Account {
    private String investmentType; // Additional attribute (e.g., "stocks", "bonds", etc.)

    public InvestmentAccount(String accountNumber, String investmentType) {
        super(accountNumber);
        this.investmentType = investmentType;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    @Override
    public String toString() {
        return "InvestmentAccount [accountNumber=" + accountNumber 
                + ", nickname=" + nickname 
                + ", investmentType=" + investmentType + "]";
    }
}

/**
 * LoanAccount: adds interest rate and loan amount attributes.
 * This class also overrides setNickname() to prevent nickname assignment.
 */
class LoanAccount extends Account {
    private double interestRate;
    private double loanAmount; // Additional attribute

    public LoanAccount(String accountNumber, double interestRate, double loanAmount) {
        super(accountNumber);
        this.interestRate = interestRate;
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Override to prevent setting a nickname.
    @Override
    public void setNickname(String nickname) {
        System.err.println("Error: LoanAccount cannot have a nickname.");
    }

    @Override
    public String toString() {
        return "LoanAccount [accountNumber=" + accountNumber 
                + ", interestRate=" + interestRate 
                + ", loanAmount=" + loanAmount + "]";
    }
}

// ================================================================
// Client Hierarchy
// ================================================================

/**
 * Abstract Client class.
 * This class manages the association with Account objects.
 */
abstract class Client {
    protected String clientID;
    protected String name;
    protected List<Account> accounts = new ArrayList<>();

    public Client(String clientID, String name) {
        this.clientID = clientID;
        this.name = name;
    }

    public String getClientID() {
        return clientID;
    }

    public String getName() {
        return name;
    }

    // Association methods for managing accounts.
    public void addAccount(Account account) {
        if (account == null) {
            System.err.println("Error: Cannot add a null account.");
            return;
        }
        if (accounts.contains(account)) {
            System.err.println("Error: Account already exists for this client.");
            return;
        }
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        if (!accounts.contains(account)) {
            System.err.println("Error: Account not found for this client.");
            return;
        }
        accounts.remove(account);
    }

    public void listAccounts() {
        System.out.println("Accounts for client " + name + " (" + clientID + "):");
        for (Account account : accounts) {
            System.out.println("  " + account);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [clientID=" + clientID + ", name=" + name + "]";
    }
}

/**
 * Abstract BMOClient class extends Client and adds a loyaltyPoints attribute.
 */
abstract class BMOClient extends Client {
    protected int loyaltyPoints;

    public BMOClient(String clientID, String name, int loyaltyPoints) {
        super(clientID, name);
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}

/**
 * Minor subclass of BMOClient.
 * Adds a guardianName attribute.
 */
class Minor extends BMOClient {
    private String guardianName;

    public Minor(String clientID, String name, int loyaltyPoints, String guardianName) {
        super(clientID, name, loyaltyPoints);
        this.guardianName = guardianName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    @Override
    public String toString() {
        return "Minor [clientID=" + clientID + ", name=" + name 
                + ", loyaltyPoints=" + loyaltyPoints 
                + ", guardianName=" + guardianName + "]";
    }
}

/**
 * Student subclass of BMOClient.
 * Adds a schoolName attribute.
 */
class Student extends BMOClient {
    private String schoolName;

    public Student(String clientID, String name, int loyaltyPoints, String schoolName) {
        super(clientID, name, loyaltyPoints);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Student [clientID=" + clientID + ", name=" + name 
                + ", loyaltyPoints=" + loyaltyPoints 
                + ", schoolName=" + schoolName + "]";
    }
}

/**
 * Abstract Adult subclass of BMOClient.
 * Adds an occupation attribute.
 */
abstract class Adult extends BMOClient {
    protected String occupation;

    public Adult(String clientID, String name, int loyaltyPoints, String occupation) {
        super(clientID, name, loyaltyPoints);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}

/**
 * Investor subclass of Adult.
 * Adds a riskTolerance attribute.
 */
class Investor extends Adult {
    private String riskTolerance; // e.g., "High", "Medium", "Low"

    public Investor(String clientID, String name, int loyaltyPoints, String occupation, String riskTolerance) {
        super(clientID, name, loyaltyPoints, occupation);
        this.riskTolerance = riskTolerance;
    }

    public String getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(String riskTolerance) {
        this.riskTolerance = riskTolerance;
    }

    @Override
    public String toString() {
        return "Investor [clientID=" + clientID + ", name=" + name 
                + ", loyaltyPoints=" + loyaltyPoints 
                + ", occupation=" + occupation 
                + ", riskTolerance=" + riskTolerance + "]";
    }
}

/**
 * Individual subclass of Adult.
 * Adds an annualIncome attribute.
 */
class Individual extends Adult {
    private double annualIncome;

    public Individual(String clientID, String name, int loyaltyPoints, String occupation, double annualIncome) {
        super(clientID, name, loyaltyPoints, occupation);
        this.annualIncome = annualIncome;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    @Override
    public String toString() {
        return "Individual [clientID=" + clientID + ", name=" + name 
                + ", loyaltyPoints=" + loyaltyPoints 
                + ", occupation=" + occupation 
                + ", annualIncome=" + annualIncome + "]";
    }
}

/**
 * SmallBusiness subclass of Adult.
 * Adds a businessRegistrationNumber attribute.
 */
class SmallBusiness extends Adult {
    private String businessRegistrationNumber;

    public SmallBusiness(String clientID, String name, int loyaltyPoints, String occupation, String businessRegistrationNumber) {
        super(clientID, name, loyaltyPoints, occupation);
        this.businessRegistrationNumber = businessRegistrationNumber;
    }

    public String getBusinessRegistrationNumber() {
        return businessRegistrationNumber;
    }

    public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
        this.businessRegistrationNumber = businessRegistrationNumber;
    }

    @Override
    public String toString() {
        return "SmallBusiness [clientID=" + clientID + ", name=" + name 
                + ", loyaltyPoints=" + loyaltyPoints 
                + ", occupation=" + occupation 
                + ", businessRegistrationNumber=" + businessRegistrationNumber + "]";
    }
}

/**
 * LargeBusiness subclass of Adult.
 * Adds a numberOfEmployees attribute.
 */
class LargeBusiness extends Adult {
    private int numberOfEmployees;

    public LargeBusiness(String clientID, String name, int loyaltyPoints, String occupation, int numberOfEmployees) {
        super(clientID, name, loyaltyPoints, occupation);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "LargeBusiness [clientID=" + clientID + ", name=" + name 
                + ", loyaltyPoints=" + loyaltyPoints 
                + ", occupation=" + occupation 
                + ", numberOfEmployees=" + numberOfEmployees + "]";
    }
}

/**
 * OtherBankClient extends Client.
 * (No additional attributes are defined here, but you could add some if needed.)
 */
class OtherBankClient extends Client {
    public OtherBankClient(String clientID, String name) {
        super(clientID, name);
    }

    @Override
    public String toString() {
        return "OtherBankClient [clientID=" + clientID + ", name=" + name + "]";
    }
}

// ================================================================
// Demo Class: BmoBankingSystemDemo
// ================================================================

public class BmoBankingSystemDemo {
    public static void main(String[] args) {
        // ----------------------------------------------------------------
        // Create Clients
        // ----------------------------------------------------------------

        // Create an Investor client (an Adult)
        Investor investor = new Investor("C001", "Alice Investor", 1000, "Software Engineer", "High");

        // Create a Minor client
        Minor minorClient = new Minor("C002", "Bobby Minor", 100, "Mary Minor");

        // Create a Student client
        Student student = new Student("C003", "Charlie Student", 200, "University of XYZ");

        // Create an OtherBankClient
        OtherBankClient externalClient = new OtherBankClient("C004", "Dana External");

        // ----------------------------------------------------------------
        // Create Accounts
        // ----------------------------------------------------------------

        // SavingsAccount: interestRate, minimumBalance
        SavingsAccount savings = new SavingsAccount("A1001", 0.02, 500.0);
        savings.setNickname("Alice's Savings");

        // CheckingAccount: overdraftLimit
        CheckingAccount checking = new CheckingAccount("A1002", 200.0);
        checking.setNickname("Alice's Checking");

        // InvestmentAccount: investmentType
        InvestmentAccount investAcc = new InvestmentAccount("A1003", "Stocks");
        investAcc.setNickname("Alice's Investment");

        // LoanAccount: interestRate, loanAmount (nickname cannot be set)
        LoanAccount loan = new LoanAccount("A1004", 0.05, 10000.0);
        loan.setNickname("Attempted Nickname"); // This will trigger an error message

        // ----------------------------------------------------------------
        // Associate Accounts with Clients
        // ----------------------------------------------------------------

        // Add accounts to investor
        investor.addAccount(savings);
        investor.addAccount(checking);
        investor.addAccount(investAcc);
        investor.addAccount(loan);

        // Add an account to a Minor client
        minorClient.addAccount(new CheckingAccount("A2001", 100.0));
        
        // Add an account to a Student client
        student.addAccount(new SavingsAccount("A3001", 0.03, 300.0));

        // Add an account to an external client
        externalClient.addAccount(new InvestmentAccount("A4001", "Bonds"));

        // ----------------------------------------------------------------
        // List accounts for each client
        // ----------------------------------------------------------------

        System.out.println("=== Investor Accounts ===");
        investor.listAccounts();

        System.out.println("\n=== Minor Accounts ===");
        minorClient.listAccounts();

        System.out.println("\n=== Student Accounts ===");
        student.listAccounts();

        System.out.println("\n=== Other Bank Client Accounts ===");
        externalClient.listAccounts();

        // ----------------------------------------------------------------
        // Demonstrate removeAccount (attempting to remove an account that doesn't exist)
        // ----------------------------------------------------------------
        CheckingAccount dummyAccount = new CheckingAccount("A9999", 0);
        System.out.println("\nAttempting to remove a non-existent account from investor...");
        investor.removeAccount(dummyAccount);

        // Remove an existing account from investor and list again
        System.out.println("\nRemoving an existing account (CheckingAccount) from investor...");
        investor.removeAccount(checking);
        investor.listAccounts();
    }
}

/**
 *
 * @author wolves
 */
public class assignment {
    
}
