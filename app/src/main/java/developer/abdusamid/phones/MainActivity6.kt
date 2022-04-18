package developer.abdusamid.phones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import developer.abdusamid.phones.MyShare.MyShare
import developer.abdusamid.phones.Object.Object
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity6 : AppCompatActivity() {
    lateinit var arrayList: ArrayList<Dataa>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        MyShare.init(this)
        arrayList = ArrayList()
        arrayList.addAll(MyShare.dataList!!)
        tv_phone_Name_AddPhone.text = Object.string
        btn_save.setOnClickListener {
            val stringName = edt_PhoneName.text.toString()
            val stringModel = Object.string
            val stringFeatures = edt_PhoneFeatures.text.toString()
            if (stringName.isNotEmpty() && stringModel.isNotEmpty() && stringFeatures.isNotEmpty()) {
                arrayList.add(Dataa(stringName, stringModel, stringFeatures))
                MyShare.dataList = arrayList
                edt_PhoneName.text!!.clear()
                edt_PhoneFeatures.text!!.clear()
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Not enough information to save", Toast.LENGTH_SHORT).show()
            }
        }
    }
}