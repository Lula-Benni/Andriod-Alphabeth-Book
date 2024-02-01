package com.example.assignment3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import java.io.File
import java.io.FileOutputStream

class Model(co: Context,dir:File) : Thread(),Contract.Model {
    private val col:Context
    private lateinit var file:File
    private var dir:File? = null
    init {
        col = co
        this.dir = dir
    }

    //@JvmName("getImages")
    @SuppressLint("UseCompatLoadingForDrawables")

    override fun getImages():ArrayList<Drawable?>{
        val images:ArrayList<Drawable?> = ArrayList<Drawable?>(26)
        images.add(col.getDrawable(R.drawable.slide01))
        images.add(col.getDrawable(R.drawable.slide02))
        images.add(col.getDrawable(R.drawable.slide03))
        images.add(col.getDrawable(R.drawable.slide04))
        images.add(col.getDrawable(R.drawable.slide05))
        images.add(col.getDrawable(R.drawable.slide06))
        images.add(col.getDrawable(R.drawable.slide07))
        images.add(col.getDrawable(R.drawable.slide08))
        images.add(col.getDrawable(R.drawable.slide09))
        images.add(col.getDrawable(R.drawable.slide10))
        images.add(col.getDrawable(R.drawable.slide11))
        images.add(col.getDrawable(R.drawable.slide12))
        images.add(col.getDrawable(R.drawable.slide13))
        images.add(col.getDrawable(R.drawable.slide14))
        images.add(col.getDrawable(R.drawable.slide15))
        images.add(col.getDrawable(R.drawable.slide16))
        images.add(col.getDrawable(R.drawable.slide17))
        images.add(col.getDrawable(R.drawable.slide18))
        images.add(col.getDrawable(R.drawable.slide19))
        images.add(col.getDrawable(R.drawable.slide20))
        images.add(col.getDrawable(R.drawable.slide21))
        images.add(col.getDrawable(R.drawable.slide22))
        images.add(col.getDrawable(R.drawable.slide23))
        images.add(col.getDrawable(R.drawable.slide24))
        images.add(col.getDrawable(R.drawable.slide25))
        images.add(col.getDrawable(R.drawable.slide26))

        return images
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun run() {
        var count = 1

        for (img in getImages()!!){
            val img: Drawable? = img//col.getDrawable(R.drawable.slide01)
            val bitMap = (img as BitmapDrawable).bitmap
            val folder = File(dir?.absolutePath,"Alphabet")
            folder.mkdir()
            file = if(count<10)
                File(folder.path, "slide0$count.PNG")
            else
                File(folder.path, "slide$count.PNG")
            if(file.exists()){
                file.delete()
            }
            try {
                val out = FileOutputStream(file)
                bitMap.compress(Bitmap.CompressFormat.PNG, 100, out)
                out.flush()
                out.close()
            } catch (e: Exception) {
                print("Could not save image")
            }
            count++
        }
    }
}