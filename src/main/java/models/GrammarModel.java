package models;

import java.util.ArrayList;
import java.util.List;

public class GrammarModel {

    private String Alphabet;

    private String Axiom;

    private List<RuleModel> Rules;

    private Integer Rounds;

    private StringBuilder Result;

    public Integer getRounds() {
        return Rounds;
    }

    public void addRule(String s)
    {
        String target,replacement;
        String[] aux = s.trim().replace("P:", "").split("->");

        target = aux[0].trim();
        replacement = aux[1].trim();

        Rules.add(new RuleModel(target,replacement));
    }

    public void setRounds(Integer rounds) {
        Rounds = rounds;
    }

    public String getAlphabet() {
        return Alphabet;
    }

    public void setAlphabet(String alphabet) {
        Alphabet = alphabet;
    }

    public String getAxiom() {
        return Axiom;
    }

    public void setAxiom(String axiom) {
        Axiom = axiom;
    }

    public void setResult(StringBuilder result) {
        Result = result;
    }

    public void appendIntoResult(String data)
    {
        if(Result == null)
            return;

        Result.append(data);
    }

    public StringBuilder getResult() {
        return Result;
    }

    public List<RuleModel> getRules() {
        return Rules;
    }

    public void setRules(List<RuleModel> rules) {
        Rules = rules;
    }

    public GrammarModel() {
        Rules = new ArrayList<RuleModel>();
        Result = new StringBuilder();
    }
}
