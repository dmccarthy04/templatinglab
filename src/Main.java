import java.util.*;
import java.io.*;
interface Ingredient {
    String getName();
    int getQuantity();
}
class SolidIngredient implements Ingredient {
    private String _name;
    private int _quantity;
    public SolidIngredient(String n, int q) {
        _name = n;
        _quantity = q;
    }
    public String getName() {
        return _name;
    }
    public int getQuantity(){
        return _quantity;
    }
}
class LiquidIngredient implements Ingredient {
    private String _name;
    private int _quantity;
    public LiquidIngredient(String n, int q) {
        _name = n;
        _quantity = q;
    }
    public String getName() {
        return _name;
    }
    public int getQuantity(){
        return _quantity;
    }
}
class Recipe<T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    public Recipe(String name, String instructions, int size) {
        _ingredients = new ArrayList<T>(size);
        _name = name;
        _instructions = instructions;
    }
    public void addIngredient(T t) {
        _ingredients.add(t);
    }
    public void print() {
        if(_ingredients != null) {
            for(int i=0;i< _ingredients.size();i++) {
                System.out.println("Ingredients: " + _ingredients.get(i).getClass().getName());
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Recipe<SolidIngredient> solidRecipe= new Recipe<>("Sandwich", "Instructions", 2);
        solidRecipe.addIngredient(new SolidIngredient("bread", 2));
        solidRecipe.addIngredient(new SolidIngredient("cheese", 1));
        solidRecipe.print();
    }
}