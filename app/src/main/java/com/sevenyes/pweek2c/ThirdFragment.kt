package com.sevenyes.pweek2c

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sevenyes.pweek2c.databinding.FragmentSecondBinding
import com.sevenyes.pweek2c.databinding.FragmentThirdBinding
import com.sevenyes.pweek2c.models.EventsData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var evPos: Int = 0
    private var event: Evento? = null

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            evPos = it.getInt("ZEY")
            event = EventsData.getEvent(evPos)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        var dayLeft = binding.calendarTxt.date
        binding.titleTxt.text = event?.title
        binding.catTxt.text = event?.cat
        dayLeft = putDate(event!!.fecha) - dayLeft
        dayLeft = (dayLeft/86400000)

        binding.daysLeftCounter.text = dayLeft.toString()
        binding.calendarTxt.date = putDate(event!!.fecha)

        binding.daysLeftCounter.text = "$dayLeft days left"

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}