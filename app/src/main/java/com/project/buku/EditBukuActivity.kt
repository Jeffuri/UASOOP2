package com.project.buku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.project.buku.Database.AppRoomDB
import com.project.buku.Database.Constant
import com.project.buku.Database.Buku
import kotlinx.android.synthetic.main.activity_edit_buku.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditBukuActivity : AppCompatActivity() {

    val db by lazy { AppRoomDB(this) }
    private var sepatuId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_buku)
        setupListener()
        setupView()
    }

    fun setupListener(){
        btn_saveBuku.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.bukuDao().addBuku(
                    Buku(0, txt_buku.text.toString(), Integer.parseInt(txt_jumlah.text.toString()), Integer.parseInt(txt_harga.text.toString()) )
                )
                finish()
            }
        }
        btn_updateBuku.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.bukuDao().updateBuku(
                    Buku(sepatuId, txt_buku.text.toString(), Integer.parseInt(txt_jumlah.text.toString()), Integer.parseInt(txt_harga.text.toString()) )
                )
                finish()
            }
        }
    }

    fun setupView() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val intentType = intent.getIntExtra("intent_type", 0)
        when (intentType) {
            Constant.TYPE_CREATE -> {
                btn_updateBuku.visibility = View.GONE
            }
            Constant.TYPE_READ -> {
                btn_saveBuku.visibility = View.GONE
                btn_updateBuku.visibility = View.GONE
                getBuku()
            }
            Constant.TYPE_UPDATE -> {
                btn_saveBuku.visibility = View.GONE
                getBuku()
            }
        }
    }

    fun getBuku() {
        sepatuId = intent.getIntExtra("intent_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
           val sepatus =  db.bukuDao().getBuku( sepatuId )[0]
            txt_buku.setText( sepatus.namabuku )
            txt_jumlah.setText( sepatus.jumlah.toString() )
            txt_harga.setText( sepatus.harga.toString() )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}