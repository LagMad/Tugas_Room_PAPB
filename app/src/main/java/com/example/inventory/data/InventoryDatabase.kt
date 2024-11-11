package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    // fungsi abstrak agar database tau tentang DAO
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        // Jika instance dari database tidak ada/null, akan dibuat baru. Jika sudah ada, akan langsung dikembalikan
        fun getDatabase(context: Context): InventoryDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    InventoryDatabase::class.java,
                    "item_database"
                ).build().also { Instance = it }
            }
        }
    }
}