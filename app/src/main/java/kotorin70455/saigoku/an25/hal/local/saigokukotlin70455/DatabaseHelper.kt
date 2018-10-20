package kotorin70455.saigoku.an25.hal.local.saigokukotlin70455

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private const val DATABASE_NAME = "saigokukotlin70455.db"
private const val DATABASE_VERSION = 1

class DatabaseHelper : SQLiteOpenHelper{

    constructor(context :Context) : super(context, DATABASE_NAME , null, DATABASE_VERSION){ }

    override fun onCreate(db: SQLiteDatabase) {
        val sb = StringBuilder()
        sb.append("CREATE TABLE temples (")
        sb.append("_id INTEGER,")
        sb.append("name TEXT,")
        sb.append("honzon TEXT,")
        sb.append("shushi TEXT,")
        sb.append("address TEXT,")
        sb.append("url TEXT,")
        sb.append("note TEXT,")
        sb.append("PRIMARY KEY (_id)")
        sb.append(");")
        db.execSQL(sb.toString())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

}