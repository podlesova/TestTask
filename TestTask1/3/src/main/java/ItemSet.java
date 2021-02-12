import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemSet {

    private  Map<String, List<Item>>  conditions = new HashMap<>();

    public ItemSet(List<String> strings) {
        for (String condition: strings) {
            Matcher matcher = Pattern.compile("(?<coef1>\\d+(\\.\\d+)?)\\s(?<name1>\\w+)\\s=\\s(?<coef2>\\d+(\\.\\d+)?)\\s(?<name2>\\w+)").matcher(condition);
            if (matcher.find()) {
                double coef1 = Double.parseDouble(matcher.group("coef1"));
                double coef2 = Double.parseDouble(matcher.group("coef2"));
                String name1 = matcher.group("name1");
                String name2 = matcher.group("name2");
                addItem(coef2 / coef1, name1, name2);
                addItem(coef1 / coef2, name2, name1);
            }
        }
    }

    public void addItem(double coef,  String name1, String name2){
        if (conditions.containsKey(name1)){
            List<Item> value = conditions.get(name1);
            value.add(new Item(coef,name2));
        }
        else {
            List<Item> value = new ArrayList<>();
            value.add(new Item(coef,name2));
            conditions.put(name1,value);
        }

    }

    public Map<String, List<Item>> getConditions() {
        return conditions;
    }
}
