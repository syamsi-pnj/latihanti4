package  ac.id.pnj.sample.ti4a

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
	lateinit var btn_pindah:Button
	lateinit var btn_picket_tanggal:Button
	lateinit var textView: TextView
	lateinit var btn_picker_time:Button

	var calendar = Calendar.getInstance()

	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

		textView = findViewById(R.id.textView);
		btn_pindah = findViewById(R.id.btn_pindah)
		btn_picket_tanggal = findViewById(R.id.btn_picker_tanggal);
		btn_picker_time = findViewById(R.id.btn_picker_time);


		btn_pindah.setOnClickListener(this)
		btn_picket_tanggal.setOnClickListener(this)
		btn_picker_time.setOnClickListener(this)


    }

	override fun onStart() {
		super.onStart()
		Log.e("onStart ", "onStart")
	}

	override fun onResume() {
		super.onResume()
		Log.e("onResume ", "onResume")
	}

	override fun onClick(v: View?) {
		if(v?.id==R.id.btn_pindah){
			val i = Intent(this,LatihanListView::class.java)
			i.putExtra("nama","Syamsi Dwi Cahya")
			i.putExtra("umur", 30)
//
//			startActivityForResult(i,100)
//			val phoneNumber = "087778266328"
//			val i = Intent(Intent.ACTION_DIAL,Uri.parse("tel:$phoneNumber"))
			startActivity(i)
		}else if(v?.id==R.id.btn_picker_tanggal){
			showDatePicker()
		}else if(v?.id==R.id.btn_picker_time){
			showTimePicker()
		}
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if(requestCode==100){
			btn_pindah.setText(data?.extras?.getString("data"))
		}else {

		}
	}
	
	var listenerDate  = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
		val data = Calendar.getInstance()
		data.set(Calendar.DAY_OF_MONTH, dayOfMonth)
		data.set(Calendar.MONTH,month)
		data.set(Calendar.YEAR, year)

		val dateFormat = SimpleDateFormat("dd MMM yyyy")
		textView.setText(dateFormat.format(data.time))

	}
	
	fun showDatePicker() {
		DatePickerDialog(this,listenerDate,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()
	}


	var listenerTime = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
		val data = Calendar.getInstance()
		data.set(Calendar.HOUR_OF_DAY, hourOfDay)
		data.set(Calendar.MINUTE,minute)

		val dateFormat = SimpleDateFormat("HH:mm")
		textView.setText(dateFormat.format(data.time))
	}

	fun showTimePicker() {
		TimePickerDialog(this, listenerTime,calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
	}

}
