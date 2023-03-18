package com.example.yasin



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView



class Tampil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Initialize data.
        val myDataset = loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }


        fun loadAffirmations(): List<Affirmation> {
            return listOf<Affirmation>(
                Affirmation(R.string.affirmation1, R.drawable.bintang),
                Affirmation(R.string.affirmation2, R.drawable.alif),
                Affirmation(R.string.affirmation3, R.drawable.yudis),
                Affirmation(R.string.affirmation4, R.drawable.dhika),
                Affirmation(R.string.affirmation5, R.drawable.zearmy),
                Affirmation(R.string.affirmation6, R.drawable.akmal),
                Affirmation(R.string.affirmation7, R.drawable.arka),
                Affirmation(R.string.affirmation8, R.drawable.sila),
            )
        }
    }