package developer.abdusamid.phones.MyAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import developer.abdusamid.phones.MyOnClickListiner.MyOnClickListiner
import developer.abdusamid.phones.R
import java.util.ArrayList

class MyAdapter(
    private val tags: ArrayList<String>,
    private var OnClickListiner: MyOnClickListiner
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tagTV: TextView = view.findViewById<View>(R.id.tv_model) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.dinamik_view2, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tag = tags[position]
        holder.tagTV.text = tag
        holder.tagTV.setOnClickListener {
            OnClickListiner.OnClick(tag)
        }
    }


    override fun getItemCount(): Int {
        return tags.size
    }

}