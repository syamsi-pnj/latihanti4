package ac.id.pnj.sample.ti4a

import ac.id.pnj.sample.ti4a.data.DataBerita
import ac.id.pnj.sample.ti4a.fragment.FragmentOne
import ac.id.pnj.sample.ti4a.fragment.FragmentTwo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class LatihanActivityFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_fragment)

		var fm = supportFragmentManager.beginTransaction()
		fm.add(R.id.containerLayout, FragmentOne())
		fm.commit()
    }


	fun pindahHalamanDetail(data:DataBerita) {
		var halamanDetail = FragmentTwo();
		var bundle = Bundle();

		halamanDetail.arguments = bundle

		var fm = supportFragmentManager.beginTransaction()
		fm.replace(R.id.containerLayout, FragmentTwo()?.newInstance(data)!!)
		fm.addToBackStack(null)
		fm.commit()

		Log.e("E","Pindah")

	}
}
