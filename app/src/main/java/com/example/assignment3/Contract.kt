package com.example.assignment3

import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.drawable.Drawable

interface Contract {
    interface View{
        fun getImages(to:Int)
    }

    interface Model{
        fun getImages():ArrayList<Drawable?>
    }

    interface Presenter{
        fun clickNext(cur: Cursor?,cols:String): Bitmap?
        fun clickPrevious(cur: Cursor?,cols:String):Bitmap?
        fun clickFirstPage(cur: Cursor?,cols:String):Bitmap?
        fun clickLastPAge(cur: Cursor?,cols:String):Bitmap?
    }
}