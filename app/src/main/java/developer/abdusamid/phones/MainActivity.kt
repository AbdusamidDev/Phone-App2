package developer.abdusamid.phones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import developer.abdusamid.phones.MyShare.MyShare
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var arrayList: ArrayList<Dataa>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyShare.init(this)
        arrayList = ArrayList()
        arrayList.addAll(MyShare.dataList!!)

        if (arrayList.isEmpty()) {
            arrayList.add(
                Dataa(
                    "Iphone XS", "Iphone", "Super Retina HD display.\n" +
                            "5.8‑inch (diagonal) all‑screen OLED Multi‑Touch display.\n" +
                            "HDR display.\n" +
                            "2436‑by-1125‑pixel resolution at 458 ppi.\n" +
                            "1,000,000:1 contrast ratio (typical)\n" +
                            "True Tone display.\n" +
                            "Wide color display (P3)\n" +
                            "3D Touch."
                )
            )
            MyShare.dataList = arrayList
        }

        btn_addPhone.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        btn_phone.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}