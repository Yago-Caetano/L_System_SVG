package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUtils {


    public static List<String> FetchData(String fileName) throws Exception {
        int qt=0;
        List<String> retValue = new ArrayList<String>();

        System.out.println("Analisando memória.....");
        File file = new File(fileName);
        Scanner input = null;
        StringBuffer buffer = new StringBuffer();

        try
        {
            input = new Scanner(file);
        } catch (FileNotFoundException e)
        {
            System.out.println("Arquivo não encontrado");
            throw new Exception();
        }
        while (input.hasNextLine())
        {
            String aux = input.nextLine();
            retValue.add(aux);
        }
        if(retValue.size()>0)
            System.out.println("Dados recuperados com sucesso!!");
        else
            System.out.println("O arquivo está vazio");

        return retValue;
    }

    public static void write(String s, String Caminho) {

        try(FileWriter fw = new FileWriter(Caminho, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(s);
            //more code
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo de dados");
        }
    }


}



