package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
}


	
    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            Item ithItem = items.get(i);
			if ((!"Aged Brie".equals(ithItem.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(ithItem.getName())) 
            {
                if (ithItem.getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(ithItem.getName()))
                    {
                        ithItem.setQuality(ithItem.getQuality() - 1);
                    }
                }
            }
            else
            {
                if (ithItem.getQuality() < 50)
                {
                    ithItem.setQuality(ithItem.getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(ithItem.getName()))
                    {
                        if (ithItem.getSellIn() < 11)
                        {
                            if (ithItem.getQuality() < 50)
                            {
                                ithItem.setQuality(ithItem.getQuality() + 1);
                            }
                        }

                        if (ithItem.getSellIn() < 6)
                        {
                            if (ithItem.getQuality() < 50)
                            {
                                ithItem.setQuality(ithItem.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(ithItem.getName()))
            {
                ithItem.setSellIn(ithItem.getSellIn() - 1);
            }

            if (ithItem.getSellIn() < 0)
            {
                if (!"Aged Brie".equals(ithItem.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(ithItem.getName()))
                    {
                        if (ithItem.getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(ithItem.getName()))
                            {
                                ithItem.setQuality(ithItem.getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        ithItem.setQuality(ithItem.getQuality() - ithItem.getQuality());
                    }
                }
                else
                {
                    if (ithItem.getQuality() < 50)
                    {
                        ithItem.setQuality(ithItem.getQuality() + 1);
                    }
                }
            }
        }
    }

}
