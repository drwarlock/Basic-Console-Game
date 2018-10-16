package cards;

import java.util.List;

public interface Card {
	String getName();
	CardType getType();
	List<CardValue> getValues();
}
