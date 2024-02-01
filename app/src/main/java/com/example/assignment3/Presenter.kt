package com.example.assignment3

import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class Presenter: Contract.Presenter{
    override fun clickNext(cur: Cursor?, cols:String): Bitmap? {
        var bitmap: Bitmap? = null
        cur?.moveToNext()
        if (cur?.isAfterLast == true) {
            //nxtBtn.isEnabled = false
            cur?.moveToPrevious()
        }
        else{
            val index = cur?.getColumnIndex(MainActivity().cols[0])
            val path = index?.let { it1 -> cur?.getString(it1) }
            bitmap = BitmapFactory.decodeFile(path)
            //imgView.setImageBitmap(bitmap)
        }
        return bitmap
    }

    override fun clickPrevious(cur: Cursor?,cols:String):Bitmap? {
        var bitmap: Bitmap? = null
        cur?.moveToPrevious()
        if(cur?.isBeforeFirst==true){
            cur?.moveToNext()
            //prevBtn.isEnabled=false
        }
        else{
            val index = cur?.getColumnIndex(MainActivity().cols[0])
            val path = index?.let { it1 -> cur?.getString(it1) }
            bitmap = BitmapFactory.decodeFile(path)
            //imgView.setImageBitmap(bitmap)
        }
        return bitmap
    }

    override fun clickFirstPage(cur: Cursor?,cols:String):Bitmap? {
        var bitmap: Bitmap? = null
        cur?.moveToFirst()
        val index = cur?.getColumnIndex(MainActivity().cols[0])
        val path = index?.let { it1 -> cur?.getString(it1) }
        bitmap = BitmapFactory.decodeFile(path)
        //imgView.setImageBitmap(bitmap)
        return bitmap
    }

    override fun clickLastPAge(cur: Cursor?,cols:String):Bitmap? {
        var bitmap: Bitmap? = null
        cur?.moveToLast()
        val index = cur?.getColumnIndex(MainActivity().cols[0])
        val path = index?.let { it1 -> cur?.getString(it1) }
        bitmap = BitmapFactory.decodeFile(path)
        //imgView.setImageBitmap(bitmap)
        return bitmap
    }

}