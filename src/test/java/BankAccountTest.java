import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountTest {

    BankAccount account;
    BankAccount destinationAccount;

    @BeforeAll
    public void initClass() {
        account = new BankAccount("0600888030", 2000);
        destinationAccount = new BankAccount("788772888", 1000);
    }

    @Test @Order(1)
    public void testGetAccountNumber() {
        Assertions.assertEquals("0600888030", account.getAccountNumber());
    }

    @Test @Order(2)
    public void testGetBalance() {
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test @Order(3)
    public void testDepositValid() {
        account.deposit(1000);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test @Order(4)
    public void testDepositInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-4000);
        });
        // Ensure balance remains unchanged
        Assertions.assertEquals(3000, account.getBalance());
    }


    @Test @Order(5)
    public void testWithdrawValid() {
        account.withdraw(500);
        Assertions.assertEquals(2500, account.getBalance());
    }

    @Test @Order(6)
    public void testWithdrawInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(8000);
        });
    }

    @Test @Order(7)
    public void testTransferValid() {
        account.transferFunds(destinationAccount, 500);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test @Order(8)
    public void testTransferInValid() {
        account.transferFunds(destinationAccount, 1000);
        Assertions.assertNotEquals(2000, account.getBalance());
    }

    @Test @Order(9)
    public void  testTransferInsufficientFunds() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.transferFunds(destinationAccount, 3000);
        });
    }

    @Test @Order(10)
    public void testTransferFundsValid() {
        account.transferFunds(destinationAccount, 500);
        Assertions.assertEquals(500, account.getBalance());
        Assertions.assertEquals(3000, destinationAccount.getBalance());
    }

}