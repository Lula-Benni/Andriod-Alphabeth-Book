package com.example.assignment3

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() ,Contract.View{
    val cols = listOf(MediaStore.Images.Media.DATA).toTypedArray()
    private var path:String?=null
    companion object{var cur:Cursor? = null}

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("SdCardPath", "Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Overview Page"
        //try saving image
        GlobalScope.launch {  Model(baseContext, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)).start()}
        //Done

        //Button Listeners
        val btnA = findViewById<Button>(R.id.buttonA)
        btnA.setOnClickListener {
            GlobalScope.launch { getImages(1) }
        }

        val btnB = findViewById<Button>(R.id.buttonB)
        btnB.setOnClickListener {
            GlobalScope.launch { getImages(2)}
        }
        val btnC = findViewById<Button>(R.id.buttonC)
        btnC.setOnClickListener {
            GlobalScope.launch { getImages(3)}
        }

        val btnD = findViewById<Button>(R.id.buttonD)
        btnD.setOnClickListener {
            GlobalScope.launch {getImages(4) }
        }
        val btnE = findViewById<Button>(R.id.buttonE)
        btnE.setOnClickListener {
            GlobalScope.launch { getImages(5) }
        }

        val btnF = findViewById<Button>(R.id.buttonF)
        btnF.setOnClickListener {
            GlobalScope.launch { getImages(6)}
        }
        val btnG = findViewById<Button>(R.id.buttonG)
        btnG.setOnClickListener {
            GlobalScope.launch { getImages(7)}
        }

        val btnH = findViewById<Button>(R.id.buttonH)
        btnH.setOnClickListener {
            GlobalScope.launch { getImages(8)}
        }
        val btnI = findViewById<Button>(R.id.buttonI)
        btnI.setOnClickListener {
            GlobalScope.launch { getImages(9)}
        }

        val btnJ = findViewById<Button>(R.id.buttonJ)
        btnJ.setOnClickListener {
            GlobalScope.launch { getImages(10)}
        }
        val btnK = findViewById<Button>(R.id.buttonK)
        btnK.setOnClickListener {
            GlobalScope.launch { getImages(11)}
        }

        val btnL = findViewById<Button>(R.id.buttonL)
        btnL.setOnClickListener {
            GlobalScope.launch { getImages(12)}
        }
        val btnM = findViewById<Button>(R.id.buttonM)
        btnM.setOnClickListener {
            GlobalScope.launch { getImages(13)}
        }

        val btnN = findViewById<Button>(R.id.buttonN)
        btnN.setOnClickListener {
            GlobalScope.launch { getImages(14)}
        }
        val btnO = findViewById<Button>(R.id.buttonO)
        btnO.setOnClickListener {
            GlobalScope.launch { getImages(15)}
        }

        val btnP = findViewById<Button>(R.id.buttonP)
        btnP.setOnClickListener {
            GlobalScope.launch { getImages(16) }
        }
        val btnQ = findViewById<Button>(R.id.buttonQ)
        btnQ.setOnClickListener {
            GlobalScope.launch { getImages(17)}
        }

        val btnR = findViewById<Button>(R.id.buttonR)
        btnR.setOnClickListener {
            GlobalScope.launch { getImages(18)}
        }
        val btnS = findViewById<Button>(R.id.buttonS)
        btnS.setOnClickListener {
            GlobalScope.launch { getImages(19)}
        }

        val btnT = findViewById<Button>(R.id.buttonT)
        btnT.setOnClickListener {
            GlobalScope.launch { getImages(20)}
        }
        val btnU = findViewById<Button>(R.id.buttonU)
        btnU.setOnClickListener {
            GlobalScope.launch { getImages(21)
            }
        }

        val btnV = findViewById<Button>(R.id.buttonV)
        btnV.setOnClickListener {
            GlobalScope.launch {
                getImages(22) }
        }
        val btnW = findViewById<Button>(R.id.buttonW)
        btnW.setOnClickListener {
            GlobalScope.launch { getImages(23) }
        }

        val btnX = findViewById<Button>(R.id.buttonX)
        btnX.setOnClickListener {
            GlobalScope.launch {getImages(24)}
        }
        val btnY = findViewById<Button>(R.id.buttonY)
        btnY.setOnClickListener {
            GlobalScope.launch {getImages(25)}
        }

        val btnZ = findViewById<Button>(R.id.buttonZ)
        btnZ.setOnClickListener {
            GlobalScope.launch { getImages(26) }
        }

        if (savedInstanceState!=null){
            path =savedInstanceState.getString("path")
        }
    }

    @SuppressLint("Recycle")
    override fun getImages(to: Int) {
        val currentImg: Uri = MediaStore.Files.getContentUri("external")
        cur = contentResolver.query(currentImg,cols,MediaStore.Images.Media.DATA+" like ? ",arrayOf("%Alphabet%"),null)
        cur?.move(to)
        val index = cur?.getColumnIndex(cols[0])
        path = index?.let { cur?.getString(it) }

        val img = ImageView(baseContext)
        val bitmap = BitmapFactory.decodeFile(path)
        img.setImageBitmap(bitmap)

        val i = Intent(applicationContext, ImageActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
        i.putExtra("path", path)
        startActivity(i)
    }

    @Override
    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString("path", path)
    }
    @Override
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        path =savedInstanceState.getString(path)
    }
}