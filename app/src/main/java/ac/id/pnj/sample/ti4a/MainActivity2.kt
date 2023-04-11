package ac.id.pnj.sample.ti4a

import android.content.Intent
import android.media.Session2Command
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
	lateinit var txtNama:TextView
	lateinit var txtUmur:TextView
	lateinit var bbtnKirim: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

		val bundle = intent.extras
		txtNama = findViewById(R.id.txtNama)
		txtUmur = findViewById(R.id.txtUmur)
		bbtnKirim = findViewById(R.id.btn_kirim)
		bbtnKirim.setOnClickListener {
			val k = Intent()
			k.putExtra("data", "Hallo")
			setResult(RESULT_OK,k)
			finish()
		}

		if(bundle!=null) {
			val nama = bundle.getString("nama")
			val umur = bundle.getInt("umur")
			txtNama.setText(nama)
			txtUmur.setText(""+umur)
		}
    }
}
