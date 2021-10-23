package controllers;

import models.GrammarModel;
import models.RuleModel;
import utils.SVGUtils;

public class GrammarControler {

    GrammarModel Grammar;

    public GrammarControler(GrammarModel grammar) {
        Grammar = grammar;
    }

    public void Execute()
    {
        //verificar se todos os caracteres do axioma são válidos no alfabeto
        Grammar.setResult(new StringBuilder().append(Grammar.getAxiom()));
        for(int i = 0; i < Grammar.getRounds();i++)
        {

            for(int j = 0; j < Grammar.getResult().length(); j++)
            {
                for (RuleModel r: Grammar.getRules())
                {
                    if(Grammar.getResult().charAt(j) == r.getTarget().charAt(0))
                    {
                        Grammar.getResult().replace(j,j , r.getReplacementString());
                        j+= r.getReplacementString().length();
                    }
                    //Grammar.appendIntoResult();
                    //Grammar.setResult(Grammar.getResult().replace(r.getTarget(),r.getReplacementString()));
                }
            }


        }

        SVGUtils.drawSVGWithGrammar(Grammar.getResult());
        System.out.println("SVG Gerado com sucesso !!!");

    }
}
