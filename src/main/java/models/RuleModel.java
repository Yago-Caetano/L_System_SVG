package models;

public class RuleModel {

   private String Target;

   private String ReplacementString;

   public String getTarget() {
      return Target;
   }

   public String getReplacementString() {
      return ReplacementString;
   }

   public RuleModel(String target, String replacementString) {
      Target = target;
      ReplacementString = replacementString;
   }
}
