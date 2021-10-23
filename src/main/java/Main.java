import controllers.GrammarControler;
import models.GrammarModel;
import utils.TextUtils;

import java.security.spec.ECField;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        try{
            GrammarControler controler = new GrammarControler(getGrammar());
            controler.Execute();
        }
        catch (Exception e)
        {

        }
    }

    private static GrammarModel getGrammar() throws Exception
    {
        GrammarModel Grammar = new GrammarModel();
        List<String> rdData = TextUtils.FetchData("input.txt");
        if(rdData.size()>0)
        {
            //take alphabet
            if(rdData.get(0).trim().contains("Σ:"))
            {
                Grammar.setAlphabet(rdData.get(0).trim().replace("Σ:",""));
            }
            else
            {
                throw new Exception();
            }

            //take rounds
            if(rdData.get(1).trim().contains("n:"))
            {
                Grammar.setRounds(Integer.parseInt(rdData.get(1).replace("n:","").trim()));
            }
            else
            {
                throw new Exception();
            }

            //take axiom
            if(rdData.get(2).trim().contains("ω:"))
            {
                Grammar.setAxiom(rdData.get(2).trim().replace("ω:",""));
            }
            else
            {
                throw new Exception();
            }

            //take rules
            for(int i = 3; i < rdData.size();i++)
            {
                //take rule
                if(rdData.get(i).trim().contains("P:"))
                {
                    Grammar.addRule(rdData.get(i));
                }
                else
                {
                    throw new Exception();
                }
            }

        }


        return Grammar;
    }
}
