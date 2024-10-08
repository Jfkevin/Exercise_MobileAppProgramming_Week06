package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
        //Glide is used here to load the images
        //Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        //Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.MaineCoon,
                    "Garfield",
                    "Loves lasagna",
                    "https://cdn2.thecatapi.com/images/MTUwMTQwMg.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Ragdoll,
                    "Hello Kitty",
                    "Not a cat",
                    "https://cdn2.thecatapi.com/images/MTUwMTQwMg.jpg"),
                CatModel(
                    Gender.Male,
                    CatBreed.Siamese,
                    "Tom",
                    "Jerry's nemesis",
                    "https://cdn2.thecatapi.com/images/MTUwMTQwMg.jpg"),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Sphynx,
                    "Mr. Bigglesworth",
                    "Evil genius",
                    "https://cdn2.thecatapi.com/images/MTUwMTQwMg.jpg"),
                CatModel(
                    Gender.Male,
                    CatBreed.RussianBlue,
                    "Boris",
                    "Loves vodka",
                    "https://cdn2.thecatapi.com/images/MTUwMTQwMg.jpg"),
                CatModel(
                    Gender.Female,
                    CatBreed.Persian,
                    "Fluffy",
                    "Aku kucing mas",
                    "https://cdn2.thecatapi.com/images/MTUwMTQwMg.jpg"),
                CatModel(
                    Gender.Male,
                    CatBreed.Bengal,
                    "Simba",
                    "King of the jungle",
                    "https://cdn2.thecatapi.com/images/MTUwMTQwMg.jpg")
            )
        )
    }
    //This will create a pop up dialog when one of the items from the recycler view is clicked.
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
//Set the title for the dialog
            .setTitle("Cat Selected")
//Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")
//Set if the OK button should be enabled
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}
