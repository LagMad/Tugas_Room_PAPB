/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 */

@Entity(tableName = "items")
data class Item(
    // ID dijadikan primary key dan sifatnya unik atau tidak akan ada duplikat satu sama lain. Akan auto-generate oleh aplikasi database.
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Nama item
    val name: String,

    // Harga item
    val price: Double,

    // Kuantitas/banyaknya item
    val quantity: Int
)
