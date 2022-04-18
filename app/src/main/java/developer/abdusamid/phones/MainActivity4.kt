package developer.abdusamid.phones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import developer.abdusamid.phones.MyShare.MyShare
import developer.abdusamid.phones.Object.Object
import developer.abdusamid.phones.Object.ObjectPhone
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    lateinit var arrayList: ArrayList<Dataa>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        MyShare.init(this)
        tv_phone_model.text = Object.string
        arrayList = ArrayList()
        arrayList.addAll(MyShare.dataList!!)
        BuildModelArray(Object.string)
        for (i in 0 until arrayList.size){
            if (arrayList[i].stringName != "" && arrayList[i].stringFeatures != "") {
                BuildDinamikView(arrayList[i].stringName , arrayList[i].stringModel , arrayList[i].stringFeatures )
            }
        }
    }

    private fun BuildModelArray(string: String) {
        var arrayListTest = ArrayList<Dataa>()
        for (i in 0 until arrayList.size){
            if (arrayList[i].stringModel == string){
                arrayListTest.add(arrayList[i])
            }
        }
        arrayList = arrayListTest
    }

    fun BuildDinamikView (stringName: String , stringModel : String , stringFeatures: String) {
        val view = layoutInflater.inflate(R.layout.dinamik_view , null , false)
        val name = view.findViewById<TextView>(R.id.tv_model)
        name.text = stringName
        name.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
            ObjectPhone.stringName = stringName
            ObjectPhone.stringModel = stringModel
            ObjectPhone.stringFeatures = stringFeatures
        }
        containerPhones.addView(view)
    }
}