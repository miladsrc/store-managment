package service;

import application.context.ValidationUtil;
import connection.util.Connector;
import model.Shareholder;
import repository.ShareholderRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderService {

    private final Scanner input = new Scanner(System.in);
    private final ShareholderRepository shareholderRepository;

    public ShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }


    public void createShareholder() throws SQLException {

        System.out.println("enter shareholder name : ");
        String name = input.next();

        String phoneNumber;
        Boolean result;
        do {
            System.out.println("enter shareholder phone number ");
            phoneNumber = input.next();
            result = ValidationUtil.phoneNumberValidator(phoneNumber);
        } while (!result);

        int nationalCode;
        Boolean result2;
        do {
            System.out.println("enter national code :");
            nationalCode = input.nextInt();
            result2 = ValidationUtil.nationalCodeValidator(String.valueOf(nationalCode));
        } while (!result2);


        Shareholder shareholder = new Shareholder(name, phoneNumber, nationalCode);

        while (shareholderRepository.createShareholder(shareholder)) {
            System.out.println("shareholder added to database !");
            break;
        }

    }


    public void readShareholder() throws SQLException {
        System.out.println("enter shareholder id :");
        int id = input.nextInt();
        System.out.println(shareholderRepository.readShareholder(id).toString());
    }


    public void updateShareholder() throws SQLException {
        shareholderRepository.shareholderList();

        System.out.println("\nenter id to change :");
        int id = input.nextInt();

        System.out.println("enter shareholder name : ");
        String name = input.next();

        String phoneNumber;
        Boolean result;
        do {
            System.out.println("enter shareholder phone number ");
            phoneNumber = input.next();
            result = ValidationUtil.phoneNumberValidator(phoneNumber);
        } while (!result);

        long nationalCode;
        Boolean result2;
        do {
            System.out.println("enter national code :");
            nationalCode = input.nextLong();
            result2 = ValidationUtil.nationalCodeValidator(String.valueOf(nationalCode));
            System.out.println(result2);
        } while (!result2);


        Shareholder shareholder = new Shareholder(id, name, phoneNumber, Integer.valueOf((int) nationalCode));

        while (shareholderRepository.updateShareholder(shareholder)) {
            System.out.println("shareholder updated in database !");
            break;
        }
    }

    public void dropShareholder() throws SQLException {
        System.out.println("enter shareholder id :");
        int id = input.nextInt();
        shareholderRepository.dropShareholder(id);
        System.out.println("shareholder successfully removed !");
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getConnection();
        ShareholderRepository shareholderRepository1 = new ShareholderRepository(connection);
        ShareholderService shareholderService = new ShareholderService(shareholderRepository1);

        shareholderService.dropShareholder();
    }


}

