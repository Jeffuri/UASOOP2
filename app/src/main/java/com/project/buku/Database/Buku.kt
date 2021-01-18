package com.project.buku.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buku")
data class Buku(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "namabuku") val namabuku: String,
    @ColumnInfo(name = "jumlah") val jumlah: Int,
    @ColumnInfo(name = "harga") val harga: Int
)