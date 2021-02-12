import java.util.*;
import java.util.stream.Collectors;

public class ValueCalculator {
    ItemSet itemSet;

    public ValueCalculator(ItemSet itemSet) {
        this.itemSet = itemSet;
    }

    public void countConditions(){
        Map<String, List<Item>> conditions = itemSet.getConditions();
        boolean isEnd = true;
        while (isEnd) {
            isEnd=false;
            for (Map.Entry<String,List<Item>> entry : conditions.entrySet()){
                Set<String> names = new HashSet<>();
                names.add(entry.getKey());
                entry.getValue().stream().map(Item::getName).forEach(names::add);
                List<Item> items = new ArrayList<>();
                for (Item item : entry.getValue()){
                    List<Item> itemsToAdd = conditions.get(item.getName()).stream().filter(item1 -> !names.contains(item1.getName())).collect(Collectors.toList());
                    for (Item i : itemsToAdd) {
                        if (!names.contains(i.getName())){
                            names.add(i.getName());
                            Item item2 = new Item( item.getCoef() * i.getCoef() , i.getName() );
                            items.add(item2);
                            isEnd = true;}
                    }
                }
                entry.getValue().addAll(items);
            }
        }
    }
}
