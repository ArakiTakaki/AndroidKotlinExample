package kotorin70455.saigoku.an25.hal.local.saigokukotlin70455.dataaccesss

import android.database.sqlite.SQLiteDatabase
import kotorin70455.saigoku.an25.hal.local.saigokukotlin70455.Temple


fun findTmpleByPK(db :SQLiteDatabase, temple:Temple){
    val sql = "SELECT name, honzon, shushi, address, url, note  FROM temples WHERE _id = " + temple.id
    val cursor = db.rawQuery(sql,null)
    if(!cursor.moveToNext()) return
    var idxContent = cursor.getColumnIndex("name")
    temple.name = cursor.getString(idxContent)
    idxContent = cursor.getColumnIndex("honzon")
    temple.honzon = cursor.getString(idxContent)

    idxContent = cursor.getColumnIndex("shushi")
    temple.shushi = cursor.getString(idxContent)

    idxContent = cursor.getColumnIndex("address")
    temple.address = cursor.getString(idxContent)

    idxContent = cursor.getColumnIndex("url")
    temple.url = cursor.getString(idxContent)

    idxContent = cursor.getColumnIndex("note")
    temple.note = cursor.getString(idxContent)
}

fun replaceTemple(db :SQLiteDatabase, temple: Temple){
    val sql = "REPLACE INTO temples(_id, name, honzon, shushi, address, url, note) VALUES( ?, ?, ?, ?, ?, ?, ?)"
    val stmt = db.compileStatement(sql)
    stmt.bindLong(1, temple.id.toLong())
    stmt.bindString(2, temple.name)
    stmt.bindString(3, temple.honzon)
    stmt.bindString(4, temple.shushi)
    stmt.bindString(5, temple.address)
    stmt.bindString(6, temple.url)
    stmt.bindString(7, temple.note)
    stmt.execute()
}