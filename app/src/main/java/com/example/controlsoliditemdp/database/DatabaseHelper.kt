package com.example.controlsoliditemdp.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "passwords.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "passwords"
        private const val COLUMN_ID = "id"
        private const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableStatement =
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_PASSWORD TEXT)"
        db.execSQL(createTableStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertPassword(password: String) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_PASSWORD, password)
        db.insert(TABLE_NAME, null, cv)
    }

    fun isOldPassword(password: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT COUNT(*) FROM $TABLE_NAME WHERE $COLUMN_PASSWORD = ?", arrayOf(password))
        cursor.moveToFirst()
        val count = cursor.getInt(0)
        cursor.close()
        return count > 0
    }
}