package developer.abdusamid.phones.MyShare

import android.content.Context
import android.content.SharedPreferences
import developer.abdusamid.phones.Dataa
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MyShare {
    private const val NAME = "my_cache_file"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var name: String?
        get() = sharedPreferences.getString("key", "")
        set(value) = sharedPreferences.edit {
            it.putString("key", value)
        }

    var dataList: ArrayList<Dataa>?
        get() = gsonToArray(sharedPreferences.getString("dataList", "[]")!!)
        set(value) = sharedPreferences.edit {
            it.putString("dataList", listToGson(value!!))
        }

    fun gsonToArray(gsonString: String): ArrayList<Dataa> {
        val list = ArrayList<Dataa>()

        val type = object : TypeToken<List<Dataa>>() {}.type
        list.addAll(Gson().fromJson(gsonString, type))
        return list
    }

    fun listToGson(list: ArrayList<Dataa>): String {
        var gsonString = "[]"
        gsonString = Gson().toJson(list)
        return gsonString
    }
}