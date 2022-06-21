package com.kroger.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicFragment : Fragment() {

    private val comicViewModel: ComicViewModel by viewModels()
    private lateinit var title: TextView
    private lateinit var image: ImageView
    private lateinit var altText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_comic_details, container, false)

        title = view.findViewById(R.id.title)
        image = view.findViewById(R.id.image)
        altText = view.findViewById(R.id.altText)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
    }

    fun getData(){
        comicViewModel.currentComic.observe(viewLifecycleOwner, Observer{

            title.text = it.title
            altText.text = it.alt

            activity?.let { it1 ->
                Glide.with(it1)
                    .load(it.img)
                    .into(image)
            }



        })
    }
}
