package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hanaria on 2/2/17.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        String line = "";
        try{
            line = reader.readLine();

        }
        catch (IOException e){

        }
        return line;
    }

    public static String askCurrencyCode()
    {
        writeMessage("Input currency code: ");
        String currencyCode = "";
        while(true){
            currencyCode = readString();
            if(currencyCode.length() == 3){
                break;
            }
            else writeMessage("Currency code error!");
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode)
    {
        writeMessage("Input denomination and quantity " + currencyCode);
        String str = "";
        String[] nominalAndQuantity;
        int nominal = 0,quantity = 0;
        while (true){
            str = readString();
            nominalAndQuantity = str.split(" ");
            try
            {
                nominal = Integer.parseInt(nominalAndQuantity[0]);
                quantity = Integer.parseInt(nominalAndQuantity[1]);
            }
            catch (Exception e){
                writeMessage("Invalid denomination and quantity data");
                continue;
            }
            if(nominal <= 0 || quantity <= 0 || nominalAndQuantity.length>2){
                writeMessage("Invalid data denomination or quantity <= 0");
                continue;
            }
            break;
        }
        return nominalAndQuantity;
    }

    public static Operation askOperation(){
        Integer ordinal;

        while (true){
            writeMessage("Choose operation 1 INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            try{
                ordinal = Integer.parseInt(readString());
                if(ordinal>=5 || ordinal <=0) continue;
                break;
            }
            catch (Exception e){
            }
        }
        return Operation.getAllowableOperationByOrdinal(ordinal);
    }
}