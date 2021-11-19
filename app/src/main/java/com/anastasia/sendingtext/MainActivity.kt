package com.anastasia.sendingtext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_MESSAGE = "com.anastasia.sendingtext.MESSAGE"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Function is called when user taps Save button
    fun sendMessage(view: View) {
        val editRecipeName = findViewById<EditText>(R.id.edit_recipe_name)
        val message = editRecipeName.text.toString()
        // The Intent constructor takes two parameters, a Context and a Class.
        //The Context parameter is used first because the Activity class is a subclass of Context.
        //The Class parameter of the app component, to which the system delivers the Intent, is, in this case, the activity to start.
        val intent = Intent(this, DisplayRecipe::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
      //  The putExtra() method adds the value of EditText to the intent. An Intent can carry data types as key-value pairs called extras.
      //  Your key is a public constant EXTRA_MESSAGE because the next activity uses the key to retrieve the text value.
        startActivity(intent)
    }
}