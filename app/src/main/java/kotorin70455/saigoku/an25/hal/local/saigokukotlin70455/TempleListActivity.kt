package kotorin70455.saigoku.an25.hal.local.saigokukotlin70455

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class TempleListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temple_list)

        val lvTemple = findViewById<ListView>(R.id.lvTemple)
        val templeList = createTempleList()
        val adapter = ArrayAdapter<String>(this@TempleListActivity, android.R.layout.simple_list_item_1,templeList)

        // JAVA   : lvTemple.setAdapter(adapter)
        // kotlin : lvTemple.adapter = adapterContent
        lvTemple.adapter = adapter
        // listenerの登録

        lvTemple.onItemClickListener = LvTempleOnClick()
    }

    private  fun createTempleList():List<String>{
        val templeList = listOf<String>().toMutableList();
        templeList += "第一番 青岸渡寺"
        templeList += "第二番 金剛宝寺"
        return templeList
    }

    // inner class としないと親クラスの変数にアクセスできない。
    private inner class LvTempleOnClick : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>, _view: View, position: Int, _id: Long) {
            val templeName = parent.getItemAtPosition(position) as String
            println(templeName)
            println(position)

            val intent = Intent(this@TempleListActivity,TempleEditActivity::class.java)
            intent.putExtra("selectedTempleNo", position)
            intent.putExtra("selectedTempleName", templeName)
            startActivity(intent)


        }
    }


}
