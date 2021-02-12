import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private  static final String BREAK = "break";
    public static void main(String[] args) {
        System.out.println("Условия (для завершения ввести break):");
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        for (;;){
            String condition = scanner.nextLine();
            if (condition.equals(BREAK)) break;
            if (!condition.matches("\\d+(\\.\\d+)?\\s\\w+\\s=\\s\\d+(\\.\\d+)?\\s\\w+")) {
                System.out.println("Условие не соответствует шаблону (a V = b W)");
                continue;
            }
            strings.add(condition);
        }

        ItemSet itemSet = new ItemSet(strings);
        ValueCalculator valueCalculator = new ValueCalculator(itemSet);
        valueCalculator.countConditions();

        System.out.println("Вопросы (для завершения ввести break):");
        for (;;){
            String question = scanner.nextLine();
            if (question.equals(BREAK)) break;
            if (!question.matches("\\d+(\\.\\d+)?\\s\\w+\\s=\\s[?]\\s\\w+")) {
                System.out.println("Вопрос не соответствует шаблону (a V = ? W)");
                continue;
            }
            Matcher matcher = Pattern.compile("(?<coef>\\d+(\\.\\d+)?)\\s(?<name1>\\w+)\\s=\\s[?]\\s(?<name2>\\w+)").matcher(question);
            if (matcher.find()){
                double coef = Double.parseDouble(matcher.group("coef"));
                String name1 = matcher.group("name1");
                String name2 = matcher.group("name2");
                Optional searchCoef = itemSet.getConditions().get(name1).stream().filter(item -> item.getName().equals(name2)).map((i1) -> i1.getCoef()).findAny();
                if (searchCoef.isEmpty())
                    System.out.println("Conversion not possible.");
                else{
                    double value = (Double)searchCoef.get() * coef;
                    System.out.println(String.format("%.2f",coef) + " " + name1 + " = " + String.format("%.2f",value) + " " + name2);
                }
            }
        }

    }

}
