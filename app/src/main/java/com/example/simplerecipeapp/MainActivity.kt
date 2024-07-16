package com.example.simplerecipeapp

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerDishType: Spinner
    private lateinit var buttonGetRecipe: Button
    private lateinit var textViewRecipe: TextView

    private val recipesAppetizer = arrayOf(
        "Bruschetta: Bread, tomatoes, basil, garlic, olive oil.",
        "Stuffed Mushrooms: Mushrooms, cheese, breadcrumbs, garlic.",
        "Deviled Eggs: Eggs, mayonnaise, mustard, paprika."
    )

    private val recipesMainCourse = arrayOf(
        "Grilled Chicken: Chicken, olive oil, lemon, herbs.",
        "Pasta Primavera: Pasta, vegetables, olive oil, parmesan.",
        "Beef Tacos: Beef, tortillas, cheese, lettuce, salsa."
    )

    private val recipesDessert = arrayOf(
        "Chocolate Cake: Flour, cocoa, sugar, eggs, butter.",
        "Fruit Salad: Assorted fruits, honey, lemon juice.",
        "Ice Cream Sundae: Ice cream, chocolate sauce, nuts, cherries."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerDishType = findViewById(R.id.spinnerDishType)
        buttonGetRecipe = findViewById(R.id.buttonGetRecipe)
        textViewRecipe = findViewById(R.id.textViewRecipe)

        val dishTypes = resources.getStringArray(R.array.dish_types)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dishTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDishType.adapter = adapter

        buttonGetRecipe.setOnClickListener {
            val selectedDishType = spinnerDishType.selectedItem.toString()
            val recipe = getRecipe(selectedDishType)
            textViewRecipe.text = recipe
        }
    }

    private fun getRecipe(dishType: String): String {
        return when (dishType) {
            "Appetizer" -> recipesAppetizer.random()
            "Main Course" -> recipesMainCourse.random()
            "Dessert" -> recipesDessert.random()
            else -> "Enjoy cooking!"
        }
    }
}
