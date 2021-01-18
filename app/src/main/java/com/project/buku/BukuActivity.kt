package com.project.buku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.buku.Database.AppRoomDB
import com.project.buku.Database.Constant
import com.project.buku.Database.Buku
import kotlinx.android.synthetic.main.activity_buku.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BukuActivity : AppCompatActivity() {

    val db by lazy { AppRoomDB(this) }
    lateinit var bukuAdapter: BukuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buku)
        setupListener()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        loadBuku()
    }

    fun loadBuku(){
        CoroutineScope(Dispatchers.IO).launch {
            val allBuku = db.bukuDao().getAllBuku()
            Log.d("BukuActivity", "dbResponse: $allBuku")
            withContext(Dispatchers.Main) {
                bukuAdapter.setData(allBuku)
            }
        }
    }

    fun setupListener() {
        btn_createBuku.setOnClickListener {
           intentEdit(0, Constant.TYPE_CREATE)
        }
    }

    fun setupRecyclerView() {
        bukuAdapter = BukuAdapter(arrayListOf(), object: BukuAdapter.OnAdapterListener {
            override fun onClick(buku: Buku) {
                // read detail
                intentEdit(buku.id, Constant.TYPE_READ)
            }

            override fun onDelete(buku: Buku) {
                // delete data
                deleteDialog(buku)
            }

            override fun onUpdate(buku: Buku) {
                // edit data
                intentEdit(buku.id, Constant.TYPE_UPDATE)
            }

        })
        list_buku.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = bukuAdapter
        }
    }

    fun intentEdit(bukuId: Int, intentType: Int ) {
        startActivity(
            Intent(applicationContext, EditBukuActivity::class.java)
                .putExtra("intent_id", bukuId)
                .putExtra("intent_type", intentType)
        )
    }

    private fun deleteDialog(buku: Buku) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("Konfirmasi")
            setMessage("Yakin ingin menghapus data ini?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.bukuDao().deleteBuku(buku)
                    loadBuku()
                }
            }
        }
        alertDialog.show()
    }
}