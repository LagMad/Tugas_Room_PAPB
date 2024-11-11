package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import androidx.room.Update

@Dao
interface ItemDao {

    // Menambahkan data baru ke tabel items
    @Insert(onConflict = OnConflictStrategy.IGNORE) // Jika ada konflik, data baru yang ditambahkan akan diabaikan
    suspend fun insert(item: Item)

    // Memperbarui data yang sudah ada di dalam tabel items
    @Update
    suspend fun update(item: Item)

    // Menghapus data dari tabel 'items'
    @Delete
    suspend fun delete(item: Item)

    // Mengambil satu data berdasarkan ID-nya dari tabel items dan mengembalikannya sebagai flow
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    // Mengambil semua data dari tabel items lalu mengurutkan berdasarkan nama secara ascending/menaik, dan mengembalikannya sebagai flow.
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}