package developer.abdusamid.phones

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import developer.abdusamid.phones.MyShare.MyShare
import developer.abdusamid.phones.Object.Object
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    lateinit var arrayList: ArrayList<Dataa>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        MyShare.init(this)
        arrayList = ArrayList()
        arrayList.addAll(MyShare.dataList!!)
        val arrayListDinamikView = BuildArrayModel(arrayList)
        for (i in arrayListDinamikView.indices) {
            BuildDinamikView(arrayListDinamikView[i])
        }

        btn_saqlash.setOnClickListener {
            if (btn_saqlash.text == "Add") {
                btn_saqlash.text = "Save"
                ti_nomi.visibility = View.VISIBLE
            }
            if (btn_saqlash.text == "Save") {
                val modelNomi = edt_ModelNomi.text
                if (modelNomi.toString() != "") {
                    arrayList.add(Dataa("", modelNomi.toString(), ""))
                    MyShare.dataList = arrayList
                    BuildDinamikView(modelNomi.toString())
                    edt_ModelNomi.text!!.clear()
                    ti_nomi.visibility = View.GONE
                    btn_saqlash.text = "Add"
                }
            }
        }

    }

    fun BuildDinamikView(string: String) {
        val view = layoutInflater.inflate(R.layout.dinamik_view, null)
        val nomi = view.findViewById<TextView>(R.id.tv_model)
        nomi.text = string
        nomi.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
            Object.string = string
        }
        containerAdd.addView(view)
    }
}

private fun BuildArrayModel(arrayList: ArrayList<Dataa>): ArrayList<String> {
    val arrayListString = ArrayList<String>()
    val hashSet = HashSet<String>()
    for (i in 0 until arrayList.size) {
        val boolean = hashSet.add(arrayList[i].stringModel)
        if (boolean) {
            arrayListString.add(arrayList[i].stringModel)
        }
    }

    return arrayListString
}