public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        Meal vegMeal = builder.PrepareVegMeal();
        Meal nonVegMeal = builder.PrepareNonVegMeal();

        System.out.println("VegMeal:");
        vegMeal.showItems();
        System.out.println("Total Cost:" + vegMeal.getCost());

        System.out.println("\nNonVegMeal:");
        nonVegMeal.showItems();
        System.out.println("Total Cost:" + nonVegMeal.getCost());
    }
}
