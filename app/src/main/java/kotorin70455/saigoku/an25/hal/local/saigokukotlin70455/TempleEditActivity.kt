package kotorin70455.saigoku.an25.hal.local.saigokukotlin70455

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotorin70455.saigoku.an25.hal.local.saigokukotlin70455.dataaccesss.findTmpleByPK
import kotorin70455.saigoku.an25.hal.local.saigokukotlin70455.dataaccesss.replaceTemple

class TempleEditActivity : AppCompatActivity() {

    private var temple = Temple();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temple_edit)

        val tvName = findViewById<TextView>(R.id.tvName)
        val etHonzon = findViewById<EditText>(R.id.etHonzon)
        val etShushi = findViewById<EditText>(R.id.etShushi)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etUrl = findViewById<EditText>(R.id.etUrl)
        val etNote = findViewById<EditText>(R.id.etNote)

        temple.name = intent.getStringExtra("selectedTempleName")
        temple.id = intent.getIntExtra("selectedTempleNo", 0)
        // kotlin的にはgetter setterはあまり好まれないらしい。
        tvName.text = temple.name

        //getIntentしなくても取得することが可能。
        val db = DatabaseHelper(this@TempleEditActivity).readableDatabase
        try{
            findTmpleByPK(db,temple)
        }catch(ex :Exception){
            Log.e("TempleKotlin",ex.toString())
        }finally{
            db.close()
        }
        Editable.Factory()

        // String型はsetTextを通して変換する。　多分Editableオブジェクトを使用すればKotlinらしく記述できそうな感じある
        etHonzon.setText(temple.honzon)
        etShushi.setText(temple.shushi)
        etAddress.setText(temple.address)
        etUrl.setText(temple.url)
        etNote.setText(temple.note)

//        val btSave = findViewById<Button>(R.id.btSave)
    }

    fun btSaveOnClick(view: View?){

        val etHonzon = findViewById<EditText>(R.id.etHonzon)
        val etShushi = findViewById<EditText>(R.id.etShushi)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etUrl = findViewById<EditText>(R.id.etUrl)
        val etNote = findViewById<EditText>(R.id.etNote)

        temple.honzon = etHonzon.text.toString()
        temple.shushi = etShushi.text.toString()
        temple.address = etAddress.text.toString()
        temple.url = etUrl.text.toString()
        temple.note = etNote.text.toString()

        val db = DatabaseHelper(this@TempleEditActivity).writableDatabase
        //いわゆるgetter settter
        try{
            replaceTemple(db,temple)
        }catch(ex:Exception){
            Log.e("TempleKotlin",ex.toString())
        }finally{
            db.close()
        }
        finish()
    }
}
