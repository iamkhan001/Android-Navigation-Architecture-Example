package com.nstudio.navigationexample.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nstudio.navigationexample.R


/**
 * A simple [Fragment] subclass.
 *
 */
class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val colors = context!!.resources.getStringArray(R.array.colors)
        val lv : ListView = view.findViewById(R.id.listView)

        lv.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(context,"Selected Color: "+colors[position],Toast.LENGTH_SHORT).show()
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment()
            action.selectedColor = colors[position]
            findNavController().navigate(action)
        }

    }

}
