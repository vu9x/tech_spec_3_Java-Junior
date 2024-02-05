package ru.geekbrains.junior.lesson1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    //endregion

    /**
     * Балансировка корзины
     */
    public void cardBalancing()
    {
        AtomicBoolean proteins = new AtomicBoolean(false);
        AtomicBoolean fats = new AtomicBoolean(false);
        AtomicBoolean carbohydrates = new AtomicBoolean(false);

        AtomicBoolean[] isBalanced = {proteins, fats, carbohydrates};

//        boolean proteins1 = false;
//        boolean fats1 = false;
//        boolean carbohydrates1 = false;
//
//        boolean[] isBalanced = {proteins1, fats1, carbohydrates1};

        /*
        for (var food : foodstuffs)
        {
            if (!proteins.get() && food.getProteins())
                proteins.set(true);
            else
            if (!fats.get() && food.getFats())
                fats.set(true);
            else
            if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins.get() && fats.get() && carbohydrates)
                break;
        } */

/*
        if (proteins.get() && fats.get() && carbohydrates)
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }
*/
/*        for (var thing : market.getThings(clazz))
        {
            if (!proteins.get() && thing.getProteins())
            {
                proteins.set(true);
                foodstuffs.add(thing);
            }
            else if (!fats.get() && thing.getFats())
            {
                fats.set(true);
                foodstuffs.add(thing);
            }
            else if (!carbohydrates && thing.getCarbohydrates())
            {
                carbohydrates = true;
                foodstuffs.add(thing);
            }
            if (proteins.get() && fats.get() && carbohydrates)
                break;
        }

        if (proteins.get() && fats.get() && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

*/
        foodstuffs.stream()
                .filter(food -> {
                    if(!proteins.get() && food.getProteins()) proteins.set(true);
                    if(!fats.get() && food.getFats()) fats.set(true);
                    if(!carbohydrates.get() && food.getFats()) carbohydrates.set(true);
                    return true;});


        market.getThings(clazz).stream()
                .forEach(food -> {
                    if(!proteins.get() && food.getProteins()){
                        proteins.set(true);
                        foodstuffs.add(food);};
                    if(!fats.get() && food.getFats()){
                        fats.set(true);
                        foodstuffs.add(food);}
                    if(!carbohydrates.get() && food.getFats()) {
                        carbohydrates.set(true);
                        carbohydrates.set(true);
                    };
                });

        if (proteins.get() && fats.get() && carbohydrates.get())
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs(){
        /*int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");
         */
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));

    }

}
