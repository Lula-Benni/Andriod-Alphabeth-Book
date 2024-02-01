package com.example.assignment3

import android.content.Intent
import android.database.Cursor
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

open class ImageActivity : AppCompatActivity() {
    private var cur:Cursor? = MainActivity.cur
    private val prefs = "picture"
    companion object{private var picture =0}
    private var path:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        title="Letter Page"
        val imgView : ImageView = findViewById(R.id.imageView)
        val bundle = intent.extras
        if (bundle!=null) {
            picture= bundle.getInt(prefs)
            imgView.setImageResource(picture)
        }
        path = intent.getStringExtra("path")
        val bitmap = BitmapFactory.decodeFile(path)
        imgView.setImageBitmap(bitmap)

        val firstBtn = findViewById<Button>(R.id.first_Btn)
        firstBtn.setOnClickListener {
            cur?.moveToFirst()
            val index = cur?.getColumnIndex(MainActivity().cols[0])
            val path = index?.let { it1 -> cur?.getString(it1) }
            val bitmap = BitmapFactory.decodeFile(path)
            imgView.setImageBitmap(bitmap)
        }

        val lastBtn = findViewById<Button>(R.id.last_Btn)
        lastBtn.setOnClickListener {
            cur?.moveToLast()
            val index = cur?.getColumnIndex(MainActivity().cols[0])
            path = index?.let { it1 -> cur?.getString(it1) }
            val bitmap = BitmapFactory.decodeFile(path)
            imgView.setImageBitmap(bitmap)
        }

        val overViewBtn = findViewById<Button>(R.id.overview_button)
        overViewBtn.setOnClickListener {
            val intent = Intent(this@ImageActivity,MainActivity::class.java)
            startActivity(intent)
        }

        val nxtBtn = findViewById<Button>(R.id.Next_button)
        nxtBtn.setOnClickListener {
            cur?.moveToNext()
            if (cur?.isAfterLast == true) {
                cur?.moveToPrevious()
            }
            else{
                val index = cur?.getColumnIndex(MainActivity().cols[0])
                val path = index?.let { it1 -> cur?.getString(it1) }
                val bitmap = BitmapFactory.decodeFile(path)
                imgView.setImageBitmap(bitmap)
            }
        }

        val prevBtn = findViewById<Button>(R.id.prev_button)
        prevBtn.setOnClickListener {
            cur?.moveToPrevious()
            if(cur?.isBeforeFirst==true){
                cur?.moveToNext()
            }
            else{
                val index = cur?.getColumnIndex(MainActivity().cols[0])
                val path = index?.let { it1 -> cur?.getString(it1) }
                val bitmap = BitmapFactory.decodeFile(path)
                imgView.setImageBitmap(bitmap)
            }
        }
        if (savedInstanceState!=null){
            path =savedInstanceState.getString("path")
            picture=savedInstanceState.getInt("picture")
        }
    }

    @Override
    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putInt("picture", picture)
        savedInstanceState.putString("path",path)
        super.onSaveInstanceState(savedInstanceState)
    }
    @Override
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        picture = savedInstanceState.getInt("picture")
        path=savedInstanceState.getString("path")
    }
}