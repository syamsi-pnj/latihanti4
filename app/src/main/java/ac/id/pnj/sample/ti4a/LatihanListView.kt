package ac.id.pnj.sample.ti4a

import ac.id.pnj.sample.ti4a.adapter.AdapterListBerita
import ac.id.pnj.sample.ti4a.data.DataBerita
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import java.util.*

class LatihanListView : AppCompatActivity() {

	lateinit var listView: ListView
	lateinit var adatepter: AdapterListBerita

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_latihan_list_view)
		listView = findViewById(R.id.listView)
		adatepter = AdapterListBerita(this, R.layout.item_list_layout)
		listView.adapter = adatepter
		buatData()


		listView.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
			var data  = parent.getItemAtPosition(position) as DataBerita
			Toast.makeText(applicationContext,"Judul Berita ${data.title}", Toast.LENGTH_SHORT).show()

		})
	}

	fun buatData() {
		var arrayList = ArrayList<DataBerita>()

		for (i in 0..10){
			var data1 = DataBerita()
			data1.imageUrl= "https://akcdn.detik.net.id/community/media/visual/2022/11/27/penampakan-belasan-rumah-semi-permanen-roboh-dihantam-puting-beliung-2_169.jpeg?w=700&q=90"
			data1.title = "Berita $i"
			data1.desc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
			arrayList.add(data1)
		}


		adatepter.addAll(arrayList)
		adatepter.notifyDataSetChanged()
	}
}
