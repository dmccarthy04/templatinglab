import java.util.*;
import java.io.*;
interface Ingredient {
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient {
    private String _name;
    private double _qtyInGrams;
    public SolidIngredient(String n, double q) {
        _name = n;
        _qtyInGrams = q;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity(){
        return _qtyInGrams;
    }
}
class LiquidIngredient implements Ingredient {
    private String _name;
    private double _qtyInMl;
    public LiquidIngredient(String n, double q) {
        _name = n;
        _qtyInMl = q;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity(){
        return _qtyInMl;
    }
}
class Recipe<T extends Ingredient> { //extends indicates a constraint for the type variable/parameter. Only keyword that can be used.
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    public Recipe(String name, String instructions) { //can add int size as parameter
        _ingredients = new ArrayList<T>();
        _name = name;
        _instructions = instructions;
    }
    public void addIngredient(T t) {
        _ingredients.add(t);
    }
    public void print() {
        if(_ingredients != null) {
            for (T ingredient : _ingredients) {
                System.out.println("Ingredients: " + ingredient.getClass().getName() + " " + ingredient.getName() + " " + ingredient.getQuantity());
            }
        }
    }
}
public class Main {
    public static void menu(Recipe<Ingredient> recipe) { //could try catch for type error exception for nextInt()
        System.out.println("1. to add ingredient to recipe");
        System.out.println("2. to print recipe");
        System.out.println("-1. to exit");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        while (select != -1) { //move to individual functions, have menu return choice, switch cases in main
            if (select == 1) {
                System.out.println("For solid ingredient type 's' for liquid type 'l'");
                //need to differentiate type with input scan.nextLine().charAt(0);
                System.out.println("Enter the ingredient name and quantity separated with a space");
                String nameIn = sc.next();
                double qtyIn = sc.nextDouble(); //try catch
                recipe.addIngredient(new SolidIngredient(nameIn, qtyIn));
                //separate adding solid and liquid
            }
            if (select == 2) {
                recipe.print();
            }
            System.out.println("1. to add ingredient to recipe");
            System.out.println("2. to print recipe");
            System.out.println("-1. to exit");
            select = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        Recipe<Ingredient> recipe = new Recipe<>("Sandwich", "Put cheese in bread");
        //Ingredient in Recipe template works similarly to creating an ArrayList<Employees> from an abstract class type
        //since each element is not instantiated only the polymorphic variables are declared as this type
        //can similarly declare a variable with interface type (Ingredient ing;)
        menu(recipe);
    }
}