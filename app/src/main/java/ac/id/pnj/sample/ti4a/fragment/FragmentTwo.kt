package ac.id.pnj.sample.ti4a.fragment

import ac.id.pnj.sample.ti4a.R
import ac.id.pnj.sample.ti4a.data.DataBerita
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class FragmentTwo : Fragment() {
	lateinit var imageView: ImageView
	lateinit var txtTitle:TextView
	lateinit var txtDesc:TextView

	fun newInstance(data: DataBerita): FragmentTwo? {
		val fragmentDemo = FragmentTwo()
		val args = Bundle()

		args.putString("title", data.title)
		args.putString("img", data.imageUrl)
		args.putString("desc", data.desc)
		fragmentDemo.setArguments(args)
		return fragmentDemo
	}


	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return layoutInflater.inflate(R.layout.layout_fragment_two, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		imageView = view.findViewById(R.id.imageView)
		txtTitle = view.findViewById(R.id.txtTitle)
		txtDesc = view.findViewById(R.id.txtDesc)


		var bundle = arguments

		Glide.with(requireActivity()).load(bundle?.getString("img","")).into(imageView)
		txtTitle.setText(bundle?.getString("title",""))
		txtDesc.setText(bundle?.getString("desc",""))

	}
}
